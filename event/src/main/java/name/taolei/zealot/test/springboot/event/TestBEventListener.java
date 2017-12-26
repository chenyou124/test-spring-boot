package name.taolei.zealot.test.springboot.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class TestBEventListener implements ApplicationListener<TestBEvent> {
    @Override public void onApplicationEvent(TestBEvent doServiceEvent) {
        System.out.println("监听B事件：" + doServiceEvent.getMsg());
    }
}
