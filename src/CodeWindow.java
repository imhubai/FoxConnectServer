import java.awt.*;
import java.util.Objects;
import javax.swing.*;
import javax.swing.border.*;

public class CodeWindow extends JDialog {
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JPanel panel2;
    private JLabel label1;
    private JPanel panel1;
    JLabel label2;
    private JPanel buttonBar;
    JButton okButton;

    public CodeWindow(Window owner) {
        super(owner);
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        panel2 = new JPanel();
        label1 = new JLabel();
        panel1 = new JPanel();
        label2 = new JLabel();
        buttonBar = new JPanel();
        okButton = new JButton();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(240, 195));
        setTitle("与新设备配对");
        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/drawable/logo.png"))).getImage());
        setMaximumSize(new Dimension(500, 500));
        setType(Window.Type.POPUP);
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
        dialogPane.setLayout(new BorderLayout());
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
        label1.setText("请在您的设备上输入配对码");
        panel2.add(label1);
        contentPanel.add(panel2);
        panel1.setLayout(new GridLayout(1, 1));
        label2.setText("0000");
        label2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 48));
        label2.setBackground(Color.white);
        label2.setForeground(Color.black);
        panel1.add(label2);
        contentPanel.add(panel1);
        dialogPane.add(contentPanel, BorderLayout.CENTER);
        buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
        buttonBar.setLayout(new GridBagLayout());
        ((GridBagLayout) buttonBar.getLayout()).columnWidths = new int[]{0, 85, 80};
        ((GridBagLayout) buttonBar.getLayout()).columnWeights = new double[]{1.0, 0.0, 0.0};
        okButton.setText("明白");
        okButton.setContentAreaFilled(false);
        okButton.setFocusPainted(false);
        buttonBar.add(okButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
       new Insets(0, 0, 0, 0), 0, 0));
        dialogPane.add(buttonBar, BorderLayout.SOUTH);
        contentPane.add(dialogPane, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(getOwner());
    }
}
