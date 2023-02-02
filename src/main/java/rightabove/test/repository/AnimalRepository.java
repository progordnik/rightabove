package rightabove.test.repository;

import rightabove.test.repository.entity.AnimalEntity;
import rightabove.test.service.domain.AnimalDto;

import java.util.List;

public interface AnimalRepository {
    List<AnimalEntity> getAnimalEntityList();

    AnimalEntity createAnimal(AnimalDto animalDto);
}
