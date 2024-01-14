package Day_3_4.Array.Ex15;

public class Main {
    public static void main(String[] args) {
        int arr[] = {4, 8, 7, 12};
        int sec_arr[] = {3, 6};
        int result = 0;
        int i = 0, y = 0;
        
        while (i < sec_arr.length) {
            while (y < arr.length) {
                result += sec_arr[i] * arr[y];
                y++;
            }
            y = 0;
            i++;
        }
        System.out.println(result);
    }
}
