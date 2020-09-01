package cses;
import java.util.*;
import java.io.*;

public class ChessBoardAndQueens {
	public static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	public static int NQueensCount(String[] srr, boolean[][] board, int row) {

		if (row == board.length) return 1;
		
		int count =0;
		for (int col = 0; col < board[0].length; col++) {
			if (isItSafe(row, col, board) && srr[row].charAt(col) != '*') {
				board[row][col] = true;
				count += NQueensCount(srr, board, row + 1);
				board[row][col] = false;
			}
		}
		return count;
	}

	public static boolean isItSafe(int row, int col, boolean[][] board) {
		// vertically
		int r = row - 1;
		int c = col;
		while (r >= 0) {

			if (board[r][c]) {
				return false;
			}
			r--;

		}
		// left diagonally
		r = row - 1;
		c = col - 1;
		while (r >= 0 && c >= 0) {

			if (board[r][c]) {
				return false;
			}
			r--;
			c--;

		}
		// right diagonally
		r = row - 1;
		c = col + 1;
		while (r >= 0 && c < board[0].length) {

			if (board[r][c]) {
				return false;
			}
			c++;
			r--;

		}
		return true;

	}

	
	public static void main(String[] args) {
		FastReader scn = new FastReader();
		String[] srr = new String[8];
		for(int i=0; i<8; i++) srr[i] = scn.next();
		
		System.out.println(NQueensCount(srr, new boolean[8][8], 0));	
	}
}
