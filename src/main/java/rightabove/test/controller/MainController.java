package rightabove.test.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import rightabove.test.Person;
import rightabove.test.controller.dto.AnimalDto;
import rightabove.test.controller.dto.MammalDto;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    private static List<Person> persons = new ArrayList<Person>();

    static {
        persons.add(new Person("Bill", "Gates"));
        persons.add(new Person("Steve", "Jobs"));
    }

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {

        String message = "Hello Spring Boot + JSP";

        model.addAttribute("message", message);

        return "index";
    }

    @RequestMapping(value = { "/personList" }, method = RequestMethod.GET)
    public String viewPersonList(Model model) {

        model.addAttribute("persons", persons);

        return "personList";
    }

//    @RequestMapping(value = { "/mammalList" }, method = RequestMethod.GET)
//    public String viewPersonList(Model model) {
//
//        List<AnimalDto> animals = new ArrayList<>();
//        MammalDto dto = new MammalDto(1L, "asda", "asdd");
//        MammalDto dto2 = new MammalDto(1L, "asda", "asdd");
//        MammalDto dto3 = new MammalDto(1L, "aasda", "asdd");
//
//        animals.add(dto);
//        animals.add(dto2);
//        animals.add(dto3);
//
//        model.addAttribute("mammals", animals);
//
//        return "mammalList";
//    }
}
