package ink.icopy.base;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author lizhengguang
 */
@EnableAspectJAutoProxy
@SpringBootApplication
@MapperScan("ink.icopy.base.mapper")
public class BaseServiceApplication {

    public static ConfigurableApplicationContext applicationContext;

    public static void main(String[] args) {
        BaseServiceApplication.applicationContext = SpringApplication.run(BaseServiceApplication.class, args);
    }
}

