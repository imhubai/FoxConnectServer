import java.awt.*;
import java.util.Objects;
import javax.swing.*;
import javax.swing.border.*;

public class changedirWindow extends JDialog {
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label1;
    JTextField textField1;
    private JPanel buttonBar;
    JButton okButton;
    JButton cancelButton;

    public changedirWindow(Window owner) {
        super(owner);
        initComponents();
    }

    private void initComponents() {
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();
        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/drawable/logo.png"))).getImage());
        setPreferredSize(new Dimension(320, 145));
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("改变接收文件的位置");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
        dialogPane.setLayout(new BorderLayout());
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        label1.setText("请输入文件夹地址");
        label1.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        contentPanel.add(label1);
        textField1.setText("D:/Download");
        textField1.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        textField1.setBorder(new EmptyBorder(5, 0, 0, 0));
        contentPanel.add(textField1);
        dialogPane.add(contentPanel, BorderLayout.CENTER);
        buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
        buttonBar.setLayout(new GridBagLayout());
        ((GridBagLayout) buttonBar.getLayout()).columnWidths = new int[]{0, 85, 80};
        ((GridBagLayout) buttonBar.getLayout()).columnWeights = new double[]{1.0, 0.0, 0.0};
        okButton.setText("确定");
        okButton.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));
        cancelButton.setText("取消");
        cancelButton.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        dialogPane.add(buttonBar, BorderLayout.SOUTH);
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
    }

}
