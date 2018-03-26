
public class Node {
	int data;
	Node next;
	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
	
	public int getValue() {
		return this.data;
	}
	public void setValue(int data) {
		this.data = data;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
}
