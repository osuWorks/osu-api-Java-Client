package de.maxikg.osuapi.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.base.Optional;
import de.maxikg.osuapi.utils.Valuable;
import de.maxikg.osuapi.utils.ValuableUtils;
import lombok.RequiredArgsConstructor;

/**
 * @author maxikg
 * @since 1.0
 */
@RequiredArgsConstructor
public enum TeamType implements Valuable<Integer> {

    HEAD_TO_HEAD(0),
    TAG_COOP(1),
    TEAM_VS(2),
    TAG_TEAM_VS(3);

    private final Integer value;

    @JsonValue
    public Integer getValue() {
        return value;
    }

    @JsonCreator
    public static Optional<TeamType> byValue(int value) {
        return ValuableUtils.getByValue(TeamType.class, value);
    }
}
