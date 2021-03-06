package breadth_first_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2589 {
	private static int R;
	private static int C;
	private static char[][] graph;
	private static int[][] dir = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		graph = new char[R][C];

		for(int i = 0; i < R; i++) {
			graph[i] = br.readLine().toCharArray();
		}

		int res = -1;

		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(graph[i][j] == 'L') {
					res = Math.max(res, bfs(j,i));
				}
			}
		}
		System.out.println(res);
	}

	private static int bfs(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		boolean[][] visited = new boolean[R][C];
		int cnt = -1;

		queue.offer(new Point(x,y));
		visited[y][x] = true;

		while(!queue.isEmpty()) {
			int len = queue.size();

			for(int i = 0; i < len; i++) {
				Point cur = queue.poll();

				for(int[] d : dir) {
					int nextX = cur.x + d[0];
					int nextY = cur.y + d[1];

					if(0 <= nextX && nextX < C && 0 <= nextY && nextY < R) {
						if(graph[nextY][nextX] == 'L' && visited[nextY][nextX] == false) {
							visited[nextY][nextX] = true;
							queue.offer(new Point(nextX, nextY));
						}
					}
				}
			}
			cnt += 1;
		}
		return cnt;
	}

	private static class Point {
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}
}
