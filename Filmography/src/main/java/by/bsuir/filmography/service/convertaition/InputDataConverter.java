package by.bsuir.filmography.service.convertaition;

import java.time.LocalDate;

public class InputDataConverter {
    public static LocalDate convertDate(String date) {
        if(date.equals("")) {
            return null;
        }
        return LocalDate.parse(date);
    }
    public static int convertID(String id) {
        if(id.equals("")) {
            return -1;
        }
        return Integer.parseInt(id);
    }
}
