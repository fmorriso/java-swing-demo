import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloDemo extends JFrame
{
    private JPanel panelMain;
    private JTextField txtName;
    private JButton btnClick;

    private Dimension scaledSize;

    public HelloDemo(String title, Dimension scaledSize)
    {
        super(title);
        // remember our scaled size
        this.scaledSize = scaledSize;

        this.setContentPane(panelMain);

        btnClick.addActionListener(e -> {
            String msg = String.format("Hello %s", txtName.getText());
            JOptionPane.showMessageDialog(btnClick, msg);
        });
    }

}
