package test.leetcode.easy;

/*
请你来实现一个 atoi 函数，使其能将字符串转换成整数。

首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。

当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。

该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。

注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。

在任何情况下，若函数不能进行有效的转换时，请返回 0。

说明：

假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。

示例 1:

输入: "42"
输出: 42
示例 2:

输入: "   -42"
输出: -42
解释: 第一个非空白字符为 '-', 它是一个负号。
     我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
示例 3:

输入: "4193 with words"
输出: 4193
解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
示例 4:

输入: "words and 987"
输出: 0
解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
     因此无法执行有效的转换。
示例 5:

输入: "-91283472332"
输出: -2147483648
解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
     因此返回 INT_MIN (−231) 。
 */

public class 字符串转换整数 {
    public static void main(String[] args) {
        System.out.println(myAtoi("   -"));
    }

    public static int myAtoi(String str) {
        int index = 0;
        int len = str.length();
        boolean flag = false;//记录是否是负数
        //跳过为空的下标
        while (index < len) {
            if (str.charAt(index) == ' ') {
                index++;
            } else {
                break;
            }
        }
        //如果下表等于长度则表示该字符串为空
        if (len == index) {
            return 0;
        }
        //判断第一位非空字符如果是负号则标记，然后下标后移
        if (str.charAt(index) == '-') {
            flag = true;
            index++;
        //判断第一位非空字符为正号则下表后移
        } else if (str.charAt(index) == '+') {
            index++;
        }
        //如果出现“   -”的情况会导致下标越界，如果出现该情况则返回0；
        try {
            if (!Character.isDigit(str.charAt(index))) {
                return 0;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return 0;
        }
        //遍历字符串中的数字
        StringBuilder sb = new StringBuilder();
        for (int i = index; i < len; i++) {
            if (Character.isDigit(str.charAt(i))) {
                sb.append(str.charAt(i));
            } else {
                //非数字跳出，减少开销。
                break;
            }
        }
        int num;
        if (flag) {
            //如果超出int表示范围且为负数，返回int最小值
            try {
                num = 0 - Integer.parseInt(sb.toString());
            } catch (Exception e) {
                return Integer.MIN_VALUE;
            }
        } else {
            //如果超出int表示范围且为正数，返回int最大值
            try {
                num = Integer.parseInt(sb.toString());
            } catch (Exception e) {
                return Integer.MAX_VALUE;
            }
        }
        return num;
    }
}
