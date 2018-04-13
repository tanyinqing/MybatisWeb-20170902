package ioc.c;



public class UsbWriter implements DeviceWriter{

    @Override
    public void saveToDevice() {
        System.out.println("save data to use...");
    }
}
