package com.fan.bucket.migrate_project.component.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author fby
 * @apiNote
 * @date 2024/7/12
 */
@Component
@ConfigurationProperties("user")
@Data
public class User {
    
    private List<Person> persons;
    
    
    @Data
    public static class Person{
        private String name;
        
        private Integer age;
    } 
}
