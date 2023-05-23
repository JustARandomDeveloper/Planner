package com.example.planner;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.TimePicker;
import androidx.fragment.app.DialogFragment;
import java.util.Calendar;

public class FragmentTimePickerJava extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    private MainActivity mainActivity= new MainActivity();

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        return new TimePickerDialog(requireActivity(), this, hour, minute, DateFormat.is24HourFormat(requireActivity()));
    }

    @Override
    public void onTimeSet(TimePicker view, int hour, int minute) {
        Log.i("Date:", "Hour: " + hour);
        Log.i("Date:", "Minute: " + minute);
        mainActivity.setSelectedHour(hour + ":" + minute);
    }
}
