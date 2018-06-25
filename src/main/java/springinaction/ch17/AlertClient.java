package springinaction.ch17;

import org.springframework.jms.core.JmsOperations;
import springinaction.ch04.Spittle;

public class AlertClient {
    private JmsOperations operations;

    public Spittle receiveSpittleAlert() {
        return (Spittle) operations.receiveAndConvert();
    }
}
