package topinterviewquestions;

public class Problem_0014_LongestCommonPrefix {

	public static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		char[] chs = strs[0].toCharArray();
		int min = Integer.MAX_VALUE;
		// 这里忽略了strs=[""]这种情况，如果是只有一个字符串那就会跳过更新min值，
		// 最后截取字符串会越界
		for (String str : strs) {
			char[] tmp = str.toCharArray();
			int index = 0;
			while (index < tmp.length && index < chs.length) {
				if (chs[index] != tmp[index]) {
					break;
				}
				index++;
			}
			min = Math.min(index, min);
			if (min == 0) {
				return "";
			}
		}
		return strs[0].substring(0, min);
	}

	public String _longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		if (strs.length == 1) {
			return strs[0];
		}
		char[] firstChars = strs[0].toCharArray();
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < strs.length; i++) {
			char[] curChars = strs[i].toCharArray();
			int index = 0;
			for (index = 0; index < firstChars.length && index < curChars.length; index++) {
				// 不等于的时候已经加1，所以截取字符串的时候不需要加1
				if (firstChars[index] != curChars[index]) {
					break;
				}
			}
			min = Math.min(min, index);
			if (min == 0) {
				return "";
			}
		}
		return strs[0].substring(0, min);
	}
}
