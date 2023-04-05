package com.test.todo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class TodoApplication {

    public static void main(String[] args) {
        log.info("""

                ----------------------------------------------------------
                Launching ...
                ----------------------------------------------------------""");
        SpringApplication.run(TodoApplication.class, args);
        log.info("""

                ----------------------------------------------------------
                Application is running!\s
                ----------------------------------------------------------""");
    }

}
