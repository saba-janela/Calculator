import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener{
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[10];
    JButton addButton, subButton, mulButton, divButton, prcButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;

    Font font = new Font("Times New Roman", Font.BOLD, 20);
    Font font2 = new Font("Times New Roman", Font.BOLD, 50);

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Calculator(){
        // frame
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(450, 600);
        frame.setLayout(null);
        ImageIcon image = new ImageIcon("calculator.png");
        frame.setIconImage(image.getImage());
        UIManager.put("activeCaption", new Color(0x000000));
        frame.getContentPane().setBackground(new Color(0x000000));

        // textField
        textField = new JTextField();
        textField.setBounds(15, 15, 405, 90);
        textField.setText(null);
        textField.setEditable(false);
        textField.setFont(font2);
        textField.setBackground(new Color(0x000000));
        textField.setForeground(new Color(0xFFFFFF));
        textField.setBorder(null);

        // buttons
        // function buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("×");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("del");
        clrButton = new JButton("c");
        prcButton = new JButton("%");
        negButton = new JButton("( - )");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = prcButton;
        functionButtons[9] = negButton;

        for (JButton functionButton : functionButtons) {
            functionButton.addActionListener(this);
            functionButton.setFocusable(false);
            functionButton.setFont(font);
            functionButton.setBackground(new Color(0x141414));
            functionButton.setForeground(Color.white);
            functionButton.setBorder(null);
        }

        functionButtons[5].setBackground(new Color(0xCC5500));
        // number buttons
        for (int i = 0; i < numberButtons.length; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setFont(font);
            numberButtons[i].setBackground(new Color(0x222222));
            numberButtons[i].setForeground(new Color(0xFFFFFF));
            numberButtons[i].setBorder(null);

        }

        // panel
        panel = new JPanel();
        panel.setBounds(15,120,405,430);
        panel.setLayout(new GridLayout(5, 4, 4, 4));
        panel.setBackground(new Color(0x000000));

        //adding buttons
        panel.add(prcButton);
        panel.add(clrButton);
        panel.add(delButton);
        panel.add(divButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(negButton);
        panel.add(numberButtons[0]);
        panel.add(decButton);
        panel.add(equButton);


        // adding stuff
        frame.add(textField);
        frame.add(panel);
        frame.setVisible(true);
    }


    // functions for buttons
    @Override
    public void actionPerformed(ActionEvent e) {

        // function for numbers
        for (int i = 0; i < numberButtons.length; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        // function for decimal button
        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }

        // function for addition button
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        // function for substraction button
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

        // function for multiplication button
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }

        // function for division button
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        //function for percentage button
        if (e.getSource() == prcButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '%';
            textField.setText("");
        }

        // function for equality button
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());
            textField.setText("");

            switch (operator) {
                case '+':
                    result = num1+num2;
                    break;
                case '-':
                    result = num1-num2;
                    break;
                case '*':
                    result = num1*num2;
                    break;
                case '/':
                    result = num1/num2;
                    break;
                case '%':
                    result = num1%num2;
                    break;
            }

            textField.setText(String.valueOf(result));
            num1 = result;

        }

        // function for clear button
        if (e.getSource() == clrButton) {
            textField.setText("");
        }

        // function for del button
        if (e.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length()-1; i++) {
                textField.setText(textField.getText()+string.charAt(i));
            }
        }

        // function for negative button
        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }
    }
}