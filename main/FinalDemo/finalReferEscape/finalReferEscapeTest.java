package FinalDemo.finalReferEscape;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * @author Lucas
 * @date 2019/5/17 14:26
 */
public class finalReferEscapeTest {
    private static Logger logger = LogManager.getLogger(finalReferEscapeTest.class);

    public static void main(String[] args) {
        logger.info("Main线程");
        new Thread(){
            @Override
            public void run() {
                finalReferEscape.writer();
                logger.error("第1个线程");
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                finalReferEscape.reader();
                logger.error("第2个线程");
            }
        }.start();
    }
}
