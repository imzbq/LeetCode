package test.leetcode.easy;

public class 汉明距离 {
    public static void main(String[] args) {
        int result = solution2(93, 73);
        System.out.println(result);
    }

    //x <= 0 , y < 2^31
    public static int solution(int x, int y) {
        if (x == y) {
            return 0;
        } else if (x > y) {
            return 1;
        }
        int count = 0;
        while (x <= y) {
            x = x << 1;
            count++;
        }
        return count;
    }

    public static int solution2(int x, int y){
        int z = x ^ y;
        int sum = 0;
        while (z != 0){
            int a = z & 1;
            sum += a;
            z = z>>1;
        }
        return sum;
    }
}
