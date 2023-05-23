package com.example.planner;

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.util.Calendar

class FragmentDatePickerKotlin : DialogFragment(), DatePickerDialog.OnDateSetListener {

    private val mainActivity = MainActivity()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)


        return DatePickerDialog(requireContext(), this, year, month, day)
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        Log.i("Date", "Year: $year")
        Log.i("Date", "Month: ${month + 1}")
        Log.i("Date", "Day: $dayOfMonth")
        val formattedDate =
            dayOfMonth.toString() + "/" + (month + 1).toString() + "/" + year.toString()
        mainActivity.setSelectedDate(formattedDate)
    }
}
