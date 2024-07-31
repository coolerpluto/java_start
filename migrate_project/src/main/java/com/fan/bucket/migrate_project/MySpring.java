package com.fan.bucket.migrate_project;

import com.fan.bucket.migrate_project.component.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author fby
 * @apiNote
 * @date 2024/7/12
 */
@SpringBootApplication
public class MySpring {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MySpring.class, args);
        System.out.println(run.getBean("user", User.class));
        User user = run.getBean("user", User.class);
        for (User.Person person : user.getPersons()) {
            System.out.println(person);
        }
    }
}
