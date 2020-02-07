import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
////测试类
//ArrayList 和 LinkedList
public class MyTest {
    public static void addTest(List<String> list){
        System.out.println(list.getClass().getName()+"开始查找");
        long start = System.currentTimeMillis();
        System.out.println("开始时间: " + start);
        list.add("需要查找的数据");
        list.add("eeee");
        list.add("aaee");
        list.add("abbb");
        for (int i = 0;i < 10000000;i++){
            for (int j = 0;j < list.size();j++){
                list.get(j).contains("e");
                System.out.println("");
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("结束时间： "+ end);
        System.out.println("总耗时："+(end - start));
    }

    public static void main(String[] args){
        List<String> a = new ArrayList<>();
        List<String> b = new LinkedList<>();
        addTest(a);
        addTest(b);
    }
}