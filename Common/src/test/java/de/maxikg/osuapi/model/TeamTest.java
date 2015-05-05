package de.maxikg.osuapi.model;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author maxikg
 */
public class TeamTest {

    @Test
    public void testByValue() {
        for (Team team : Team.values())
            assertThat(team, equalTo(Team.byValue(team.getValue()).orNull()));
    }
}
