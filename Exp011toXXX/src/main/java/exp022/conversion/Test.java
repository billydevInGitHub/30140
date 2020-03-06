package exp022.conversion;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.chrono.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DecimalStyle;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;

public class Test {



    public static void main(String[] args) {

        //to non-iso///////////////////////////
        //quick conversion using from
        LocalDateTime date = LocalDateTime.of(2013, Month.JULY, 20, 19, 30);
        JapaneseDate jdate     = JapaneseDate.from(date);
        HijrahDate hdate       = HijrahDate.from(date);
        MinguoDate mdate       = MinguoDate.from(date);
        ThaiBuddhistDate tdate = ThaiBuddhistDate.from(date);
        System.out.println("Japanese time:"+jdate);
        System.out.println("HijrahDate:"+hdate);
        System.out.println("MinguoDate:"+mdate);
        System.out.println("ThaiBuddhistDate:"+tdate);


        //use the converter
        LocalDate date2 = LocalDate.of(1996, Month.OCTOBER, 29);
        System.out.printf("%s%n",
                toString(date2, JapaneseChronology.INSTANCE));
        System.out.printf("%s%n",
                toString(date2, MinguoChronology.INSTANCE));
        System.out.printf("%s%n",
                toString(date2, ThaiBuddhistChronology.INSTANCE));
        System.out.printf("%s%n",
                toString(date2, HijrahChronology.INSTANCE));




        //to iso///////////////////////////////////
        LocalDate date3 = LocalDate.from(JapaneseDate.now());
        System.out.println("now date from JapaneseDate:"+date3);//now is unchanged I guess

        //use converter
        System.out.printf("%s%n", fromString("10/29/0008 H",
                JapaneseChronology.INSTANCE));
        System.out.printf("%s%n", fromString("10/29/0085 1",
                MinguoChronology.INSTANCE));
        System.out.printf("%s%n", fromString("10/29/2539 B.E.",
                ThaiBuddhistChronology.INSTANCE));
        System.out.printf("%s%n", fromString("6/16/1417 1",
                HijrahChronology.INSTANCE));

    }


    public static String toString(LocalDate localDate, Chronology chrono) {
        if (localDate != null) {
            Locale locale = Locale.getDefault(Locale.Category.FORMAT);
            ChronoLocalDate cDate;
            if (chrono == null) {
                chrono = IsoChronology.INSTANCE;
            }
            try {
                cDate = chrono.date(localDate);
            } catch (DateTimeException ex) {
                System.err.println(ex);
                chrono = IsoChronology.INSTANCE;
                cDate = localDate;
            }
            DateTimeFormatter dateFormatter =
                    DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)
                            .withLocale(locale)
                            .withChronology(chrono)
                            .withDecimalStyle(DecimalStyle.of(locale));
            String pattern = "M/d/yyyy GGGGG";
            return dateFormatter.format(cDate);
        } else {
            return "";
        }
    }


    /**
     * Parses a String to a ChronoLocalDate using a DateTimeFormatter
     * with a short pattern based on the current Locale and the
     * provided Chronology, then converts this to a LocalDate (ISO)
     * value.
     *
     * @param text   - the input date text in the SHORT format expected
     *                 for the Chronology and the current Locale.
     *
     * @param chrono - an optional Chronology. If null, then IsoChronology
     *                 is used.
     */
    public static LocalDate fromString(String text, Chronology chrono) {
        if (text != null && !text.isEmpty()) {
            Locale locale = Locale.getDefault(Locale.Category.FORMAT);
            if (chrono == null) {
                chrono = IsoChronology.INSTANCE;
            }
            String pattern = "M/d/yyyy GGGGG";
            DateTimeFormatter df = new DateTimeFormatterBuilder().parseLenient()
                    .appendPattern(pattern)
                    .toFormatter()
                    .withChronology(chrono)
                    .withDecimalStyle(DecimalStyle.of(locale));
            TemporalAccessor temporal = df.parse(text);
            ChronoLocalDate cDate = chrono.date(temporal);
            return LocalDate.from(cDate);
        }
        return null;
    }
}
