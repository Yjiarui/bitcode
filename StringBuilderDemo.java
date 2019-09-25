public class StringBuilderDemo {
    public static void test1(){
        String s = "";
        for(int i = 0;i < 10;i++){
            s += i;
        }
        System.out.println(s);
    }

    public static void main(String[] args) {
        test1();
    }
}
