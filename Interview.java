class ListNode{
	public int value;  //保存结点中的数据
	public ListNode next;  //指向下一个结点的引用
	
	//构造方法
	public ListNode(int value){
		this.value=value;
		this.next=null;
	}
	
	public String toString(){
		return String.format("Node()%d",val);
	}
}
class Review{
//头插
public static ListNode pushFront(Node head){
	Node newNode = new Node;
	newNode.next = head;
	return newNode;
}
//尾删
public static ListNode popBack(Node head){
	if(head = null){
		return null;
	}
	
	if(head.next == null){
		return null;	
	}else{
		Node lastLast = getlastLast(head);
		lastLast.next = null;
		return head;
	}
 }
}
public class Solution{
	public ListNode reverseList(ListNode head){
		ListNode result = null;
		ListNode cur = head;
		while(cur != null){
			ListNode next = cur.next;
			cur.next = result;
			result = cur;
			cur = next;
		}
		return result; 
	public ListNode removeElements(ListNode head,int val){
		if(head == null){
			return null;
		}
		ListNode prev = head;
		ListNode cur = head.next;
		
		while(cur != null){
			if(cur.val == val){
				prev.next = cur.next;
			}else{
				prev = cur;
			}
			cur = cur.next;
		}
		
		if(head.val == val){
			head = head.next;
		}
		return head;
	}
	public ListNode removeElements2(ListNode head, int val) {
		ListNode result = null;
		ListNode last = null;
		ListNode cur = head;
		
		while (cur != null) {
			if (cur.val != val) {
				if (result == null) {
					result = cur;
				} else {
					last.next = cur;
				}
				
				last = cur;
			}
			
			cur = cur.next;
		}
		
		if (last != null) {
			last.next = null;
		}
		
		return result;
	}
	
	public ListNodeFindKthToTail(ListNode head,int k){
		int length = 0;
		for(Node cur = head;cur != null;cur=cur.next){
			length++;
		}
		
		if(length < k){
			return null;
		}
		
            int n = length - k;
			ListNode kth = head;
			for(int i =0; i < n;i++){
				kth = kth.next;
			}
			return kth;
    }
	public ListNode FindKthToTail2(ListNode head,int k){
		ListNode front = head;
		ListNode back = head;
		
		for(int i = 0;i < k;i++){
			if(front = null){
				return null;
			}
			front = front.next;
		}
		
		while(front != null){
			front = front.next;
			back = back.next;
		}
		return back;
	}
	public ListNode middleNode(ListNode head){
		ListNode red = head;
		ListNode blue = head;
		
		if(red = null){
			return null;
		}
		while(red != null){
			red = red.next;
			if(red == null){
				break;
			}
			blue = blue.next;	
			red = red.next;
		}
		return blue;
	}
	public ListNode mergeTwoLists(ListNode l1,ListNode l2){
		if (l1 == null) { return l2; }
		if (l2 == null) { return l1; }
		
		ListNode cur1 = l1;
		ListNode cur2 = l2;
		ListNode result = null;
		ListNode last = null;
		
		while (cur1 != null && cur2 != null) {
			if (cur1.val <= cur2.val) {
				ListNode next = cur1.next;
				
				// 把 cur1 尾插到 result 上
				// 两种情况：链表为空链表/非空链表
				// 1. 空链：头插
				// 2. 非空链表：1）确定最后一个结点（利用last记录）
				//              2）最后一个结点的 next = cur1
				if (result == null) {
					cur1.next = result;	// 可选的
					result = cur1;
				} else {
					cur1.next = null;	// 可选的
					last.next = cur1;
				}
				// 保证 last 永远指向最后一个结点
				last = cur1;
				
				cur1 = next;
			} else {
				ListNode next = cur2.next;	// 让循环走起来
				
				// 把 cur2 尾插到 result 上
				// 两种情况：链表为空链表/非空链表
				// 1. 空链：头插
				// 2. 非空链表：1）确定最后一个结点（利用last记录）
				//              2）最后一个结点的 next = cur2
				if (result == null) {
					cur2.next = result;	// 可选的
					result = cur2;
				} else {
					cur2.next = null;	// 可选的
					last.next = cur2;
				}
				// 保证 last 永远指向最后一个结点
				last = cur2;
				
				cur2 = next;	// 让循环走起来
			}
		}
		
		// cur		current	当前
		// 或者 cur1 为空 或者 cur2 为空
		if (cur1 != null) {
			last.next = cur1;
		} else {
			last.next = cur2;
		}
		
		return result;
	}
	
}