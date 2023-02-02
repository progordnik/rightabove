package rightabove.test.service.mapper;

import org.springframework.stereotype.Component;
import rightabove.test.controller.dto.AmphibianDto;
import rightabove.test.controller.dto.AnimalDto;
import rightabove.test.controller.dto.MammalDto;
import rightabove.test.controller.dto.WaterfowlDto;
import rightabove.test.repository.entity.AnimalEntity;

import java.util.ArrayList;
import java.util.List;

@Component
public class EntityToDtoMapper {
    public List<AnimalDto> listEntityToListDto(List<AnimalEntity> entityList) {
        List<AnimalDto> dtoList = new ArrayList<>();
        for (AnimalEntity animalEntity : entityList) {
            dtoList.add(entityToDto(animalEntity));
        }
        return dtoList;
    }

    public AnimalDto entityToDto(AnimalEntity entity) {
        AnimalDto animalDto;
        switch(entity.getType()){
            case "mammal" : animalDto = new MammalDto(entity.getId(),
                    entity.getName(),
                    entity.getClassName(),
                    entity.getType());
            break;
            case "waterfowl" : animalDto = new WaterfowlDto(entity.getId(),
                    entity.getName(),
                    entity.getClassName(),
                    entity.getType());
            break;
            default : animalDto = new AmphibianDto(entity.getId(),
                    entity.getName(),
                    entity.getClassName(),
                    entity.getType());
        }
        return animalDto;
    }
}
