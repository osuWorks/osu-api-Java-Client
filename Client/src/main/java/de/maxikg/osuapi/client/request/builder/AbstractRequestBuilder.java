package de.maxikg.osuapi.client.request.builder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import de.maxikg.osuapi.client.exception.OsuClientException;
import de.maxikg.osuapi.client.exception.OsuClientRequestException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * @author maxikg
 */
public abstract class AbstractRequestBuilder {

    private static final String PARAM_API_KEY = "k";

    protected final Map<String, Object> parameters = Maps.newHashMap();
    private final ObjectMapper objectMapper;
    private final HttpClient client;
    private final String baseUrl;
    private final String apiKey;

    protected AbstractRequestBuilder(ObjectMapper objectMapper, HttpClient client, String baseUrl, String apiKey) {
        this.objectMapper = Preconditions.checkNotNull(objectMapper);
        this.client = Preconditions.checkNotNull(client);
        this.baseUrl = Preconditions.checkNotNull(baseUrl).endsWith("/") ? baseUrl : baseUrl + "/";
        this.apiKey = Preconditions.checkNotNull(apiKey);
    }

    protected final <T> T execute(String apiEndpoint, TypeReference<T> typeReference) {
        try {
            return objectMapper.readValue(execute(apiEndpoint), typeReference);
        } catch (IOException e) {
            throw new OsuClientException("Cannot parse json response.", e);
        }
    }

    private String execute(String apiEndpoint) {
        URIBuilder uriBuilder;
        try {
            uriBuilder = new URIBuilder(baseUrl + apiEndpoint);
        } catch (URISyntaxException e) {
            throw new OsuClientException("Invalid api uri.", e);
        }

        for (Map.Entry<String, Object> entry : parameters.entrySet()) {
            if (entry.getValue() != null)
                uriBuilder.setParameter(entry.getKey(), entry.getValue().toString());
        }
        uriBuilder.setParameter(PARAM_API_KEY, apiKey);

        HttpResponse response;
        try {
            response = client.execute(new HttpGet(uriBuilder.build()));
        } catch (URISyntaxException e) {
            throw new OsuClientException("Cannot construct url.");
        } catch (IOException e) {
            throw new OsuClientRequestException("Cannot execute api request.", e);
        }

        try {
            return EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            throw new OsuClientException("Cannot process api response.", e);
        }
    }
}
