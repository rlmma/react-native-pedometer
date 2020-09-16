import { NativeModules } from 'react-native';

type PedometerType = {
  isSupported(): Promise<boolean>;
  startStepCounter(): any;
  stopStepCounter(): any;
};

const { Pedometer } = NativeModules;

export default Pedometer as PedometerType;
