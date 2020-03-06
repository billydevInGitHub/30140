package exp019.temporal.query;

import java.time.*;
import java.time.temporal.*;

public class Test {

    private static class FamilyVacations implements TemporalQuery<Boolean> {
        public  Boolean queryFrom(TemporalAccessor date) {
            int month = date.get(ChronoField.MONTH_OF_YEAR);
            int day = date.get(ChronoField.DAY_OF_MONTH);

            // Angie's birthday is on April 3.
            if ((month == Month.APRIL.getValue()) && (day == 3))
                return Boolean.TRUE;

            // Sue's birthday is on June 18.
            if ((month == Month.JUNE.getValue()) && (day == 18))
                return Boolean.TRUE;

            // Joe's birthday is on May 29.
            if ((month == Month.MAY.getValue()) && (day == 29))
                return Boolean.TRUE;

            return Boolean.FALSE;
        }
    }

    public static void main(String[] args) {
        TemporalQuery<TemporalUnit> query = TemporalQueries.precision();
        System.out.printf("LocalDate precision is %s%n",
                LocalDate.now().query(query));
        System.out.printf("LocalDateTime precision is %s%n",
                LocalDateTime.now().query(query));
        System.out.printf("Year precision is %s%n",
                Year.now().query(query));
        System.out.printf("YearMonth precision is %s%n",
                YearMonth.now().query(query));
        System.out.printf("Instant precision is %s%n",
                Instant.now().query(query));


        //custom query
        System.out.printf("custom query is %s%n",
                LocalDateTime.now().query(new TemporalQuery<Boolean>() {

                    @Override
                    public Boolean queryFrom(TemporalAccessor date) {
                        int month = date.get(ChronoField.MONTH_OF_YEAR);
                        int day   = date.get(ChronoField.DAY_OF_MONTH);

                        // Disneyland over Spring Break
                        if ((month == Month.APRIL.getValue()) && ((day >= 3) && (day <= 8)))
                            return Boolean.TRUE;

                        // Smith family reunion on Lake Saugatuck
                        if ((month == Month.AUGUST.getValue()) && ((day >= 8) && (day <= 14)))
                            return Boolean.TRUE;

                        return Boolean.FALSE;
                    }
                }));



        //the second is a bit changed myself using lambda
        System.out.printf("custom query 2 is %s%n",
                LocalDateTime.now().query(new FamilyVacations()));

    }
}
