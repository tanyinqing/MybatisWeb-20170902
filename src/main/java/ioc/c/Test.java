package ioc.c;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 低耦合
 */
public class Test {
    public static void main(String[] args) {
         /*        Business business=new Business();
        business.setDeviceWriter(new FloppyWriter11());
        business.setDeviceWriter(new UsbWriter11());
        //  Business business=new Business(new UsbWriter11());
        business.saveData();*/
//加载配置文件  应用程序上下文  测试类调用底层应用类
        ApplicationContext applicationContext=
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Business business= (Business) applicationContext.getBean("business");
        business.saveData();
    }
}
