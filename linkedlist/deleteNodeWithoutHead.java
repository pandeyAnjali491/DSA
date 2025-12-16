public class deleteNodeWithoutHead{
    // main logic is without pre list how can you delete the node
    // answer is - make curr node which have to be delete as next node (like twins) and then delete the next node as we can reach to it  
    public static void deleteNode(Node node) {
        Node next = node.next;
        node.val = next.val;
        node.next = next.next;
    }
    public static void add(Node head,int data){
        Node newNode = new Node(data);
        Node temp = head;
        while (temp.next!=null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }
    public static void display(Node head){
        Node temp = head;
        while (temp!=null) {
            System.out.print(temp.val+" -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        Node head = new Node(0);
        add(head, 4);
        head = head.next; // head at-> 4
        add(head, 5);
        add(head, 1);
        add(head, 9);
        display(head);
        deleteNode(head.next.next); // 1
        display(head);
    }
}

class Node {
    int val;
    Node next;
    Node(int d){
        this.val = d;
    }
}