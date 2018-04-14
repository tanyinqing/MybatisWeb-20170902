package ioc.b;

/**
 * µÍñîºÏ
 */
public class Test {
    public static void main(String[] args) {
        //         Business business=new Business(new FloppyWriter11());
      Business business=new Business(new UsbWriter());
        business.saveData();
    }
}
