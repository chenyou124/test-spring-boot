package name.taolei.zealot.test.springboot.dubbo.zookeeper.use;

import com.alibaba.dubbo.config.annotation.Reference;
import name.taolei.zealot.test.dubbo.zookeeper.core.TestEntity;
import name.taolei.zealot.test.dubbo.zookeeper.core.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("/")
public class TestController {
    @Reference
    private TestService testService;

    @RequestMapping("/")
    @ResponseBody
    public String test() {
        TestEntity testEntity = new TestEntity();
        testEntity.setId(123);
        testEntity.setName("taolei");
        return testService.getName(testEntity);
    }
}


