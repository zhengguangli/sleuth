package ink.icopy.base.controller;

import ink.icopy.base.BaseServiceApplication;
import ink.icopy.base.demo.AutoMethodDemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lizhengguang
 */
@RestController
public class TestController {

    @GetMapping("/method2")
    public void method2() {
        AutoMethodDemoService autoMethodDemoService = BaseServiceApplication.applicationContext.getBean(AutoMethodDemoService.class);
        String test = autoMethodDemoService.test();
        System.out.println(test);
    }
}
