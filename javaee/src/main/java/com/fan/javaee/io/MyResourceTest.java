package com.fan.javaee.io;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;

/**
 * @author fby
 * @apiNote
 * @date 2024/7/18
 */
public class MyResourceTest {
    public static void main(String[] args) throws IOException {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        // 加载所有匹配的资源文件
        Resource[] resources = resolver.getResources("classpath*:*.*");

        for (Resource resource : resources) {
            System.out.println("Resource filename: " + resource.getFilename());
            System.out.println("Resource URL: " + resource.getURL());
        }
    }
}
