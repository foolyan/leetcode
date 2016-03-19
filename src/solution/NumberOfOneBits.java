package solution;


/**
 * 描述: 
 *
 */

class NumberOfOneBits {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new NumberOfOneBits().hammingWeight((int)2147483648L-1));
	}

	public int hammingWeight(int n) {
        int num = 0;
        while(n!=0){
            if(n%2 == 1)
                num++;
                
            n = n/2;
        }
        
        return num;
    }
}
