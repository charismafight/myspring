package springinaction.ch14;

import org.springframework.security.access.annotation.Secured;

public class SecuredFuck implements FuckService {

    @Override
    @Secured("ROLE_FUCK")
    public void fuck() {
        System.out.println("this is secured fuck service");
    }
}
