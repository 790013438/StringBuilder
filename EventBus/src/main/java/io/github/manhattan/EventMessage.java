package io.github.manhattan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 程淼
 * @version 1.0
 * ClassName io.github.manhattan
 * Description: 描述
 * Company: com.yinhai
 * date 2019/1/11
 */
public class EventMessage {
    private final int message;
    private final static Logger LOGGER = LoggerFactory.getLogger(EventMessage.class);

    public EventMessage(int message) {
        this.message = message;
        LOGGER.debug("event message:{}", message);
    }

    public int getMessage() {
        return message;
    }
}
