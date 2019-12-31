package test.other;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 6, 2, 1, 9, 21};
        arr = maoPao(arr);
        for (int item : arr) {
            System.out.println(item);
        }
    }

    public static int[] maoPao(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}

