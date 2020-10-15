import org.junit.platform.commons.util.ToStringBuilder;

/**
 * Notation Class
 * @author Elizabeth Perez
 *
 */
public class Notation {
	/**
	 * Convert an infix expression into a postfix expression
	 * @param infix - the infix expression in string format
	 * @return the postfix expression in string format
	 * @throws InvalidNotationFomatException - if the infix expression format is invalid
	 */
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {
		NotationQueue<Character> solutionQueue = new NotationQueue<Character>();
		NotationStack<Character> operatorStack = new NotationStack<Character>();
		for(int i = 0; i < infix.length(); i++) {
			char next = infix.charAt(i);
			switch (next) {
				case ' ':
					break;
				case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9':
					try {
						solutionQueue.enqueue(next);
					} catch (QueueOverflowException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case '(':
					try {
						operatorStack.push(next);
					} catch (StackOverflowException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case '+': case '-': case '*': case '/':
					while(!operatorStack.isEmpty()) {
						try {
							if(((operatorStack.top() == '*' || operatorStack.top() == '/') && (next == '-' || next == '+')) 
									|| ((operatorStack.top() == '-' || operatorStack.top() == '+') && (next == '-' || next == '+'))
									|| ((operatorStack.top() == '*' || operatorStack.top() == '/') && (next == '*' || next == '/'))) {
								solutionQueue.enqueue(operatorStack.pop());
							}
						} catch (StackUnderflowException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (QueueOverflowException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					try {
						operatorStack.push(next);
					} catch (StackOverflowException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case ')':
					try {
						char nextOperator = operatorStack.pop();
						while(nextOperator != '(') {
							solutionQueue.enqueue(nextOperator);
							nextOperator = operatorStack.pop();
						}
					} catch (StackUnderflowException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						throw new InvalidNotationFormatException();
					} catch (QueueOverflowException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
					break;
				default:
					throw new InvalidNotationFormatException();
			}
		}
		while(!operatorStack.isEmpty()) {
			try {
				solutionQueue.enqueue(operatorStack.pop());
			} catch (StackUnderflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (QueueOverflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return solutionQueue.toString();
	}
	
	/**
	 * Convert the postfix expression to the infix expression
	 * @param postfix - the postfix expression in string format
	 * @return the infix expression in string format
	 * @throws InvalidNotationFomatException - if the postfix expression format is invalid
	 */
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {
		String infix = "";
		NotationStack<String> infixStack = new NotationStack<String>();
		String next, operand1, operand2;
		for(int i = 0; i < postfix.length(); i++) {
			next = Character.toString(postfix.charAt(i));
			switch (next) {
				case " ":
					break;
				case "0": case "1": case "2": case "3": case "4": case "5": case "6": case "7": case "8": case "9":
					try {
						infixStack.push(next);
					} catch (StackOverflowException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case "+": case "-": case "*": case "/":
					try {
						operand1 = infixStack.pop();
						operand2 = infixStack.pop();
						String part = "(" + operand2 + next + operand1 + ")";
						infixStack.push(part);
					} catch (StackUnderflowException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (StackOverflowException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				default:
					break;
			}
		}
		if(infixStack.size() == 1) {
			try {
				infix = infixStack.pop();
			} catch (StackUnderflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			throw new InvalidNotationFormatException();
		}
		return infix;
	}
	
	/**
	 * Evaluates a postfix expression from a string to a double
	 * @param postfixExpr - the postfix expression in String format
	 * @return the evaluation of the postfix expression as a double
	 * @throws InvalidNotationFormatException - if the postfix expression format is invalid
	 */
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException {
		double answer = 0.0;
		char next;
		double operand1, operand2, eval;
		String result;
		NotationStack<String> evaluate = new NotationStack<String>();
		for(int i = 0; i < postfixExpr.length(); i++) {
			next = postfixExpr.charAt(i);
			switch (next) {
				case ' ':
					break;
				case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9':
					try {
						evaluate.push(Character.toString(next));
					} catch (StackOverflowException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case '+':
					try {
						operand1 = Double.parseDouble(evaluate.pop());
						operand2 = Double.parseDouble(evaluate.pop());	
						eval = operand2 + operand1;
						result = String.valueOf(eval);
						evaluate.push(result);
					} catch (StackUnderflowException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						throw new InvalidNotationFormatException();
					} catch (StackOverflowException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case '-':
					try {
						operand1 = Double.parseDouble(evaluate.pop());
						operand2 = Double.parseDouble(evaluate.pop());	
						eval = operand2 - operand1;
						result = String.valueOf(eval);
						evaluate.push(result);
					} catch (StackUnderflowException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						throw new InvalidNotationFormatException();
					} catch (StackOverflowException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case '*':
					try {
						operand1 = Double.parseDouble(evaluate.pop());
						operand2 = Double.parseDouble(evaluate.pop());	
						eval = operand2 * operand1;
						result = String.valueOf(eval);
						evaluate.push(result);
					} catch (StackUnderflowException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						throw new InvalidNotationFormatException();
					} catch (StackOverflowException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case '/':
					try {
						operand1 = Double.parseDouble(evaluate.pop());
						operand2 = Double.parseDouble(evaluate.pop());	
						eval = operand2 / operand1;
						result = String.valueOf(eval);
						evaluate.push(result);
					} catch (StackUnderflowException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						throw new InvalidNotationFormatException();
					} catch (StackOverflowException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				default:
					break;
					
			}
		}
		try {
			answer = Double.parseDouble(evaluate.pop());
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return answer;
	}
}
