package topinterviewquestions;

public class Problem_0007_ReverseInteger {

    public static int reverse(int x) {
        boolean neg = ((x >>> 31) & 1) == 1;
        x = neg ? x : -x;
        int m = Integer.MIN_VALUE / 10;
        int o = Integer.MIN_VALUE % 10;
        int res = 0;
        while (x != 0) {
            if (res < m || (res == m && x % 10 < o)) {
                return 0;
            }
            res = res * 10 + x % 10;
            x /= 10;
        }
        return neg ? res : Math.abs(res);
    }

    /**
     * 负数的绝对值表示范围比正数的表示范围要大于1
     * 
     * @param x
     * @return
     */
    public int _reverse(int x) {
        boolean negative = (x >>> 31 & 1) == 1;
        if (!negative) {
            x = -x;
        }
        int res = 0;
        int m = Integer.MIN_VALUE / 10;
        int o = Integer.MIN_VALUE % 10;
        while (x != 0) {
            if (res < m || (res == m && x % 10 < o)) {
                return 0;
            }
            res = res * 10 + x % 10;
            x = x / 10;
        }
        if (!negative) {
            return -res;
        } else {
            return res;
        }
    }

}
