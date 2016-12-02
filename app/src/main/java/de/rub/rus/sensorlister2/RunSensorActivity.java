package de.rub.rus.sensorlister2;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by patrik on 02.12.2016.
 */
public abstract class RunSensorActivity extends AppCompatActivity implements SensorEventListener{
    private SensorManager theSensormanager;
    private Sensor theSensor;
    protected int sensorType;

    protected abstract int getContentViewID();

    protected abstract void setSensorType();

    protected abstract void setTextViews();

    protected abstract void setTextViewsDefaults();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(getContentViewID());

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        setSensorType();

        theSensormanager = (SensorManager) getSystemService(SENSOR_SERVICE);
        theSensor = theSensormanager.getDefaultSensor(sensorType);
        theSensormanager.registerListener(this,theSensor,SensorManager.SENSOR_DELAY_NORMAL);

        setTextViews();
        setTextViewsDefaults();

    }

    public abstract void onSensorChanged(SensorEvent theEvent);
}
