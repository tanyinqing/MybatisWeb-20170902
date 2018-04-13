package ioc.c;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 低耦合
 */
public class Test {
    public static void main(String[] args) {
         /*        Business business=new Business();
        business.setDeviceWriter(new FloppyWriter());
        business.setDeviceWriter(new UsbWriter());
        //  Business business=new Business(new UsbWriter());
        business.saveData();*/
//加载配置文件
        ApplicationContext applicationContext=
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Business business= (Business) applicationContext.getBean("business");
        business.saveData();
    }
}
