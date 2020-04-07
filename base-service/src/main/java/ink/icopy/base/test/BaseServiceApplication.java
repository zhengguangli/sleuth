package ink.icopy.base.test;


import okhttp3.OkHttpClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author lizhengguang
 */
@EnableAspectJAutoProxy
@SpringBootApplication
@MapperScan("ink.icopy.base.mapper")
public class BaseServiceApplication {
    private final OkHttpClient okHttpClient;

    public BaseServiceApplication(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    public static void main(String[] args) {
        SpringApplication.run(BaseServiceApplication.class, args);
    }
}

