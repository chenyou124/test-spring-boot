package name.taolei.zealot.test.springboot.dubbo.zookeeper.use;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ImportResource("classpath:spring-dubbo-zookeeper-use.xml")
public class Run extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Run.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Run.class, args);
    }
}
