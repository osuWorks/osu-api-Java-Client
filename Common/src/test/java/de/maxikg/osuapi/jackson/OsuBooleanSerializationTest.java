package de.maxikg.osuapi.jackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * @author maxikg
 */
public class OsuBooleanSerializationTest {

    @Test
    public void testSerializationProcess() throws Throwable {
        ObjectMapper mapper = new ObjectMapper();

        String trueTest = mapper.writeValueAsString(new TestClass(true));
        assertThat(mapper.readValue(trueTest, JsonNode.class).get("value").asText(), equalTo("1"));
        assertThat(mapper.readValue(trueTest, TestClass.class).isValue(), equalTo(true));

        String falseTest = mapper.writeValueAsString(new TestClass(false));
        assertThat(mapper.readValue(falseTest, JsonNode.class).get("value").asText(), equalTo("0"));
        assertThat(mapper.readValue(falseTest, TestClass.class).isValue(), equalTo(false));
    }

    @Data @NoArgsConstructor @AllArgsConstructor
    public static class TestClass {

        @JsonSerialize(using = OsuBooleanSerializer.class)
        @JsonDeserialize(using = OsuBooleanDeserializer.class)
        private boolean value;
    }
}
