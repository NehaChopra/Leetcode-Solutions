import java.util.Scanner;
import java.util.Stack;

//https://leetcode.com/problems/longest-valid-parentheses/solution/

/*
 * SOLUTION : Using Stack
 * Complexity 
 * Time complexity : O(n)O(n). n is the length of the given string..
 * Space complexity : O(n)O(n). The size of stack can go up to n. 
 */
class longestValidParentheses {
	public static void main(String[] args) {
			Scanner input = new Scanner(System.in);
			int testCases = input.nextInt();
			
			for(int test=0; test<testCases; test++){
				String validString = input.nextLine();
				System.out.println(longestValidParentheses(validString));
			}
	}
   public static int longestValidParentheses(String inputString) {
   	int maxLength = 0;
   	Stack<Integer> stack = new Stack<Integer>();
   	stack.push(-1);
   	for(int index=0; index<inputString.length(); index++) {
   		if(inputString.charAt(index) == '(') {
   			stack.push(index);
   		}else {
   			stack.pop();
   			if(stack.isEmpty()) {
   				stack.push(index);
   			}
   			maxLength = Math.max(maxLength, index - stack.peek());
   		}
   	}
		return maxLength;
   }
}

