package de.maxikg.osuapi.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.maxikg.osuapi.utils.DateUtils;
import org.junit.Test;

import java.util.List;
import java.util.Locale;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * @author maxikg
 */
public class UserTest {

    @Test
    public void testFromFile() throws Throwable {
        ObjectMapper mapper = new ObjectMapper();
        List<User> users = mapper.readValue(getClass().getResourceAsStream("/api/responses/get_user.json"), new TypeReference<List<User>>() {
        });

        assertThat(users.size(), equalTo(1));

        User first = users.get(0);
        assertThat(first.getUserId(), equalTo(1));
        assertThat(first.getUsername(), equalTo("User name"));
        assertThat(first.getCount300(), equalTo(1337));
        assertThat(first.getCount100(), equalTo(123));
        assertThat(first.getCount50(), equalTo(69));
        assertThat(first.getPlayCount(), equalTo(42));
        assertThat(first.getRankedScore(), equalTo(666666L));
        assertThat(first.getTotalScore(), equalTo(999999998L));
        assertThat(first.getPpRank(), equalTo(2442));
        assertThat((double) first.getLevel(), closeTo(50.5050, 0.0001));
        assertThat((double) first.getPpRaw(), closeTo(3113, 0.1));
        assertThat((double) first.getAccuracy(), closeTo(98.1234, 0.0001));
        assertThat(first.getCountRankSs(), equalTo(54));
        assertThat(first.getCountRankS(), equalTo(81));
        assertThat(first.getCountRankA(), equalTo(862));
        assertThat(first.getCountry(), equalTo(Locale.GERMAN));

        List<UserEvent> events = first.getEvents();
        assertThat(events.size(), equalTo(1));

        UserEvent firstEvent = events.get(0);
        assertThat(firstEvent.getDisplayHtml(), equalTo("<img src='/images/A_small.png'/>..."));
        assertThat(firstEvent.getBeatmapId(), equalTo(222342));
        assertThat(firstEvent.getBeatmapSetId(), equalTo(54851));
        assertThat(firstEvent.getDate(), equalTo(DateUtils.parseDate("2013-07-07 22:34:04")));
        assertThat(firstEvent.getEpicFactor(), equalTo((short) 1));
    }
}
