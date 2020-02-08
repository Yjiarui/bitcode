//java实现多线程方法一
//利用Thread实现多线程
//步骤
//1.通过继承Thread创建线程的子类
//2.重写Thread类run()方法
//3.创建子类实例对象
//4.调用子类实例对象start()方法启动线程

public class ThreadCreate1 {

    public static void main(String[] args) {
        //创建第一个子线程
        MyThread firstThread = new MyThread();
        firstThread.start();
        String firstThreadName = firstThread.getName();
        System.out.println("firstThreadName="+firstThreadName);

        //创建第二个子线程
        MyThread secondThread = new MyThread();
        secondThread.start();
        String secondThreadName = secondThread.getName();
        System.out.println("secondThreadName="+secondThreadName);
    }
}

//MyThread继承Thread类
class MyThread extends Thread{
    public void run(){
        super.run();
        String threadName = Thread.currentThread().getName();
        for (int i = 0;i < 5;i++){
            System.out.println(threadName+",i="+i);
        }
    }
}
