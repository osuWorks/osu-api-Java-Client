package de.maxikg.osuapi.model;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author maxikg
 */
public class WinningConditionTest {

    @Test
    public void testByValue() {
        for (WinningCondition winningCondition : WinningCondition.values())
            assertThat(winningCondition, equalTo(WinningCondition.byValue(winningCondition.getValue()).orNull()));
    }
}
