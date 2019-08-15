class Node{
	public int val;
	public Node next = null;
	
	public Node(int val){this.val = val;}
}
public class Java0815{
	public static Node reverse(Node head){
		//遍历 head 代表的链表
		//把每个结点头插到新链表上
		Node rhead = null;
		Node cur = head;
		while(cur != null){
			Node next = cur.next;
			cur.next = rhead;
			rhead = cur;
			cur = next;
		}
	   return rhead;
	}
	public static void main(String[] args){
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = null;
		Node head = reverse(n1);
		reverse(n1);
		for(Node cur = head;cur != null;cur = cur.next){
			System.out.printf("(%d)-->",cur.val);
		}
	}
}
