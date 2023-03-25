import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DiceRollerGUI {
    public static void main(String[] args) {
        // Set look and feel theme
        com.formdev.flatlaf.FlatDarculaLaf.install();

        // Create a JFrame
        JFrame frame = new JFrame("Dice Roller");

        // Icon image
        ImageIcon diceIcon = null;

        java.net.URL imgURL = DiceRollerGUI.class.getResource("dice.jpg");
        if (imgURL != null) {
            diceIcon = new ImageIcon(imgURL);
            frame.setIconImage(diceIcon.getImage());
        } else {
            JOptionPane.showMessageDialog(frame, "Icon image not found.");
        }

        // Create a JPanel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,1));

        // Create a JLabel for the title
        JLabel title = new JLabel("Roll the Dice", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(title);

        // Create a JLabel for the dice result
        JLabel resultLabel = new JLabel("Result: ", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(resultLabel);

        // Create a JButton to roll the dice
        JButton rollButton = new JButton("Roll");
        rollButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int result = rollDice();
                resultLabel.setText("Result: " + result);
            }
        });
        panel.add(rollButton);

        // Add panel to the frame
        frame.add(panel);

        // Set frame properties
        frame.setSize(300, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);

    }

    // Method to roll a die and return the result
    private static int rollDice() {
        int result = (int) (Math.random() * 6) + 1;
        return result;
    }
}
