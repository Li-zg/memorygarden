package life.lieren.memorygarden;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("life.lieren.memorygarden.mapper")
public class MemorygardenApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemorygardenApplication.class, args);
    }

}
