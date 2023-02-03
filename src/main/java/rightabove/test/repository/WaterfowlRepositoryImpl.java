package rightabove.test.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rightabove.test.repository.entity.AnimalEntity;
import rightabove.test.repository.entity.WaterfowlEntity;
import rightabove.test.controller.dto.AnimalDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class WaterfowlRepositoryImpl implements AnimalRepository {
    private final Connection connection;
    private static final Logger logger = LogManager.getLogger();

    @Autowired
    public WaterfowlRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public AnimalEntity createAnimal(AnimalDto animalDto) {
        String insertQuery = "INSERT INTO waterfowl (name, class_name, type)"
                + "VALUES (?, ?, ?)";
        WaterfowlEntity waterfowl = new WaterfowlEntity(animalDto.getName(), animalDto.getClassName(), animalDto.getType());
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(
                             insertQuery, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, animalDto.getName());
            preparedStatement.setString(2, animalDto.getClassName());
            preparedStatement.setString(3, animalDto.getType());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                waterfowl.setId(Long.parseLong(String.valueOf(resultSet.getObject(1, Long.class))));
            }
        } catch (SQLException e) {
            logger.error(String.format("Can`t add waterfowl %s to DB", animalDto), e.getMessage());
            throw new RuntimeException("Can't create waterfowl " + animalDto, e);
        }
        logger.info("Waterfowl {} was added to DB", animalDto);
        return waterfowl;
    }

    @Override
    public List<AnimalEntity> getAnimalEntityList() {
        String selectQuery = "SELECT *"
                + "FROM waterfowl "
                + "WHERE is_deleted IS NOT TRUE";
        List<AnimalEntity> animalEntities = new ArrayList<>();
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(selectQuery)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                animalEntities.add(parseAnimalFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            logger.error("Can`t get all waterfowls from DB", e.getMessage());
            throw new RuntimeException("Can't get all waterfowls", e);
        }
        logger.info("Got all waterfowls from DB complete");
        return animalEntities;
    }

    private AnimalEntity parseAnimalFromResultSet(ResultSet resultSet) throws SQLException {
        long animalId = resultSet.getLong("id");
        String animalName = resultSet.getString("name");
        String animalClass = resultSet.getString("class_name");
        String animalType = resultSet.getString("type");
        WaterfowlEntity waterfowlEntity = new WaterfowlEntity(animalId,animalName,animalClass, animalType);
        return waterfowlEntity;
    }
}
