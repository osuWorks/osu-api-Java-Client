package de.maxikg.osuapi.model;

import com.google.common.collect.ImmutableSet;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

/**
 * @since 1.0
 * @author maxikg
 */
@RequiredArgsConstructor
public enum Mod {

    NO_FAIL(1),
    EASY(2),
    HIDDEN(8),
    HARD_ROCK(16),
    SUDDEN_DEATH(32),
    DOUBLE_TIME(64),
    RELAX(128),
    HALF_TIME(256),
    NIGHTCORE(512),
    FLASHLIGHT(1024),
    AUTOPLAY(2048),
    SPUN_OUT(4096),
    RELAX_2(8192),
    PERFECT(16384),
    KEY_4(32768),
    KEY_5(65536),
    KEY_6(131072),
    KEY_7(262144),
    KEY_8(524288),
    KEY_MOD(KEY_4.getFlag() | KEY_5.getFlag() | KEY_6.getFlag() | KEY_7.getFlag() | KEY_8.getFlag()),
    FADE_IN(1048576),
    RANDOM(2097152),
    LAST_MOD(4194304),
    FREE_MOD_ALLOWED(NO_FAIL.getFlag() | EASY.getFlag() | HIDDEN.getFlag() | HARD_ROCK.getFlag() | SUDDEN_DEATH.getFlag() | FLASHLIGHT.getFlag() | FADE_IN.getFlag() | RELAX.getFlag() | RELAX_2.getFlag() | SPUN_OUT.getFlag() | KEY_MOD.getFlag()),
    KEY_9(16777216),
    KEY_10(33554432),
    KEY_1(67108864),
    KEY_3(134217728),
    KEY_2(268435456);

    @Getter
    private final int flag;

    public boolean isEnabled(int flagSum) {
        int flag = getFlag();

        return (flagSum & flag) == flag;
    }

    public static Set<Mod> parseFlagSum(int flagSum) {
        ImmutableSet.Builder<Mod> builder = ImmutableSet.builder();

        for (Mod mod : values()) {
            if (mod.isEnabled(flagSum))
                builder.add(mod);
        }

        return builder.build();
    }

    public static int createSum(Iterable<Mod> mods) {
        int sum = 0;

        for (Mod mod : mods)
            sum |= mod.getFlag();

        return sum;
    }
}
