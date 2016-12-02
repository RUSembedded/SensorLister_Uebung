package de.rub.rus.sensorlister2;

/**
 * Created by patrik on 02.12.2016.
 */

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

/**
 * Abstract class for all sensor info activity classes, for example, ShowRotationVectorSensorInfoActivity.
 */
public abstract class ShowSensorInfoActivity extends AppCompatActivity {
    private SensorManager theSensorManager;
    private Sensor defaultSensor;
    private List<Sensor> sensorList;
    private String infoString;
//    private TextView defaultSensorInfoTextView;
//    private TextView allSensorsInfoTextView;

    protected int contentViewId;
    protected int sensorType;
    protected TextView defaultSensorInfoTextView;
    protected TextView allSensorsInfoTextView;

    /**
     Returns content view id.
     */
    protected abstract int getContentViewId();

    /**
     Sets sensor type.
     */
    protected abstract void setSensorType();

    /**
     Sets Ids for TextViews that correspond to the sensor; must be overwritten in
     derived class, since each derived class will have its corresponding unique fragment
     with its corresponding unique TextViews.
     */
    protected abstract void setTextViews();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);


        setSensorType();
        // Every class derived from this abstract one has its own fragment, text views etc.,
        // which must be set in setTextViewIds.

        setTextViews();

        /*
        Get default sensor object, convert to string and print to screen
         */
        theSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        defaultSensor = theSensorManager.getDefaultSensor(sensorType);
        defaultSensorInfoTextView.setText(defaultSensor.toString());

        /*
        Get all sensor objects of the given type, print their data to screen.
         */
        sensorList = theSensorManager.getSensorList(sensorType);

        infoString = "";
        for (Sensor s : sensorList) {
            infoString += s.toString();
            infoString += "\n";
        }
        allSensorsInfoTextView.setText(infoString);
    }


}
