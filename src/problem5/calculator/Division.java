package problem5.calculator;

import java.util.ArrayList;
import java.util.List;

public class Division implements Calculator{
    @Override
    public List<String> numbersToCalculate(List<String> currentExpression) {
        List<String> updatedCalculation = new ArrayList<>(currentExpression);
        int i = 0;

        while (i < updatedCalculation.size()) {
            String currentElement = updatedCalculation.get(i);
            if (currentElement.equals("/")) {
                if (i - 1 < 0 || i + 1 >= updatedCalculation.size()) {
                    System.out.println("Invalid expression: Operator '+' is the last element.");
                    break;
                }

                String operand1 = updatedCalculation.get(i - 1);
                String operand2 = updatedCalculation.get(i + 1);

                try {
                    String result = calculate(operand1, operand2);
                    updatedCalculation.set(i, result);
                } catch (Exception e) {
                    System.out.println("Please use valid characters for the calculator. " + e);
                    break;
                }

                updatedCalculation.remove(i + 1);
                updatedCalculation.remove(i - 1);
                i -= 1;
            } else {
                i++;
            }
        }

        return updatedCalculation;
    }

    @Override
    public String calculate(String s1, String s2) {
        double d1 = Double.parseDouble(s1);
        double d2 = Double.parseDouble(s2);

        return String.valueOf(d1/d2);
    }


}
