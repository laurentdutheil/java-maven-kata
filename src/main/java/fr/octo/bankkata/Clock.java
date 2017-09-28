package fr.octo.bankkata;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Clock {

    public String currentDate() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
