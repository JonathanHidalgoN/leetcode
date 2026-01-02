import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

class Solution {
  public boolean isValid(String s) {

    Set<Character> openerSet = new HashSet<>();
    openerSet.add('(');
    openerSet.add('{');
    openerSet.add('[');
    Map<Character, Character> closerMap = new HashMap<>();
    closerMap.put(')', '(');
    closerMap.put('}', '{');
    closerMap.put(']', '[');

    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char currentChat = s.charAt(i);

      if (openerSet.contains(currentChat)) {
        stack.add(currentChat);
      } else {
        if (stack.size() == 0) {
          return false;
        } else {
          char lastOpener = stack.pop();
          if (lastOpener != closerMap.get(currentChat)) {
            return false;
          }
        }
      }

    }

    return stack.size() == 0;

  }
}
