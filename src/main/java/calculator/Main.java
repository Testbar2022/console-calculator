package calculator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern plusOppattern = Pattern.compile("\\s*(\\d+)\\s*\\+\\s*(\\d+)|\\s*\\+\\s*(\\d)|\\s+(\\d+)");
        Pattern multiplyOppattern = Pattern.compile("\\s*(\\d+)\\s*\\*\\s*(\\d+)|\\s*\\*\\s*(\\d)|\\s+(\\d+)"); // multiplikation
        Pattern quitPattern = Pattern.compile("^\\s*:q\\s*$");
        boolean calculatorStopped = false;
        Matcher quitMatcher;
        while (!calculatorStopped) {
            System.out.print("Eingabe tätigen: ");
            String input = scanner.nextLine();
            Matcher plusOpMatcher = plusOppattern.matcher(input);
            Matcher multiplyOpMatcher = multiplyOppattern.matcher(input); //Multiplizeren
            quitMatcher = quitPattern.matcher(input);

            if (plusOpMatcher.matches()) {
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


         else if (quitMatcher.matches()) {
            System.out.println("Taschenrechner wird gestopped...");
            calculatorStopped = true;

        } else {
            System.err.println("Operation: " + input + " nicht erkannt");

        }
    }}}


