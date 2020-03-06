package exp012.dateclasses;

import java.time.*;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class Test {
    public static void main(String[] args) {
        //LocalDate
        LocalDate date = LocalDate.of(2000, Month.NOVEMBER, 20);
        LocalDate nextWed = date.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
        System.out.println(nextWed);

        DayOfWeek dotw = LocalDate.of(2012, Month.JULY, 9).getDayOfWeek();
        System.out.println(dotw);

         date = LocalDate.of(2000, Month.NOVEMBER, 20);
        TemporalAdjuster adj = TemporalAdjusters.next(DayOfWeek.WEDNESDAY);
         nextWed = date.with(adj);
        System.out.printf("For the date of %s, the next Wednesday is %s.%n",
                date, nextWed);

        //YearMonth
        YearMonth date1 = YearMonth.now();
        System.out.printf("%s: %d%n", date1, date1.lengthOfMonth());

        YearMonth date2 = YearMonth.of(2010, Month.FEBRUARY);
        System.out.printf("%s: %d%n", date2, date2.lengthOfMonth());

        YearMonth date3 = YearMonth.of(2012, Month.FEBRUARY);
        System.out.printf("%s: %d%n", date3, date3.lengthOfMonth());


        //MonthDay
        MonthDay date5 = MonthDay.of(Month.FEBRUARY, 29);
        boolean validLeapYear = date5.isValidYear(2010);
        System.out.println(date5);
        System.out.println(validLeapYear);

        //Year
         validLeapYear = Year.of(2012).isLeap();
        System.out.println(validLeapYear);
    }
}
