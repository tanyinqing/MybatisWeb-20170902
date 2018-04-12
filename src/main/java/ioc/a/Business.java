package ioc.a;

/**
 * 商务类  高层应用类
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
