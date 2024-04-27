package com.example.todolistapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Objects;

public class CustomAddTaskDialog extends Dialog {
    EditText taskName;
    Button cancleBtn,saveBtn,datePicker;
    String date;
    Context context;

    public CustomAddTaskDialog(Context context) {
        super(context);
        this.context = context;

    }

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.custom_add_task_dialog);

        taskName=findViewById(R.id.taskName);
        datePicker=findViewById(R.id.datePicker);
        cancleBtn=findViewById(R.id.cancel_Btn);
        saveBtn=findViewById(R.id.save_Btn);

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(Objects.requireNonNull(getWindow()).getAttributes());
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        getWindow().setAttributes(layoutParams);

        datePicker.setOnClickListener(v -> showDatePickerDialog());

        cancleBtn.setOnClickListener(v -> dismiss());
        saveBtn.setOnClickListener(v -> {
            String taskname = taskName.getText().toString();
            date = datePicker.getText().toString();
            TaskEntity taskTabel=new TaskEntity(taskname,date);
            AppDataBase.executorService.execute(() -> {
                AppDataBase appDataBase= AppDataBase.getInstance(context);
                DaoTaskTabel daoTaskTabel= appDataBase.daoTaskTabel();
                daoTaskTabel.insertTask(taskTabel);
            });


            dismiss();
        });
    }
    private void showDatePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                (view, year1, month1, dayOfMonth1) -> {
                    // Handle date selection here
                    date = dayOfMonth1 + "/" + (month1 + 1) + "/" + year1;
                    datePicker.setText(date);

                }, year, month, dayOfMonth);
        datePickerDialog.show();
    }
}
