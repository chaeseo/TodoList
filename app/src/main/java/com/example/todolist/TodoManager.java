package com.example.todolist;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TodoManager {
    private List<TodoItem> todoItems;

    public TodoManager() {
        // Initialize the todoItems list
        todoItems = new ArrayList<>();
    }

    public int getTodoCountForDate(Date date) {
        int count = 0;
        for (TodoItem item : todoItems) {
            if (isSameDate(item.getDate(), date)) {
                count++;
            }
        }
        return count;
    }

    private boolean isSameDate(Date date1, Date date2) {
        // Implement the logic to check if the dates are the same
        // For simplicity, let's assume that dates are the same if their time in milliseconds is the same
        return date1.getTime() == date2.getTime();
    }
}
