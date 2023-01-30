package NumbersSystems;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.util.Objects;

public class GUI extends JFrame implements ActionListener  {

    // The GUI of the Convertor and Calculator Application.

    JTextField s1_num, s1_b, s1_result,         // inputs field for (base to Decimal/decimal to Base)(s1) section.
            s2_num, s2_b, s2_tb, s2_result,     // inputs field for (from base to base)(s2) section.
            clc_n1, clc_n2, clc_result, clc_b1, clc_b2, clc_b3; // inputs field for Calculator(clc) section
    JButton s1_btn, s2_btn, clc;
    JLabel target_base; // to make ( )and with the target base in clc section.
    JComboBox<String> clc_operation = new JComboBox<>(new String[]{"+", "-", "*", "/"}); // to choose an operation
    Convertor convert = new Convertor();
    Calculator calculate = new Calculator();
    JRadioButton d2n_rd, n2d_rd; // to choose what service to use.
    ButtonGroup rg;              // contain the radio buttons.

    public GUI() {

        Tools tool = new Tools();

        // size of the Screen (1200, 720) and name it "Convertor and Calculator"
        this.setSize(1200, 720);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Convertor and Calculator");

        // Create two Branches "Convertor and Calculator"
        tool.text(this, "Convertor", 40, 167, 10, 206, 49);
        tool.text(this, "Calculator", 40, 807, 10, 206, 49);

        //******************** Decimal 2 N-base or N-base 2 Decimal (s1) **************************

        // initialize radioButtons with a specific Name on it
        d2n_rd = new JRadioButton("Decimal to N-base");
        n2d_rd = new JRadioButton("N-base to Decimal");

        // put them in a specific position into the Window.
        d2n_rd.setBounds(89, 111 - tool.sizer_txt + 10, 180, 23);
        d2n_rd.setFont(new Font("Inter", Font.PLAIN, 16));

        n2d_rd.setBounds(297, 111 - tool.sizer_txt + 10, 180, 23);
        n2d_rd.setFont(new Font("Inter", Font.PLAIN, 16));

        // set radiobutton ("Decimal to N-base") defaulted selected
        d2n_rd.setSelected(true);

        // create a group for the two radio buttons and add them to it.
        rg = new ButtonGroup();
        rg.add(d2n_rd);
        rg.add(n2d_rd);

        // make radio button selected when it is clicked.
        d2n_rd.addActionListener(this);
        n2d_rd.addActionListener(this);

        // add radio button to a Frame and to the window.
        this.add(d2n_rd);
        this.add(n2d_rd);

        // Put text as Label before input field in (s1).
        tool.text(this, "Number", 16, 34, 170 - tool.sizer_txt, 130, 35);
        tool.text(this, "Base (int)", 16, 34, 245 - tool.sizer_txt, 130, 35);
        tool.text(this, "Result", 16, 34, 304 - tool.sizer_txt, 130, 35);

        // Put input field in (s1).
        s1_num = tool.input(this, 138, 170);
        s1_b = tool.input(this, 138, 245);
        s1_result = tool.input(this, 138, 304);

        // to avoid edit in the result field.
        s1_result.setEditable(false);
        s1_result.setBackground(Color.white);

        // make button to get result when clicked in (s1).
        s1_btn = tool.btn(this, "Convert", 416, 309, 92, 20);
        s1_btn.addActionListener(this);

        // ******************N-Base 2 N-Base **************

        // title of second section (s2) ->  "N-Base to N-Base"
        tool.text(this, "N-Base to N-Base", 16, 228, 416 - tool.sizer_txt + 10, 138, 20);

        // Put text as Label before input field in (s2).
        tool.text(this, "N-Base Number", 16, 34, 464 - tool.sizer_txt + 10, 138, 20);
        tool.text(this, "Base (int)", 16, 34, 510 - tool.sizer_txt + 10, 138, 20);
        tool.text(this, "Target Base (int)", 16, 34, 563 - tool.sizer_txt + 10, 138, 20);
        tool.text(this, "Result", 16, 34, 621 - tool.sizer_txt + 10, 138, 20);

        // Put input field in (s2).
        s2_num = tool.input(this, 172, 464);
        s2_b = tool.input(this, 172, 511);
        s2_tb = tool.input(this, 172, 564);
        s2_result = tool.input(this, 172, 620);

        // to avoid edit in the result field.
        s2_result.setEditable(false);
        s2_result.setBackground(Color.white);

        // make button to get result when clicked in (s2).
        s2_btn = tool.btn(this, "Convert", 411, 621 + 5, 102, 20);
        s2_btn.addActionListener(this);


        // ******************** Calculations **************

        // title and description of calc section
        tool.text(this, "This Simple Calculator Make operation (+, -, *, /)",
                16, 697, 122 - tool.sizer_txt, 439, 57);
        tool.text(this, "Enter your numbers and specify its base and Chose any",
                16, 697 - 30, 122 + 20 - tool.sizer_txt, 600, 57);
        tool.text(this, "Operation and click Calculate.",
                16, 697 + 60, 122 + 20 + 20 - tool.sizer_txt, 600, 57);

        // Put text as Label before input field in (clc) section.
        tool.text(this, "Number 1", 16, 646, 283 - tool.sizer_txt, 116, 25);
        tool.text(this, "Base 1", 16, 646, 334 - tool.sizer_txt, 116, 25);

        tool.text(this, "Operation", 16, 646, 388 - tool.sizer_txt, 116, 25);

        tool.text(this, "Number 2", 16, 646, 446 - tool.sizer_txt, 116, 25);
        tool.text(this, "Base 2", 16, 646, 500 - tool.sizer_txt, 116, 25);

        tool.text(this, "Target Base", 16, 647, 558 - tool.sizer_txt, 116, 25);
        tool.text(this, "Result", 16, 646, 598 - tool.sizer_txt, 116, 25);

        tool.text(this, "(", 35, 646 + 80, 598 - tool.sizer_txt, 116, 25);
        tool.text(this, ")", 35, 646 + 80 + 200 + 15, 598 - tool.sizer_txt, 116, 25);

        // target_base is variable Label based on target base from user.
        target_base = tool.text(this, "", 12, 951, 618 - tool.sizer_txt, 116, 25);

        // get first number and its base
        clc_n1 = tool.input(this, 739, 283 - 5);
        clc_b1 = tool.input(this, 739, 334 - 5);

        // put combo box (operation) in frame and set its UI properties.
        clc_operation.setBounds(739, 387 - 40, 200, 30);
        clc_operation.setFont(new Font("Inter", Font.PLAIN, 20));
        this.add(clc_operation);

        // get second number and its base
        clc_n2 = tool.input(this, 739, 446 - 5);
        clc_b2 = tool.input(this, 739, 504 - 5);

        // get target base reposition it.
        clc_b3 = tool.input(this, 750, 555 - 5);
        clc_b3.setBounds(750, 518, 200 - (750 - 739), 30);

        // show result and make it un editable.
        clc_result = tool.input(this, 739, 597 - 5);
        clc_result.setEditable(false);
        clc_result.setBackground(Color.white);

        // get Calculated result when clicking on the calculate button.
        clc = tool.btn(this, "Calculate", 1034, 597, 102, 25);
        clc.addActionListener(this);

        this.setLayout(null);
        this.setVisible(true);
        this.setResizable(false); // Disable resizing Window.
    }

