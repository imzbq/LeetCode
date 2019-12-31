package test.other;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        List<Integer> numList = new ArrayList<>();
        int target = 16548;
        for (int i = 1; i < 100000000; i++) {
            numList.add(i);
        }
        int result = binarySearch(numList, target);
        System.out.println("结果：" + result);
    }

    public static int binarySearch(List<Integer> numList, int target) {
        int low = 0;
        int high = numList.size() - 1;
        int count = 0;
        while (low <= high) {
            count++;
            System.out.println("执行第：" + count + "次");
            int mid = (low + high) / 2;
            int guess = numList.get(mid);
            if (guess == target) {
                return guess;
            }
            if (guess > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return 0;
    }
}
