
import java.util.*;
import java.io.*;

public class Tree {

    //peyda kardan tedaade har character 
    public static ArrayList<Node> saf(char[] vorodiChar) {

        ArrayList<Character> charsList = new ArrayList<>();
        HashMap<Character, Integer> charHashMap = new HashMap<Character, Integer>();

        //ja gozaari charactera to hashmap
        for (int i = 0; vorodiChar.length > i; i++) {
            if (charHashMap.containsKey(vorodiChar[i])) {
                charHashMap.put(vorodiChar[i], charHashMap.get(vorodiChar[i]) + 1);
            } else {
                charsList.add(vorodiChar[i]);
                charHashMap.put(vorodiChar[i], 1);
            }
        }

        //tabdile hashmap be safe olaviat 
        ArrayList<Node> nodesList = new ArrayList<>();

        for (int i = 0; i < charsList.size(); i++) {
            int num1 = charHashMap.get(charsList.get(i));
            if (nodesList.isEmpty()) {
                nodesList.add(new Node(num1, charsList.get(i)));
            } else {
                int j = i;
                while (j > 0 && num1 < nodesList.get(j - 1).rep) {
                    j--;
                }
                nodesList.add(j, new Node(num1, charsList.get(i)));
            }
        }
        return nodesList;
    }

    //-----------------------------------------------------------------------------------------------------------------
    //saakhte derakhte min Heap 
    public static Node minHeap(ArrayList<Node> nodeList) {

        ArrayList<Node> nodeListNew = nodeList;
        Node nodeLeft, nodeRight;
        int repSum = 0;

        while (nodeListNew.size() > 1) {

            nodeLeft = nodeListNew.remove(0);
            nodeRight = nodeListNew.remove(0);
            repSum = nodeLeft.rep + nodeRight.rep;

            int i = 0;
            while (i < nodeListNew.size() && repSum > nodeListNew.get(i).rep) {
                i++;
            }
            //gere pedar bad farzande chapo raast 
            nodeListNew.add(i, new Node(repSum, nodeLeft, nodeRight));
        }

        //rishe barmigarde
        return nodeListNew.get(0);
    }

    //-----------------------------------------------------------------------------------------------------------------
    //code charactera 
    public static HashMap<Character, String> makeCharCode(Node node, String charCode, HashMap<Character, String> charCodeHashMap) {

        //age be gere i resid ke barg bod codo zakhire mikonim 
        if (node.left == null && node.right == null) {
            charCodeHashMap.put(node.ch, charCode);
        } else {
            if (node.left != null) {
                makeCharCode(node.left, charCode + "0", charCodeHashMap);
            }
            if (node.right != null) {
                makeCharCode(node.right, charCode + "1", charCodeHashMap);
            }
        }
        return charCodeHashMap;
    }

}
