package ioc.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Calculator {
    private int x;
    private int y;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int add(){
        return x+y;
    }

}
class CalculatorTest{
    public static void main(String[] args) {
        ApplicationContext applicationContext=
                new ClassPathXmlApplicationContext("test.xml");
        Calculator calculator= (Calculator) applicationContext.getBean("calculator");
        System.out.println(calculator.add());
    }
}