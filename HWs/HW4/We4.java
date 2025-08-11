
import java.util.*;

public class We4 {

    public static int changed = 0;
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int n = 3, m = 3;

        int[][] box = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] str1 = input.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(str1[j]);
            }
        }

        int result = check(box, n, m);
        System.out.println(result);

    }

    public static int check(int[][] box, int n, int m) {
        //extra box
        int[][] exbox = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                exbox[i][j] = 0;
            }
        }

        boolean change = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //if Empty
                if (box[i][j] == 0) {
                    continue;
                }
                //if Fresh
                if (box[i][j] == 1 && exbox[i][j] == 0) {
                    exbox[i][j] = box[i][j];
                    continue;
                }
                //if Rotten
                if (box[i][j] == 2) {
                    exbox[i][j] = 0;
                    if ((i + 1) < n && box[i + 1][j] == 1) {
                        exbox[i + 1][j] = 2;
                        change = false;
                    }

                    if ((i - 1) >= 0 && box[i - 1][j] == 1) {
                        exbox[i - 1][j] = 2;
                        change = false;
                    }

                    if ((j + 1) < m && box[i][j + 1] == 1) {
                        exbox[i][j + 1] = 2;
                        change = false;
                    }

                    if ((j - 1) >= 0 && box[i][j - 1] == 1) {
                        exbox[i][j - 1] = 2;
                        change = false;
                    }
                    continue;

                }

            }
        }

        //vaziyate box 
        int f = 0, r = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (exbox[i][j] == 2) {
                    r++;
                }
                if (exbox[i][j] == 1) {
                    f++;
                }
            }
        }
        //afzaayesh dor 
        if (change == false) {
            changed++;
        }

        System.out.print("\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(exbox[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");

        if (f == 0) {
            return changed;
        } else if (r == 0) {
            return -1;
        }
        return check(exbox, n, m);
    }
}
