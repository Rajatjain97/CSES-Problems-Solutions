package cses;


// pending

import java.util.*;
import java.io.*;

public class ConcertTickets {
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

	public static int searchInsert(int[] nums, int target) {

		if (nums.length == 0 || target < nums[0])
			return 0;
		else if (target > nums[nums.length - 1])
			return nums.length;

		return binarySearch(nums, 0, nums.length - 1, target);
	}

	private static int binarySearch(int[] nums, int s, int e, int target) {

		if (s > e)
			return -1;

		int mid = (s + e) / 2;

		if (nums[mid] == target)
			return mid;

		else if (s < mid && nums[mid - 1] < target && nums[mid] > target)
			return mid;

		else if (mid < e && nums[mid] < target && nums[mid + 1] > target)
			return mid + 1;

		else if (nums[mid] < target)
			return binarySearch(nums, mid + 1, e, target);

		else
			return binarySearch(nums, s, mid - 1, target);
	}

	public static void main(String[] args) {
		FastReader scn = new FastReader();
		int n = scn.nextInt();
		int m = scn.nextInt();
		HashMap<Integer, Integer> map = new HashMap<>();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}

		Arrays.sort(arr);
		
//		for(int i=0;i<n;i++) {
//			System.out.print(" " +  i + " ");
//		}
//		System.out.println();
		
		
//		System.out.println(Arrays.toString(arr) + " " + map);

		StringBuffer sb = new StringBuffer("");

		int cm = m;
		
		while (m-- > 0) {
			int x = scn.nextInt();
			int pos = searchInsert(arr, x);
//			System.out.println(pos + " " + map + " " + x);
			if(pos == cm) {
				sb.append(-1).append('\n');
				continue;
			}
			if(pos > 0) {
				if(arr[pos] == x && map.get(arr[pos]) > 0) {
					sb.append(arr[pos]).append('\n');
					map.put(arr[pos], map.get(arr[pos]) - 1);
				} else if(arr[pos] != x && map.get(arr[pos-1]) > 0) {
					sb.append(arr[pos-1]).append('\n');
					map.put(arr[pos-1], map.get(arr[pos-1]) - 1);
				} else if(arr[pos] == x && map.get(arr[pos]) == 0) {
					if(map.get(arr[pos-1]) > 0) {
						sb.append(arr[pos-1]).append('\n');
						map.put(arr[pos-1], map.get(arr[pos-1]) - 1);					
					} else sb.append(-1).append('\n');
				}
				else
					sb.append(-1).append('\n');
			} else { // pos == 0
				
				if(arr[pos] == x && map.get(arr[pos]) > 0) {
					sb.append(arr[pos]).append('\n');
					map.put(arr[pos], map.get(arr[pos]) - 1);
				} else 
					sb.append(-1).append('\n');
			}
		}
		System.out.println(sb);
	}
}
