package de.maxikg.osuapi.model;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * @author maxikg
 */
public class ModTest {

    @Test
    public void testCreateSum() {
        int tmp = 0;
        for (Mod mod : Mod.values())
            tmp |= mod.getFlag();

        assertThat(Mod.createSum(Lists.newArrayList(Mod.values())), equalTo(tmp));
    }

    @Test
    public void testIsEnabled() {
        int allModsSum = Mod.createSum(Lists.newArrayList(Mod.values()));

        for (Mod mod : Mod.values())
            assertThat(mod.isEnabled(allModsSum), equalTo(true));
    }

    @Test
    public void testParseFlagSum() {
        Set<Mod> enabledMods = Mod.parseFlagSum(Mod.createSum(Lists.newArrayList(Mod.values())));
        for (Mod mod : Mod.values())
            assertThat(enabledMods.contains(mod), equalTo(true));
    }
}
