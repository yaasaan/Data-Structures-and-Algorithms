
public class Node {

    Node left;
    Node right;
    int rep;
    Character ch;

    public Node(int rep, Character ch, Node left, Node right) {
        this.rep = rep;
        this.ch = ch;
        this.left = left;
        this.right = right;
    }

    public Node(int rep, Node left, Node right) {
        this.rep = rep;
        this.ch = null;
        this.left = left;
        this.right = right;
    }

    public Node(int rep, Character ch) {
        this.rep = rep;
        this.ch = ch;
        this.left = null;
        this.right = null;
    }

}
