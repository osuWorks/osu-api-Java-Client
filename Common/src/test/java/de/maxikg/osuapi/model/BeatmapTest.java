package de.maxikg.osuapi.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.maxikg.osuapi.utils.DateUtils;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * @author maxikg
 */
public class BeatmapTest {

    @Test
    public void testFromFile() throws Throwable {
        ObjectMapper mapper = new ObjectMapper();
        List<Beatmap> beatmaps = mapper.readValue(getClass().getResourceAsStream("/api/responses/get_beatmaps.json"), new TypeReference<List<Beatmap>>() {
        });

        assertThat(beatmaps.size(), equalTo(1));

        Beatmap first = beatmaps.get(0);
        assertThat(first.getApproved(), equalTo(BeatmapState.byValue(1).orNull()));
        assertThat(first.getApprovedDate(), equalTo(DateUtils.parseDate("2013-07-02 01:01:12")));
        assertThat(first.getLastUpdate(), equalTo(DateUtils.parseDate("2013-07-06 16:51:22")));
        assertThat(first.getArtist(), equalTo("Luxion"));
        assertThat(first.getBeatmapId(), equalTo(252002));
        assertThat(first.getBeatmapSetId() ,equalTo(93398));
        assertThat((double) first.getBpm(), closeTo(196, 0.1));
        assertThat(first.getCreator(), equalTo("RikiH_"));
        assertThat((double) first.getDifficultyRating(), closeTo(5.59516, 0.00001));
        assertThat(first.getDifficultySize(), equalTo(4));
        assertThat(first.getDifficultyOverall(), equalTo(6));
        assertThat(first.getDifficultyApproach(), equalTo(7));
        assertThat(first.getDifficultyDrain(), equalTo(6));
        assertThat(first.getHitLength(), equalTo(113));
        assertThat(first.getSource(), equalTo("BMS"));
        assertThat(first.getTitle(), equalTo("High-Priestess"));
        assertThat(first.getTotalLength(), equalTo(145L));
        assertThat(first.getVersion(), equalTo("Overkill"));
        assertThat(first.getMode(), equalTo(GameMode.byValue(0).orNull()));
    }
}
