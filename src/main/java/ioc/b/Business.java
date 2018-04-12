package ioc.b;

import ioc.a.UsbWriter;

/**
 * 商务类  高层应用类
 */
public class Business {

private DeviceWriter deviceWriter;

    public Business(DeviceWriter deviceWriter) {
        this.deviceWriter = deviceWriter;
    }

    public  void saveData(){
        this.deviceWriter.saveToDevice();
    }
}
