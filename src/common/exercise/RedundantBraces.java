package common.exercise; /**
WHAT?
Checks if the input string has redundant braces.

For example,
((x+y)) - Has redundant braces.
(x+(y+z)) - This doesn't have redundant braces.

HOW?
1. get the input expression string
2. create a stack to store character
3. iterate characters in string
4. if char != ')' then push characters into stack
5. else pop a character 
6. check if it is '(' then the string has redundant braces
7. else pop all characer till '('
8. goto step 3
9. done

*/

import java.util.Stack;
public class RedundantBraces {

	public static boolean hasRedundantBraces(String expStr) {
		Stack<Character> charStack = new Stack<Character>();

		for(int i=0; i<expStr.length(); i++) {
			char c = expStr.charAt(i);

			if( c != ')') {
				charStack.push(c);
			} else {
				if( charStack.pop() == '(') {
					return true;
				}else {
					while( charStack.pop() != '(') {
					}
				}
			}
		}
		return false;
	}

	//character array is used as  stack
	public static boolean hasRedundantBraces2(String expStr) {
		char charArray[] = new char[expStr.length()];
		int count = 0;

		for(int i=0; i<expStr.length(); i++) {
			char c = expStr.charAt(i);

			if( c != ')') {
				charArray[count] = c;
				count++;
			} else {
				count--;
				if( charArray[count] == '(') {
					return true;
				}else {
					while( charArray[count]  != '(') {
						count--;
					}
				}
			}
		}
		return false;
	}




	public static void main(String[] args) {
		System.out.println(hasRedundantBraces2("(x+(y+z))"));
		System.out.println(hasRedundantBraces2("((x+y))"));
	}
}

