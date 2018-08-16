package io.github.floyd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * 验证StringBuilder不是线程安全的
 */
public class AppTest {

    @RepeatedTest(10000)
    public void testStringBuilder() {
        testAbstractStringBuilder(new StringBuilder(), StringBuilder::append);
    }

    @RepeatedTest(10000)
    public void testStringBuffer() {
        testAbstractStringBuilder(new StringBuffer(), StringBuffer::append);
    }

    private <T extends CharSequence> void testAbstractStringBuilder(T builder, BiFunction<T, ? super String, T> accumulator) {
        final long SIZE = 1000;
        final Supplier<String> GENERATOR = () -> "a";

        final CharSequence sequence = Stream
            .generate(GENERATOR)
            .parallel()
            .limit(SIZE)
            .reduce(builder, accumulator, (b1, b2) -> b1);

        Assertions.assertEquals(
                SIZE * GENERATOR.get().length(),  // expected
                sequence.toString().length()      // actual
                );
    }
}
