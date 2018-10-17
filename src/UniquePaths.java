import java.util.Scanner;

//https://leetcode.com/problems/unique-paths-ii/description/
/*
 * DFS approach
 * Complexity 
 * Time complexity : O(n)
 * Space complexity : O(n)
 */
class UniquePaths {
	public static int count;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		
		for(int test=0; test<testCases; test++){
			int row = input.nextInt();
			int col = input.nextInt();
			int[][] obstacleGrid = new int[row][col]; 
			for(int index=0; index<row; index++) {
				for(int jIndex=0; jIndex<col; jIndex++) {
					obstacleGrid[index][jIndex] = input.nextInt();
				}
			}
			System.out.println(uniquePathsWithObstacles(obstacleGrid));
		}
	}
   public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
   	int rowLength = obstacleGrid.length;
   	int colLength = obstacleGrid.length;
   	boolean [][] visitedGrid = new boolean[rowLength][colLength];
   	Integer uniquePathCount = 0;
   	DFS(0, 0, obstacleGrid, visitedGrid, uniquePathCount, rowLength, colLength);
      return count;
   }
   public static void DFS(int row, int col, int[][] obstacleGrid, boolean [][] visitedGrid, Integer uniquePathCount,
   		int rowLength, int colLength) {
   	visitedGrid[row][col] = true;
   	if(row == rowLength-1 && col == colLength-1) {
   		visitedGrid[row][col] = false;
   		count = count + 1;
   	}
   	if(isSafe(row+1, col, obstacleGrid, visitedGrid, rowLength, colLength)) {
   		DFS(row+1, col, obstacleGrid, visitedGrid, uniquePathCount, rowLength, colLength);
   	}
   	if(isSafe(row, col+1, obstacleGrid, visitedGrid, rowLength, colLength)) {
   		DFS(row, col+1, obstacleGrid, visitedGrid, uniquePathCount, rowLength, colLength);
   	}
   }
   public static boolean isSafe(int row, int col, int[][] obstacleGrid, boolean [][] visitedGrid, int rowLength, int colLength) {
   	return (row < rowLength) && (col < colLength) && (obstacleGrid[row][col] == 0) && (visitedGrid[row][col] == false);
   }
}
