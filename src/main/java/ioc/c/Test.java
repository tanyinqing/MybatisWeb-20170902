package ioc.c;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * �����
 */
public class Test {
    public static void main(String[] args) {
         /*        Business business=new Business();
        business.setDeviceWriter(new FloppyWriter11());
        business.setDeviceWriter(new UsbWriter11());
        //  Business business=new Business(new UsbWriter11());
        business.saveData();*/
//���������ļ�  Ӧ�ó���������  ��������õײ�Ӧ����
        ApplicationContext applicationContext=
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Business business= (Business) applicationContext.getBean("business");
        business.saveData();
    }
}
