//Sequence List顺序表
import java.util.Arrays;
public class SeqList{
	//属性
	private int[] array;      //保存数据
	private int size;         //保存array中已经有的数据个数
	//构造方法
	public SeqList(){
		//初始化部分
		//1.初始化数组给定默认大小
		//2.初始化size=0，没有数据
		array=new int[11];  //11可调节
		size=0;
	}
	//支持的方法
	//头插
	public void pushFront(int element){
		//Todo:先不考虑array放不下的情况
		//i是数据下标，遍历范围[size-1,o]
		ensureCapacity();
		for(int i=size-1;i>=0;i--){
		array[i+1]=array[i];
		}
		array[0]=element;
		size++;
	}
	//尾插
	public void pushBack(int element){
		//Todo:先不考虑array放不下的情况
		ensureCapacity();
		array[size++]=element;
	}
	//插入
	public void insert(int index,int element){
		//index的合法性[0，size]
		if(index<0||index>size){
			System.out.printf("index不合法");
		}
		ensureCapacity();
		//i代表的是空间的下标
		for(int i=size-1;i>=index;i--){
				array[i+1]=array[i];
		}
		array[index]=element;
		size++;
	}
	//头删
	public void popFront(){
		if(size==0){
			System.out.println("空顺序表，无法删除");
			return;
		}
		for(int i=1;i <=size-1; i++){
			array[i-1]=array[i];
		}
		size--;
	}
	//尾删
    public void popBack(){
		if(size==0){
			System.out.println("空顺序表，无法删除");
			return;
		}
		array[--size]=0;
	}
	//删除
	public void erase(int index){
		if(index<0||index>size){
			System.out.printf("index不合法");
		}
		for(int i=index;i <= size-1; i++){
			array[i]=array[i+1];
		}
		size--;
	}
	//查找
	public int indexOf(int element){
		for(int i = 0;i < size; i++){
			if(array[i]==element){
				return i; 
			}
		}
		return -1;
	}
	//根据下标，获取元素
	public int get(int index){
		for(int i = 0;i < size; i++){
			if(i==index){
				return array[i];
			}
		}
		return -1;
	}
	//给定下标，修改下标所在元素的值
	public int set(int index,int element){
		for(int i = 0;i <= size-1; i++){
			if(i==index){
				array[i]=element;
			}
		}
		return -1;
	}
	public int size(){
		return size;
	} 
	public boolean isEmpty(){
		return size==0;
	}
	public int capacity(){
		return array.length;
	}
	//便于打印，显示顺序表中已有元素
	public String toString(){
		return Arrays.toString(Arrays.copyOf(array,size));
	}
	//删除
	public void remove(int element){
		int index=indexOf(element);
		if(index!=-1){
			erase(index);
		}
	}
	public void removeAll(int element){
		/*int index;
		while((index=indexOf(element)) !=-1){
			erase(index);
		}*/
		int[] newArray=new int[size];
		int j=0;
		for(int i = 0;i < size; i++){
			if(array[i] !=element){
				newArray[j++]=array[i];
			}
		}
		//最后剩下的数一共有j个
		//1.把数据搬回去 2.更新size
		for(int i = 0;i < j; i++) {
			array[i]=newArray[i];
		}
		size = j;
	}
	//内部使用的方法
	//无论是否需要扩容，调用完这个方法，保证容量一定够用
	private void ensureCapacity(){
		if(size<array.length){
			//不需要扩容
			return;
		}
		//1.申请新房子
		int newCapacity=array.length+array.length/2;
		int[] newArray=new int[newCapacity];
		//2.搬家
		for(int i=0;i<array.length;i++){
			newArray[i]=array[i];
		}
		//3.发朋友圈
		this.array=newArray;
		//4.退老房子，利用javad垃圾回收，自动回收原来的数组
	}
	public static void test1(String[] args){
		SeqList seqList=new SeqList();
		System.out.println(seqList.toString());
		seqList.pushBack(1);
		seqList.pushBack(2);
		seqList.pushBack(3);
	    System.out.println(seqList.toString());
		
		seqList.pushFront(10);
		seqList.pushFront(20);
		seqList.pushFront(30);
		//[30,20,10,1,2,3]
		System.out.println(seqList.toString());
		
		seqList.insert(2,100);
		seqList.insert(4,200);
		//[30,20,100,10,200,1,2,3]
		System.out.println(seqList.toString());
		
		seqList.popFront();
		seqList.popFront();
		seqList.popFront();
		seqList.popFront();
		//[200,1,2,3]
		System.out.println(seqList.toString());
		
		seqList.popBack();
		seqList.popBack();
		seqList.popBack();
		//[200]
		System.out.println(seqList.toString());
		
		seqList.pushBack(3);
		seqList.pushBack(5);
		seqList.pushBack(8);
	    System.out.println(seqList.toString());
		
		
		int indexNum=seqList.indexOf(5);
		System.out.println("下标是"+indexNum);
		System.out.println(seqList.toString());
		
		System.out.println("元素是"+seqList.get(0));
		System.out.println(seqList.toString());
		
		seqList.set(2,77);
	    System.out.println(seqList.toString());
		
		seqList.removeAll(77);
	    System.out.println(seqList.toString());
		
	}
	public static void test2(String[] args){
		SeqList s=new SeqList();
		s.pushBack(1);
		s.pushBack(2);
		s.pushBack(3);
		s.pushBack(4);
		s.pushBack(1);
		s.pushBack(2);
		s.pushBack(3);
		s.pushBack(4);
		//[1,2,3,4,1,2,3,4]
		System.out.println(s.toString());
		s.remove(2);
		//[1,3,4,1,2,3,4]
		System.out.println(s.toString());
		s.removeAll(4);
		//[1,3,1,2,3]
		System.out.println(s.toString());
	}
	public static void main(String[] args){
		test1(args);
		test2(args);
	}
}
















