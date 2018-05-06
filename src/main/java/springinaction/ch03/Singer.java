package springinaction.ch03;

import org.springframework.stereotype.Component;

@Component
public class Singer implements Performance {
    @Override
    public void perform() {
        System.out.println("singing");
    }
}
