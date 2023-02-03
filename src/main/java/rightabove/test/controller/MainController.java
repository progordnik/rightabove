package rightabove.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import rightabove.test.service.SaveAnimalStrategy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MainController {
    private final SaveAnimalStrategy strategy;

    @Autowired
    public MainController(SaveAnimalStrategy strategy) {
        this.strategy = strategy;
    }

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {
        String message = "Hello Spring Boot + JSP";
        model.addAttribute("message", message);
        return "index";
    }

    @PostMapping("/addAnimal")
    public String addBook(HttpServletRequest request, HttpServletResponse response) {
        strategy.saveAnimal(request);
        return "index";
    }
}
