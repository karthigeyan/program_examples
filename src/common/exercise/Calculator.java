package common.exercise; /**
WHAT?
Simple calculator  program to evaluate simple expressions like
4*5
6/3
Only four operators(/, *, + , -)  are allowed in the expressions.

HOW?
1. get the first operand from stdin  using java.util.Scanner.nextDouble()
2. get the operator
3. get the second operand from stdin using java.util.Scanner.nextDouble()
4. use switch case and respective arithematic operation.
5. print the result
6. done

*/

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {

		double oprnd1;
		double oprnd2;
		char   opr;
		Scanner in = null;
		double result = 0;


		try {
			in = new Scanner(System.in);
			oprnd1 = in.nextDouble();
			opr = in.next().charAt(0);
			oprnd2 = in.nextDouble();

			switch(opr) {
				case '+':
					result = oprnd1 + oprnd2;
					break;
				case '-':
					result = oprnd1 - oprnd2;
					break;
				case '*':
					result = oprnd1 * oprnd2;
					break;
				case '/':
					result = oprnd1 / oprnd2;
					break;
				default:
					System.out.println("Error: Invalid Expression");
			}
			System.out.println("\nResult: " + result);

		}catch(Exception e) {

		}finally {
			if( in != null ) {
				in.close();
			}
		}
	}
}
