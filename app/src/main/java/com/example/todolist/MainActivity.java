package com.example.todolist;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private CalendarView calendarView;
    private TextView selectedDateTextView;
    private TodoManager todoManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TodoManager 초기화
        todoManager = new TodoManager();

        calendarView = findViewById(R.id.calendarView);
        selectedDateTextView = findViewById(R.id.selectedDateTextView);

        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            // 선택된 날짜에 대한 처리
            Date selectedDate = new Date(year - 1900, month, dayOfMonth); // Date 생성자는 deprecated되었지만 예제에서는 간단히 사용
            int todoCount = todoManager.getTodoCountForDate(selectedDate);
            selectedDateTextView.setText("할 일 개수: " + todoCount);
        });
    }
}


