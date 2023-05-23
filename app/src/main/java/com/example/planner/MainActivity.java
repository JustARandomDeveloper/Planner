package com.example.planner;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

public class MainActivity extends AppCompatActivity {
    private CommitmentDbJava db;
    private String selectedDate;
    private String selectedHour;
    private EditText userDescription;

    public void setSelectedDate(String mselectedDate) {
        selectedDate = mselectedDate;
    }

    public void setSelectedHour(String mselectedHour) {
        selectedHour = mselectedHour;
    }

    private TextView commitmentTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userDescription = findViewById(R.id.description);
        Button btnOK = findViewById(R.id.btn_ok);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String description = userDescription.getText().toString();
                addAppointments(selectedDate, selectedHour, description);
                showAppointments();

            }
        });

        Button btnToday = findViewById(R.id.btn_today);
        commitmentTextView = findViewById(R.id.text_scroll);

        btnToday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAppointments();
            }
        });
    }

    public void showDialogTimePicker(View v) {
        DialogFragment newFragment = new FragmentTimePickerJava();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    public void showDialogDatePicker(View v) {
        DialogFragment newFragment = new FragmentDatePickerJava();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    private void addAppointments(String date, String hour, String description) {
        if (db == null) {
            db = new CommitmentDbJava(this);
        }

        CommitmentJava userCommitment = new CommitmentJava(date, hour, description);
        db.addCommitment(userCommitment);
    }

    private void showAppointments() {
        if (db == null) {
            return;
        }
        Cursor cursor = db.queryCommitments(null, null);
        StringBuilder stringBuilder = new StringBuilder();

        if (cursor != null && cursor.moveToFirst()) {
            do {
                String date = cursor.getString(cursor.getColumnIndexOrThrow(DbSchemaJava.CommitmentTable.Cols.date));
                String hour = cursor.getString(cursor.getColumnIndexOrThrow(DbSchemaJava.CommitmentTable.Cols.hour));
                String description = cursor.getString(cursor.getColumnIndexOrThrow(DbSchemaJava.CommitmentTable.Cols.description));

                if (!description.isEmpty()) {
                    stringBuilder.append(date).append("  ").append(hour).append("  ").append(description).append("\n");
                }
            } while (cursor.moveToNext());

            cursor.close();
        }

        commitmentTextView.setText(stringBuilder.toString());
    }
}
