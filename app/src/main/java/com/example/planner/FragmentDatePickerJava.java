package com.example.planner;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import android.util.Log;
import android.widget.DatePicker;
import java.util.Calendar;

public class FragmentDatePickerJava extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private MainActivity mainActivity= new MainActivity();


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(requireContext(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Log.i("Date", "Year:" + year);
        Log.i("Date", "Month:" + (month + 1));
        Log.i("Date", "Day:" + dayOfMonth);
        String formattedDate = String.valueOf(dayOfMonth) + "/" + String.valueOf(month+1) + "/" + String.valueOf(year);
        mainActivity.setSelectedDate(formattedDate);
    }
}
