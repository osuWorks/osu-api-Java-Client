package de.maxikg.osuapi.utils;

import com.google.common.base.Optional;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Utils to deal with {@link Valuable}.
 *
 * @since 1.0
 * @author maxikg
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ValuableUtils {

    /**
     * Identifies a enum value based on value returned by {@link Valuable#getValue()}.
     *
     * @param enumClass The class of the enumeration type.
     * @param value The value to search for (it can be null).
     * @param <T> The value type.
     * @param <U> The enum entry type.
     * @return A {@link Optional} value. Absent if no enum entry matches given value.
     */
    public static <T, U extends Enum<U> & Valuable<T>> Optional<U> getByValue(Class<U> enumClass, T value) {
        for (U enumerationValue : enumClass.getEnumConstants()) {
            T currentValue = enumerationValue.getValue();

            if ((currentValue == null && value == null) || (value != null && value.equals(currentValue)))
                return Optional.fromNullable(enumerationValue);
        }

        return Optional.absent();
    }
}
