package calculator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern plusOppattern = Pattern.compile("\\s*(\\d+)\\s*\\+\\s*(\\d+)|\\s*\\+\\s*(\\d)|\\s+(\\d+)");         // Addition
        Pattern multiplyOppattern = Pattern.compile("\\s*(\\d+)\\s*\\*\\s*(\\d+)|\\s*\\*\\s*(\\d)|\\s+(\\d+)"); // Multiplikation
        Pattern subtractOppattern = Pattern.compile("\\s*(\\d+)\\s*\\-\\s*(\\d+)|\\s*\\-\\s*(\\d)|\\s+(\\d+)"); // Subtraktion
        Pattern divideOppattern = Pattern.compile("\\s*(\\d+)\\s*\\/\\s*(\\d+)|\\s*\\/\\s*(\\d)|\\s+(\\d+)");   // Division
        Pattern moduloOppattern = Pattern.compile("\\s*(\\d+)\\s*\\%\\s*(\\d+)|\\s*\\%\\s*(\\d)|\\s+(\\d+)");   // Modulo

        Pattern quitPattern = Pattern.compile("^\\s*:q\\s*$");

        boolean calculatorStopped = false;

        Matcher quitMatcher;
        while (!calculatorStopped) {
            System.out.print("Eingabe tätigen: ");
            String input = scanner.nextLine();
            Matcher plusOpMatcher = plusOppattern.matcher(input);
            Matcher multiplyOpMatcher = multiplyOppattern.matcher(input);
            Matcher subtractOpMatcher = subtractOppattern.matcher(input);
            Matcher divideOpMatcher = divideOppattern.matcher(input);
            Matcher moduloOpMatcher = moduloOppattern.matcher(input);

            quitMatcher = quitPattern.matcher(input);

            if (plusOpMatcher.matches()) {                               // Addition
                if (plusOpMatcher.group(4) != null) {
                    double result = Double.parseDouble(plusOpMatcher.group(4));
                    System.out.println(input + " = " + result);
                } else if (plusOpMatcher.group(3) != null) {
                    double result = Double.parseDouble(plusOpMatcher.group(3));
                    System.out.println(input + " = " + result);
                } else {
                    double firstOperand = Double.parseDouble(plusOpMatcher.group(1));
                    double secondOperand = Double.parseDouble(plusOpMatcher.group(2));
                    double result = firstOperand + secondOperand;
                    System.out.println(input + " = " + result);
                }

            } else if (multiplyOpMatcher.matches()) {                   // Multiplikation
                if (multiplyOpMatcher.group(4) != null) {
                    double result = Double.parseDouble(multiplyOpMatcher.group(4));
                    System.out.println(input + " = " + result);
                } else if (multiplyOpMatcher.group(3) != null) {
                    double result = Double.parseDouble(multiplyOpMatcher.group(3));
                    System.out.println(input + " = " + result);
                } else {
                    double firstOperand = Double.parseDouble(multiplyOpMatcher.group(1));
                    double secondOperand = Double.parseDouble(multiplyOpMatcher.group(2));
                    double result = firstOperand * secondOperand;
                    System.out.println(input + " = " + result);
                }
            }
            else if (subtractOpMatcher.matches()) {                              // Subtraktion
                if (subtractOpMatcher.group(4) != null) {
                    double result = Double.parseDouble(subtractOpMatcher.group(4));
                    System.out.println(input + " = " + result);
                } else if (subtractOpMatcher.group(3) != null) {
                    double result = Double.parseDouble(subtractOpMatcher.group(3));
                    System.out.println(input + " = " + result);
                } else {
                    double firstOperand = Double.parseDouble(subtractOpMatcher.group(1));
                    double secondOperand = Double.parseDouble(subtractOpMatcher.group(2));
                    double result = firstOperand - secondOperand;
                    System.out.println(input + " = " + result);
                }
            }

            else if (divideOpMatcher.matches()) {                                // Division
                if (divideOpMatcher.group(4) != null) {
                    double result = Double.parseDouble(divideOpMatcher.group(4));
                    System.out.println(input + " = " + result);
                } else if (divideOpMatcher.group(3) != null) {
                    double result = Double.parseDouble(divideOpMatcher.group(3));
                    System.out.println(input + " = " + result);
                } else {
                    double firstOperand = Double.parseDouble(divideOpMatcher.group(1));
                    double secondOperand = Double.parseDouble(divideOpMatcher.group(2));
                    double result = firstOperand / secondOperand;
                    System.out.println(input + " = " + result);
                }
            }

            else if (moduloOpMatcher.matches()) {                                // Modulo
                if (moduloOpMatcher.group(4) != null) {
                    double result = Double.parseDouble(moduloOpMatcher.group(4));
                    System.out.println(input + " = " + result);
                } else if (moduloOpMatcher.group(3) != null) {
                    double result = Double.parseDouble(moduloOpMatcher.group(3));
                    System.out.println(input + " = " + result);
                } else {
                    double firstOperand = Double.parseDouble(moduloOpMatcher.group(1));
                    double secondOperand = Double.parseDouble(moduloOpMatcher.group(2));
                    double result = firstOperand % secondOperand;
                    System.out.println(input + " = " + result);
                }
            }

         else if (quitMatcher.matches()) {
            System.out.println("Taschenrechner wird gestopped...");
            calculatorStopped = true;

        } else {
            System.err.println("Operation: " + input + " nicht erkannt");

        }
    }}}


