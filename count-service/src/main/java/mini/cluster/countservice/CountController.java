package mini.cluster.countservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class CountController {

    private CountService countService;

    @Autowired
    public CountController(CountService countService) {
        this.countService = countService;
    }

    @GetMapping("/helloworld")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/count")
    public int getCurrentCount() {
        return this.countService.getCurrentCount().getCountVal();
    }

    @PutMapping("/count")
    public int setCurrentCount(@RequestParam("setCount") int setCount) {
        return this.countService.setCurrentCount(setCount).getCountVal();
    }
}