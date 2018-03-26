
public class LinkedList {
	public Node head;
	public int num;
	public LinkedList() {
		head = null;
		num = 0;
	}
	
	public void add(Node n) {
		Node runner = this.head;
		if (head == null) {
			this.head = n;
		}else {
			while (runner.next != null) {
				runner = runner.next;
			}
			runner.next = n;
			this.num++;
		}
	}
	
	public void addBegin(Node n) {
		if (this.head != null)
			n.next = this.head;
		this.head = n;
		this.num++;
	}
	
	
	public void addMiddle(int position, Node n) {
		int i=0;
		Node runner = this.head;
		while (runner != null) {
			if (i == position) {
				n.next = runner.next;
				runner.next = n;
				break;
			}
			i++;
			runner = runner.next;
			this.num++;
		}
		
	}

	
	public void clear() {
		this.head = null;
	}
	
	public void cloneList() {
		
	}
	
	public int getElement(int position) {
		int i=0;
		Node runner = head;
		while (runner != null) {
			if (i == position) {
			return runner.data;	
		}
			i++;
			runner = runner.next;
		}
		
		return 0;
	}
	

	public boolean containsElement(int data) {
		Node runner = head;
		while (runner != null) {
			if (runner.data == data) {
				return true;
			}
			runner = runner.next;
		}
		
		return false;
	}
	
	public void print() {
		Node runner = head;;
		while (runner != null) {
			System.out.print(runner.data + "->");
			runner = runner.next;
		}
		System.out.print("null");
	}
}
