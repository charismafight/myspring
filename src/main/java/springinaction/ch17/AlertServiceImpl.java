package springinaction.ch17;

import jdk.nashorn.api.tree.ForInLoopTree;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.MessageCreator;
import springinaction.ch04.Spittle;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

public class AlertServiceImpl implements AlertService {
    private JmsOperations operations;

    @Autowired
    public AlertServiceImpl(JmsOperations operations) {
        this.operations = operations;
    }

    @Override
    public void sendSpittleAlert(final Spittle spittle) {
        operations.send("spittle.alert.queue", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(spittle);
            }
        });
    }

    public void convertAndSent(final Spittle spittle) {
        operations.convertAndSend(spittle);
    }

    //默认convert会使用simpoleconverter，如果需要使用其他的converter可以中加入到bean中进行覆盖。

    @Autowired
    private RabbitTemplate rabbit;

    public void sendSpittleAlertByRabbit(final Spittle spittle) {
        rabbit.convertAndSend("spittle.alert.exchange", "spittle.alerts", spittle);
    }
}
