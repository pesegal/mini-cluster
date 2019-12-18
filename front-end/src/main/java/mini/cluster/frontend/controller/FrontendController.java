package mini.cluster.frontend.controller;

import mini.cluster.frontend.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FrontendController {

    private CountService countService;

    @Autowired
    public FrontendController(CountService countService) {
        this.countService = countService;
    }

    @GetMapping("/")
    public String launch(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("counter", countService.getCount());
        return "index";
    }

    @GetMapping(value = "/count")
    public String greeting(Model model) {
        var currentCount = countService.getCount();
        currentCount++;
        countService.setCount(currentCount);
        // Explicitly grab the new count for testing
        var newCount = countService.getCount();
        model.addAttribute("counter", newCount);
        return "index";
    }
}