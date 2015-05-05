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
public enum WinningCondition implements Valuable<Integer> {

    SCORE(0),
    ACCURACY(1),
    COMBO(2);

    private final Integer value;

    @JsonValue
    public Integer getValue() {
        return value;
    }

    @JsonCreator
    public static Optional<WinningCondition> byValue(int value) {
        return ValuableUtils.getByValue(WinningCondition.class, value);
    }
}
