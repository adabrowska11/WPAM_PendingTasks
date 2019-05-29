package com.example.pendingtasks;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class NewTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        View view_data = findViewById(R.id.button_data);
        View view_data_label = findViewById(R.id.data_label);
        View view_time = findViewById(R.id.button_time);
        View view_time_label = findViewById(R.id.time_label);
        switch (view.getId()) {
            case R.id.dataigodzina:
                view_data_label.setVisibility(View.VISIBLE);
                view_data.setVisibility(View.VISIBLE);
                view_time_label.setVisibility(View.VISIBLE);
                view_time.setVisibility(View.VISIBLE);
                break;
            case R.id.lokalizacja:
                view_data_label.setVisibility(View.GONE);
                view_data.setVisibility(View.GONE);
                view_time_label.setVisibility(View.GONE);
                view_time.setVisibility(View.GONE);
                break;
            default:
                break;
        }
    }

    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), getString(R.string.datepicker));
    }

    public void processDatePickerResult(int year, int month, int day) {
        String month_string = Integer.toString(month + 1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (year_string + "/" + month_string + "/" + day_string);
        Toast.makeText(this, getString(R.string.data_toast) + dateMessage, Toast.LENGTH_SHORT).show();
    }

    public void showTimePicker(View view) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), getString(R.string.timepicker));
    }

    public void processTimePickerResult(int hour, int minute) {
        String hour_string = Integer.toString(hour);
        String minute_string = Integer.toString(minute);
        String timeMessage = (hour_string + "/" + minute_string);
        Toast.makeText(this, getString(R.string.time_toast) + timeMessage, Toast.LENGTH_SHORT).show();
    }
}