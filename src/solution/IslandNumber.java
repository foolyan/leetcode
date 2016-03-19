package solution;


/**
 * 描述: 岛屿数目
 * 
 */

public class IslandNumber {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] grid = new char[][]{
				{'1','0','0','0','0'},
				{'0','1','0','0','0'},
				{'0','1','1','1','0'},
				{'0','0','0','0','0'},
				{'0','0','1','0','0'},
				{'1','0','0','1','1'},
				{'1','1','1','1','0'}
		};
		System.out.println(new IslandNumber().getIslandNumber(grid));
	}

	/**
	 * 寻找岛屿数目
	 * 
	 * @param grid
	 * @return
	 */
	public int getIslandNumber(char[][] grid) {
		if (grid == null)
			return 0;

		int number = 0; // 岛屿数
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					markIsland(grid, i, j);
					number++;
				}
			}
		}
		
		return number;
	}

	/**
	 * 标记岛屿
	 * 
	 * @param grid
	 * @param i
	 * @param j
	 */
	private void markIsland(char[][] grid, int i, int j) {
		grid[i][j] = '2';

		if (i > 0 && grid[i - 1][j] == '1') // 上方相连岛屿
			markIsland(grid, i - 1, j);

		if (i < grid.length - 1 && grid[i + 1][j] == '1')  // 下方相连岛屿
			markIsland(grid, i + 1, j);

		if (j > 0 && grid[i][j - 1] == '1')  // 左侧相连岛屿
			markIsland(grid, i, j - 1);

		if (j < grid[0].length - 1 && grid[i][j + 1] == '1')  // 右侧相连岛屿
			markIsland(grid, i, j + 1);
	}
	
}
