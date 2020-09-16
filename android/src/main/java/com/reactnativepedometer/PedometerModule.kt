package com.reactnativepedometer

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.Promise
import android.content.Context;
import android.hardware.Sensor
import android.hardware.SensorManager

class PedometerModule : ReactContextBaseJavaModule {

  private var mStepCounterRecord:StepCounterRecord? = null
  private var mReactContext:ReactApplicationContext

  private var mSensorManager: SensorManager

  constructor(reactContext: ReactApplicationContext) : super(reactContext) {
    this.mReactContext = reactContext
    mSensorManager = reactContext.getSystemService(Context.SENSOR_SERVICE) as SensorManager
  }

    override fun getName(): String {
        return "Pedometer"
    }

    @ReactMethod
    fun isSupported(promise: Promise) {
      val mStepCounter = mSensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)
      if (mStepCounter != null) {
        promise.resolve(true)
      } else {
        promise.resolve(false)
      }
    }

    @ReactMethod
    fun startStepCounter(): Int {
      if (mStepCounterRecord == null)
        mStepCounterRecord = StepCounterRecord(mReactContext)
      val stepCounterRecord = mStepCounterRecord
      val delay = 1000
      if (stepCounterRecord != null)
        return stepCounterRecord.start(delay)
      return 0
    }

    @ReactMethod
    fun stopStepCounter() {
      val stepCounterRecord = mStepCounterRecord
      if (stepCounterRecord != null)
        mStepCounterRecord?.stop();
    }
}
