package ioc.b;

import ioc.a.UsbWriter;

/**
 * ������  �߲�Ӧ����
 */
public class Business {

private DeviceWriter deviceWriter;//�ӿ�ʵ����

    public Business(DeviceWriter deviceWriter) {
        this.deviceWriter = deviceWriter;
    }

    public  void saveData(){
        this.deviceWriter.saveToDevice();
    }
}
