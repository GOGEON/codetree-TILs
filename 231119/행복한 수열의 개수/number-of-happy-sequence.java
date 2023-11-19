import java.util.Scanner;

public class Main {
    public static final int MAX_N = 20;
    public static int n;
    public static int m;
    public static int[][] grid = new int[MAX_N][MAX_N];

    // 연속하여 m개 이상의 동일한 원소가 나오는 순간이 존재하는 수열을 판별
    public static boolean isConsecutive(int[] sequence, int m) {
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (sequence[i] == sequence[i - 1])
                count++;
            else
                count = 1;
            if (count == m)
                return true;
        }
        return false;
    }
    // 행과 열을 바꾼 배열을 반환한다.
    public static int[][] transpose(int[][] grid) {
        int[][] result = new int[n][n];
        for (int row = 0; row < n; row++)
            for (int col = 0; col < n; col++)
                result[col][row] = grid[row][col];
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = 0;

        // 입력
        n = sc.nextInt();
        m = sc.nextInt();

        // 0으로 채운 n x n 배열 생성
        grid = new int[n][n];
        
        // 2차원 배열 입력
        for (int row = 0; row < n; row++)
            for (int col = 0; col < n; col++)
                grid[row][col] = sc.nextInt();
 


        for (int row = 0; row < n; row++) {
            if (isConsecutive(grid[row], m)) {
                count++;
                
            }
            if (isConsecutive(transpose(grid)[row], m)) {
                count++;
 
            }
        }
        
        System.out.println(count);

    }
}