package ioc.c;


/**
 * 商务类  高层应用类 调用底层模块
 */
public class Business {

private DeviceWriter deviceWriter;//接口实现类

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
