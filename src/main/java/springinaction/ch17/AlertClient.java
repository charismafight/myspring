package springinaction.ch17;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import springinaction.ch04.Spittle;


public class AlertClient {
    private JmsOperations operations;

    public Spittle receiveSpittleAlert() {
        return (Spittle) operations.receiveAndConvert();
    }

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public Spittle receiveSpittleByRabbit() {
        return (Spittle) rabbitTemplate.receiveAndConvert("spittle.alerts");

    }
}
