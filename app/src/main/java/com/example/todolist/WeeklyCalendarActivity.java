package com.example.todolist;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class WeeklyCalendarActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private WeeklyCalendarAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_calendar);

        // RecyclerView 초기화
        recyclerView = findViewById(R.id.weeklyCalendarRecyclerView);

        // GridLayoutManager 설정 (7개의 열로 표시)
        GridLayoutManager layoutManager = new GridLayoutManager(this, 7);
        recyclerView.setLayoutManager(layoutManager);

        // MainActivity에서 전달한 선택된 날짜를 받아옴
        Date selectedDate = (Date) getIntent().getSerializableExtra("selectedDate");

        // 주간 날짜 목록 생성
        List<Date> weeklyDates = generateWeeklyDates(selectedDate);

        // 어댑터 초기화 (주간 달력 아이템을 표시하기 위해)
        adapter = new WeeklyCalendarAdapter(weeklyDates);
        recyclerView.setAdapter(adapter);
    }

    public static List<Date> generateWeeklyDates(Date selectedDate) {
        List<Date> weeklyDates = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(selectedDate);

        // 선택한 날짜의 요일 (일요일: 1, 월요일: 2, ..., 토요일: 7)
        int selectedDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        // 주의 시작을 일요일로 설정 (이를 월요일로 변경하려면 -1을 더합니다)
        calendar.add(Calendar.DATE, 1 - selectedDayOfWeek);

        // 주간 날짜 목록 생성 (예: 일요일부터 토요일까지)
        for (int i = 0; i < 7; i++) {
            weeklyDates.add(calendar.getTime());
            calendar.add(Calendar.DATE, 1); // 다음 날짜로 이동
        }

        return weeklyDates;
    }
}

