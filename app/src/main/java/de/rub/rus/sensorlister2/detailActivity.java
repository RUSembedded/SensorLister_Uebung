package de.rub.rus.sensorlister2;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;

public class detailActivity extends AppCompatActivity implements SensorEventListener{
    private TextView txtTypeInfo;
    private SensorManager mySensorManager;
    private Sensor mySensor;
    private int sensorType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtTypeInfo = (TextView)findViewById(R.id.txtTypeInfo);

        Intent i = getIntent();
        sensorType = i.getIntExtra("sensorType",-1);

        mySensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        mySensor = mySensorManager.getDefaultSensor(sensorType);

        if (mySensor!=null){
            txtTypeInfo.setText(""+sensorTypes.get(mySensor.getType()));
        }


    }

    private HashMap<Integer,String>sensorTypes = new HashMap<Integer,String>();
    {
        sensorTypes.put(Sensor.TYPE_ACCELEROMETER,"TYPE_ACCELEROMETER");
        // TODO: Weitere Typen hinzzu
    }


    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
