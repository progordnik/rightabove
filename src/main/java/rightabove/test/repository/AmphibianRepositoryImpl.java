package rightabove.test.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rightabove.test.repository.entity.AmphibianEntity;
import rightabove.test.repository.entity.AnimalEntity;
import rightabove.test.service.domain.AnimalDto;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AmphibianRepositoryImpl implements AnimalRepository {

    private final DataSource dataSource;
    private static final Logger logger = LogManager.getLogger();

    @Autowired
    public AmphibianRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public AnimalEntity createAnimal(AnimalDto animalDto) {
        String insertQuery = "INSERT INTO amphibian (name, class_name, type)"
                + "VALUES (?, ?, 'amphibian')";
        AmphibianEntity amphibian = new AmphibianEntity(animalDto.getName(), animalDto.getClassName());
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(
                             insertQuery, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, animalDto.getName());
            preparedStatement.setString(2, animalDto.getClassName());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                amphibian.setId(resultSet.getObject(1, Long.class));
            }
        } catch (SQLException e) {
            logger.error(String.format("Can`t add amphibian %s to DB", animalDto), e.getMessage());
            throw new RuntimeException("Can't create amphibian " + animalDto, e);
        }
        logger.info("Amphibian {} was added to DB", animalDto);
        return amphibian;
    }

    @Override
    public List<AnimalEntity> getAnimalEntityList() {
        String selectQuery = "SELECT *"
                + "FROM amphibian"
                + "WHERE deleted = false";
        List<AnimalEntity> animalEntities = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(selectQuery)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                animalEntities.add(parseAnimalFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            logger.error("Can`t get all amphibians from DB", e.getMessage());
            throw new RuntimeException("Can't get all amphibians", e);
        }
        logger.info("Got all amphibians from DB complete");
        return animalEntities;
    }

    private AnimalEntity parseAnimalFromResultSet(ResultSet resultSet) throws SQLException {
        long animalId = resultSet.getLong("id");
        String animalName = resultSet.getString("name");
        String animalClass = resultSet.getString("class_name");
        AmphibianEntity amphibianEntity = new AmphibianEntity(animalId,animalName,animalClass);
        return amphibianEntity;
    }
}
