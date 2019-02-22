package Level2;

/**
WHAT?
Adds two matrix of m x n .

For example
1 2 3 		11 12 13    1+11 2+12 3+13   12 14 16
4 5 6    +  14 15 16  = 4+14 5+15 6+16 = 18 20 22

Refer: http://en.wikipedia.org/wiki/Matrix_addition

HOW?
1. get the two input matrix 
2. check number of rows and columns of two matrices are same , if not throw exception
3. create a new two dimentional array with the same number of rows and columns of input matrices for result matrix
4. iterate rows
	iterate columns
		add  elements from both input matrices and store in the result matrix
5. print result matrix
6. done
*/


public class MatrixAddition {

	public static int[][] addMatrix(int[][] matA, int[][] matB) {
		
		if( matA.length != matB.length || matA[0].length != matB[0].length) {
			throw new IllegalArgumentException();
		}

		int rows = matA.length;
		int columns = matA[0].length;

		int[][] matC = new int[rows][columns];
		
		for(int i=0; i<rows; i++) {
				for(int j=0; j<columns; j++) {
					matC[i][j] = matA[i][j] + matB[i][j];
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
		int[][] matB = { {11,12,13},
						 {14,15,16}
					   };	
		int[][] matC;			   

		matC = addMatrix(matA, matB);			   
		printMatrix(matC);
	}
}
