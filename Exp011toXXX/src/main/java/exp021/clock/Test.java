package exp021.clock;

import java.time.Clock;
import java.time.LocalDateTime;

public class Test {
    public static void main(String[] args) {
        System.out.println(LocalDateTime.now());

        System.out.println(LocalDateTime.now(Clock.systemUTC())); //is that time zone's now local datetime
    }
}
