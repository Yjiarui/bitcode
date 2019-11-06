public class CreateThread {
    public static void main(String[] args) {
        //创建一个线程，并启动
        MyThread p = new MyThread();
        p.start();

        MyRunner runner = new MyRunner();
        Thread t = new Thread(runner);
        t.start();
        //javaMain是java层面上的主线程，和main方法中自行创建的线程是同级的
        while(true){

        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("in thread");
        while (true){

        }
    }
}
  class MyRunner implements Runnable{
     @Override
     public void run(){
         System.out.println("in runnable");
         while (true){

         }
     }
  }

