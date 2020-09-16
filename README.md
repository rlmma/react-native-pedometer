# react-native-pedometer

react native module to count steps

## Installation

```sh
npm install react-native-pedometer
```

## Usage

```js
import Pedometer from "react-native-pedometer";

// ...

Pedometer.isSupported().then((result) => {
      if (result) {
        console.log('Sensor TYPE_STEP_COUNTER is supported on this device');

        const myModuleEvt = new NativeEventEmitter(NativeModules.Pedometer);
        myModuleEvt.addListener('StepCounter', (data) => {
          console.log('STEPS', data.steps);
        });

        Pedometer.startStepCounter();
      } else {
        console.log('Sensor TYPE_STEP_COUNTER is not supported on this device');
      }
    });
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT
