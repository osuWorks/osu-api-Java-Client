package de.maxikg.osuapi.model;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author maxikg
 */
public class GameModeTest {

    @Test
    public void testByValue() {
        for (GameMode gameMode : GameMode.values())
            assertThat(gameMode, equalTo(GameMode.byValue(gameMode.getValue()).orNull()));
    }
}
