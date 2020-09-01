package cses;

import java.io.*;
import java.util.*;

//import com.google.*; 

public class TrafficLights {
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

	public static int searchInsert(List<Integer> nums, int target) {

		if (nums.size() == 0 || target < nums.get(0))
			return 0;
		else if (target > nums.get(nums.size() - 1))
			return nums.size();

		return binarySearch(nums, 0, nums.size() - 1, target);
	}

	private static int binarySearch(List<Integer> nums, int s, int e, int target) {

		if (s > e)
			return -1;

		int mid = (s + e) / 2;

		if (nums.get(mid) == target)
			return mid;

		else if (s < mid && nums.get(mid - 1) < target && nums.get(mid) > target)
			return mid;

		else if (mid < e && nums.get(mid) < target && nums.get(mid + 1) > target)
			return mid + 1;

		else if (nums.get(mid) < target)
			return binarySearch(nums, mid + 1, e, target);

		else
			return binarySearch(nums, s, mid - 1, target);
	}


	public static void main(String[] args) {
		FastReader scn = new FastReader();

		
		int mxn = 2*100005;
		int x = scn.nextInt(), n = scn.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		
		
		
//		List<Integer> fixed = FixedSizeList.decorate(Arrays.asList(new int[100]));
		
//		Integer[] arr = new Integer[mxn];
		
//		Arrays.fill(arr, Integer.MAX_VALUE);
		
//		List<Integer> list = Arrays.asList(arr);

		PriorityQueue<Integer> set = new PriorityQueue<>(Collections.reverseOrder());
		set.add(x - 0);

		list.add(0, 0);
		list.add(1, x);
		
//		list.add(0, (Integer)0);
//		list.add(1, (Integer)x);

		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}	
		
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < n; i++) {
			int in = arr[i];
			int pos = searchInsert(list, in);

			int left = list.get(pos - 1);
			int right = list.get(pos);
			
			set.remove(right - left);
			
			set.add(in - left);
			set.add(right - in);
			list.add(pos, in);
			
			sb.append(set.peek() + " ");
			
		}
		System.out.println(sb);			
	}
}
