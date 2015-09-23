package com.fefeyo.alermapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    private Button setbutton;

    private int hour, minute;

    private AlarmManager am;

    private void assignViews() {
        setbutton = (Button) findViewById(R.id.setbutton);
        setbutton.setOnClickListener(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        assignViews();
        am = (AlarmManager)getSystemService(ALARM_SERVICE);
        new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                hour = hourOfDay;
                MainActivity.this.minute = minute;
            }
        }, 0, 0, true).show();
    }

    @Override
    public void onClick(View v) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);

        final Intent i = new Intent(getApplicationContext(), AlarmService.class);
        final PendingIntent pi = PendingIntent.getService(
                getApplicationContext(),
                0,
                i,
                PendingIntent.FLAG_UPDATE_CURRENT
        );

        am.set(
                AlarmManager.RTC_WAKEUP,
                calendar.getTimeInMillis(),
                pi
        );

        Log.i("alarmmanager", "" + am);
    }
}
