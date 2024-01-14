package Day_3.Array.Ex10;

public class Main10 {
    public static void main(String[] args) {
        int i = 0;
        int arr[] = {4, 8, 7, 9, 1, 5, 4, 6};
        int result = 0;

        while (i < arr.length) {
            result += arr[i];    
            i++;
        }
        System.out.println(result);
    }
}
