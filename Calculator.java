package NumbersSystems;

// Calculator  can perform basic operations like addition, subtraction, multiplication and division
// on Two numbers even they are with different bases system.


public class Calculator {

    Convertor convert = new Convertor();

    public String get_result(String num1, int b1, String num2, int b2, String ope, int target_base) throws Exception {
        /*  get_result Method
            convert the two numbers to the decimal and do calculations and
            return the result with respect to the target base.

            num1 is the First  number and b1 is the base of the first number
            num2 is the Second number and b2 is the base of the second number.
            ope is the operation (+, -, *, /)
            target_base is the base of the result number.
        */


        double n1 = convert.BaseToDecimal(num1, b1); // converts first number to decimal number

        double n2 = convert.BaseToDecimal(num2, b2); // converts second number to decimal number

        double result_num = 0.0;

        String polarity = "+"; // assume the result is positive (+)


        switch (ope) {
            case "+" -> result_num = n1 + n2;
            case "-" -> {
                result_num = Math.abs(n1 - n2);
                if (n1 - n2 < 0)
                    polarity = "-";
            }
            case "*" -> result_num = n1 * n2;
            case "/" -> {
                if (n2 == 0)
                    throw new ArithmeticException("divide by zero");
                result_num = n1 / n2;

            }
        }

        // Convert the decimal result to number with respect to target base.
        String result_nBase = convert.decimalToBase(String.valueOf(result_num), target_base);

        // if the result is negative then add "-" before the result.
        if (polarity.equals("+"))
            return result_nBase;
        else
            return "-" + result_nBase;
    }
}
