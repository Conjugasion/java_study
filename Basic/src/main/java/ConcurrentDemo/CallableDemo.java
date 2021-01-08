package ConcurrentDemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Lucas
 * @date 2019/4/22 17:04
 */
public class CallableDemo implements Callable {
    public String param;
    public CallableDemo(String param){
        this.param = param;
    }

    @Override
    public String call() throws Exception {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(param);
            Thread.sleep(500);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new CallableDemo("Tang"));
        new Thread(futureTask).start();
        System.out.println("futureTask请求完毕，等待结果返回, 我先做别的任务去了");
        // 假装接着执行任务
        Thread.sleep(2000);
        System.out.println("做完别的任务了，但是结果还未返回，等待");
        // 若处理完别的任务后，结果还未返回，会等待
        System.out.println("数据 = " + futureTask.get());
    }
}
