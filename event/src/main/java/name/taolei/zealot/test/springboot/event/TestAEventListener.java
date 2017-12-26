package name.taolei.zealot.test.springboot.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class TestAEventListener implements ApplicationListener<TestAEvent> {
    @Override public void onApplicationEvent(TestAEvent doServiceEvent) {
        System.out.println("监听A事件：" + doServiceEvent.getMsg());
    }
}
