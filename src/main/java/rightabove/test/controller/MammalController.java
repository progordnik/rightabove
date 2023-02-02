package rightabove.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rightabove.test.controller.dto.AnimalDto;
import rightabove.test.controller.dto.MammalDto;
import rightabove.test.service.AnimalService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MammalController {
    private final AnimalService animalService;

    @Autowired
    public MammalController(@Qualifier("waterfowlServiceImpl")AnimalService animalService) {
        this.animalService = animalService;
    }

    @RequestMapping(value = { "/mammalList" }, method = RequestMethod.GET)
    public String viewPersonList(Model model) {

        List<AnimalDto> animals = new ArrayList<>();
//        MammalDto dto = new MammalDto(1L, "asdffa", "afghgfhd");
//        MammalDto dto2 = new MammalDto(2L, "asdfgha", "ahgfdhgfd");
//        MammalDto dto3 = new MammalDto(3L, "aashjda", "fghgfhd");
//
//        animals.add(dto);
//        animals.add(dto2);
//        animals.add(dto3);

        model.addAttribute("mammals", animals);

        return "mammalList";
    }
}
