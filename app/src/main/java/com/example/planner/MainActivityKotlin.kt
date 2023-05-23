package com.example.planner;

import android.database.Cursor
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment


class MainActivityKotlin : AppCompatActivity() {
    private var db:CommitmentDbKotlin? = null;
    private var selectedDate: String? = null;
    private var selectedHour: String? = null;
    private lateinit var userDescription: EditText;


    fun setSelectedDate(mselectedDate: String) {
        this.selectedDate = mselectedDate
    }

    fun setSelectedHour(mselectedHour: String) {
        this.selectedHour = mselectedHour
    }

    private lateinit var commitmentTextView: TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userDescription = findViewById(R.id.description)
        val btnOK = findViewById<Button>(R.id.btn_ok)

        btnOK.setOnClickListener(View.OnClickListener {
            val description = userDescription.text.toString()
            addAppointments(date = selectedDate!!, hour = selectedHour!!, description = userDescription.toString())
        })

        val btnToday = findViewById<Button>(R.id.btn_today)
        commitmentTextView = findViewById(R.id.text_scroll)

        btnToday.setOnClickListener(View.OnClickListener { showAppointments() })
    }

    fun showDialogTimePicker(v: View?) {
        val newFragment: DialogFragment = FragmentTimePickerKotlin()
        newFragment.show(supportFragmentManager, "timePicker")
    }

    fun showDialogDatePicker(v: View?) {
        val newFragment: DialogFragment = FragmentDatePickerKotlin()
        newFragment.show(supportFragmentManager, "datePicker")
    }

    private fun addAppointments(date: String, hour: String, description: String) {
        if (db == null) {
            db = CommitmentDbKotlin(this)
        }

        val userCommitment = CommitmentKotlin(date, hour, description)
        db!!.addCommitment(userCommitment);
    }

    private fun showAppointments() {
        if (db == null) return

        val cursor: Cursor? = db?.queryCommitment(null, null)
        val stringBuilder = StringBuilder()

        if (cursor != null && cursor.moveToFirst()) {
            do {
                val date: String = cursor.getString(cursor.getColumnIndexOrThrow(DbSchemaKotlin.CommitmentTable.Cols.date))
                val hour: String = cursor.getString(cursor.getColumnIndexOrThrow(DbSchemaKotlin.CommitmentTable.Cols.hour))
                val description: String = cursor.getString(cursor.getColumnIndexOrThrow(DbSchemaKotlin.CommitmentTable.Cols.description))

                if (hour != null && !description.isEmpty()) {
                    stringBuilder.append(date).append("  ").append(hour).append("  ").append(description).append("\n")
                }
            } while (cursor.moveToNext())

            cursor.close()
        }

        commitmentTextView.text = stringBuilder.toString()
    }


}
