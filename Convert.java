import java.util.Scanner;

import static java.lang.System.out;

public class Convert {
    public static String input(String msg) {
        out.print(msg);
        Scanner in = new Scanner(System.in);
        return in.next();
    }
    public static StringBuilder decimalToBase_int(int num, int base) {
        StringBuilder res = new StringBuilder();
        int rem;

        while (num != 0) {
            rem = num % base;
            if (rem > 9)
                res.insert(0, Character.toString(65 + rem - 10));
            else
                res.insert(0, String.valueOf(rem));

            num /= base;
        }
        return res;
    }

    public static StringBuilder decimalToBase_float(float num, int base) {

        StringBuilder res = new StringBuilder();
        num -= (int) num;
        int counter = 0;
        int n;
        while (num != (int) num && counter < 7) {
            num *= base;
            n = (int) num;

            if (n > 9) res.append(Character.toString('A' + (n - 10)));
            else res.append(n);

            num -= n;
            counter++;
        }
        return res;
    }

    public static String decimalToBase(Boolean show_this_func, Double num, int base) {

        if (show_this_func) {
            num = Double.parseDouble(input("\nEnter number in decimal system: "));

            base = Integer.parseInt(input("             Enter target base: "));
        }
        else {
            if(num == 0.0){
                return "0";
            }
        }

        StringBuilder res = decimalToBase_int(num.intValue(), base);
        if (num != num.intValue()) {
            res.append(".").append(decimalToBase_float(num.floatValue(), base));
        }
        if (show_this_func)
            out.printf("    Number with base %2d result: %s",  base, res.toString());
        else
            return res.toString();

        return null;
    }

    public static double baseToDecimal_int(String num, int base) {

        int locNum;
        char locChar;
        long deNum = 0L;

        for (int i = 0; i < num.length(); i++) {
            locChar = num.charAt(num.length() - i - 1);

            if (Character.isLetter(locChar)) locNum = locChar - 'A' + 10;
            else locNum = Integer.parseInt(String.valueOf(locChar));

            deNum += locNum * Math.pow(base, i);
        }

        return deNum;
    }

    public static double baseToDecimal_float(String num, int base) {

        long locNum;
        char locChar;
        double deNum = 0;

        for (int i = 1; i < num.length(); i++) {
            locChar = num.charAt(i);

            if (Character.isLetter(locChar)) locNum = locChar - 'A' + 10;
            else locNum = Integer.parseInt(String.valueOf(locChar));

            deNum += (locNum * Math.pow(base, -i));
        }

        return deNum;
    }

    public static Double BaseToDecimal(Boolean show_this_func, String num, int base) {
        double deNum_int;
        double deNum_f = 0;
        boolean isFloat = false;


        if (show_this_func) {
            base = Integer.parseInt(input("\t\t\t   Enter Base: "));
            num = input("Enter base " + base + " number with: ");
        }

        String num_int = num, num_f;

        if (num.contains(".")) {
            num_int = num.substring(0, num.indexOf("."));
            num_f = num.substring(num.indexOf("."), num.length());

            deNum_f = baseToDecimal_float(num_f, base);
            isFloat = true;
        }

        deNum_int = baseToDecimal_int(num_int, base);

        if (isFloat) {
            if (show_this_func)
                out.println("\tDecimal result number: " + (deNum_int + deNum_f));
            else {
                return deNum_int + deNum_f;
            }

        } else {
            if (show_this_func)
                out.println("\tDecimal result number: " + deNum_int);
            else {
                return deNum_int;
            }
        }
        return 0.;
    }

    public static void NBase2NBase() {
        int base = Integer.parseInt(input("Enter the base number from : "));

        String num = input("Enter number with base %3d : ".formatted(base));

        double decNum = BaseToDecimal(false, num, base);
        int targetBase = Integer.parseInt(input("\nEnter the target base number : "));

        String result = decimalToBase(false, decNum, targetBase);
        out.printf("Result from num = %s, base = %d,\n to base %d is num : %s", num, base, targetBase, result);


    }
}
