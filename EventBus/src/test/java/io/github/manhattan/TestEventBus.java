package io.github.manhattan;

import com.google.common.eventbus.EventBus;
import org.junit.jupiter.api.Test;
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
public class TestEventBus {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestEventBus.class);

    @Test
    public void testReceiveEvent() throws Exception {

        EventBus eventBus = new EventBus("test");
        EventListener eventListener = new EventListener();

        eventBus.register(eventListener);

        eventBus.post(new EventMessage(200));
        eventBus.post(new EventMessage(300));
        eventBus.post(new EventMessage(400));

        LOGGER.debug("程序结束消息:" + eventListener.getLastMessage());
    }
}
