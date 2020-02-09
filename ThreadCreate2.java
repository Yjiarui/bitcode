//java实现多线程方法二
//利用Runnable接口实现多线程
//步骤
//1.创建Runnable接口实现类并重写该接口run()方法
//2.创建Runnable接口实现类对象
//3.利用Thread有参构造函数 public Thread(Runnable target)和Runnable接口实现类对象创建线程实例
//4.调用线程实例的start()方法启动线程
public class ThreadCreate2 {

    public static void main(String[] args) {
        //创建第一个子线程
        MyRunnable firstMyRunnable = new MyRunnable();
        Thread firstThread = new Thread(firstMyRunnable);
        firstThread.start();
        String firstThreadName = firstThread.getName();
        System.out.println("firstThreadName="+firstThreadName);

        //创建第二个子线程
        MyRunnable secondMyRunnable = new MyRunnable();
        Thread secondThread = new Thread(secondMyRunnable);
        secondThread.start();
        String secondThreadName = secondThread.getName();
        System.out.println("secondThreadName="+ secondThreadName);
    }
}

//MyRunnable 实现Runnable接口
class MyRunnable implements Runnable {
    public void run(){
        String threadName = Thread.currentThread().getName();
        for (int i = 0;i < 5;i++){
            System.out.println(threadName +",i = "+i);
        }
    }
}