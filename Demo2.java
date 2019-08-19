//Map示例

import java.util.Map;
import java.util.HashMap;

public class Demo2{
	public static void main(String[] args){
		Map<String,String> map = new HashMap<>();
		System.out.println(map.size());
		System.out.println(map.isEmpty());
		System.out.println(map.get("作者"));
		System.out.println(map.getOrDefault("作者","佚名"));
		System.out.println(map.containsKey("作者"));
		System.out.println(map.containsValue("佚名"));
		map.put("作者","鲁迅");
		map.put("标题","狂人日记");
		map.put("发表时间","1918年");
		System.out.println(map.size());
		System.out.println(map.isEmpty());
		System.out.println(map.get("作者"));
		System.out.println(map.getOrDefault("作者","佚名"));
		System.out.println(map.containsKey("作者"));
		System.out.println(map.containsValue("佚名"));
		for(Map.Entry<String,String> entry : map.entrySet()){
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
	}
}
/*0
true
null
佚名
false
false
3
false
鲁迅
鲁迅
true
false
作者
鲁迅
发表时间
1918年
标题
狂人日记
*/