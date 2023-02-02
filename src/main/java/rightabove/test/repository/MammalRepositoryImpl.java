package rightabove.test.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rightabove.test.repository.entity.AnimalEntity;
import rightabove.test.repository.entity.MammalEntity;
import rightabove.test.service.domain.AnimalDto;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MammalRepositoryImpl implements AnimalRepository {
    private final DataSource dataSource;
    private static final Logger logger = LogManager.getLogger();

    @Autowired
    public MammalRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public AnimalEntity createAnimal(AnimalDto animalDto) {
        String insertQuery = "INSERT INTO mammal (name, class_name, type)"
                + "VALUES (?, ?, 'mammal')";
        MammalEntity mammal = new MammalEntity(animalDto.getName(), animalDto.getClassName());
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(
                             insertQuery, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, animalDto.getName());
            preparedStatement.setString(2, animalDto.getClassName());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                mammal.setId(resultSet.getObject(1, Long.class));
            }
        } catch (SQLException e) {
            logger.error(String.format("Can`t add mammal %s to DB", animalDto), e.getMessage());
            throw new RuntimeException("Can't create animal " + animalDto, e);
        }
        logger.info("Animal {} was added to DB", animalDto);
        return mammal;
    }

    @Override
    public List<AnimalEntity> getAnimalEntityList() {
        String selectQuery = "SELECT *"
                + "FROM mammal"
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
            logger.error("Can`t get all mammals from DB", e.getMessage());
            throw new RuntimeException("Can't get all mammals", e);
        }
        logger.info("Got all mammals from DB complete");
        return animalEntities;
    }

    private AnimalEntity parseAnimalFromResultSet(ResultSet resultSet) throws SQLException {
        long animalId = resultSet.getLong("id");
        String animalName = resultSet.getString("name");
        String animalClass = resultSet.getString("class_name");
        MammalEntity mammalEntity = new MammalEntity(animalId,animalName,animalClass);
        return mammalEntity;
    }


//    public CarEntity createCar(CarEntity carEntity) {
//        String insertQuery = "INSERT INTO car (model, number, driver_id)"
//                + "VALUES (?, ?, ?)";
//        try (Connection connection = dataSource.getConnection();
//             PreparedStatement preparedStatement =
//                     connection.prepareStatement(
//                             insertQuery, Statement.RETURN_GENERATED_KEYS)) {
//            preparedStatement.setString(1, carEntity.getModel());
//            preparedStatement.setString(2, carEntity.getNumber());
//            preparedStatement.setLong(3, carEntity.getDriverId());
//            preparedStatement.executeUpdate();
//            ResultSet resultSet = preparedStatement.getGeneratedKeys();
//            if (resultSet.next()) {
//                carEntity.setId(resultSet.getObject(1, Long.class));
//            }
//        } catch (SQLException e) {
//            logger.error(String.format("Can`t add car %s to DB", carEntity), e.getMessage());
//            throw new RuntimeException("Can't create car " + carEntity, e);
//        }
//        logger.info("Car {} was added to DB", carEntity);
//        return carEntity;
//    }
//
//    @Override
//    public List<CarEntity> getAllCars() {
//        String selectQuery = "SELECT *"
//                + "FROM car"
//                + "WHERE deleted = false";
//        List<CarEntity> carEntities = new ArrayList<>();
//        try (Connection connection = dataSource.getConnection();
//             PreparedStatement preparedStatement =
//                     connection.prepareStatement(selectQuery)) {
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                carEntities.add(parseCarFromResultSet(resultSet));
//            }
//        } catch (SQLException e) {
//            logger.error("Can`t get all cars from DB", e.getMessage());
//            throw new RuntimeException("Can't get all cars", e);
//        }
//        logger.info("Got all cars from DB complete");
//        return carEntities;
//    }
}
