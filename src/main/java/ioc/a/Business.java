package ioc.a;

/**
 * ������  �߲�Ӧ����
 */
public class Business {
/*   private FloppyWriter11 floppyWriter;

    public Business(FloppyWriter11 floppyWriter) {
        this.floppyWriter = floppyWriter;
    }

    public  void saveData(){
        this.floppyWriter.writeToFloppy();
    }*/

private UsbWriter usbWriter;

    public Business(UsbWriter usbWriter) {
        this.usbWriter = usbWriter;
    }
//���õײ�ģ����ķ���
    public  void saveData(){
        this.usbWriter.writeToUsb();
    }
}
