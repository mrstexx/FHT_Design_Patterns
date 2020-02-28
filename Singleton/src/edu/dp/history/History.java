package edu.dp.history;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class History {
    private String userName;
    private LocalDateTime dateTime;

    public History(String userName, LocalDateTime dateTime) {
        this.dateTime = dateTime;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY, HH:mm");
        return this.getUserName() + ", " + this.getDateTime().format(formatter);
    }
}
