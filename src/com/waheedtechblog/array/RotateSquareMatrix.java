package com.waheedtechblog.array;

public class RotateSquareMatrix {

    public static void main(String[] args) {
        int N = 4;

        // Test Case 1
        int[][] mat =
                {
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}
                };
        RotateSquareMatrix rotateSquareMatrix = new RotateSquareMatrix();
        rotateSquareMatrix.rotateMatrix(N,mat);
        rotateSquareMatrix.displayMatrix(N,mat);

    }

    public void rotateMatrix(int N, int[][] mat) {
        // Total circle will be N/2
        for (int x = 0; x < N / 2; x++) {
            for (int y = x; y < N - x - 1; y++) {
                int temp = mat[x][y];
                mat[x][y] = mat[y][N - x - 1];
                mat[y][N - 1 - x] = mat[N - 1 - x][N - 1 - y];
                mat[N - 1 - x][N - 1 - y] = mat[N - 1 - y][x];
                mat[N - 1 - y][x] = temp;
            }
        }
    }

    public void displayMatrix(int N, int mat[][])
    {
        for (int x = 0; x < N; x++)
        {
            for (int y = 0; y < N; y++)
                System.out.print(" " + mat[x][y]);
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}
