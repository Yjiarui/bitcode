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
	







