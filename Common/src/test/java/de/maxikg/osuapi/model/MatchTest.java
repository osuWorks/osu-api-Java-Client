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
public class MatchTest {

    @Test
    public void testFromFile() throws Throwable {
        ObjectMapper mapper = new ObjectMapper();
        List<Match> matches = mapper.readValue(getClass().getResourceAsStream("/api/responses/get_match.json"), new TypeReference<List<Match>>() {
        });

        assertThat(matches.size(), equalTo(1));

        Match first = matches.get(0);

        MatchDetails firstDetails = first.getDetails();
        assertThat(firstDetails.getMatchId(), equalTo(1936471));
        assertThat(firstDetails.getName(), equalTo("Marcin's game"));
        assertThat(firstDetails.getStartTime(), equalTo(DateUtils.parseDate("2013-10-06 03:34:54")));
        assertThat(firstDetails.getEndTime(), nullValue());

        List<MatchGame> firstGames = first.getGames();
        assertThat(firstGames.size(), equalTo(1));

        MatchGame firstGame = firstGames.get(0);
        assertThat(firstGame.getGameId(), equalTo(45668898));
        assertThat(firstGame.getStartTime(), equalTo(DateUtils.parseDate("2013-10-06 03:36:27")));
        assertThat(firstGame.getEndTime(), equalTo(DateUtils.parseDate("2013-10-06 03:40:01")));
        assertThat(firstGame.getBeatmapId(), equalTo(181717));
        assertThat(firstGame.getPlayMode(), equalTo(GameMode.byValue(0).orNull()));
        assertThat(firstGame.getMatchType(), equalTo(0));
        assertThat(firstGame.getScoringType(), equalTo(WinningCondition.byValue(0).orNull()));
        assertThat(firstGame.getTeamType(), equalTo(TeamType.byValue(0).orNull()));
        assertThat(firstGame.getMods().size(), equalTo(0));

        List<MatchScore> firstScores = firstGame.getScores();
        assertThat(firstScores.size(), equalTo(1));

        MatchScore firstScore = firstScores.get(0);
        assertThat(firstScore.getSlot(), equalTo(0));
        assertThat(firstScore.getTeam(), equalTo(Team.byValue(0).orNull()));
        assertThat(firstScore.getUserId(), equalTo(722665));
        assertThat(firstScore.getScore(), equalTo(3415874));
        assertThat(firstScore.getMaxCombo(), equalTo(411));
        assertThat(firstScore.getRank(), equalTo(0));
        assertThat(firstScore.getCount50(), equalTo(0));
        assertThat(firstScore.getCount100(), equalTo(11));
        assertThat(firstScore.getCount300(), equalTo(425));
        assertThat(firstScore.getCountMiss(), equalTo(1));
        assertThat(firstScore.getCountGeki(), equalTo(67));
        assertThat(firstScore.getCountKatu(), equalTo(9));
        assertThat(firstScore.isPerfect(), equalTo(false));
        assertThat(firstScore.isPass(), equalTo(true));
    }
}
