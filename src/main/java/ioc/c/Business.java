package ioc.c;


/**
 * ������  �߲�Ӧ���� ���õײ�ģ��
 * ���췽����set��������ʵ�ַ�ʽ
 */
public class Business {

private DeviceWriter deviceWriter;//�ӿ�ʵ����

    public Business(DeviceWriter deviceWriter) {
        this.deviceWriter = deviceWriter;
    }

    public  void saveData(){
        this.deviceWriter.saveToDevice();
    }



//    public void setDeviceWriter(DeviceWriter1 deviceWriter) {
//        this.deviceWriter = deviceWriter;
//    }
}
