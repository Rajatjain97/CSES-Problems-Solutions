package cses;

import java.util.*;
import java.io.*;

public class islands {

	static Scanner scn = new Scanner(System.in);

	public static int changeLandToWater(int[][] grid, int i, int j) {

		if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0 || grid[i][j] == -1)
			return 0;

		int ans = 1;
		grid[i][j] = -1;
		
		ans += changeLandToWater(grid, i - 1, j);
		ans += changeLandToWater(grid, i + 1, j);
		ans += changeLandToWater(grid, i, j - 1);
		ans += changeLandToWater(grid, i, j + 1);
		
		return ans;
	}

	public static void main(String[] args) {
		int r = scn.nextInt(), c = scn.nextInt();

		int[][] arr = new int[r][c];
		for (int i = 0; i < r; i++)
			for (int j = 0; j < c; j++)
				arr[i][j] = scn.nextInt();

		int maxAns = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == 1) {
					int ret = changeLandToWater(arr, i, j);
					int[] ar = new int[1];
					dfs(arr, i, j, ar);
					System.out.println(i + " " + j);
					int sub = ar[0];
					System.out.println(ar[0]);
					maxAns = Math.max(maxAns, ret - sub);
				}
			}
		}
		for(int[] ar : arr) System.out.println(Arrays.toString(ar));

		System.out.println(maxAns);
	}

	private static void dfs(int[][] grid, int i, int j, int[] ar) {

		if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0 || grid[i][j] == -2)
			return;

		grid[i][j] = -2;
		
		if (!(i < 1 || i >= grid.length - 1 || j < 1 || j >= grid[i].length - 1)) {
			
			Integer[] trr = new Integer[4];
			
			trr[0] = grid[i+1][j];
			trr[1] = grid[i-1][j];
			trr[2] = grid[i][j+1];
			trr[3] = grid[i][j-1];
			
			int z = 0;
			for(int val : trr) if(val == 0) z++;
			System.out.println(Arrays.toString(trr) + " " + z);
			if(z <= 1) ar[0]++;
//			Arrays.sort(trr);
//			System.out.println(Arrays.toString(trr));
//			if(Arrays.asList(trr).contains(0)) { if(trr[2] != 0) ar[0]++; }
//			else ar[0]++;
		}
		
		dfs(grid, i - 1, j,ar);
		dfs(grid, i + 1, j,ar);
		dfs(grid, i, j - 1,ar);
		dfs(grid, i, j + 1,ar);
		
	}
}








//5 6
//1 1 0 0 1 1
//1 1 0 0 1 1
//0 0 1 1 1 1
//0 0 1 1 0 1
//0 0 0 1 1 1









