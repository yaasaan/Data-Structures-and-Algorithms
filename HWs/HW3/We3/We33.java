
import java.util.*;

public class We33 {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        String str1 = input.nextLine();

        if (Math.abs((str1.charAt(0)) - (str1.charAt(4))) == Math.abs((str1.charAt(2)) - (str1.charAt(6)))) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }

}
