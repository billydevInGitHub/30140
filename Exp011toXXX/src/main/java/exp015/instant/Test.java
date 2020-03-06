package exp015.instant;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class Test {

    public static void main(String[] args) {
        Instant timestamp = Instant.now();
        System.out.println("instant now :"+timestamp);
        Instant oneHourLater = Instant.now().plusSeconds(3600);
        System.out.println("instant time after an hour:"+oneHourLater);

        long secondsFromEpoch = Instant.ofEpochSecond(0L).until(Instant.now(),
                ChronoUnit.SECONDS);
        System.out.println("secondsFromEpoch:"+secondsFromEpoch);

        Instant timestampNow=Instant.now();

        LocalDateTime ldt = LocalDateTime.ofInstant(timestampNow, ZoneId.systemDefault());
        System.out.printf("Information of LocalDateTime constructed from instant : %s %d %d at %d:%d%n", ldt.getMonth(), ldt.getDayOfMonth(),
                ldt.getYear(), ldt.getHour(), ldt.getMinute());

    }
}
