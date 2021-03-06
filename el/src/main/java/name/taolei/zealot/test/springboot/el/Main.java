package name.taolei.zealot.test.springboot.el;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:el.properties")
@ComponentScan("name.taolei.zealot.test.springboot.el")
public class Main {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public static void main(String[] ags) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Main.class);
        context.refresh();
        People people = context.getBean(People.class);
        System.out.println("name:" + people.getName());
        System.out.println("sex:" + people.getSex());
        context.close();
        System.exit(0);
    }
}
