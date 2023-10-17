package com.example.todolist;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TodoItem {

    private String title;
    private Date date;

    public TodoItem(String title, Date date) {
        this.title = title;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    // Utility method to get a formatted string representation of the date
    public String getFormattedDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return sdf.format(date);
    }

    // Utility method to check if two dates represent the same day
    public boolean isSameDay(Date otherDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return sdf.format(date).equals(sdf.format(otherDate));
    }
}
