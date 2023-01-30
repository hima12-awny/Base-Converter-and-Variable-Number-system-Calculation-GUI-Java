package NumbersSystems;
import javax.swing.*;
import java.awt.*;

public class Tools {
    // this tool make my productivity better.

    public int sizer_txt = 40;   // default missed space for UI purpose.
    public int sizer_in = 5;     // default missed space for UI purpose.
    public JLabel text(JFrame frame, String txt, int size,
                       int x, int y, int width, int height) {
        // making easy label by one line
        // frame : the desired frame to put into.
        //  txt : the text to display on the label.
        // size : the size of the label.
        // x, y : the coordinate of the label.
        // width, height : the desired width and height of the label.

        JLabel label = new JLabel(txt);
        label.setBounds(x, y, width, height);
        label.setFont(new Font("Inter", Font.PLAIN, size));
        frame.add(label);
        return label;
    }
    public JTextField input(JFrame frame, int x, int y) {
        // make input text field in one line
        // frame : the desired frame to put into.
        // x, y : the coordinate of the input text field.

        JTextField input = new JTextField(10);
        input.setBounds(x, y - sizer_txt + sizer_in, 200, 30);
        input.setFont(new Font("Inter", Font.PLAIN, 20));
        frame.add(input);
        return input;
    }
    public JButton btn(JFrame frame, String text,
                       int x, int y, int width, int height) {

        // make button in one line
        //  frame : the desired frame to put into.
        // text : the text to display on the button.
        // x, y : the coordinate of the button.
        // width, height : the desired width and height of the button.

        JButton btn = new JButton(text);
        btn.setBounds(x, y - sizer_txt + sizer_in, width, height);
        btn.setBackground(Color.lightGray);
        frame.add(btn);
        return btn;
    }
}
