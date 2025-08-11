
import java.math.*;
import java.util.*;

public class We35 {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        String[] str = input.nextLine().split("#");

        int sum = calculate(str.length, 0, 1, 0);

        BigDecimal bigdc = BigDecimal.valueOf((double) sum / str.length);
        System.out.print(bigdc.setScale(2, RoundingMode.DOWN));

    }

    public static int calculate(int n, int x, int lvl, int sum) {
        //sharte paayaan
        if (x >= n) {
            return sum;
        }
        //tedaade arraye har level
        int max = (int) Math.pow(2, lvl - 1);
        //age hame gerehaaye level por nashode baashan
        if (max + x > n) {
            max = n - x;
        }

        sum += (lvl * max);

        return calculate(n, (max + x), (lvl + 1), sum);
    }

}
