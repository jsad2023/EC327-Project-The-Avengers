package com.example.game0;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.WindowManager;
public class SensorActivity extends Activity implements SensorEventListener {

    // sensors
    private SensorManager sensorManager;
    private Sensor mAccelorometer;
    private Sensor mMagneticField;

    /*
    Pitch: This value represents the angle between a plane
    parallel to the device's screen and a plane parallel to the ground. Assuming that the bottom
    edge of the device faces the user and that the screen is face-up, tilting the top edge of the
    device toward the ground creates a positive pitch angle. The range of values is -π to π.
    */
    /*Roll, This value represents the angle between a plane
    perpendicular to the device's screen and a plane perpendicular to the ground. Assuming that the
     bottom edge of the device faces the user and that the screen is face-up, tilting the left edge
     of the device toward the ground creates a positive roll angle. The range of values is
     -π/2 to π/2.
     */
    public float pitch;
    public float roll;

    private float gravityVector[];
    private float geomagneticVector[];

    @Override
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mMagneticField = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        mAccelorometer sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        // do something if either sensor is unavailable, though they should be available

    }

    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Do something here if sensor accuracy changes.
        // if accelerometer changes values
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            for(int i = 0; i < 3; i++)
                gravityVector[i] = event.values[i];

            // if geomagnetic sensor is different
        } else if(event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
            for(int i = 0; i < 3; i++)
                geomagneticVector[i] = event.values[i];
        }

        this.updatePitchAndRoll();
    }

    @Override
    public final void onSensorChanged(SensorEvent event) {

        // if accelerometer changes values
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            for(int i = 0; i < 3; i++)
                gravityVector[i] = event.values[i];

            // if geomagnetic sensor is different
        } else if(event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
            for(int i = 0; i < 3; i++)
                geomagneticVector[i] = event.values[i];
        }

        this.updatePitchAndRoll();
    }

    private void updatePitchAndRoll() {

        float R[] = new float[9];
        boolean success = SensorManager.getRotationMatrix(R, null, gravityVector, geomagneticVector);
        if(success) {
            float orientation[] = new float[3];
            SensorManager.getOrientation(R, orientation);
            pitch = orientation[1];
            roll = orientation[2];
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, mAccelorometer, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, mMagneticField, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}
}