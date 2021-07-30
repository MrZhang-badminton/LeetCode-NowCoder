package basic.strings;

public class Exe36Add {

	private static String str = "0123456789abcdefghijklmnopqrstuvwxyz";

	public static int getNum(char ch) {
		return str.indexOf(ch);
	}

	public static char getChar(int num) {
		return str.charAt(num);
	}

	public static String add(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
			return s1 != null ? s1 : s2;
		}
		int n1 = s1.length(), n2 = s2.length();
		int i = n1 - 1, j = n2 - 1;
		int temp = 0;
		StringBuilder sb = new StringBuilder();
		while (i >= 0 && j >= 0) {
			int num1 = getNum(s1.charAt(i));
			int num2 = getNum(s2.charAt(j));

			int sum = num1 + num2 + temp;
			temp = sum / 36;
			sb.append(getChar(sum % 36));
			i--;
			j--;
		}
		while (i >= 0) {
			int num = s1.charAt(i);
			int sum = num + temp;
			temp = sum / 36;
			sb.append(getChar(sum % 36));
			i--;
		}
		while (j >= 0) {
			int num = s1.charAt(j);
			int sum = num + temp;
			temp = sum / 36;
			sb.append(getChar(sum % 36));
			j--;
		}
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		System.out.println(add("11", "1z"));
	}
}
