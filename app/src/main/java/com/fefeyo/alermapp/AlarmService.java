package com.fefeyo.alermapp;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by USER on 2015/09/23.
 */
public class AlarmService extends IntentService{

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public AlarmService(String name) {
        super(name);
    }

    public AlarmService(){
        super("alarmservice");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i("alarmmanager", "きたよ");
    }
}
