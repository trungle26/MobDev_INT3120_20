package com.example.lesson12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Toast;

import com.example.lesson12.databinding.ActivitySensorBinding;

public class SensorActivity extends AppCompatActivity implements SensorEventListener {

    private ActivitySensorBinding binding;
    private SensorManager mSensorManager;
    private Sensor mMagneticSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySensorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mMagneticSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        if (mMagneticSensor != null) {
            // Success! There's a magnetometer
            Toast.makeText(this,"Magnetomometer sensor is working",Toast.LENGTH_SHORT).show();
        } else {
            // Failure! No magnetometer.
            Toast.makeText(this,"there is no Magnetomometer sensor!",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mMagneticSensor != null) {
            mSensorManager.registerListener(this, mMagneticSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mMagneticSensor != null) {
            mSensorManager.unregisterListener(this);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        if (sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
            switch (accuracy) {
                case SensorManager.SENSOR_STATUS_ACCURACY_LOW:
                    // Handle low accuracy
                    Toast.makeText(this,"low accuracy",Toast.LENGTH_SHORT).show();
                    break;
                case SensorManager.SENSOR_STATUS_ACCURACY_MEDIUM:
                    // Handle medium accuracy
                    Toast.makeText(this,"medium accuracy",Toast.LENGTH_SHORT).show();
                    break;
                case SensorManager.SENSOR_STATUS_ACCURACY_HIGH:
                    // Handle high accuracy
                    Toast.makeText(this,"high accuracy",Toast.LENGTH_SHORT).show();
                    break;
                case SensorManager.SENSOR_STATUS_UNRELIABLE:
                    // Handle unreliable accuracy
                    Toast.makeText(this,"unreliable accuracy",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
            float[] magneticValues = event.values;
            // Process the magnetic field values
            // Avoid heavy processing in this method
        }
    }
}