package name.taolei.zealot.test.springboot.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] ags) {
        Main main = new Main();
        for (int i = 0; i < 10; i++) {
            main.logger.debug("This is a debug message");
            main.logger.info("This is an info message");
            main.logger.warn("This is a warn message");
            main.logger.error("This is an error message");
        }
    }
}
