package Algo.Implement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PGR_84021 { // 블로그참고
	class Solution {
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		public int solution(int[][] game_board, int[][] table) {
			int answer = -1;
			int tableLen = table.length;

			List<List<int[]>> boardList = new ArrayList<>();
			List<List<int[]>> tableList = new ArrayList<>();
			boolean[][] boardVisit = new boolean[tableLen][tableLen];
			boolean[][] tableVisit = new boolean[game_board.length][game_board.length];
			for (int i = 0; i < tableLen; i++) {
				for (int j = 0; j < tableLen; j++) {

					if (table[i][j] == 1 && !tableVisit[i][j]) {
						bfs(i, j, tableVisit, table, 1, tableList);
					}

					if (game_board[i][j] == 0 && !boardVisit[i][j]) {
						bfs(i, j, boardVisit, game_board, 0, boardList);
					}
				}
			}
			answer = findBlock(boardList, tableList);
			return answer;
		}

		public int findBlock(List<List<int[]>> board, List<List<int[]>> table) {
			int size = 0;
			int tableSize = table.size();
			int boardSize = board.size();
			boolean[] boardVisit = new boolean[boardSize];
			for (int i = 0; i < tableSize; i++) {
				List<int[]> tablePoints = table.get(i);
				for (int j = 0; j < boardSize; j++) {
					List<int[]> boardPoints = board.get(j);

					if (tablePoints.size() == boardPoints.size() && !boardVisit[j]) {
						if (isRotate(boardPoints, tablePoints)) {
							size += tablePoints.size();
							boardVisit[j] = true;
							break;
						}
					}
				}
			}
			return size;
		}

		public boolean isRotate(List<int[]> board, List<int[]> table) {
			boolean check = false;
			Collections.sort(board, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					return o1[0] > o2[0] ? 1 : o1[0] < o2[0] ? -1 : Integer.compare(o1[1], o2[1]);
				}
			});
//			board.sort((o1, o2) -> {
//				return o1[0] > o2[0] ? 1 : o1[0] < o2[0] ? -1 : Integer.compare(o1[1], o2[1]);
//			});

			for (int i = 0; i < 4; i++) {
				Collections.sort(table, new Comparator<int[]>() {
					public int compare(int[] o1, int[] o2) {
						return o1[0] > o2[0] ? 1 : o1[0] < o2[0] ? -1 : Integer.compare(o1[1], o2[1]);
					}
				});

				int nearZeroX = table.get(0)[0];
				int nearZeroY = table.get(0)[1];

				for (int j = 0; j < table.size(); j++) {
					table.get(j)[0] -= nearZeroX;
					table.get(j)[1] -= nearZeroY;
				}

				boolean isCollectPoint = true;
				for (int j = 0; j < board.size(); j++) { // 좌표 비교
					int[] boardPoint = board.get(j);
					int[] tablePoint = table.get(j);

					if (boardPoint[0] != tablePoint[0] || boardPoint[1] != tablePoint[1]) {
						isCollectPoint = false;
						break;
					}
				}

				if (isCollectPoint) {
					check = true;
					break;
				} else { // 90도 회전 : x,y -> y, -x
					for (int j = 0; j < table.size(); j++) {
						int tmp = table.get(j)[0];
						table.get(j)[0] = table.get(j)[1];
						table.get(j)[1] = -tmp;
					}
				}
			}
			return check;
		}

		public void bfs(int x, int y, boolean[][] visit, int[][] map, int blockEmpty, List<List<int[]>> list) {
			Queue<int[]> q = new LinkedList<>();
			visit[x][y] = true;
			q.add(new int[] { x, y });
			List<int[]> subList = new ArrayList<>();
			subList.add(new int[] { x - x, y - y });

			while (!q.isEmpty()) {
				int[] now = q.poll();
				for (int i = 0; i < 4; i++) {
					int nx = now[0] + dx[i];
					int ny = now[1] + dy[i];
					if (nx < 0 || ny < 0 || nx >= map.length || ny >= map.length)
						continue;
					if (!visit[nx][ny] && map[nx][ny] == blockEmpty) {
						visit[nx][ny] = true;
						q.offer(new int[] { nx, ny });
						subList.add(new int[] { nx - x, ny - y });
					}
				}
			}
			list.add(subList);
		}
	}
}
