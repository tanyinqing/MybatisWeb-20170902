package ioc.a;

/**
 * ������  �߲�Ӧ����
 */
public class Business {
/*   private FloppyWriter floppyWriter;

    public Business(FloppyWriter floppyWriter) {
        this.floppyWriter = floppyWriter;
    }

    public  void saveData(){
        this.floppyWriter.writeToFloppy();
    }*/

private UsbWriter usbWriter;

    public Business(UsbWriter usbWriter) {
        this.usbWriter = usbWriter;
    }

    public  void saveData(){
        this.usbWriter.writeToUsb();
    }
}
