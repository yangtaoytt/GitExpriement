package problem1_5;

import javax.imageio.metadata.IIOMetadataFormatImpl;

public class Matrix {
    private int[][] matrix;//内部私有的数据结构用来保存矩阵

    public Matrix(int[][] arr){//构造函数传入以恶搞二维数组
        matrix=arr.clone();
    }

    public void PrintMatrix(){//打印矩阵的函数
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static Matrix Multiply(Matrix m1,Matrix m2){//利用行列相乘计算res矩阵
        int[][] a1=m1.matrix,a2=m2.matrix;
        int[][] res=new int[a1.length][a2[0].length];
        for (int i = 0; i < a1.length; i++) {//第一个矩阵的行
            for (int j = 0; j < a2[0].length; j++) {//第二个矩阵的列
                int sum=0;
                for (int k = 0; k < a2.length; k++) {
                    sum+=a1[i][k]*a2[k][j];//结果存入sum
                }
                res[i][j]=sum;
            }

        }
        return new Matrix(res);
    }
    public static void main(String[] args) {

        Matrix matrix1=new Matrix(new int[][]{{1,1},{2,1}});//使用自定义的martix类操作
        Matrix matrix2=new Matrix(new int[][]{{2,1,1},{2,4,1}});
        Matrix res=Matrix.Multiply(matrix1,matrix2);
        res.PrintMatrix();
    }
}
