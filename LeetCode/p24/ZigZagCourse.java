package p24;

public class ZigZagCourse {

	public static String convert(String s, int nRows) {

		if (nRows <= 1)
			return s;
		int round = 2 * nRows - 2;

		StringBuffer sb = new StringBuffer();

		int block = s.length() / (2 * nRows - 2) + 1;

		for (int i = 0; i < nRows; i++) {
			for (int j = i; j < s.length(); j += round) {

				sb.append(s.charAt(j));
				if (i > 0 && i < nRows - 1) {
					if (s.charAt(j + block - 2 * i) != null) {
						sb.append(s.charAt(j + block - 2 * i));
					}
				}

			}
		}
		return sb.toString();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "yourlifeismine";
		str = convert(str, 3);
		System.out.println(str);
	}

}
