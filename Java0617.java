//设定x 将小于x的数排在大于或等于x之前
class ListNode{
	int val;
	ListNode next;
	
	ListNode(int val){
		this.val = val;
	}
}

public ListNode partition(ListNode pHead, int x){
	ListNode small = null;
	ListNode big = null;
	ListNode last1 = null;
	ListNode last2 = null;
	for(ListNode cur = head;cur != null;cur = cur.next){
		if(cur.val < x){
			if(small == null){
				small = cur;
			}else{
				last1.next = cur;
			}
			last1 = cur;
		}else{
			if(big == null){
				big = cur;
			}else{
				last2.next = cur;
			}
			last2 = cur;
		}
		if(small == null){
			return big;
		}else{
			small.next = big;
			if(big != null){
				last2.next = null;
			}
			return small;
		}
	}
}