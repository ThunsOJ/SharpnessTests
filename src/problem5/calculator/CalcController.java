package problem5.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalcController {

    private final Addition addition;
    private final Division division;
    private final Multiplication multiplication;
    private final Subtraction subtraction;


    public CalcController() {
        addition = new Addition();
        division = new Division();
        multiplication = new Multiplication();
        subtraction = new Subtraction();
        start();
    }

    public void start(){
        boolean isRunning = true;
        while (isRunning){
            Scanner scan = new Scanner(System.in);
            System.out.println("""
                    Welcome to the simple calculator.
                    Press [1] to calculate.
                    Press [0] to exit.""");
            System.out.print("Input: " );
            String input = scan.next();
            switch (input){
                case "1" -> inputExpression();
                case "0" -> isRunning=false;
                default -> System.out.println("Please enter the key 1 or 0 to navigate the menu.");
            }

        }
    }

    public void inputExpression(){
        System.out.print("Enter the desired equation: ");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine().trim().replaceAll(" ", "");

        if(isValid(input)){
            solveProblem(negativeNumberConverter(input));
        } else{
            System.out.println("Please only use letters or one of the four basic operators.");
        }
        start();
    }

    public List<String> negativeNumberConverter(String inputExpression){
        List<String> calculation = new ArrayList<>(List.of(inputExpression.split("(?<=[-+*/])|(?=[-+*/])")));

        List<String> updatedExpression = new ArrayList<>();
        for (int i = 0; i < calculation.size(); i++) {
            String currentElement = calculation.get(i);
            if (!isNumber(currentElement) && i + 2 < calculation.size() && calculation.get(i + 1).equals("-")) {
                String newNum = "-" + calculation.get(i + 2);
                updatedExpression.add(currentElement);
                updatedExpression.add(newNum);
                i += 2;
            } else {
                updatedExpression.add(currentElement);
            }
        }
        return updatedExpression;
    }

    public void solveProblem(List<String> expression){
        if(expression.stream().anyMatch(s -> s.contains("/")))
            expression = division.numbersToCalculate(expression);
        if(expression.stream().anyMatch(s -> s.contains("*")))
            expression = multiplication.numbersToCalculate(expression);
        if(expression.stream().anyMatch(s -> s.contains("-")))
            expression = subtraction.numbersToCalculate(expression);
        if(expression.stream().anyMatch(s -> s.contains("+")))
            expression = addition.numbersToCalculate(expression);

        System.out.println("The answer is: "+expression);
    }

    public boolean isValid(String input) {
        if (input.isEmpty()) {
            return false;
        }

        char[] chars = input.toCharArray();
        boolean hasOperand = false;
        boolean hasOperator = false;

        for (char c : chars) {
            if (!Character.isDigit(c)) {
                if (!String.valueOf(c).matches("[*/+-]")) {
                    return false;
                }
                hasOperator = true;
            } else {
                hasOperand = true;
            }
        }

        return hasOperand && hasOperator;
    }

    public boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
