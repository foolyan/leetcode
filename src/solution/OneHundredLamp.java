package solution;


import java.util.Date;

/**
 * 描述: 
 *
 */

public class OneHundredLamp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		OneHundredLamp lamp = new OneHundredLamp();
		Date begin = new Date();
		// TODO Auto-generated method stub
		for (int i = 1; i <= 100; i++){
			if (lamp.isLighted(i))
				System.out.println(i);
		}
		
		Date end = new Date();
		System.out.println(end.getTime() - begin.getTime());
	}
	
	/**
	 * 灯是否开着
	 * @param index 第几盏灯
	 * @return
	 */
	private boolean isLighted(int index){
		return getSwitchCount(index) % 2 == 1;
	}
	
	/**
	 * 灯的开关次数
	 * @param index 第几盏灯
	 * @return
	 */
	private int getSwitchCount(int index){
		int count = 0;
		
		for (int i = 1; i <= index; i++) {
			if (index % i == 0)
				count++;
		}
		
		return count;
	}

}




