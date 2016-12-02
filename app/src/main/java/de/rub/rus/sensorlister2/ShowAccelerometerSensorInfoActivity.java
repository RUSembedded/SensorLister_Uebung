package de.rub.rus.sensorlister2;

import android.hardware.Sensor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowAccelerometerSensorInfoActivity extends ShowSensorInfoActivity {

    @Override
    protected int getContentViewId() {
        return R.layout.activity_show_accelerometer_sensor_info;
    }

    @Override
    protected void setSensorType() {
        sensorType = Sensor.TYPE_ACCELEROMETER;

    }

    @Override
    protected void setTextViews() {
        defaultSensorInfoTextView = (TextView) findViewById(R.id.AccelerometerDefaultSensorInfoTextView);
        allSensorsInfoTextView = (TextView) findViewById(R.id.AccelerometerSensorsInfoTextView);
    }

    /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_show_accelerometer_sensor_info);
    }
    */
}
