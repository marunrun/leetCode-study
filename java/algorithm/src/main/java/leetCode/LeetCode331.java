package main.java.leetCode;

public class LeetCode331 {

    public static boolean isValid(String preorder) {
        int n = preorder.length();
        int i = 0;
        int slots = 1;
        while (i < n) {
            if (slots == 0) {
                return false;
            }

            if (preorder.charAt(i) == ',') {
                i++;
            } else if (preorder.charAt(i) == '#') {
                slots--;
                i++;
            } else {
                while (i <n && preorder.charAt(i) != ',') {
                    i++;
                }
                slots++;
            }
        }
        return slots == 0;
    }

    public static void main(String[] args) {
        boolean valid = isValid("9,3,4,#,#,1,#,#,2,#,6,#,#");
        System.out.println(valid);
    }
}
