package rightabove.test.service;

import rightabove.test.controller.dto.AnimalDto;

import java.util.List;

public interface AnimalService {
    List<AnimalDto> getAnimalList();

    AnimalDto createAnimal(rightabove.test.controller.dto.AnimalDto animalDto);
}