    public void paint(Graphics g) {
        // draw the line separator lines (by using the Graphics object)

        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        Line2D lin1 = new Line2D.Float(0, 90, 1200, 90);
        g2.draw(lin1);
        Line2D lin2 = new Line2D.Float(600, 90, 600, 750);
        g2.draw(lin2);
        Line2D lin3 = new Line2D.Float(0, 400, 600, 400);
        g2.draw(lin3);
    }

    public static void main(String[] args) {
        new GUI(); // run the program.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String result = null; // make global result to get either result or warring message.
        try {
            if (e.getSource() == s1_btn) {
                // when button (Convert) from s1 is pressed.

                // get and check the base is valid.
                int base = Integer.parseInt(s1_b.getText().strip());
                if (base <= 1) throw new Exception("Invalid Base");

                // get the service checkButton
                if (d2n_rd.isSelected()) {
                    double num = Double.parseDouble(s1_num.getText().strip());
                    result = convert.decimalToBase(num, base);  // convert decimal to base

                } else if (n2d_rd.isSelected()) {
                    String num = s1_num.getText().strip();
                    result = "%.5f".formatted(convert.BaseToDecimal(num, base)); // convert from base to decimal.
                }

            } else if (e.getSource() == s2_btn) {
                // when button (Convert) from s2 is pressed.

                String num = s2_num.getText().strip();                  // get number
                int base1 = Integer.parseInt(s2_b.getText().strip());   // get its base
                int base2 = Integer.parseInt(s2_tb.getText().strip());  //  get target base

                // avoid invalid base.
                if (base1 <= 1 || base2 <= 1)
                    throw new Exception("Invalid Base");

                result = convert.NBase2NBase(num, base1, base2);

            } else if (e.getSource() == clc) {
                // when button (Calculate) from clc section is pressed.

                // get two numbers
                String first_num = clc_n1.getText().strip();
                String sec_num = clc_n2.getText().strip();

                // and there bases
                int base1 = Integer.parseInt(clc_b1.getText().strip());
                int base2 = Integer.parseInt(clc_b2.getText().strip());

                // and the target result base.
                int target_base_num = Integer.parseInt(clc_b3.getText().strip());

                // avoid invalid base.
                if (base1 <= 1 || base2 <= 1 || target_base_num <= 1) {
                    throw new Exception("Invalid Base");
                }
                target_base.setText(String.valueOf(target_base_num)); // show target base number after result field.

                // get the selected operation from Combo Box.
                String operation = Objects.requireNonNull(clc_operation.getSelectedItem()).toString();

                result = calculate.get_result(first_num, base1, sec_num, base2, operation, target_base_num);
            }
        }
        // Handle the Exception that user will do something suspicious.
        catch (NumberFormatException ex) {
            result = "Invalid Numbers!";
        } catch (Exception ex) {
            result = ex.getMessage(); // get the exception specific message.
        } finally {
            // show the result in where button is pressed.
            if (e.getSource() == s1_btn)      s1_result.setText(result);
            else if (e.getSource() == s2_btn) s2_result.setText(result);
            else if (e.getSource() == clc)    clc_result.setText(result);
        }
    }
    // NOTE : made by Ibrahim Awny.
}