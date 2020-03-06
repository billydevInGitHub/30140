package exp020.period.duration;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Test {
    public static void main(String[] args) {

        Instant t1 = Instant.now();
        Instant t2=t1.plusMillis(20);
        System.out.println("During in nano:"+Duration.between(t1,t2).getNano());

        System.out.println(ChronoUnit.MILLIS.between(t1,t2));

        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(1960, Month.JANUARY, 1);

        Period p = Period.between(birthday, today);
        long p2 = ChronoUnit.DAYS.between(birthday, today);
        System.out.println("You are " + p.getYears() + " years, " + p.getMonths() +
                " months, and " + p.getDays() +
                " days old. (" + p2 + " days total)");
    }
}
