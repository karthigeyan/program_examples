package Level2;

/**
WHAT?
Multiplies two matrices.

For example
1 2 3 		1 2     1*1 + 2*3 + 3*5  1*2 + 2*4 + 3*6      22 28 
4 5 6    x  3 4   = 4*1 + 5*3 + 6*5  4*2 + 5*4 + 6*6   =  49 64
			5 6


Refer: http://en.wikipedia.org/wiki/Matrix_multiplication

HOW?
1. get the two input matrix let it be MatA and MatB
2. check number of columns in first matrix is equal to number of rows in second matrix , if not throw exception
3. create a new two dimentional array(MatC) with number rows from first matrix(MatA.ROWS) 
   and number  columns from second matrix(MatB.COLS)
4. iterate first matrix(I in MatA.ROWS)
	iterate second matrix column (J in MatB.COLS)
		SUM = 0
		iterate first matrix column(K in MatA.COLS)
			SUM = SUM + MatA[I][k] * MatB[k][J]
		MatC[I][J] = SUM	

5. print result matrix
6. done
*/


public class MatrixMultiplication {

	public static int[][] mulMatrix(int[][] matA, int[][] matB) {
			
		// number of columns in first matrix should equla to number rows in the second matrix	
		if( matA[0].length != matB.length) {
			throw new IllegalArgumentException();
		}

		int rows1 = matA.length;
		int columns1 = matA[0].length;

		int rows2 = matB.length;
		int columns2 = matB[0].length;

		int[][] matC = new int[rows1][columns2];
		
		for(int i=0; i<rows1; i++) {
				for(int j=0; j<columns2; j++) {
					int sum = 0;
					for(int k=0; k<columns1; k++) {
						sum += matA[i][k] * matB[k][j];
					}
					matC[i][j] = sum;
				}
		}

		return matC;
	}

	public static void printMatrix(int[][] mat) {
		int rows = mat.length;
		int columns = mat[0].length;

		for(int i=0; i<rows; i++) {
				for(int j=0; j<columns; j++) {
					System.out.print(mat[i][j] + " ");
				}
				System.out.println();
		}
	}


	public static void main(String[] args) {
		int[][] matA = { {1,2,3},
					     {4,5,6}
					   };
		int[][] matB = { {1,2},
						 {3,4},
						 {5,6}
					   };	
		int[][] matC;			   

		matC = mulMatrix(matA, matB);			   
		printMatrix(matC);
	}
}
