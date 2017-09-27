package fr.octo.bankkata;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Clock {
    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    public String currentDate() {
        return formatter.format(new Date());
    }
}
