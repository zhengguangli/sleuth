package ink.icopy.base.test;

import okhttp3.OkHttpClient;
import org.springframework.boot.SpringApplication;

/**
 * @author lizhengguang
 * @date 2019-8-12 16:54:44
 */
//@EnableAspectJAutoProxy
//@SpringBootApplication
public class VerifyCodeApplication {

    private OkHttpClient okHttpClient;

    public VerifyCodeApplication(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    public static void main(String[] args) {
        SpringApplication.run(VerifyCodeApplication.class, args);
    }
}
