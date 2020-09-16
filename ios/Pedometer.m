#import <React/RCTBridgeModule.h>
#import <React/RCTEventEmitter.h>

@interface RCT_EXTERN_MODULE(Pedometer, RCTEventEmitter)

RCT_EXTERN_METHOD(isSupported:
                 (RCTPromiseResolveBlock)resolve
                 withRejecter:(RCTPromiseRejectBlock)reject)

RCT_EXTERN_METHOD(startStepCounter)

RCT_EXTERN_METHOD(stopStepCounter)

@end
