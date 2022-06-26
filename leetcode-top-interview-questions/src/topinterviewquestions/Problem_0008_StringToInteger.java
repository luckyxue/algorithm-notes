package topinterviewquestions;

public class Problem_0008_StringToInteger {

	public static int myAtoi(String s) {
		if (s == null || s.equals("")) {
			return 0;
		}
		s = removeHeadZero(s.trim());
		if (s == null || s.equals("")) {
			return 0;
		}
		char[] str = s.toCharArray();
		if (!isValid(str)) {
			return 0;
		}
		// str 是符合日常书写的，正经整数形式
		boolean posi = str[0] == '-' ? false : true;
		int minq = Integer.MIN_VALUE / 10;
		int minr = Integer.MIN_VALUE % 10;
		int res = 0;
		int cur = 0;
		for (int i = (str[0] == '-' || str[0] == '+') ? 1 : 0; i < str.length; i++) {
			cur = '0' - str[i];
			if ((res < minq) || (res == minq && cur < minr)) {
				return posi ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			res = res * 10 + cur;
		}
		// res 负
		if (posi && res == Integer.MIN_VALUE) {
			return Integer.MAX_VALUE;
		}
		return posi ? -res : res;
	}

	public static String removeHeadZero(String str) {
		boolean r = (str.startsWith("+") || str.startsWith("-"));
		int s = r ? 1 : 0;
		for (; s < str.length(); s++) {
			if (str.charAt(s) != '0') {
				break;
			}
		}
		// s 到了第一个不是'0'字符的位置
		int e = -1;
		// 左<-右
		for (int i = str.length() - 1; i >= (r ? 1 : 0); i--) {
			if (str.charAt(i) < '0' || str.charAt(i) > '9') {
				e = i;
			}
		}
		// e 到了最左的 不是数字字符的位置
		return (r ? String.valueOf(str.charAt(0)) : "") + str.substring(s, e == -1 ? str.length() : e);
	}

	public static boolean isValid(char[] chas) {
		if (chas[0] != '-' && chas[0] != '+' && (chas[0] < '0' || chas[0] > '9')) {
			return false;
		}
		if ((chas[0] == '-' || chas[0] == '+') && chas.length == 1) {
			return false;
		}
		// 0 +... -... num
		for (int i = 1; i < chas.length; i++) {
			if (chas[i] < '0' || chas[i] > '9') {
				return false;
			}
		}
		return true;
	}

	/**
	 * 比上面的解法更加直观清晰
	 * 
	 * @param s
	 * @return
	 */
	public int _myAtoi(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        s = s.trim();
        boolean flag = s.startsWith("-") || s.startsWith("+");
        boolean negative = s.startsWith("-");
        int start = flag ? 1 : 0;
        for (; start < s.length(); start++) {
            if (s.charAt(start) != '0') {
                break;
            }
        }
        int end = start;
        for (; end < s.length(); end++) {
            if (s.charAt(end) < '0' || s.charAt(end) > '9') {
                break;
            }
        }
        String str = s.substring(start, end);
        int cur = 0;
        int res = 0;
        int m = Integer.MIN_VALUE / 10;
        int n = Integer.MIN_VALUE % 10;
        for (int i = 0; i < str.length(); i++) {
			// 很巧妙地转换成=负数
            cur = '0' - str.charAt(i);
            if (res < m || (res == m && cur < n)) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = res * 10 + cur;
        }
		// 这里需要注意正数的绝对值范围比负数的绝对值范围要大
        if (!negative && res == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return negative ? res : -res;
    }
}
