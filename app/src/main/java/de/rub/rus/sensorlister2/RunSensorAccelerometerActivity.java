package de.rub.rus.sensorlister2;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RunSensorAccelerometerActivity extends RunSensorActivity {
    private TextView a_x, a_y, a_z;

    @Override
    protected int getContentViewID() {
        return R.layout.activity_run_sensor_accelerometer;
    }

    @Override
    protected void setSensorType() {
        sensorType = Sensor.TYPE_ACCELEROMETER;
    }

    @Override
    protected void setTextViews() {
        a_x = (TextView) findViewById(R.id.txtAx);
        a_y = (TextView) findViewById(R.id.txtAy);
        a_z = (TextView) findViewById(R.id.txtAz);

    }

    @Override
    protected void setTextViewsDefaults() {

    }


    @Override
    public void onSensorChanged(SensorEvent theEvent) {
        if(theEvent.sensor.getType() == sensorType){
            a_x.setText("a_x: " + String.format("%.2f", theEvent.values[0]));
            a_y.setText("a_y: " + String.format("%.2f", theEvent.values[1]));
            a_z.setText("a_z: " + String.format("%.2f", theEvent.values[2]));
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
