package rightabove.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rightabove.test.service.AnimalService;


@Controller
public class MammalController {
    private final AnimalService animalService;

    @Autowired
    public MammalController(@Qualifier("mammalServiceImpl")AnimalService animalService) {
        this.animalService = animalService;
    }

    @RequestMapping(value = { "/mammalList" }, method = RequestMethod.GET)
    public String viewPersonList(Model model) {

        model.addAttribute("mammals", animalService.getAnimalList());

        return "mammalList";
    }
}
