package name.taolei.zealot.test.springboot.web.withoutParent.son.controller;

import name.taolei.zealot.test.springboot.web.withoutParent.son.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @Autowired
    private TestService testService;
    @RequestMapping("/")
    public String greeting() {
        return testService.doSomething();
    }
}
