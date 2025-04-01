package algorithm.dynamicProgramming.a_1137_tribonacci;

public class Solution {

    public int tribonacci(int n) {
        // n = n + n+1 + n+2
        int t1 = 0;
        int t2 = 1;
        int t3 = 1;
        if (n == 0) {
            return 0;
        }
        if (n == 1) return 1;
        if (n == 2) return 1;
        for (int i = 3; i <= n; i++) {
            int tmp = t3;
            t3 = t1 + t2 + t3;
            t1 = t2;
            t2 = tmp;
        }
        return t3;
    }
}
