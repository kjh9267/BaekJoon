package back_tracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15652 {
	private static int[] nums;
	private static int N;
	private static int M;
	private static StringBuilder sb;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		
		for(int i = 0; i < N; i++) {
			nums[i] = i + 1;
		}

		dfs(0, 0, "");
		System.out.print(sb);
	}
	
	private static void dfs(int cur, int depth, String s) {
		if(depth == M ) {
			sb.append(s);
			sb.append('\n');
			return;
		}
		
		if(cur == N)
			return;
		
		dfs(cur, depth + 1, s + nums[cur] + " ");
		dfs(cur + 1, depth, s);
	}
}
