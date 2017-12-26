package name.taolei.zealot.test.springboot.dubbo.zookeeper.support;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @RequestMapping("/")
    @ResponseBody
    public String greeting() {
        return "123";
    }
}
