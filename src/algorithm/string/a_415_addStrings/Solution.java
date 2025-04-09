package algorithm.string.a_415_addStrings;

class Solution {

    public String addStrings(String num1, String num2) {
        char[] longArray;
        char[] shortArray;
        longArray = num1.length() >= num2.length() ? num1.toCharArray() : num2.toCharArray();
        shortArray = num1.length() < num2.length() ? num1.toCharArray() : num2.toCharArray();

        int j = shortArray.length - 1;
        boolean shift = false;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = longArray.length - 1; i >= 0; i--) {
            char c1 = longArray[i];
            char c2;
            if (j < 0) {
                c2 = Character.forDigit(0, 10);
            } else {
                c2 = shortArray[j--];
            }
            int sum = Character.getNumericValue(c1) + Character.getNumericValue(c2);
            if (shift) {
                sum++;
            }
            if (sum > 9) {
                stringBuilder.append(Character.forDigit((sum - 10), 10));
                shift = true;
            } else {
                stringBuilder.append(Character.forDigit(sum, 10));
                shift = false;
            }
        }
        if (shift) {
            stringBuilder.append(Character.forDigit(1, 10));
        }
        return String.valueOf(stringBuilder.reverse());
    }

    public static void main(String[] args) {
        String num1 = "1";
        String num2 = "9";
        Solution solution = new Solution();
        String s = solution.addStrings(num1, num2);
        System.out.println(s);
//        int x = 1;
//        System.out.println(--x);
        char a = 1 + '0';

    }
}
