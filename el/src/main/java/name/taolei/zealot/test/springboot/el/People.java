package name.taolei.zealot.test.springboot.el;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class People {
    @Value("${name}")
    private String name;
    @Value("男")
    private String sex;

}
