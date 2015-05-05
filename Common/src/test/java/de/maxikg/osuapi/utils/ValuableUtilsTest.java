package de.maxikg.osuapi.utils;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * @author maxikg
 */
public class ValuableUtilsTest {

    @Test
    public void testGetByValue() {
        assertThat(ValuableUtils.getByValue(TestEnum.class, 42).orNull(), equalTo(TestEnum.SIXTH));
        assertThat(ValuableUtils.getByValue(TestEnum.class, 1234).orNull(), nullValue());
    }

    @RequiredArgsConstructor
    private enum TestEnum implements Valuable<Integer> {

        FIRST(4),
        SECOND(8),
        THIRD(15),
        FOURTH(16),
        FIFTH(23),
        SIXTH(42);

        @Getter @NonNull
        private final Integer value;
    }
}
