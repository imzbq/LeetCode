package test.leetcode.easy;

/*
给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
示例 1:
输入: 123
输出: 321

示例 2:
输入: -123
输出: -321

示例 3:
输入: 120
输出: 21
注意:
假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class ReverseNumber {
    public static void main(String[] args) {
        System.out.println(solution(01));
    }

    public static <T> int solution(T x) {
        String str = x.toString();
        Integer num;
        Integer result;
        try {
            num = Integer.parseInt(str);
            if (str.startsWith("-")) {
                str = str.substring(1, str.length());
            }
            StringBuilder sb = new StringBuilder();
            for (int i = str.length() - 1; i >= 0; i--) {
                sb.append(str.charAt(i));
            }
            result = Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
        return num < 0 ? 0 - result : result;
    }
}
