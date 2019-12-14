package mini.cluster.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FrontendController {

    private int clickCount = 0;

    @GetMapping("/")
    public String launch(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("counter", clickCount);
        return "index";
    }

    @GetMapping(value="/count")
    public String greeting(Model model) {
        clickCount++;
        model.addAttribute("counter", clickCount);
        return "index";
    }
    



}