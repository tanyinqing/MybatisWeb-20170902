package ioc.c;


/**
 * ������  �߲�Ӧ���� ���õײ�ģ��
 */
public class Business {

private DeviceWriter deviceWriter;//�ӿ�ʵ����

   /* public Business(DeviceWriter deviceWriter) {
        this.deviceWriter = deviceWriter;
    }*/

    public  void saveData(){
        this.deviceWriter.saveToDevice();
    }



    public void setDeviceWriter(DeviceWriter deviceWriter) {
        this.deviceWriter = deviceWriter;
    }
}
