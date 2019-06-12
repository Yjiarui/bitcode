//给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
//如果有两个中间结点，则返回第二个中间结点。
 
public class ListNode {
      int val;
      ListNode next;
	  
      ListNode(int val) { 
	     this.val = val; 
		 }
  }
 
class Solution {
	public ListNode middleNode(ListNode head){
        ListNode fast = head;
		ListNode slow = head;
		while(fast != null){
			fast = fast.next;
			if(fast == null){
                break;
            }else{
			fast = fast.next;
			slow = slow.next;
            }
		}
		return slow;
    }
}
	







