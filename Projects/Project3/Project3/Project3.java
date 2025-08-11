
import java.util.*;
import java.io.*;

public class Project3 {

    public static void main(String[] args) {

        Tree tr = new Tree();

        //vorodi 
        Scanner input = new Scanner(System.in);

        System.out.println("Enter : ");
        String vorodiString = input.nextLine();
        char[] vorodiChar = vorodiString.toCharArray();

        //ijaade safe olaviyat va min heap
        ArrayList<Node> nodeList = tr.saf(vorodiChar);
        Node root = tr.minHeap(nodeList);

        //ekhtesaase code har character
        String charCode = "";
        HashMap<Character, String> charCodeHashMap = new HashMap<>();
        charCodeHashMap = tr.makeCharCode(root, charCode, charCodeHashMap);
        System.out.println(charCodeHashMap);

        //khoroji
        for (int i = 0; i < vorodiChar.length; i++) {
            System.out.print(charCodeHashMap.get((vorodiChar[i])) + "-");
        }

    }

}
