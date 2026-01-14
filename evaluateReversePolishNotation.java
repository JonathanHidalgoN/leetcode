import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Solution {
  public int evalRPN(String[] tokens) {
    Stack<String> stack = new Stack<>();
    Set<String> operationSymbols = new HashSet<>();
    operationSymbols.add("+");
    operationSymbols.add("-");
    operationSymbols.add("/");
    operationSymbols.add("*");

    for (int i = 0; i < tokens.length; i++) {
      String currentSymbol = tokens[i];
      if (operationSymbols.contains(currentSymbol)) {
        int operand2 = Integer.parseInt(stack.pop());
        int operand1 = Integer.parseInt(stack.pop());
        int result;
        if (currentSymbol.equals("+")) {
          result = operand1 + operand2;
        } else if (currentSymbol.equals("-")) {
          result = operand1 - operand2;
        } else if (currentSymbol.equals("*")) {
          result = operand1 * operand2;
        } else {
          result = operand1 / operand2;
        }
        stack.push(Integer.toString(result));
      } else {
        stack.push(currentSymbol);
      }
    }

    return Integer.parseInt(stack.pop());

  }
}
