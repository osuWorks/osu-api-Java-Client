package de.maxikg.osuapi.utils;

import com.google.common.base.Throwables;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author maxikg
 */
@NoArgsConstructor(access = AccessLevel.NONE)
public class DateUtils {

    private static final DateFormat OSU_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    static {
        OSU_DATE_FORMAT.setTimeZone(TimeZone.getTimeZone("UTC+8"));
    }

    public static Date parseDate(String input) {
        try {
            synchronized (OSU_DATE_FORMAT) {
                return OSU_DATE_FORMAT.parse(input);
            }
        } catch (ParseException e) {
            throw Throwables.propagate(e);
        }
    }

    public static String formatDate(Date date) {
        synchronized (OSU_DATE_FORMAT) {
            return OSU_DATE_FORMAT.format(date);
        }
    }
}
