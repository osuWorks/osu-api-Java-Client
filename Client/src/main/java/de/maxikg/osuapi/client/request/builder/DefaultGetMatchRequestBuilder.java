package de.maxikg.osuapi.client.request.builder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.maxikg.osuapi.model.Match;
import org.apache.http.client.HttpClient;

import java.util.Collection;

/**
 * @author maxikg
 */
public class DefaultGetMatchRequestBuilder extends AbstractRequestBuilder implements GetMatchRequestBuilder {

    private static final String ENDPOINT = "get_match";
    private static final String PARAM_MATCH_ID = "mp";

    public DefaultGetMatchRequestBuilder(ObjectMapper objectMapper, HttpClient client, String baseUrl, String apiKey, int matchId) {
        super(objectMapper, client, baseUrl, apiKey);

        parameters.put(PARAM_MATCH_ID, matchId);
    }

    @Override
    public Collection<Match> query() {
        return execute(ENDPOINT, new TypeReference<Collection<Match>>() {
        });
    }
}
