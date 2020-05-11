package mini.cluster.frontend.controller;

import mini.cluster.frontend.service.CountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.client.RestClientException;

@Controller
public class FrontendController {
    Logger logger = LoggerFactory.getLogger(FrontendController.class);

    private CountService countService;

    @Value("${myMessage}")
    private String myMessage;

    @Autowired
    public FrontendController(CountService countService) {
        this.countService = countService;
    }

    @GetMapping("/")
    public String launch(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        try {
            model.addAttribute("counter", countService.getCount());
            model.addAttribute("myMessage", myMessage);

        } catch (RestClientException e) {
            logger.error(e.getMessage());
            model.addAttribute("counter", -1);
            model.addAttribute("errorMsg", e.getMessage());
        }
        return "index";
    }

    @GetMapping(value = "/count")
    public String greeting(Model model) {
        int newCount;
        try {
            var currentCount = countService.getCount();
            currentCount++;
            countService.setCount(currentCount);
            // Explicitly grab the new count for testing
            newCount = countService.getCount();
        } catch (RestClientException e) {
            logger.error(e.getMessage());
            model.addAttribute("errorMsg", e.getMessage());
            newCount = -1;
        }
        model.addAttribute("counter", newCount);
        return "index";
    }
}