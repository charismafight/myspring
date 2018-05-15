package springinaction.ch04.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/input")
public class MultiInputController {
    @RequestMapping(method = RequestMethod.GET)
    public String input() {
        return "multiinputs";
    }
}