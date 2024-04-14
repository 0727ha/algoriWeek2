package algoriWeek2;

public class Maze {
    int count = 0;
    int[][] maze;

    public Maze(int[][] in) {
        maze = in;
    }

    public int findMaxIter(int[][] maze) {
        int[][] dp = new int[maze.length][maze.length];
        dp[0][0] = maze[0][0];

        // 첫 번째 행 초기화
        for (int j = 1; j < maze.length; j++) {
            dp[0][j] = dp[0][j - 1] + maze[0][j];
        }

        // 첫 번째 열 초기화
        for (int i = 1; i < maze.length; i++) {
            dp[i][0] = dp[i - 1][0] + maze[i][0];
        }

        // 나머지 요소 계산
        for (int i = 1; i < maze.length; i++) {
            for (int j = 1; j < maze.length; j++) {
                dp[i][j] = maze[i][j] + Math.max(dp[i][j - 1], Math.max(dp[i - 1][j], dp[i - 1][j - 1]));
            }
        }

        return dp[maze.length - 1][maze.length - 1];
    }

    public int findMaxRec(int[][] maze, int i, int j) {
        count++;
        if (i == 0 && j == 0)
            return maze[i][j];
        if (i == 0)
            return maze[i][j] + findMaxRec(maze, i, j - 1);
        if (j == 0)
            return maze[i][j] + findMaxRec(maze, i - 1, j);
        return maze[i][j] + Math.max(findMaxRec(maze, i, j - 1), Math.max(findMaxRec(maze, i - 1, j), findMaxRec(maze, i - 1, j - 1)));
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        int[][] maze = { { 1, 2, 1, 5, 8, 4 }, { 4, 1, 9, 4, 2, 3 }, { 8, 5, 4, 3, 8, 2 }, { 1, 5, 3, 5, 7, 3 },
                { 4, 7, 7, 9, 2, 8 }, { 2, 4, 6, 3, 1, 4 } };

        Maze me = new Maze(maze); 

        System.out.println("Maze Iter = " + me.findMaxIter(maze) + "  count = " + me.getCount());
        System.out.println("Maze Rec = " + me.findMaxRec(maze, maze.length - 1, maze.length - 1) + "  count = " + me.getCount());
    }
}
