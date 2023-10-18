package com.example.todolist;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private CalendarView calendarView;
    private EditText editTextTask;
    private Button buttonAdd;
    private ListView listViewTasks;
    private ArrayAdapter<TaskItem> tasksAdapter; // ArrayAdapter의 제네릭을 TaskItem으로 변경
    private ArrayList<TaskItem> taskList; // ArrayList의 제네릭을 TaskItem으로 변경

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarView = findViewById(R.id.calendarView);
        editTextTask = findViewById(R.id.editTextTask);
        buttonAdd = findViewById(R.id.buttonAdd);
        listViewTasks = findViewById(R.id.listViewTasks);

        taskList = new ArrayList<>();
        tasksAdapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.taskText, taskList);
        listViewTasks.setAdapter(tasksAdapter);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                // 달력 선택일 변경 이벤트 처리
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String task = editTextTask.getText().toString();
                if (!task.isEmpty()) {
                    // 새로운 TaskItem 객체를 생성하고 목록에 추가
                    TaskItem newTask = new TaskItem(task);
                    taskList.add(newTask);
                    tasksAdapter.notifyDataSetChanged();
                    editTextTask.setText("");
                }
            }
        });

        listViewTasks.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 아이템 클릭 이벤트 처리
                CheckBox checkBox = view.findViewById(R.id.checkBox);
                TaskItem taskItem = taskList.get(position);
                taskItem.setChecked(checkBox.isChecked());
            }
        });
    }

    // TaskItem 클래스 정의
    public class TaskItem {
        private String taskText;
        private boolean checked;

        public TaskItem(String taskText) {
            this.taskText = taskText;
            this.checked = false;
        }

        public String getTaskText() {
            return taskText;
        }

        public boolean isChecked() {
            return checked;
        }

        public void setChecked(boolean checked) {
            this.checked = checked;
        }

        @Override
        public String toString() {
            return taskText;
        }
    }
}