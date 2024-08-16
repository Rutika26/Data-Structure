package prefixEvaluation;

import java.util.Stack;

public class PrefixEvaluation {
	//function to check priority
	public static int priority(char operator ) {
		switch (operator) {
		case '$' : return 3;
		case '*' : return 2;
		case '/' : return 2;
		case '%' : return 2;
		case '-' : return 1;
		case '+' : return 1;
		}
		return 0;
	}
	//infix to prefix conversion
	public static String infixToPrefix(String infix) {
		Stack<Character> s = new Stack<Character>();
		StringBuilder pre = new StringBuilder();
		//1. traverse infix expression from right to left
		for(int i = infix.length()-1; i >=0 ; i--) {
			char sym = infix.charAt(i); // sym can be operand, (, ) or operator
			//2. if operand is found, append to prefix.
			if(Character.isDigit(sym))
				pre.append(sym);
			else if(sym == ')') //4. if opening ( is found, then push it on stack.
				s.push(sym);
			else if(sym == '(') { //5. if closing ) is found, 
				// pop all operators from stack one by one and append to postfix
				// until closing ( is found.
				while(s.peek() != ')')
					pre.append(s.pop());
				// also pop and discard closing )
				s.pop();
			} 
			else { //3. if "operator" is found, push it on the stack.
				// if priority of topmost operator from stack > priority of current operator,
				while(!s.isEmpty() && priority(s.peek()) > priority(sym)) {
					// pop operator from stack and append to prefix.
					pre.append(s.pop());
				}
				s.push(sym);
			}		
		} // end of for loop
		//6. when all syms from infix are done, pop all operators from stack one by one and append to pre  fi
		while(!s.isEmpty())
			pre.append(s.pop());
		System.out.println(pre);
		return pre.reverse().toString();
	}
	
	
	public static int prefixEvaluation(String prefix) {
		Stack<Integer> s = new Stack<Integer>();
		for (int i = prefix.length()-1 ;i>=0 ;i--) {
			char symbol = prefix.charAt(i);
			if (Character.isDigit(symbol)) { // Check if char is digit, if true then push in the stack
				// s.push(symbol); Error
				// We have to convert char into digit,so that we can push the element

				String operand = Character.toString(symbol);
				s.push(Integer.parseInt(operand));
			} else { // pop 2 element and perform operation
				int a = s.pop();
				int b = s.pop();
				int c = calculation(a, b, symbol);
				s.push(c);
			}
		}
		return s.pop();

	}

	private static int calculation(int a, int b, char operator) {
		switch(operator) {
		case '$' : return (int) Math.pow(a, b);
		case '%' : return a%b;
		case '/' : return a/b;
		case '*' : return a*b;
		case '+' :return a+b;
		case '-' : return a-b;
		}
		return 0;
	}
public static boolean isBalanced(String expr) {
	Stack<Character> s = new Stack<Character>();
	String open = "([{", close = ")]}";
	//1. traverse expression from left to right
	for(int i = 0; i < expr.length(); i++) {
		char sym = expr.charAt(i);
		//2. if opening ( is found, push on stack
		if(open.indexOf(sym) != -1)
			s.push(sym);
		//3. if closing ) is found, 
		else if(close.indexOf(sym) != -1) {
			// if stack is empty (some opening is less)
			if(s.empty())
				return false;
			// pop one from stack
			char pop = s.pop();
			// compare if they are matching. if yes, continue.
			if(close.indexOf(sym) != open.indexOf(pop))
				return false;
			// if not matching, return false
		}
	}
	//4. when whole expression is done, if stack is empty, return true else return false.
	return s.isEmpty();
}
	public static void main(String[] args) {
		String infix = "5+9-4*(8-6/2)+1$(7-3)";
		
		System.out.println("Balanced : " + isBalanced(infix));
		
		String prefix = infixToPrefix(infix);
		System.out.println(prefix);
		int answer = prefixEvaluation(prefix);
		System.out.println("Answer is  "  + answer);
	}

}
