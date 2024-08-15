import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;

class user_Age_Calculation
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> new user_Age_Calculation().createAndShowGUI());
    }

    private void createAndShowGUI()
    {
        JFrame frame = new JFrame("Age Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(4, 2));

        JLabel birthDateLabel = new JLabel("Enter Birthdate (YYYY-MM-DD):");
        JTextField birthDateField = new JTextField();
        JButton calculateButton = new JButton("Calculate Age");
        JLabel resultLabel = new JLabel("Your age is: ");

        frame.add(birthDateLabel);
        frame.add(birthDateField);
        frame.add(calculateButton);
        frame.add(resultLabel);

        calculateButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String birthDateText = birthDateField.getText();
                try
                {
                    LocalDate birthDate = LocalDate.parse(birthDateText);
                    LocalDate currentDate = LocalDate.now();
                    int age = calculateAge(birthDate, currentDate);
                    resultLabel.setText("Your age is: " + age);
                }
                catch (Exception ex)
                {
                    resultLabel.setText("Invalid date format. Use YYYY-MM-DD.");
                }
            }
        });

        frame.setVisible(true);
    }

    public int calculateAge(LocalDate birthDate, LocalDate currentDate)
    {
        if ((birthDate != null) && (currentDate != null))
        {
            return Period.between(birthDate, currentDate).getYears();
        }
        return 0;
    }
}

