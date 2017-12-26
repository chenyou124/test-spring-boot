package name.taolei.zealot.test.springboot.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class TestEventPublish {
    @Autowired ApplicationContext applicationContext;

    public void publishAEvent(String msg) {
        applicationContext.publishEvent(new TestAEvent(this, msg));
    }
    public void publishBEvent(String msg) {
        applicationContext.publishEvent(new TestBEvent(this, msg));
    }
}
