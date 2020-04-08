package ink.icopy.base.context;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Book1 {
    private final ApplicationContext applicationContext;

    public Book1(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public void show() {
        Book1 book1 = applicationContext.getBean(Book1.class);
        System.out.println(book1.toString());
        System.out.println(applicationContext.getClass());
    }
}
