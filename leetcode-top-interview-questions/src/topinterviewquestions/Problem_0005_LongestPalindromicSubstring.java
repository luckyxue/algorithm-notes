package topinterviewquestions;

public class Problem_0005_LongestPalindromicSubstring {

	public static String longestPalindrome(String str) {
		if (str == null || str.length() == 0) {
			return "";
		}
		char[] charArr = manacherString(str);
		int[] pArr = new int[charArr.length];
		int index = -1;
		int pR = -1;
		int max = Integer.MIN_VALUE;
		int mid = 0;
		for (int i = 0; i != charArr.length; i++) {
			pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1;
			while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
				if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
					pArr[i]++;
				else {
					break;
				}
			}
			if (i + pArr[i] > pR) {
				pR = i + pArr[i];
				index = i;
			}
			if (max < pArr[i]) {
				max = pArr[i];
				mid = i;
			}
		}
		mid = (mid - 1) / 2;
		max = max - 1;
		return str.substring((max & 1) == 0 ? mid - (max / 2) + 1 : mid - (max / 2), mid + (max / 2) + 1);
	}

	public static char[] manacherString(String str) {
		char[] charArr = str.toCharArray();
		char[] res = new char[str.length() * 2 + 1];
		int index = 0;
		for (int i = 0; i != res.length; i++) {
			res[i] = (i & 1) == 0 ? '#' : charArr[index++];
		}
		return res;
	}

	public String _longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		int start = 0;
		int end = 0;
		for (int i = 0; i < s.length(); i++) {
			int len1 = expandCenter(s, i, i);
			int len2 = expandCenter(s, i, i + 1);
			int len = Math.max(len1, len2);
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}

	public int expandCenter(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		// 这里有一个很大的坑点就是，不满足的时候跳出来，这时候left和right都已经加一了
		// (right - 1) - (left - 1) + 1 = right - left - 1
		return right - left - 1;
	}

}
