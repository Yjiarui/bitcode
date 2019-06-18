//删除一排序链表中重复的结点且不保留
class ListNode{
	int val;
	ListNode next;
	
	ListNode(int val){
		this.val = val;
	}
}

public ListNode deleteDuplication(ListNode pHead){
	ListNode prev = null;
	ListNode p1 = pHead;
	ListNode p2 = pHead;
	while(p2 != null){
		if(p1.val == p2.val){
			p1 = p1.next;
			p2 = p2.next;
			prev = p1;
		}else{
			while(p2 != null && p2.val == p1.val){
				p2 = p2.next;
			}
			if(prev == null){
				prev = p2;
			}else{
				prev.next = p2;
			}
			p1 = p2;
			if(p2 != null){
				p2 = p2.next;
			}
		}
	}
	return prev.next;
}