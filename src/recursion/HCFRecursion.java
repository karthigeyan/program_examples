package recursion;

/**
WHAT?
Finds highest common factor of two numbers  using Dijkstra's Algorithm.

Refer: http://www.cse.wustl.edu/~ychen/131/Notes/Recursion/recursion.html

HOW?
1.get input number NUM1 and NUM2
2. if NUM1 == NUM2 then return NUM1
3. if NUM1 > NUM2 then recursively call this algorithm with NUM1-NUM2 and NUM2
4. if NUM2 > NUM1 then recursively call this algorithm with NUM1 and NUM2-NUM1
5. print HCF
6. done
*/
public class HCFRecursion {

	public static int hcf(int num1, int num2) {
		if(num1 == num2){
			return num1;
		} else if (num1 > num2) {
			return hcf(num1-num2, num2);
		} else{
			return hcf(num1, num2-num1);
		}
	}


	public static void main(String[] args) {
		System.out.println(hcf(12, 16));
	}
}
