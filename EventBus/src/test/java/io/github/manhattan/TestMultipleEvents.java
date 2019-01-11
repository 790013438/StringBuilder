package io.github.manhattan;

import com.google.common.eventbus.EventBus;
import org.junit.jupiter.api.RepeatedTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMultipleEvents {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestMultipleEvents.class);

    @RepeatedTest(100000)
    public void testMultipleEvents() throws Exception {
        EventBus eventBus = new EventBus("test");
        MultipleListener multiListener = new MultipleListener();

        eventBus.register(multiListener);

        eventBus.post(new Integer(100));
        eventBus.post(200);
        eventBus.post(300);
        eventBus.post(800L);
        eventBus.post(800990L);
        eventBus.post(800882934L);

        LOGGER.debug("程序结束消息Integer:" + multiListener.getLastInteger());
        LOGGER.debug("程序结束消息Long:" + multiListener.getLastLong());
    }
}
