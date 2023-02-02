package rightabove.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import rightabove.test.repository.AnimalRepository;
import rightabove.test.controller.dto.AnimalDto;
import rightabove.test.service.mapper.EntityToDtoMapper;

import java.util.List;

@Service
public class MammalServiceImpl implements AnimalService {
    private final AnimalRepository animalRepository;
    private final EntityToDtoMapper mapper;

    @Autowired
    public MammalServiceImpl(@Qualifier("mammalRepositoryImpl") AnimalRepository animalRepository, EntityToDtoMapper mapper) {
        this.animalRepository = animalRepository;
        this.mapper = mapper;
    }
    @Override
    public List<AnimalDto> getAnimalList() {
        return mapper.listEntityToListDto(animalRepository.getAnimalEntityList());
    }

    @Override
    public AnimalDto createAnimal(AnimalDto animalDto) {
        return null;
    }
}
