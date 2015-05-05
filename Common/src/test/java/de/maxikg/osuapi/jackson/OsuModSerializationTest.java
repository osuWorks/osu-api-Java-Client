package de.maxikg.osuapi.jackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import de.maxikg.osuapi.model.Mod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * @author maxikg
 */
public class OsuModSerializationTest {

    @Test
    public void testSerializationProcess() throws Throwable {
        ObjectMapper mapper = new ObjectMapper();
        TestClass allMods = new TestClass(Sets.newHashSet(Mod.values()));
        String test = mapper.writeValueAsString(allMods);

        assertThat(Integer.parseInt(mapper.readValue(test, JsonNode.class).get("value").asText()), equalTo(Mod.createSum(Lists.newArrayList(Mod.values()))));

        Set<Mod> mods = mapper.readValue(test, TestClass.class).getValue();
        assertThat(mods.size(), equalTo(Mod.values().length));
        for (Mod mod : Mod.values())
            assertThat(mods.contains(mod), equalTo(true));
    }

    @Data @NoArgsConstructor @AllArgsConstructor
    public static class TestClass {

        @JsonSerialize(using = OsuModSerializer.class)
        @JsonDeserialize(using = OsuModDeserializer.class)
        private Set<Mod> value;
    }
}
