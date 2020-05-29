package test.leetcode.easy;

import java.util.Stack;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 */

public class 最长公共前缀 {
    public static void main(String[] args) {
        String result = solution(new String[]{"a"});
        System.out.println(result);
    }

    private static String solution(String[] strs) {
//        System.out.println(strs.toString());
        System.out.println(strs.length);
        if(strs.length == 0){
            return "";
        }
//        Stack<Character> temp = new Stack<>();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 0; j < strs[1].length(); j++) {
                if (strs[0].charAt(i) == strs[1].charAt(j)) {
                    for (int k = 0; k < strs[2].length(); k++) {
                        if (strs[1].charAt(j) == strs[2].charAt(k)) {
//                            temp.push(strs[2].charAt(k));
                            temp.append(strs[2].charAt(k));
                        }
                    }
                }
            }
        }
        return temp.toString();
    }
}
