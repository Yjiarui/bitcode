//Collection示例

import java.util.Collection
import java.util.ArrayList
import java.util.Arrays

public class Demo1 {
	public static void main(String[] args){
		Collection<String> list = new ArrayList<>();
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		list.add("我");
		list.add("爱");
		list.add("Java");
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		Object[] array = list.toArray();
		System.out.println(Arrays.toString(array));
		for(String s : list){
			System.out.println(s);
		}
		list.remove("爱");
	    for(String s : list){
			System.out.println(s);
		}
		list.clear();
		System.out.println(list.size());
		System.out.println(list.isEmpty());
	}
}
/*0
true
3
fasle
[我，爱，Java]
我
爱
Java
我
Java
0
true*/