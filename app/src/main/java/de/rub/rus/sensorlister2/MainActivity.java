package de.rub.rus.sensorlister2;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtAccStatus;
    private SensorManager mySensorManager;
    private Sensor myAccSensor;

    //TODO: Weitere Sensoren einfuegen!


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtAccStatus = (TextView)findViewById(R.id.AccStatus);

        mySensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        myAccSensor = mySensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        if (myAccSensor!=null){
            txtAccStatus.setText("TRUE!");
        }else{
            txtAccStatus.setText("FALSE!");
        }
    }

    public void clickBtnAccelInfo(View view){
        //final Context context = this;
        //Intent intent = new Intent(context,detailActivity.class);
        //intent.putExtra("sensorType",1);
        //startActivity(intent);

        Intent theIntent= new Intent(this, ShowAccelerometerSensorInfoActivity.class);
        startActivity(theIntent);
    }

    public void clickBtnAccelRun(View view) {
        Intent theIntent= new Intent(this, RunSensorAccelerometerActivity.class);
        startActivity(theIntent);
    }
}
