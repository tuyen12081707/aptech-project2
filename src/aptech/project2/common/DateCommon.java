
package aptech.project2.common;

import aptech.project2.constant.Constant;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DateCommon {
    
    public static String convertDateToString(Date date, String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }

    public static Date convertStringToDateByPattern(String strTime, String pattern) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
            return dateFormat.parse(strTime);
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date convertStringDateToDate(String strTime) {
        try {
            Pattern jsonDatePattern = Pattern.compile("/Date\\((\\d+)([+-]\\d{4})\\)/");
            Matcher m = jsonDatePattern.matcher(strTime);
            if (m.matches()) {
                long epochMillis = Long.parseLong(m.group(1));
                String offsetString = m.group(2);
                OffsetDateTime dateTime = Instant.ofEpochMilli(epochMillis)
                        .atOffset(ZoneOffset.of(offsetString));
                Instant instant = dateTime.toInstant();
                Date myUtilDate = Date.from(instant);
                return myUtilDate;
            } else {
                return null;
            }
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static String convertDateToStringByPattern(Date date, String pattern) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
            return dateFormat.format(date);
        } catch (Exception e) {
            return "";
        }
    }

    public static String convertDateToString(Date date) {
        return convertDateToStringByPattern(date, Constant.DATE_FORMAT);
    }

    public static String convertDateTimeToString(Date date) {
        return convertDateToStringByPattern(date, Constant.DATE_TIME_FORMAT);
    }

    public static Date convertStringToDate(String strTime) {
        return convertStringToDateByPattern(strTime, Constant.DATE_FORMAT);
    }

    public static Date convertStringToDateTime(String strTime) {
        return convertStringToDateByPattern(strTime, Constant.DATE_TIME_FORMAT);
    }

    private static Date add(Date dt, int iValue, int iType) {
        Calendar cld = Calendar.getInstance();
        cld.setTime(dt);
        cld.add(iType, iValue);
        return cld.getTime();
    }

    public static Timestamp convertStringToTimestamp(String strTime, String pattern) throws Exception {
        if (!StringCommon.isNullOrBlank(strTime)) {
            return new Timestamp(convertStringToDateByPattern(strTime, pattern).getTime());
        }
        return null;
    }

    public static Date addYear(Date dt, int iValue) {
        return add(dt, iValue, Calendar.YEAR);
    }

    public static Date addMonth(Date dt, int iValue) {
        return add(dt, iValue, Calendar.MONTH);
    }

    public static Date addDay(Date dt, int iValue) {
        return add(dt, iValue, Calendar.DAY_OF_MONTH);
    }

    public static Date addHour(Date dt, int iValue) {
        return add(dt, iValue, Calendar.HOUR_OF_DAY);
    }

    public static Date addMinute(Date dt, int iValue) {
        return add(dt, iValue, Calendar.MINUTE);
    }

    public static Date addSecond(Date dt, int iValue) {
        return add(dt, iValue, Calendar.SECOND);
    }

    public static Date addMilliSecond(Date dt, int iValue) {
        return add(dt, iValue, Calendar.MILLISECOND);
    }

    private static Date set(Date dt, int iValue, int iType) {
        Calendar cld = Calendar.getInstance();
        cld.setTime(dt);
        cld.set(iType, iValue);
        return cld.getTime();
    }

    public static Date setYear(Date dt, int iValue) {
        return set(dt, iValue, Calendar.YEAR);
    }

    public static Date setMonth(Date dt, int iValue) {
        return set(dt, iValue, Calendar.MONTH);
    }

    public static Date setDay(Date dt, int iValue) {
        return set(dt, iValue, Calendar.DAY_OF_MONTH);
    }

    public static Date setHour(Date dt, int iValue) {
        return set(dt, iValue, Calendar.HOUR_OF_DAY);
    }

    public static Date setMinute(Date dt, int iValue) {
        return set(dt, iValue, Calendar.MINUTE);
    }

    public static Date setSecond(Date dt, int iValue) {
        return set(dt, iValue, Calendar.SECOND);
    }

    public static Date setMilliSecond(Date dt, int iValue) {
        return set(dt, iValue, Calendar.MILLISECOND);
    }

    public static long subDay(Date date1, Date date2) {
        if ((date1 == null) && (date2 == null)) {
            return 0L;
        }
        if (date1 == null) {
            return date2.getTime() / 86400000L;
        }
        if (date2 == null) {
            return -1L * date1.getTime() / 86400000L;
        }
        return (date2.getTime() - date1.getTime()) / 86400000L;
    }

    public static long subTime(Date date1, Date date2) {
        if ((date1 == null) && (date2 == null)) {
            return 0L;
        }
        if (date1 == null) {
            return date2.getTime();
        }
        if (date2 == null) {
            return -1L * date1.getTime();
        }
        return date2.getTime() - date1.getTime();
    }

    public static Date getToday() {
        return new Date();
    }

    public static Date getBeginDay(Date date) {
        date = setHour(date, 0);
        date = setMinute(date, 0);
        date = setSecond(date, 0);
        date = setMilliSecond(date, 0);

        return date;
    }

    public static Date getEndDay(Date date) {
        date = setHour(date, 23);
        date = setMinute(date, 59);
        date = setSecond(date, 59);
        date = setMilliSecond(date, 999);

        return date;
    }

    public static Date getBeginMonth(Date date) {
        date = setHour(date, 0);
        date = setMinute(date, 0);
        date = setSecond(date, 0);
        date = setMilliSecond(date, 0);
        date = setDay(date, 1);
        return date;
    }

    public static Date getEndMonth(Date date) {
        date = setHour(date, 0);
        date = setMinute(date, 0);
        date = setSecond(date, 0);
        date = setMilliSecond(date, 0);
        date = setDay(date, 1);
        date = addMonth(date, 1);
        date = addMilliSecond(date, -1);
        return date;
    }

    public static Date getBeginYear(Date date) {
        date = setHour(date, 0);
        date = setMinute(date, 0);
        date = setSecond(date, 0);
        date = setMilliSecond(date, 0);
        date = setDay(date, 1);
        date = setMonth(date, 0);
        return date;
    }

    public static Date getEndYear(Date date) {
        date = setHour(date, 0);
        date = setMinute(date, 0);
        date = setSecond(date, 0);
        date = setMilliSecond(date, 0);
        date = setDay(date, 1);
        date = setMonth(date, 0);
        date = addYear(date, 1);
        date = addMilliSecond(date, -1);
        return date;
    }

    public static int dayOfWeek(Date date) {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        //Converting the date to Instant
        Instant instant = date.toInstant();
        //Converting the Date to LocalDate
        LocalDate localDate = instant.atZone(defaultZoneId).toLocalDate();
        // Get day of week
        return localDate.getDayOfWeek().getValue();
    }

    public static int dayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DATE);
    }

    public static int dayOfYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_YEAR);
    }

    public static int monthOfDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH);
    }

    public static int yearOfDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    public static Date getTomorrow(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        return c.getTime();
    }

    public static java.sql.Date convertUtilDateToSqlDate(Date date) {
        if (date == null) {
            return null;
        } else {
            try {
                return new java.sql.Date(date.getTime());
            } catch (Exception e) {
                return null;
            }
        }
    }

    public static java.sql.Date convertDateToSqlDate(Date date) {
        return new java.sql.Date(date.getTime());
    }
    
    public static Timestamp convertDateToTimestamp(Date date) {
        return new java.sql.Timestamp(date.getTime());
    }
    
    public static Date convertTimestampToDate(Timestamp time) {
        return new Date(time.getTime());
    }
    
}
