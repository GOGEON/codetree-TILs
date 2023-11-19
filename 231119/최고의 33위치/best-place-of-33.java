import java.util.Scanner;

public class Main {

public static final int MAX_N = 20; 
    public static int n = 5;
    public static int[][] grid = new int[MAX_N][MAX_N];
    //rowS 행과 rowE 행사이의 colS colE 사이의 금의 개수를 계산한다.
    public static int countGold(int rowS, int rowE, int colS, int colE) {
        int count = 0;
        for(int i = rowS; i <= rowE; i++) {
            for(int j = colS; j <= colE; j++) {
                if(grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
  public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

       

        // 입력
        n = sc.nextInt();
        for(int row = 0; row < n; row++)
            for(int col = 0; col < n; col++)
                grid[row][col] = sc.nextInt();

    int max = 0;
    for(int row = 0; row < n; row++) {
        for(int col = 0; col < n; col++) {
            if(row+2 >= n || col+2 >= n) {
                continue;
            }
            int count = countGold(row, row+2, col, col+2);
            if(count > max) {
                max = count;
            }
        }
    
    }
    System.out.println(max);
   
  }
}