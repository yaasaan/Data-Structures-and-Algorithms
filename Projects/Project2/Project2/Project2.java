
import java.util.*;

public class Project2 {

    public static void main(String[] args) {

        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);

        Tree tr1 = new Tree();

        System.out.print("inOrder List : ");
        tr1.inOrder(root1);
        System.out.println(tr1.inOrderList);

        System.out.print("preOrder List : ");
        tr1.preOrder(root1);
        System.out.println(tr1.preOrderList);

        System.out.print("postOrder List : ");
        tr1.postOrder(root1);
        System.out.println(tr1.postOrderList);

        System.out.println("------------------------------------------------------- ");

        Node root2 = new Node(15);
        root2.left = new Node(10);
        root2.right = new Node(20);
        root2.left.left = new Node(8);
        root2.left.right = new Node(12);
        root2.right.left = new Node(16);
        root2.right.right = new Node(25);

        Tree tr2 = new Tree();

        System.out.print("inOrder List : ");
        tr2.inOrder(root2);
        System.out.println(tr2.inOrderList);

        //Successor
        int num1 = 20;
        int x = tr2.Successor(root2, num1);

        if (x != 0) {
            System.out.format("the inOrder Successor of  %d is %d\n", num1, x);
        } else {
            System.out.format("the inOrder Successor of  %d does not exist.\n", num1);
        }

        //Predecessor
        int num2 = 25;
        int y = tr2.Predecessor(root2, num2);

        if (y != 0) {
            System.out.format("the inOrder Predecessor of  %d is %d\n", num2, y);
        } else {
            System.out.format("the inOrder Predecessor of  %d does not exist.\n", num2);
        }

    }

}
