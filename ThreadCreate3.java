import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//java创建多线程方法三
//利用Callable接口实现多线程
//步骤
//1.创建Callable接口实现类并重写该接口的call()方法
//2.创建Callable接口实现类对象
//3.使用Runnable子类FutureTask的有参构造函数 public FutureTask(Callable<V> callable)和Callable接口实现类对象创建FutureTask实例
//4.利用Thread有参构造函数 public Thread(Runnable target)和FutureTask实例创建线程实例
//5.调用线程实例的start()方法启动线程
//6.利用FutureTask的get()方法获取子线程执行结果
public class ThreadCreate3 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //创建一个子线程
        MyCallable firstCallable = new MyCallable();
        FutureTask<Object> firstFutureTask = new FutureTask<>(firstCallable);
        Thread firstThread = new Thread(firstFutureTask);
        firstThread.start();
        String firstThreadName = firstThread.getName();
        System.out.println("firstThreadName="+ firstThreadName);
        //获取第一个子线程返回的结果
        Object firstThreadResult = firstFutureTask.get();
        System.out.println("firstThreadResult="+ firstThreadResult);
        
        //创建第二个子线程
        MyCallable secondMyCallable = new MyCallable();
        FutureTask<Object> secondFutureTask = new FutureTask<>(secondMyCallable);
        Thread secondThread = new Thread(secondFutureTask);
        secondThread.start();
        String secondThreadName = secondThread.getName();
        System.out.println("secondThreadName="+ secondThreadName);
        //获取第二个子线程返回的结果
        Object secondThreadResult = secondFutureTask.get();
        System.out.println("secondThreadResult=" + secondThreadResult);
    }
}
//MyCallable实现Callable接口
class MyCallable implements Callable<Object>{
    public Object call() throws Exception{
        String threadName = Thread.currentThread().getName();
        int i = 0;
        while (i < 5){
            System.out.println(threadName+",i ="+i);
            i++;
        }
        return i;
    }
}
