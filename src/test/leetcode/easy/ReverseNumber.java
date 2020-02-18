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
假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，
如果反转后整数溢出那么就返回 0。
 */
public class ReverseNumber {
    public static void main(String[] args) {
        System.out.println(solution(-1234567089));
    }

    public static <T> int solution(T x) {
        //取参数绝对值
        Integer num = Math.abs((Integer) x);
        String str = num.toString();
        Integer result;

        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }

        try {
            //此处转换如果超出int表示范围就一定回报NumberFormatException
            result = Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }

        return (Integer) x < 0 ? 0 - result : result;
    }
}
