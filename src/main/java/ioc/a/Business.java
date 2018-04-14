package ioc.a;

/**
 * 商务类  高层应用类
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
//调用底层模块类的方法
    public  void saveData(){
        this.usbWriter.writeToUsb();
    }
}
