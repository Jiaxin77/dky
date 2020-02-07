package hci.dky;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("hci.dky.dao")
public class DkyApplication {

    public static void main(String[] args) {
        SpringApplication.run(DkyApplication.class, args);
    }
}
