package test.leetcode.easy;

import sun.applet.Main;

import java.text.BreakIterator;

/*
给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。
如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1 。
 */
public class 将数字变成0的操作次数 {

    public static void main(String[] args) {
        int solution = solution(Integer.MAX_VALUE);
        System.out.println(solution);
    }

    //1、判断输入数字是否是偶数
    //2、是偶数则除以2，否则减1
    public static int solution(int num) {
        if (num == 0)
            return 0;
        else if (num == 1)
            return 1;

        int count = 0;
        while (num != 0) {
            count++;
            if (num % 2 == 0)
                num /= 2;
            else
                num--;
        }
        return count;
    }
}
