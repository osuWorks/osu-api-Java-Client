package de.maxikg.osuapi.client;

import de.maxikg.osuapi.client.exception.OsuClientConnectionException;
import de.maxikg.osuapi.model.Beatmap;
import de.maxikg.osuapi.model.GameMode;
import de.maxikg.osuapi.model.User;
import org.junit.*;

import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * @author maxikg
 */
public class DefaultOsuClientTest {

    private CloseableOsuClient osuClient;

    @Before
    public void prepare() {
        String apiKey = System.getProperty("osuApiKey", System.getenv("osuApiKey"));
        if (apiKey == null)
            throw new AssumptionViolatedException("API key not set.");

        osuClient = new DefaultOsuClient(apiKey);
    }

    @After
    public void after() {
        if (osuClient != null)
            osuClient.close();
    }

    @Test
    public void testGetBeatmaps() {
        // Requested: https://osu.ppy.sh/b/75&m=0
        Collection<Beatmap> beatmaps;
        try {
            beatmaps = osuClient.getBeatmaps()
                    .beatmapId(75)
                    .query();
        } catch (OsuClientConnectionException e) {
            throw cannotConnect(e);
        }

        assertThat(beatmaps.size(), equalTo(1));

        Beatmap firstBeatmap = beatmaps.iterator().next();
        assertThat(firstBeatmap.getBeatmapSetId(), equalTo(1));
        assertThat(firstBeatmap.getCreator(), equalToIgnoringCase("peppy"));
        assertThat(firstBeatmap.getMode(), equalTo(GameMode.STANDARD));
    }

    // testGetMatch: Matches are only kept for a month. So this test would be inconsistent.

    @Test
    public void testGetScores() {
        try {
            osuClient.getScores(75)
                    .query();
        } catch (OsuClientConnectionException e) {
            throw cannotConnect(e);
        }
    }

    @Test
    public void testGetUserBest() {
        try {
            osuClient.getUserBestById(2)
                    .query();
        } catch (OsuClientConnectionException e) {
            throw cannotConnect(e);
        }
    }

    @Test
    public void testGetUserRecent() {
        try {
            osuClient.getUserRecentById(2)
                    .query();
        } catch (OsuClientConnectionException e) {
            throw cannotConnect(e);
        }
    }

    @Test
    public void testGetUser() {
        // Requested: https://osu.ppy.sh/u/2
        Collection<User> users;
        try {
            users = osuClient.getUserById(2)
                    .query();
        } catch (OsuClientConnectionException e) {
            throw cannotConnect(e);
        }

        assertThat(users.size(), equalTo(1));

        User firstUser = users.iterator().next();
        assertThat(firstUser.getUsername(), equalToIgnoringCase("peppy"));
    }

    private static AssumptionViolatedException cannotConnect(OsuClientConnectionException e) {
        return new AssumptionViolatedException("Cannot connect to api host.", e);
    }
}
