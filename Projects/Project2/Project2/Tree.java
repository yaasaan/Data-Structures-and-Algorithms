
import java.util.*;

public class Tree {

    ArrayList<Integer> inOrderList = new ArrayList<>();
    ArrayList<Integer> preOrderList = new ArrayList<>();
    ArrayList<Integer> postOrderList = new ArrayList<>();

    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            inOrderList.add(node.data);
            inOrder(node.right);
        }
    }

    public void preOrder(Node node) {
        if (node != null) {
            preOrderList.add(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            postOrderList.add(node.data);
        }
    }

    public int Successor(Node node, int num1) {

        for (int i = 0; i < inOrderList.size() - 1; i++) {
            if (num1 == inOrderList.get(i) && inOrderList.get(i++) != null) {
                return inOrderList.get(i++);
            }
        }
        return 0;
    }

    public int Predecessor(Node node, int num2) {

        for (int i = 0; i < inOrderList.size(); i++) {
            if (num2 == inOrderList.get(i) && i != 0) {
                return inOrderList.get(--i);
            }
        }
        return 0;
    }
}
