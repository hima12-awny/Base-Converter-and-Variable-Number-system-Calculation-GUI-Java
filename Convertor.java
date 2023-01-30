package NumbersSystems;

public class Convertor {
    // Convertor Class convert number with specific base to another number with specific another base.
    public static StringBuilder decimalToBase_int(int num, int target_base) throws Exception {
        // convert the "int part" of the number to number with respect target base

        StringBuilder result = new StringBuilder();
        int remainder;

        while (num != 0) {
            remainder = num % target_base;

            // check if element is letter or digit to add.
            if (remainder > 9) {

                // throw exception To avoid having something other than letters (A - Z) only
                if (remainder >= 25) throw new Exception("BigRemainder");

                char chr_val = (char) ('A' + remainder - 10);
                result.insert(0, chr_val);
            } else
                result.insert(0, remainder);

            num /= target_base;
        }
        return result;
    }

    public static StringBuilder decimalToBase_float(float num, int base) throws Exception {
        // convert the "float part" of the number to number with respect target base
        // max seven digits after the decimal point.

        StringBuilder result = new StringBuilder();
        int counter = 0, val;


        while (num != (int) num && counter++ < 7) {
            num *= base;
            val = (int) num;

            if (val > 9) {

                // throw exception To avoid having something other than letters (A - Z) only
                if (val >= 25) throw new Exception("BigRemainder");

                char chr_val = (char) ('A' + val - 10);
                result.append(chr_val);

            } else result.append(val);

            num -= val;
        }
        return result;
    }

    public String decimalToBase(Double num, int base) throws Exception {
        // convert all parts of the decimal to number with respect target base.
        // num  : the number
        // base : the target base

        if (num == 0.0) return "0";

        StringBuilder result = decimalToBase_int(num.intValue(), base); // convert int part.

        // check if the number is Float to add Converted Float part to the result.
        if (num != num.intValue()) {
            StringBuilder flout_result = decimalToBase_float(num.floatValue(), base);
            result.append(".").append(flout_result);
        }
        return result.toString();
    }

    public static double baseToDecimal_int(String num, int base) {
        // convert "int part" Number with a specific base to decimal

        int locNum;
        char locChar;
        double deNum = 0;

        for (int i = 0; i < num.length(); i++) {
            locChar = num.charAt(num.length() - i - 1); // get the character from num (from left to right)

            // get the value of the element in the string ether digit or letter(ascii code)
            if (Character.isLetter(locChar)) locNum = locChar - 'A' + 10;
            else locNum = Integer.parseInt(String.valueOf(locChar));

            deNum += locNum * Math.pow(base, i);
        }
        return deNum;
    }

    public static double baseToDecimal_float(String num, int base) {
        // convert "float part" Number with a specific base to decimal

        long locNum;
        char locChar;
        double deNum = 0;

        for (int i = 1; i < num.length(); i++) {
            locChar = num.charAt(i);

            // same as in int part of baseToDecimal_int
            if (Character.isLetter(locChar)) locNum = locChar - 'A' + 10;
            else locNum = Integer.parseInt(String.valueOf(locChar));

            deNum += (locNum * Math.pow(base, -i)); // different from int part
        }

        return deNum;
    }

    public Double BaseToDecimal(String num, int base) throws Exception {

        // Convert Number with a specific base to decimal (Double)
        //  num  : the number
        //  base : base of the number.

        // make sure that the base bigger than any digit in number
        for (char val : num.toCharArray()) {

            if (Character.isLetter(val)) {
                if (val - 'A' + 10 >= base) throw new Exception("Small Base");
            }
            if (Integer.parseInt(String.valueOf(val)) >= base) throw new Exception("Small Base");
        }

        String num_int = num, num_float;

        // check if the number is Float to add Converted Float part to the result.
        if (num.contains(".")) {
            num_int = num.substring(0, num.indexOf("."));
            num_float = num.substring(num.indexOf("."), num.length());

            // int part                        and float part
            return baseToDecimal_int(num_int, base) + baseToDecimal_float(num_float, base);
        }
        return baseToDecimal_int(num_int, base);
    }

    public String NBase2NBase(String num, int from_base, int to_base) throws Exception {
        // Convert number from a specific base to a number with another base
        //  num         : the number
        //  from_base   : source base of the number
        //  to_base     : destination base of the number

        double decimal_num = BaseToDecimal(num, from_base);
        return this.decimalToBase(decimal_num, to_base);
    }

    // NOTE : all methods throws Exception with a specific massage to represent a specific Problem.
    // Make by : Ibrahim Awny.
}
