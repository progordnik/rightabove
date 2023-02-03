package rightabove.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import rightabove.test.controller.dto.AmphibianDto;
import rightabove.test.controller.dto.AnimalDto;
import rightabove.test.controller.dto.MammalDto;
import rightabove.test.controller.dto.WaterfowlDto;

import javax.servlet.http.HttpServletRequest;

@Component
public class SaveAnimalStrategy {
    private final AnimalService mammalService;
    private final AnimalService waterfowlService;
    private final AnimalService amphibianService;

    @Autowired
    public SaveAnimalStrategy(@Qualifier("mammalServiceImpl") AnimalService mammalService,
                              @Qualifier("waterfowlServiceImpl")AnimalService waterfowlService,
                              @Qualifier("amphibianServiceImpl")AnimalService amphibianService) {
        this.mammalService = mammalService;
        this.waterfowlService = waterfowlService;
        this.amphibianService = amphibianService;
    }

    public void saveAnimal(HttpServletRequest request) {
        AnimalDto animalDto;
        String animalClass = request.getParameter("class");
        String animalName = request.getParameter("name");
        switch (request.getParameter("type")) {
            case "mammal" : animalDto = new MammalDto(animalName, animalClass, "mammal");
            mammalService.createAnimal(animalDto);
            break;
            case "waterfowl" : animalDto = new WaterfowlDto(animalName, animalClass, "waterfowl");
                waterfowlService.createAnimal(animalDto);
                break;
            default : animalDto = new AmphibianDto(animalName, animalClass, "amphibian");
            amphibianService.createAnimal(animalDto);
            break;
        }

    }
}
