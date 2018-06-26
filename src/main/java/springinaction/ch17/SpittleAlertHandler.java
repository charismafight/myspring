package springinaction.ch17;


import javax.annotation.Resource;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(mappedName = "jms/spittle.alert.queue")
public class SpittleAlertHandler implements MessageListener {
    @Resource
    private MessageDrivenContext mdc;

    @Override
    public void onMessage(Message message) {
        System.out.println("receive message");
    }
}
