package MyStack;

/**
 * @author Johannes Zottele
 * @version 1
 */
public class PointStack {

    /**
     * head is the head node of the stack tree
     * sizeCounter stores the actual size of the stack tree
     */
    private Node head;
    private int sizeCounter = 0;

    /**
     * Pushes points to stack storage
     *
     * <p>Use {@link #pushStack(PointStack other)} to push all points of an other stack to this one.</p>
     *
     * @param p Point you want to store in stack
     */
    public void push(Point p) {
        if(head == null) head = new Node(p, null);
        else head = new Node(p, head);

        sizeCounter++;
    }

    /**
     * Push all points of other stack to this one.
     *
     * @param other an other stack you want to push to current
     */
    public void pushStack(PointStack other) {
        if(other.head == null) return;

        Node otherNode = other.head;
        for(int i = 0; i < other.size(); i++) {
            this.push(otherNode.getPoint());
            otherNode = otherNode.next();
        }
    }

    /**
     * Get all points stored in this stack
     *
     * <p>This will iterate through all nodes and collects the points from the node to an array </p>
     *
     *
     * @return Point[] with size of {@link #size()}
     */
    public Point[] getAll() {
        Point[] points = new Point[sizeCounter];
        if (head == null) return null;
        Node iNode = this.head;
        for(int i = 0; i < sizeCounter; i++) {
            points[i] = iNode.getPoint();
            iNode = iNode.next();
        }
        return points;
    }


    /**
     * Get the size of this stack
     *
     * @return amount of points stored in stack
     */
    public int size() {
        return this.sizeCounter;
    }


}
