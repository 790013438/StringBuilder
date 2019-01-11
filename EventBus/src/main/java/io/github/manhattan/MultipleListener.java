package io.github.manhattan;

import com.google.common.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MultipleListener {
    private Integer lastInteger;
    private Long lastLong;
    private static final Logger LOGGER = LoggerFactory.getLogger(MultipleListener.class);

    @Subscribe
    public void listenIngeger(Integer eventInteger) {
        lastInteger = eventInteger;
        LOGGER.debug("event Integer{}", lastInteger);
    }

    @Subscribe
    public void listenLong(Long eventLong) {
        lastLong = eventLong;
        LOGGER.debug("event Long:{}", lastLong);
    }

    public Integer getLastInteger() {
        return lastInteger;
    }

    public Long getLastLong() {
        return lastLong;
    }
}
