//如何定义类
class Person{
	String name;
	int age;
    //没有明确的给出构造方法
    void print(){
	         System.out.printf("name=%s  age=%d%n",name,age);
        }
}

//班级类
class Group{
	//属性
	String name;        //名称
	int num;            //人数
	//方法
	//构造方法
	//1.定义类的时候，没有明确的给出构造方法
	//   Java编译器会补一个默认的构造方法出来
	//Group（）{}
	Group(String n,int m){
		name=n;
		num=m;
	}
	void print(String welcome){
		System.out.printf("%s %s 的 %d位同学%n",welcome,name,num);
	}
}

class B{
	int sum;
	
	B(int a,int b,int c){
	  System.out.println(a+b+c);
	  sum=a+b+c;
	}
	void print(){
		System.out.printf("%d",sum);
	}
}


//一个文件中只允许有一个public修饰的类，其名称与文件名相同
public class Javacode05192{
	public static void main(String[] args){
		//只定义了一个引用变量，没有真正创建对象
	Person personNull=null;
	//如何根据类创建对象
	Person person=new Person();
	
	//使用对象
	//对象.属性
	//对象.方法
	person.name="China";
	person.age=5000;
	person.print();
		
	Group group=new Group("Java10班",50);
	group.print("欢迎来到比特，");
	
	
	B b=new B(1,2,3);
	}
}


/*class B{
	int sum;
	
	B(int a,int b,int c){
	  System.out.println(a+b+c);
	  sum=a+b+c;
	}
	void print(){
		System.out.printf(sum);
	}
}
public class Javacode05192{
	public static void main(String[] args){
	B b=new B(1,2,3);
	b.print();
	}
}*/













