package MyStack;

public class Node {

    private Point point;
    private Node next;

    public Node(Point point, Node next) {
        this.point = point;
        this.next = next;
    }

    public Node next() {
        return this.next;
    }

    public Point getPoint() {
        return this.point;
    }

}
