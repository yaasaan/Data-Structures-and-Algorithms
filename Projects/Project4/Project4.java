
import java.util.*;

public class Project4 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //input
        String strinput = input.nextLine();
        char[] charinput = strinput.toCharArray();

        //output
        System.out.println(infixTopostfix(charinput));
    }

    //===============================================================================================
    public static String infixTopostfix(char[] charinput) {

        //Olaviate Oprandha 
        HashMap<Character, Integer> hashmapOprand = new HashMap<>();
        hashmapOprand.put('+', 1);
        hashmapOprand.put('-', 1);
        hashmapOprand.put('*', 2);
        hashmapOprand.put('/', 2);
        hashmapOprand.put('^', 3);
        hashmapOprand.put('^', 3);
        hashmapOprand.put('(', -1);
        hashmapOprand.put(')', -1);

        String stroutput = "";

        //Stack stk = new Stack();
        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < charinput.length; i++) {
            if (Character.isLetter(charinput[i])) {

                stroutput += charinput[i];

            } else if (charinput[i] == '(') {

                stk.push(charinput[i]);

            } else if (charinput[i] == ')') {

                while (!stk.isEmpty() && stk.peek() != '(') {
                    stroutput += stk.pop();
                }
                stk.pop();

            } else {

                while (!stk.isEmpty() && hashmapOprand.get(charinput[i]) <= hashmapOprand.get(stk.peek())) {

                    stroutput += stk.pop();
                }
                stk.push(charinput[i]);

            }

        }
        //--------------------------------------------------------
        while (!stk.isEmpty()) {
            stroutput += stk.pop();
        }

        return stroutput;
    }

}
