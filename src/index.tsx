import { NativeModules } from 'react-native';

type PedometerType = {
  multiply(a: number, b: number): Promise<number>;
};

const { Pedometer } = NativeModules;

export default Pedometer as PedometerType;
