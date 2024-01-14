package Day_3_4.Array.Ex14;

public class Main14 {
    public static void main(String[] args) {
        int arr[] = {4, 8, 7, 9, 1, 5, 4, 6};
        int sec_arr[] = {7, 6, 5, 2, 1, 3, 7, 4};
        int result[] = new int[8];
        int i = 0;
        
        while (i < arr.length) {
            result[i] = arr[i] + sec_arr[i];
            System.out.print(result[i] + " ");
            i++;
        }
    }
}
