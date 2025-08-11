
import java.util.*;

public class We34 {
    
    public static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        String[] str1 = input.nextLine().split(" ");
        int[] ar1 = new int[str1.length];
        for (int i = 0; i < str1.length; i++) {
            ar1[i] = Integer.parseInt(str1[i]);
        }
        
        String[] str2 = input.nextLine().split(" ");
        int[] ar2 = new int[str2.length];
        for (int i = 0; i < str2.length; i++) {
            ar2[i] = Integer.parseInt(str2[i]);
        }
        
        int sum = input.nextInt();
        
        sort(ar1, str1.length);
        sort(ar2, str2.length);
        
        for (int i : ar1) {
            int x = search(ar2, sum - i);
            if (x != -1) {
                System.out.print("#" + i + "," + ar2[x]);
            }
        }
        
    }
    
    public static void sort(int[] ar, int n) {
        if (n < 2) {
            return;
        }
        
        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];
        
        System.arraycopy(ar, 0, left, 0, mid);
        System.arraycopy(ar, mid, right, 0, n - mid);
        
        sort(left, mid);
        sort(right, n - mid);
        
        merge(ar, left, right, mid, n - mid);
    }
    
    public static void merge(int[] ar, int[] left, int[] right, int l, int r) {
        int i = 0;//left
        int j = 0;//right 
        int k = 0;//main

        while (i < l && j < r) {
            if (left[i] <= right[j]) {
                ar[k] = left[i];
                i++;
            } else {
                ar[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < l) {
            ar[k] = left[i];
            k++;
            i++;
        }
        while (j < r) {
            ar[k] = right[j];
            k++;
            j++;
        }
        
    }
    
    public static int search(int[] ar, int x) {
        int low = 0, high = ar.length - 1;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            if (x == ar[mid]) {
                return mid;
            } else if (x > ar[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return -1;
    }
    
}
