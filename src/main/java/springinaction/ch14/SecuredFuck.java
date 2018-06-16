package springinaction.ch14;

import org.springframework.security.access.annotation.Secured;

public class SecuredFuck implements FuckService {

    @Secured("FUCK_ROLE")
    @Override
    public void fuck() {
        System.out.println("this is secured fuck service");
    }
}
