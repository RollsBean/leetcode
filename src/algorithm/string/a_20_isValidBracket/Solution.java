package algorithm.string.a_20_isValidBracket;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == '(' || c == '{' || c == '[') {
                deque.addLast(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (!deque.isEmpty()) {
                    Character peek = deque.peekLast();
                    if (c == ')' && peek == '(') {
                        deque.pollLast();
                        continue;
                    }
                    if (c == '}' && peek == '{') {
                        deque.pollLast();
                        continue;
                    }
                    if (c == ']' && peek == '[') {
                        deque.pollLast();
                        continue;
                    }
                    break;
                } else {
                    deque.addLast(c);
                    break;
                }
            }
        }
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean valid = solution.isValid("(");
        System.out.println(valid);
    }
}
