package de.maxikg.osuapi.model;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * @author maxikg
 */
public class BeatmapStateTest {

    @Test
    public void testByValue() {
        for (BeatmapState beatmapState : BeatmapState.values())
            assertThat(beatmapState, equalTo(BeatmapState.byValue(beatmapState.getValue()).orNull()));
    }
}
