package exp017.temporal.packagerelated;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.IsoFields;

public class Test {
    public static void main(String[] args) {



        //temporal stuff are used within the parameters of methods
        //ChronoField and IsoFields
        boolean isSupported = LocalDate.now().isSupported(ChronoField.CLOCK_HOUR_OF_DAY);

        LocalTime time = LocalTime.now();
        System.out.println("milli of second:"+time.get(ChronoField.MILLI_OF_SECOND));
        LocalDate date =LocalDate.now();
        int qoy = date.get(IsoFields.QUARTER_OF_YEAR);
        System.out.println("quarter of year is:"+qoy);

        //ChronoUnit
        Instant instant=Instant.now();
        boolean isSupported2 = instant.isSupported(ChronoUnit.DAYS);
        System.out.println("is instant support DAYs:" + isSupported2);



    }
}
