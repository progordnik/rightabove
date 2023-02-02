package rightabove.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import rightabove.test.repository.AnimalRepository;
import rightabove.test.controller.dto.AnimalDto;
import rightabove.test.service.mapper.EntityToDtoMapper;

import java.util.List;

@Service
public class AmphibianServiceImpl implements AnimalService {
    private final AnimalRepository animalRepository;
    private final EntityToDtoMapper mapper;

    @Autowired
    public AmphibianServiceImpl(@Qualifier("amphibianRepositoryImpl") AnimalRepository animalRepository, EntityToDtoMapper mapper) {
        this.animalRepository = animalRepository;
        this.mapper = mapper;
    }
    @Override
    public List<AnimalDto> getAnimalList() {
        return mapper.listEntityToListDto(animalRepository.getAnimalEntityList());
    }

    @Override
    public AnimalDto createAnimal(rightabove.test.controller.dto.AnimalDto animalDto) {
        return null;
    }
}
