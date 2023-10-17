package com.example.todolist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class WeeklyCalendarAdapter extends RecyclerView.Adapter<WeeklyCalendarAdapter.WeeklyCalendarViewHolder> {
    private List<Date> weeklyDates;

    public WeeklyCalendarAdapter(List<Date> weeklyDates) {
        this.weeklyDates = weeklyDates;
    }

    @Override
    public WeeklyCalendarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.weekly_calendar_item, parent, false);
        return new WeeklyCalendarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WeeklyCalendarViewHolder holder, int position) {
        Date date = weeklyDates.get(position);
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        holder.button.setText(sdf.format(date));

        // 일자 클릭 이벤트 처리
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 일자를 클릭했을 때 수행할 작업 추가
                // 예: 선택한 날짜를 표시 또는 다른 활동으로 이동
            }
        });
    }

    @Override
    public int getItemCount() {
        return weeklyDates.size();
    }

    public static class WeeklyCalendarViewHolder extends RecyclerView.ViewHolder {
        Button button;

        public WeeklyCalendarViewHolder(View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.buttonDate); // 버튼 또는 다른 View의 ID
        }
    }
}


