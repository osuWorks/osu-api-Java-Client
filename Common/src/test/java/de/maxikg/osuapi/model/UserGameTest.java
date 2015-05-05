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
public class UserGameTest {

    @Test
    public void testFromFile() throws Throwable {
        ObjectMapper mapper = new ObjectMapper();
        List<UserGame> scores = mapper.readValue(getClass().getResourceAsStream("/api/responses/get_user_recent.json"), new TypeReference<List<UserGame>>() {
        });

        assertThat(scores.size(), equalTo(1));

        UserGame first = scores.get(0);
        assertThat(first.getBeatmapId(), equalTo(987654));
        assertThat(first.getScore(), equalTo(1234567));
        assertThat(first.getMaxCombo(), equalTo(321));
        assertThat(first.getCount50(), equalTo(10));
        assertThat(first.getCount100(), equalTo(50));
        assertThat(first.getCount300(), equalTo(300));
        assertThat(first.getCountMiss(), equalTo(1));
        assertThat(first.getCountKatu(), equalTo(10));
        assertThat(first.getCountGeki(), equalTo(50));
        assertThat(first.isPerfect(), equalTo(false));
        assertThat(first.getEnabledMods(), containsInAnyOrder(Mod.parseFlagSum(76).toArray()));
        assertThat(first.getUserId(), equalTo(1));
        assertThat(first.getDate(), equalTo(DateUtils.parseDate("2013-06-22 9:11:16")));
        assertThat(first.getRank(), equalTo("SH"));
    }
}
