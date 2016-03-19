package solution;


/**
 * ����: Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 */

public class ExcelSheetColumnNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ExcelSheetColumnNumber().titleToNumber("AAZ"));
	}
	
	public int titleToNumber(String s) {
        int result = 0;
        int factor = 1;
        for(int i = s.length() - 1; i >= 0; i--){        	
        	String curStr = s.substring(i, i+1);
        	result += factor * transOneStrToNum(curStr);
        	factor *= 26;
        }
        
        return result;
    }
	
	private int transOneStrToNum(String str){
		int result = 0;
		
		if("A".equals(str))
			result = 1;
		else if("B".equals(str))
			result = 2;
		else if("C".equals(str))
			result = 3;
		else if("D".equals(str))
			result = 4;
		else if("E".equals(str))
			result = 5;
		else if("F".equals(str))
			result = 6;
		else if("G".equals(str))
			result = 7;
		else if("H".equals(str))
			result = 8;
		else if("I".equals(str))
			result = 9;
		else if("J".equals(str))
			result = 10;
		else if("K".equals(str))
			result = 11;
		else if("L".equals(str))
			result = 12;
		else if("M".equals(str))
			result = 13;
		else if("N".equals(str))
			result = 14;
		else if("O".equals(str))
			result = 15;
		else if("P".equals(str))
			result = 16;		
		else if("Q".equals(str))
			result = 17;
		else if("R".equals(str))
			result = 18;
		else if("S".equals(str))
			result = 19;
		else if("T".equals(str))
			result = 20;
		else if("U".equals(str))
			result = 21;
		else if("V".equals(str))
			result = 22;
		else if("W".equals(str))
			result = 23;
		else if("X".equals(str))
			result = 24;
		else if("Y".equals(str))
			result = 25;
		else if("Z".equals(str))
			result = 26;

		return result;
	}

}
