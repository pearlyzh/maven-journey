package com.nghiatn.maven.controller.rpc.dubbo;

import org.apache.dubbo.config.annotation.Service;

/**
 * @author nghiatn
 */

@Service(version = "1.0.0")
public class HelloDubboServiceImpl implements HelloDubboService {
    @Override
    public String sayHello(String content) {
        return "Hello from the other side, " + content;
    }
}
