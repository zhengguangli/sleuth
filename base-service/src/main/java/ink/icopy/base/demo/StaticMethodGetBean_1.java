package ink.icopy.base.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * SpringBoot 静态获取Bean方式@PostConstruct
 *
 * @author lizhengguang
 */
@Component
public class StaticMethodGetBean_1 {

    @Autowired
    private AutoMethodDemoService autoMethodDemoService;
    @Autowired
    private static AutoMethodDemoService staticAutoMethodDemoService;


    /**
     * @PostConstruct 注释用于在依赖关系注入完成之后需要执行的方法上，以执行任何初始化。
     */
    @PostConstruct
    public void init() {
        staticAutoMethodDemoService = autoMethodDemoService;
    }

    public static String getAuthorizer() {
        return staticAutoMethodDemoService.test();
    }
}
