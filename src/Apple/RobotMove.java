package Apple;

import java.util.LinkedList;

public class RobotMove {

    public int countDifferentPath(int[][] board, int[] startCo, int validMove) {

        return this.bfs(board, startCo, validMove);
    }

    private int bfs(int[][] board, int[] startCo, int validMove) {
        int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        LinkedList<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        queue.add(startCo);
        visited[startCo[0]][startCo[1]] = true;
        int validPaths = 0;

        while (!queue.isEmpty()) {
            if (validMove <= 0) break;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int[] coordinate = queue.pollFirst();
                int x = coordinate[0];
                int y = coordinate[1];
                if (x == 0 || x == board.length - 1 || y == 0 || y == board[0].length - 1) {
                    validPaths++;
                }

                for (int[] direct: direction) {
                    int xx = x + direct[0];
                    int yy = y + direct[1];

                    if (xx < 0 || xx >= board.length || yy < 0 || yy >= board[0].length) {
                        continue;
                    }else if (board[xx][yy] == 0 && !visited[xx][yy]) {
                        queue.add(new int[]{xx, yy});
                        visited[xx][yy] = true;
                    }
                }
            }
            validMove--;
            System.out.println("ValidPaths = " + validPaths);
        }

        return validPaths;
    }

    // Test
    public static void main(String[] args) {
        RobotMove solution = new RobotMove();

        int[][] board = {{1, 0, 1}, {0, 0, 0}, {0, 1, 0}};
        int[] startCo = {1, 1};

        System.out.println(solution.countDifferentPath(board, startCo, 3));
    }
}
