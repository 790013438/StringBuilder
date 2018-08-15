package io.github.floyd;

import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App {

    private static final int SIZE = 1000;

    public static void main( String[] args ) {
        final StringBuilder stringBuilder = Stream
            .generate(() -> "a")
            .limit(SIZE)
            .parallel()
            .reduce(new StringBuilder(), StringBuilder::append, (b1, b2) -> b1);

        System.out.println(SIZE == stringBuilder.toString().length());
    }
}
