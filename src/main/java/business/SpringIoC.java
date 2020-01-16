package business;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIoC {
    private static final ApplicationContext context = new ClassPathXmlApplicationContext("business/spring.xml");
    public static Object getBean(String beanName) {
        return context.getBean(beanName);
    }

}

