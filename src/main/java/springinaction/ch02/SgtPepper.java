package springinaction.ch02;

import org.springframework.stereotype.Component;

@Component
public class SgtPepper implements CompactDisc {
    @Override
    public void play() {
        System.out.println("playing SgtPepper");
    }
}
