package back_tracking;

/**
 *  @author Junho
 *  
 *  @see https://www.acmicpc.net/problem/1182
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182 {
	
	private static int cnt = 0;
	private static int N;
	private static int S;
	private static int sum = 0;
	private static int[] nums;
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		nums = new int[N];

		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0);
		System.out.println(cnt);
	}

	private static void dfs(int cur) {
		if(cur == N) {
			return;
		}

		if(sum + nums[cur] == S) {
			cnt++;
		}

		dfs(cur + 1);

		sum += nums[cur];
		dfs(cur + 1);

		sum -= nums[cur];
	}
}
