package postfixEvaluation;

import java.util.Stack;

public class PostfixEvaluation {
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
	//infix to postfix conversion
	public static String infixToPostfix(String infix) {
		Stack<Character> s = new Stack<Character>();
		StringBuilder post = new StringBuilder();
		//1. traverse infix expression from left to right
		for(int i = 0; i < infix.length(); i++) {
			char sym = infix.charAt(i); // sym can be operand, (, ) or operator
			//2. if operand is found, append to postfix.
			if(Character.isDigit(sym))
				post.append(sym);
			else if(sym == '(') //4. if opening ( is found, then push it on stack.
				s.push(sym);
			else if(sym == ')') { //5. if closing ) is found, 
				// pop all operators from stack one by one and append to postfix
				// until opening ( is found.
				while(s.peek() != '(')
					post.append(s.pop());
				// also pop and discard opening (
				s.pop();
			} 
			else { //3. if "operator" is found, push it on the stack.
				// if priority of topmost operator from stack >= priority of current operator,
				while(!s.isEmpty() && priority(s.peek()) >= priority(sym)) {
					// pop operator from stack and append to postfix.
					post.append(s.pop());
				}
				s.push(sym);
			}		
		} // end of for loop
		//6. when all syms from infix are done, pop all operators from stack one by one and append to postfi
		while(!s.isEmpty())
			post.append(s.pop());
		return post.toString();
	}

	public static int postfixEvaluation(String postfix) {
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < postfix.length(); i++) {
			char symbol = postfix.charAt(i);
			if (Character.isDigit(symbol)) { // Check if char is digit, if true then push in the stack
				// s.push(symbol); Error
				// We have to convert char into digit,so that we can push the element

				String operand = Character.toString(symbol);
				s.push(Integer.parseInt(operand));
			} else { // pop 2 element and perform operation
				int b = s.pop();
				int a = s.pop();
				int c = calculation(a, b, symbol);
				s.push(c);
			}
		}
		return s.pop();

	}

	private static int calculation(int a, int b, char operator) {
		switch (operator) {
		case '$':
			return (int) Math.pow(a, b);
		case '%':
			return a % b;
		case '/':
			return a / b;
		case '*':
			return a * b;
		case '+':
			return a + b;
		case '-':
			return a - b;
		}
		return 0;
	}

	public static void main(String[] args) {
		String infix = "5+9-4*(8-6/2)+1$(7-3)";
		String post = infixToPostfix(infix);
		System.out.println(post);
		int answer = postfixEvaluation(post);
		System.out.println("Answer is  " + answer);

	}

}
