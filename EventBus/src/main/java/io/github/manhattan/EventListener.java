package io.github.manhattan;

import com.google.common.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 79001
 */
public class EventListener {
    private int lastMessage = 0;
    private final static Logger LOGGER = LoggerFactory.getLogger(EventListener.class);

    @Subscribe
    public void listen(EventMessage testEvent) {
        lastMessage = testEvent.getMessage();
        LOGGER.debug("capture message{}", lastMessage);
    }

    public int getLastMessage() {
        return lastMessage;
    }
}
