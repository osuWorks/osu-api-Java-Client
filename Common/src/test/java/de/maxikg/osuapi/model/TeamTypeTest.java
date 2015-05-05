package de.maxikg.osuapi.model;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author maxikg
 */
public class TeamTypeTest {

    @Test
    public void testByValue() {
        for (TeamType teamType : TeamType.values())
            assertThat(teamType, equalTo(TeamType.byValue(teamType.getValue()).orNull()));
    }
}
