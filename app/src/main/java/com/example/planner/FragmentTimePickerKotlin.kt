package com.example.planner;

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import java.util.Calendar

class FragmentTimePickerKotlin : DialogFragment(), TimePickerDialog.OnTimeSetListener {

    private val mainActivity = MainActivity()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)


        return TimePickerDialog(requireActivity(), this, hour, minute, DateFormat.is24HourFormat(requireActivity()))
    }

    override fun onTimeSet(view: TimePicker?, hour: Int, minute: Int) {
        Log.i("Date", "Hour: $hour")
        Log.i("Date", "Minute: $minute")
        mainActivity.setSelectedHour(hour.toString() + ":" + minute)
    }
}
