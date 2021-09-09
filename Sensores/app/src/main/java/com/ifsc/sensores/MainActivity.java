package com.ifsc.sensores;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity //implements SensorEventListener
{

    SensorManager sensorManager;
    Sensor sensorLight;
    TextView tvLight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvLight = findViewById(R.id.tvSensorLight);

        sensorManager = (SensorManager) getSystemService(getApplicationContext().SENSOR_SERVICE);
        sensorLight = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        //sensorManager.registerListener(this, sensorLight, SensorManager.SENSOR_DELAY_NORMAL);

        List<Sensor> listSensor = sensorManager.getSensorList(Sensor.TYPE_ALL);

        StringBuilder sensorListTxt = new StringBuilder();
        for (Sensor s : listSensor) {
            sensorListTxt.append(s.getName()).append(System.getProperty("line.separator"));
        }
        tvLight.setText(sensorListTxt);
    }

    /*@Override
    public void onSensorChanged(SensorEvent event) {
        int sensorType = event.sensor.getType();
        float currentValue = event.values[0];
        tvLight.setText(Float.toString(currentValue));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }*/

}