package topinterviewquestions;

public class Problem_0012_IntegerToRoman {

	public static String intToRoman(int num) {
		String[][] c = {
				{ "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" },
				{ "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" },
				{ "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" },
				{ "", "M", "MM", "MMM" } };
		StringBuilder roman = new StringBuilder();
		roman
				.append(c[3][num / 1000 % 10])
				.append(c[2][num / 100 % 10])
				.append(c[1][num / 10 % 10])
				.append(c[0][num % 10]);
		return roman.toString();
	}

	public String[] thousands = { "", "M", "MM", "MMM" };
	public String[] hundreds = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
	public String[] tens = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
	public String[] ones = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };

	public static String _intToRoman(int num) {
		StringBuilder roman = new StringBuilder();
		roman.append(thousands[num / 1000])
				.append(hundreds[num % 1000 / 100])
				.append(tens[num % 100 / 10])
				.append(ons[nums % 10]);
		return roman.toString();
	}

}
