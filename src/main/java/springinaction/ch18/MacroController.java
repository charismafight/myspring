package springinaction.ch18;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MacroController {
    private static final Logger logger = LoggerFactory.getLogger(MacroController.class);

    @MessageMapping(value = "/marco")
    public void handlerShout(Shout incoming) {
        System.out.println("received incoming message:" + incoming.getMessage());
    }
}
