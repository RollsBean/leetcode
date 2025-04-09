package algorithm.string.a_20_isValidBracket;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    public boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        Deque<Character> deque = new ArrayDeque<>();
        boolean result = true;
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == '(' || c == '{' || c == '[') {
                deque.addLast(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (!deque.isEmpty()) {
                    Character peek = deque.peekLast();
                    if (c == ')') {
                        if (peek == '(') {
                            deque.pollLast();
                            continue;
                        } else {
                            result = false;
                            break;
                        }
                    }
                    if (c == '}') {
                        if (peek == '{') {
                            deque.pollLast();
                            continue;
                        } else {
                            result = false;
                            break;
                        }
                    }
                    if (c == ']') {
                        if (peek == '[') {
                            deque.pollLast();
                            continue;
                        } else {
                            result = false;
                            break;
                        }
                    }
                } else {
                    result = false;
                    break;
                }
            }
        }
        return result && deque.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean valid = solution.isValid("[");
        System.out.println(valid);
    }
}
