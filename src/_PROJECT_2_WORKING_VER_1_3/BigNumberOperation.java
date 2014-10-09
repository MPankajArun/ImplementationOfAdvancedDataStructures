package _PROJECT_2_WORKING_VER_1_3;

import java.io.BufferedReader;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;


public class BigNumberOperation {

	static final int nBase=10000;

	public static void main(String[] args) {

		try {
			FileInputStream in = new FileInputStream("/users/dany/downloads/project_2_inputFile1.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String currentLine;

			while ((currentLine = br.readLine()) != null) {
				try {
					if (!"0".equals(currentLine)) {
						Stack<String> operatorStack = null;
						Stack<String> operandStack = null;
						String operator = null;
						int index = 0;
						StringBuffer tempNumber = new StringBuffer();
						while (null != currentLine
								&& index < currentLine.length()
								&& ' ' != currentLine.charAt(index)) {
							char op = currentLine.charAt(index);

							if (Character.isDigit(op)) {
								while (Character.isDigit(op)) {
									tempNumber.append(op);
									index++;
									if (index < currentLine.length()) {
										op = currentLine.charAt(index);
									} else {
										break;
									}
								}
								if (null != tempNumber
										&& !"".equals(tempNumber)) {
									if (null == operandStack) {
										operandStack = new Stack<String>();
										operandStack.push(tempNumber.toString());
									} else {
										operandStack.push(tempNumber
												.toString());
									}
								}
							}
							if (op == '+' || op == '-' || op == '*'
									|| op == '^' || op == '(' || op == ')') {

								if (null != operatorStack) {
									if (op == ')') {
										while (!operatorStack.empty()) {
											operator = operatorStack.pop();
											if (operator.charAt(0) != '('
													&& null != operandStack) {
												String op1 = operandStack
																.pop();
												String op2 = operandStack
																.pop();
												String output = performOperation(
														operator.charAt(0),
														op1, op2);
												operandStack.push(output);
											} else {
												break;
											}
										}
										index++;
										continue;
									}
									char topOperator = '0';
									if (operatorStack.size() > 0
											&& null != operatorStack.peek()) {
										topOperator = operatorStack.peek().charAt(0);
									}
									if (op == '('
											|| topOperator == '('
											|| precedenceLevel(topOperator) < precedenceLevel(op)) {
										operatorStack.push(Character
												.toString(op));
									}

									else {
										operator = operatorStack.pop();
										if (null != operandStack
												&& '(' != operator
														.charAt(0)) {
											String op1 = operandStack.pop();
											String op2 = operandStack.pop();
											String output;
											output = performOperation(
													operator.charAt(0),
													op1, op2);
											operandStack.push(output
													.toString());
										}
										operatorStack.push(Character
												.toString(op));
									}
								} else {
									operatorStack = new Stack<String>();
									operatorStack.push(Character
											.toString(op));
								}
								tempNumber = new StringBuffer();
							} else if (!Character.isDigit(op)) {
								System.out.println("Unknown Operation");
								continue;
							}
							index++;
						}
						if (operatorStack.peek() != null) {
							while (!operatorStack.empty()) {
								operator = operatorStack.pop();
								if (null != operandStack) {
									String op1 = operandStack
											.pop();
									String op2 = operandStack
											.pop();
									String output = performOperation(
											operator.charAt(0), op1, op2);
									operandStack.push(output
											.toString());
								}
							}
						}
						System.out
								.println(operandStack.pop());
					} else {
						System.out.println("Bye!!!");
					}
				} catch (Exception e) {
					System.out.println("Invalid Expression");
				}
			}
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	

	}

	private static String performOperation(char op, String op1, String op2)
			throws IllegalArgumentException {

		
		switch (op) {
		case '+':
			//return add(Integer.valueOf(op1).intValue(), Integer.valueOf(op2).intValue()).toString();
			return LinkedListPolynomialAddition.addNumber(op1, op2, nBase);
		case '-':
			//return subtract(Integer.valueOf(op1).intValue(), Integer.valueOf(op2).intValue()).toString();
			return LinkedListPolynomialAddition.subractNumber(op2, op1, nBase);
		case '*':
			//return multiply(Integer.valueOf(op1).intValue(), Integer.valueOf(op2).intValue()).toString();
			return LinkedListPolynomialAddition.multiplicationHandler(op1, op2, nBase);
		case '^':
			//return exponential(Integer.valueOf(op1).intValue(), Integer.valueOf(op2).intValue()).toString();
			return LinkedListPolynomialAddition.ExponentialHandler(op2, Integer.parseInt(op1));
		default:
			throw new IllegalArgumentException("Operator unknown: " + op);
		}
	}

/*	private static String exponential(Integer op1, Integer op2) {
		return new Integer (new Double(Math.pow(op2.doubleValue(), op1.doubleValue()))
				.intValue()).toString();
	}

	private static Integer multiply(Integer op1, Integer op2) {
		return (op1 * op2);
	}

	private static Integer subtract(Integer op1, Integer op2) {
		return (op2 - op1);
	}

	private static Integer add(Integer op1, Integer op2) {
		return (op1 + op2);
	}*/

	static int precedenceLevel(char op) throws IllegalArgumentException {
		switch (op) {
		case '+':
		case '-':
			return 0;
		case '*':
			return 1;
		case '/':
			return 2;
		case '^':
			return 3;
		case '0':
			return -1;
		default:
			throw new IllegalArgumentException("Operator unknown: " + op);
		}
	}

}
