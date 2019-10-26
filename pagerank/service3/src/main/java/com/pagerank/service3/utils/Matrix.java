package com.pagerank.service3.utils;

public class Matrix {
    public static int[][] fillMatrix(int[][] M) {
        int ml = 0;
        for (int i = 0; i < M.length; i++) {
            ml = ml < M[i].length ? M[i].length : ml;
        }
        int Nm[][] = new int[M.length][ml];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                Nm[i][j] = M[i][j];
            }
        }
        return Nm;
    }

    public static int[][] createMatrix(int i1, int j1){
        java.util.Random r =new java.util.Random();
        int[][] Matrix_pointer = new int[i1][j1];
        for(int i = 0; i < i1;i++){
            for(int j = 0; j < j1;j++){
                Matrix_pointer[i][j] = r.nextInt(1000);
            }
        }
        return Matrix_pointer;
    }

    public static int[][] multiplication(int[][] A, int[][] B) throws Exception {
        A = fillMatrix(A);
        B = fillMatrix(B);
        if (A[0].length != B.length) {
            throw new Exception("矩阵A的列不等于矩阵B的行！");
        }
        int C[][] = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[i].length; j++) {
                for (int k = 0; k < A[i].length; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }

    public static int[][] transposed(int[][] A) {
        A = fillMatrix(A);
        int[][] AT = new int[A[0].length][A.length];
        for (int i = 0; i < AT.length; i++) {
            for (int j = 0; j < AT[0].length; j++) {
                AT[i][j] = A[j][i];
            }
        }
        return AT;
    }
}
