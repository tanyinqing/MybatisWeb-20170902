package ioc.c;



//����������  �ײ�ģ����
public class FloppyWriter implements DeviceWriter{ //Floppy

    @Override
    public void saveToDevice() {
        System.out.println("save date to Floppy..");
    }
}
