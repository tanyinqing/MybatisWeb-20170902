package ioc.spring;

import ioc.c.Business;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    //Sprng: Hello Tom
    public static void main(String[] args) {

        ApplicationContext applicationContext=
                new ClassPathXmlApplicationContext("beans.xml");
        Hello hello= (Hello) applicationContext.getBean("hello");
        hello.sayHello();
    }
}
