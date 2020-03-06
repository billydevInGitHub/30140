package exp013.datetime.classses;

import java.time.*;

public class Test {
    public static void main(String[] args) {
        //LocalTime
        LocalTime thisSec = LocalTime.now();

        // implementation of display code is left to the reader
        System.out.printf("hour,minute,seconds are: %s,%s,%s,%n",thisSec.getHour(), thisSec.getMinute(), thisSec.getSecond());

        //LocalDateTime
        System.out.printf("%n%nLocalDateTime now: %s%n", LocalDateTime.now());

        System.out.printf("Apr 15, 1994 @ 11:30am: %s%n",
                LocalDateTime.of(1994, Month.APRIL, 15, 11, 30));

        System.out.printf("now (from Instant): %s%n",
                LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()));

        System.out.printf("6 months from now: %s%n",
                LocalDateTime.now().plusMonths(6));

        System.out.printf("6 months ago: %s%n",
                LocalDateTime.now().minusMonths(6));

        //
    }
}
