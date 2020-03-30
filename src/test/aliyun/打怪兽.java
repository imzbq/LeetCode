package test.aliyun;

import java.lang.reflect.Array;
import java.util.*;

/*
现在有3只怪兽，他们的都有自己的血量a,b,c(1<=a,b,c<=100)，当Tom打死第一怪兽的时候花费的代价为0，
其余的怪兽的代价为当前的怪兽的血量减去上一个怪兽的血量的绝对值。问Tom打死这些怪兽所需要的最小代价
分别输入三只怪兽的血量
输出打死三只怪兽的最小代价


示例1
输入：
2
5
8
输出：
6
 */
public class 打怪兽 {

    public static void main(String[] args) {
        int result = solution(79, 39, 12);
        System.out.println(result);
    }

    public static int solution(int a, int b, int c) {
        int[] arr = {a, b, c};
        int hp = 0;
        int cost = 0;
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

        for (int i = 1; i < arr.length; i++) {
            cost = arr[i] - Math.abs(arr[i - 1]);
            hp += cost;
        }
        return hp;
    }
}
