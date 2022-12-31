package gestiune.farmacie.utils;

import java.time.LocalDate;
import java.time.ZoneId;


public class DateConverter {
    public static LocalDate convertToLocalDateViaInstant(java.util.Date dateToConvert) {
        return ((java.sql.Date)dateToConvert).toLocalDate();
    }
}
