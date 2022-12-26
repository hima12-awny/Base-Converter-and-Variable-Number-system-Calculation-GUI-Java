import static java.lang.System.out;

public class Main  extends Calc{

    public static void main(String[] args) throws Exception {

        String ans = "";

        while (!ans.equals("5")) {
            out.println("""
                    \n                
                    hello simple calc to:
                      1. decimal to N-base Direct.
                      2. N-base to decimal Direct.
                      3. N-base to another N-base.
                      4. Open the Calculator.
                      5. Exit.
                      """);
            ans = input("> ");
            switch (ans) {
                case "1" -> decimalToBase(true, 0., 0);
                case "2" -> BaseToDecimal(true, null, 0);
                case "3" -> NBase2NBase();
                case "4" -> Calculator();
                case "5" -> out.println("\nThanks to use my number Conversion Code, Awny :)");
                default -> out.println("wrong answer.");
            }
        }
    }
}
