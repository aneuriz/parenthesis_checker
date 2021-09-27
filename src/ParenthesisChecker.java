import java.util.Stack;

public class ParenthesisChecker {

    public static void main(String[] args) {
        System.out.println(validate(" 1 + (2+4)"));  // Correct
        System.out.println(validate(")(3+2)"));      // Incorrect
        System.out.println(validate("((3+2)"));      // Incorrect
        System.out.println(validate("(3+2()"));      // Incorrect
        System.out.println(validate("(3+2())"));     // Correct
        System.out.println(validate("(3+2())()()()()s("));     // InCorrect
    }

    /**
     * Evaluate if a passed string has the parenthesis correctly closed
     * @param text - the string to evaluate
     * @return String
     *
     */
    public static String validate(String text) {

        // Replace the synchronized class "Stack" by an unsynchronized one such as "Deque". for a better performance
        Stack<Character> stack = new Stack<>();

        for (char c : text.trim().toCharArray()) {

            if (c == '(') {
                stack.push(c);
            }
            else if( c == ')' && stack.isEmpty()) {
                return "Incorrect";
            }
            else if(c == ')')
            {
                stack.pop();
            }
        }

        if (stack.isEmpty())
            return "Correct";
        else
            return "Incorrect";
    }
}
