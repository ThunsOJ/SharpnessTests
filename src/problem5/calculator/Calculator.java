package problem5.calculator;

import java.util.List;

public interface Calculator {
    List<String> numbersToCalculate(List<String> currentExpression);
    String calculate(String s1, String s2);
}
