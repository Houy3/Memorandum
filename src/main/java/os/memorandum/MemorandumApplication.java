package os.memorandum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import os.memorandum.models.TestEntity;

@SpringBootApplication
public class MemorandumApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemorandumApplication.class, args);


        System.out.println(TestEntity.builder()
                        .id(1L)
                        .testField("dfdd")
                .build());
    }

}
