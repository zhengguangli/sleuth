package ink.icopy.base.demo;

import org.springframework.stereotype.Service;

/**
 * @author lizhengguang
 */
@Service
public class AutoMethodDemoServiceImpl implements AutoMethodDemoService {
    @Override
    public String test() {
        return "Hello world";
    }
}
