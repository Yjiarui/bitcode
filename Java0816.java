//合并两个有序链表
class ListNode{
    public int val;
	public ListNode next = null;
	public ListNode(int val){ this.val = val;}
}
public class Java0816{
	public static ListNode combineList(ListNode head1,ListNode head2){
		//1.分别遍历两个链表，取值比较小的结点，尾插到新链表中
		//2.把剩余链表接到新链表中
		if(head1 == null){
			return head2;
		}
		if(head2 == null){
			return head1;
		}
		ListNode rhead = null;
		ListNode rlast = null;
		ListNode c1 = head1;
		ListNode c2 = head2;
		while(c1 != null && c2 != null){
			//取值比较小的结点
			if(c1.val <= c2.val){
				if(rhead == null){
					rhead = c1;
					rlast = rhead;
				}else{
					rlast.next = c1;
					rlast = rlast.next;
				}
				c1 = c1.next;
			}else{
				if(rhead == null){
					rhead = c2;
					rlast = rhead;
				}else{
					rlast.next = c2;
					rlast = rlast.next;
				}
				c2 = c2.next;
			}
				if(c1 != null){
					rlast.next = c1;
				}
				
		}
		return rhead;
	}
	private static ListNode createOrderList1(){
         ListNode n1 = new ListNode(0);
	     ListNode n2 = new ListNode(1);
	     ListNode n3 = new ListNode(2);
	     ListNode n4 = new ListNode(3);
		 
		 n1.next = n2;
		 n2.next = n3;
		 n3.next = n4;
		 
		 return n1;
	}
	private static ListNode createOrderList2(){
         ListNode n1 = new ListNode(0);
	     ListNode n2 = new ListNode(2);
	     ListNode n3 = new ListNode(3);
	     ListNode n4 = new ListNode(4);
		 
		 n1.next = n2;
		 n2.next = n3;
		 n3.next = n4;
		 
		 return n1;
	}
	public static void main(String[] args){
	    ListNode n1 = createOrderList1();
		ListNode n2 = createOrderList2();
		
		ListNode newList = combineList(n1,n2);
		for(ListNode cur = newList;cur != null;cur = cur.next){
			System.out.printf("(%d)-->",cur.val);
		}
	}
}