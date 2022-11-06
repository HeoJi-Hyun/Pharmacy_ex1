package com.example.pharmacy_ex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.Calendar;

public class Alarm extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {
    public  static  final String TAG = "MAIN";
    private TextView time_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm);


        time_text =  findViewById(R.id.time_text);

        Button button = (Button) findViewById(R.id.time_btn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");
            }

        });

        Button alarm_calcel_btn = findViewById(R.id.alarm_cancel_btn);
        alarm_calcel_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {

                cancelAlarm();
            }
        });
    }

    //    시간을 정하면 호출되는 메소드입니따
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

        Log.d(TAG, "## onTimeSet ##");
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, 0);

//        화면에 시간지정
        updateTimeText(c);
//        알람설정
        startAlarm(c);
    }
    //    화면에 사용자가 선택한 시간을 보여줌
    private void updateTimeText(Calendar c){
        Log.d(TAG, "## updateTimeSet ##");
        String timeText = "복용알람 : ";
        timeText += DateFormat.getTimeInstance(DateFormat.SHORT).format(c.getTime());

        time_text.setText(timeText);
    }
    //    알람시작
    private void startAlarm(Calendar c){
        Log.d(TAG, "## startAlarm ##");
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);

        if(c.before((Calendar.getInstance()))){
            c.add(Calendar.DATE, 1);
        }
//        지정된 시간에 기기의 절전 모드를 해제하여 대기중인 인텐트 실행
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent);
        //alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), 1*60*1000 ,  pendingIntent);

    }

    private void cancelAlarm(){
        Log.d(TAG, "## cancelAlarm ##");
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);

        alarmManager.cancel(pendingIntent);
        time_text.setText("알람취소");
    }

}
