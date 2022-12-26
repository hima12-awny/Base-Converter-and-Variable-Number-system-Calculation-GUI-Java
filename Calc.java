package NumbersSystems;

public class Calc extends Convert {


    public static String Clc(String num1, int b1, String num2, int b2, String ope, int target_base) throws Exception {

        double n1 = BaseToDecimal(false, num1, b1);

        double n2 = BaseToDecimal(false, num2, b2);

        double result_num;

        String bol = "+";

        switch (ope){
            case "+" -> result_num = n1 + n2;
            case "-" -> {
                result_num = Math.abs(n1 - n2);
                if  (n1-n2 < 0)
                    bol = "-";
            }
            case "*" -> result_num = n1 * n2;
            case "/" -> {
                if(n2==0)
                    throw new ArithmeticException("Cannot divide by zero");
                result_num = n1 / n2;

            }
            default -> throw new ArithmeticException("Operation not found");
        }

        String result_nBase =decimalToBase(false, result_num, target_base);

        if(bol.equals("+"))
            return result_nBase;
        else
            return "-"+result_nBase;
    }


    public static void Calculator() throws Exception {
        System.out.println("\n----------Calculate----------");
        System.out.println(
                """
                Examples:
                # (num1)base1 + (num2)base2.
                # (num1)base1 - (num2)base2.
                # (num1)base1 * (num2)base2.
                # (num1)base1 / (num2)base2.
                """
        );

        int b1 = Integer.parseInt(input("     1st base_1 : "));
        String n1 =               input("1st num with %2d : ".formatted(b1));

        String ope =              input("\n      Operation : ");

        int b2 = Integer.parseInt(input("\n     2nd base_2 : "));
        String n2 =               input("2nd num with %2d : ".formatted(b2));

        int target_base = Integer.parseInt(input("the result with target base? : "));

        String result = Clc(n1, b1, n2, b2, ope, target_base);

        System.out.printf("""
                 Result of\040
                          (%s)%d
                        %s (%s)%d
                        ----------
                          (%s)%d
                 --------------------------""".formatted(n1, b1, ope, n2, b2, result, target_base));

    }

}
