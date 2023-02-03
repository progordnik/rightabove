package rightabove.test.repository;

import rightabove.test.repository.entity.AnimalEntity;
import rightabove.test.controller.dto.AnimalDto;

import java.util.List;

public interface AnimalRepository {
    List<AnimalEntity> getAnimalEntityList();

    AnimalEntity createAnimal(AnimalDto animalDto);
}
