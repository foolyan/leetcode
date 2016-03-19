package solution;


/**
 * 描述:
 * 
 */

public class ReverseInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int a = 9646324351;
		System.out.println(new ReverseInteger().reverse(1534236469));
	}

	public int reverse(int x) {
		try{
			if (x < 0) {
				return 0 - Integer.parseInt(reverseStr((0 - x) + ""));
			} else {
				return Integer.parseInt(reverseStr(x + ""));
			}
		}catch(NumberFormatException e){
			return 0;
		}

	}

	private String reverseStr(String str) {
		StringBuilder sb = new StringBuilder();
		char[] chars = str.toCharArray();
		for (int i = chars.length - 1; i >= 0; i--)
			sb.append(chars[i]);

		return sb.toString();
	}

}
