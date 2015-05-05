package de.maxikg.osuapi.jackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import de.maxikg.osuapi.utils.DateUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * @author maxikg
 */
public class OsuDateSerializationTest {

    @Test
    public void testSerializationProcess() throws Throwable {
        ObjectMapper mapper = new ObjectMapper();
        Date current = current();
        String test = mapper.writeValueAsString(new TestClass(current));

        assertThat(mapper.readValue(test, JsonNode.class).get("value").asText(), equalTo(DateUtils.formatDate(current)));
        assertThat(mapper.readValue(test, TestClass.class).getValue(), equalTo(current));
    }

    private static Date current() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }

    @Data @NoArgsConstructor @AllArgsConstructor
    public static class TestClass {

        @JsonSerialize(using = OsuDateSerializer.class)
        @JsonDeserialize(using = OsuDateDeserializer.class)
        private Date value;
    }
}
