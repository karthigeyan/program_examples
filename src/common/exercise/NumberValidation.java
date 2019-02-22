package common.exercise;

/**
WHAT?
Checks whether the input String is a number or not

For example:
""30","0.412" and  "-123"  all of them are number



HOW?
1. get the number string
2. if first character is '+' or '-' then increment index
3. iterate each character in the string
4. check '.' is present only once else print false
5. check each character is greater than '0' and less than '9' else return false
6. if all characters are sucessfully iterated , then return true else goto step 3
7. done

*/

public class NumberValidation {

	public static boolean isValidNumber(String numstr) {

		char[] charary = numstr.toCharArray();
		int idx = 0;
		int dotcnt = 0;

		if( charary[0] == '+' || charary[0] == '-') {
			idx = 1;
		}

		for(; idx < charary.length; idx++) {

			if( charary[idx] == '.') {
				if( dotcnt != 0){
					return false;
				} else { 
					dotcnt++;
					continue;
				}
			}

			if( charary[idx] < '0'  || charary[idx] > '9' ) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isValidNumber ("0.414"));
		System.out.println(isValidNumber ("-123"));
		System.out.println(isValidNumber ("-1A23"));
		System.out.println(isValidNumber ("-1.3."));
	}
}
