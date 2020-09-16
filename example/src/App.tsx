import * as React from 'react';
import {
  StyleSheet,
  View,
  Text,
  NativeModules,
  NativeEventEmitter,
} from 'react-native';
import Pedometer from 'react-native-pedometer';

export default function App() {
  const [steps, setSteps] = React.useState<number>(0);

  React.useEffect(() => {
    Pedometer.isSupported().then((result) => {
      if (result) {
        console.log('Sensor TYPE_STEP_COUNTER is supported on this device');

        const myModuleEvt = new NativeEventEmitter(NativeModules.Pedometer);
        myModuleEvt.addListener('StepCounter', (data) => {
          console.log('STEPS', data.steps);
          setSteps(data.steps);
        });

        Pedometer.startStepCounter();
      } else {
        console.log('Sensor TYPE_STEP_COUNTER is not supported on this device');
      }
    });
  }, []);

  return (
    <View style={styles.container}>
      <Text>Steps: {steps}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
});
