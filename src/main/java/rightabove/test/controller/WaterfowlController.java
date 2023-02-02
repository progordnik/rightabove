package rightabove.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rightabove.test.service.AnimalService;

@Controller
public class WaterfowlController {
    private final AnimalService animalService;
    @Autowired
    public WaterfowlController(@Qualifier("waterfowlServiceImpl") AnimalService animalService) {
        this.animalService = animalService;
    }

    @RequestMapping(value = { "/waterfowlList" }, method = RequestMethod.GET)
    public String viewPersonList(Model model) {

        model.addAttribute("waterfowls", animalService.getAnimalList());

        return "waterfowlList";
    }
}
