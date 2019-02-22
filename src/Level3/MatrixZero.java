package Level3;

/**
WHAT?
Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.

HOW?

Instead of manipulating the martrix directly, first iterate the matrix , identify rows and columns where zero should be set. For that , two temporary boolean arrays can be used. It will remember row number and column number where zero 
should be set.

1. get the matrix
2. allocate boolean array of size equal to number of rows
3. allocate boolean array of size equal to number of columns
4. iterate matrix
5. if any cell contains zero , then corresponding row and column  boolean array are set  to true
6. goto step 4 till all elements are iterated.
7. iterate row boolean array then set all elements to zero in the corresponding row
8. iterate column boolean array then set all elements to zero in the corresponding column
9. print matrix
10.done


*/

public class MatrixZero {

	public static void makeZeroMatrix(int[][] matrix) {
		boolean rows[] = new boolean[matrix.length];
		boolean cols[] = new boolean[matrix[0].length];
		int noRows = matrix.length;
		int noCols = matrix[0].length;

		for(int i=0; i<noRows; i++) {
			for(int j=0; j<noCols; j++) {
				if(matrix[i][j] == 0) {
					rows[i] = true;
					cols[j] = true;
				}
			}
		}

		for(int i=0; i<rows.length; i++) {
			if( rows[i] )  {
				for(int j=0; j<noCols; j++) {
					matrix[i][j] = 0;
				}
			}
		}

		for(int i=0; i<cols.length; i++) {
			if( cols[i] )  {
				for(int j=0; j<noRows; j++) {
					matrix[j][i] = 0;
				}
			}
		}

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

		int[][] mat = { {1,0,3},
						 {4,5,6},
						 {7,8,9}
					   };

		printMatrix(mat);
		makeZeroMatrix(mat);
		printMatrix(mat);
	}

}
