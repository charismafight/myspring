package springinaction.ch18;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

public class MacroHandler extends AbstractWebSocketHandler {
    public static final Logger logger = LoggerFactory.getLogger(MacroHandler.class);

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        logger.info("incoming some message:" + message.getPayload());
        Thread.sleep(2000);
        session.sendMessage(new TextMessage("fuck"));
    }
}
