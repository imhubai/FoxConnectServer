import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Fri Jul 07 20:24:31 CST 2023
 */



/**
 * @author Hubai
 */
public class MainWindow extends JFrame {
    public MainWindow() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        tv_icon_phone = new JLabel();
        tv_WaittingConnect = new JLabel();
        hSpacer1 = new JPanel(null);
        label1 = new JLabel();
        panel6 = new JPanel();
        separator1 = new JSeparator();
        panel7 = new JPanel();
        bt_sendfile = new JButton();
        panel8 = new JPanel();
        panel10 = new JPanel();
        checkBox2 = new JCheckBox();
        checkBox3 = new JCheckBox();
        panel9 = new JPanel();
        checkBox1 = new JCheckBox();
        panel11 = new JPanel();
        bt_getphoneinfo = new JButton();
        bt_manage = new JButton();
        button6 = new JButton();
        panel12 = new JPanel();
        bt_changedevicename = new JButton();
        panel16 = new JPanel();
        bt_changedir = new JButton();
        panel13 = new JPanel();
        panel14 = new JPanel();
        label2 = new JLabel();
        QRcodePic = new JLabel();
        panel15 = new JPanel();
        scrollPane1 = new JScrollPane();
        ta_commandline = new JTextArea();
        panel5 = new JPanel();
        hSpacer2 = new JPanel(null);
        button1 = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setPreferredSize(new Dimension(850, 580));
        setTitle("\u72d0\u8fde - \u8f7b\u677e\u8fde\u63a5\u624b\u673a");
        setMaximumSize(new Dimension(850, 580));
        setMinimumSize(new Dimension(850, 580));
        setIconImage(new ImageIcon(getClass().getResource("/drawable/logo.png")).getImage());
        var contentPane = getContentPane();
        contentPane.setLayout(new CardLayout());

        //======== panel1 ========
        {
            panel1.setBorder(new EmptyBorder(5, 5, 5, 5));
            panel1.setLayout(new BorderLayout());

            //======== panel2 ========
            {
                panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));

                //======== panel3 ========
                {
                    panel3.setForeground(Color.white);
                    panel3.setBackground(new Color(0x00999999, true));
                    panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS));

                    //======== panel4 ========
                    {
                        panel4.setBackground(new Color(0xcccccc));
                        panel4.setForeground(new Color(0x00000000, true));
                        panel4.setLayout(new BoxLayout(panel4, BoxLayout.X_AXIS));

                        //---- tv_icon_phone ----
                        tv_icon_phone.setIcon(new ImageIcon(getClass().getResource("/drawable/\u8bbe\u7f6e.png")));
                        panel4.add(tv_icon_phone);

                        //---- tv_WaittingConnect ----
                        tv_WaittingConnect.setText("\u7b49\u5f85\u624b\u673a\u8fde\u63a5\u4e2d...");
                        tv_WaittingConnect.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
                        panel4.add(tv_WaittingConnect);
                    }
                    panel3.add(panel4);
                    panel3.add(hSpacer1);

                    //---- label1 ----
                    label1.setText("Made with Love by \u72d0\u516c\u5b50");
                    label1.setBorder(BorderFactory.createEmptyBorder());
                    label1.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
                    panel3.add(label1);
                }
                panel2.add(panel3);
            }
            panel1.add(panel2, BorderLayout.NORTH);

            //======== panel6 ========
            {
                panel6.setLayout(new BoxLayout(panel6, BoxLayout.Y_AXIS));

                //---- separator1 ----
                separator1.setForeground(Color.black);
                separator1.setBorder(new EmptyBorder(10, 0, 0, 0));
                separator1.setMaximumSize(new Dimension(32767, 1));
                panel6.add(separator1);

                //======== panel7 ========
                {
                    panel7.setBorder(new EmptyBorder(5, 5, 0, 5));
                    panel7.setLayout(new GridLayout(2, 2));

                    //---- bt_sendfile ----
                    bt_sendfile.setIcon(new ImageIcon(getClass().getResource("/drawable/fileopen.png")));
                    bt_sendfile.setFocusPainted(false);
                    bt_sendfile.setBorderPainted(false);
                    panel7.add(bt_sendfile);

                    //======== panel8 ========
                    {
                        panel8.setLayout(new BoxLayout(panel8, BoxLayout.Y_AXIS));

                        //======== panel10 ========
                        {
                            panel10.setLayout(new BoxLayout(panel10, BoxLayout.X_AXIS));

                            //---- checkBox2 ----
                            checkBox2.setText("\u672c\u673a\u526a\u8d34\u677f\u540c\u6b65\u624b\u673a");
                            checkBox2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 12));
                            checkBox2.setSelected(true);
                            checkBox2.setVisible(false);
                            panel10.add(checkBox2);

                            //---- checkBox3 ----
                            checkBox3.setText("\u63a5\u6536\u624b\u673a\u7684\u526a\u8d34\u677f");
                            checkBox3.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 12));
                            checkBox3.setSelected(true);
                            checkBox3.setVisible(false);
                            panel10.add(checkBox3);
                        }
                        panel8.add(panel10);

                        //======== panel9 ========
                        {
                            panel9.setLayout(new BoxLayout(panel9, BoxLayout.X_AXIS));

                            //---- checkBox1 ----
                            checkBox1.setText("\u5141\u8bb8\u624b\u673a\u8fdc\u7a0b\u624b\u673a\u6267\u884c\u547d\u4ee4");
                            checkBox1.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 12));
                            checkBox1.setSelected(true);
                            checkBox1.setVisible(false);
                            panel9.add(checkBox1);
                        }
                        panel8.add(panel9);

                        //======== panel11 ========
                        {
                            panel11.setVisible(false);
                            panel11.setLayout(new BoxLayout(panel11, BoxLayout.X_AXIS));

                            //---- bt_getphoneinfo ----
                            bt_getphoneinfo.setText("\u83b7\u53d6\u624b\u673a\u8be6\u60c5");
                            bt_getphoneinfo.setFocusPainted(false);
                            bt_getphoneinfo.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 12));
                            panel11.add(bt_getphoneinfo);

                            //---- bt_manage ----
                            bt_manage.setText("\u7ba1\u7406\u6388\u6743\u7684\u624b\u673a");
                            bt_manage.setFocusPainted(false);
                            bt_manage.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 12));
                            panel11.add(bt_manage);

                            //---- button6 ----
                            button6.setText("\u6587\u4ef6\u5939\u540c\u6b65\u5de5\u5177");
                            button6.setFocusPainted(false);
                            button6.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 12));
                            button6.setVisible(false);
                            panel11.add(button6);
                        }
                        panel8.add(panel11);

                        //======== panel12 ========
                        {
                            panel12.setLayout(new BoxLayout(panel12, BoxLayout.X_AXIS));

                            //---- bt_changedevicename ----
                            bt_changedevicename.setText("\u6539\u53d8\u624b\u673a\u5907\u6ce8");
                            bt_changedevicename.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 12));
                            panel12.add(bt_changedevicename);
                        }
                        panel8.add(panel12);

                        //======== panel16 ========
                        {
                            panel16.setLayout(new BoxLayout(panel16, BoxLayout.X_AXIS));

                            //---- bt_changedir ----
                            bt_changedir.setText("\u6539\u53d8\u6587\u4ef6\u4fdd\u5b58\u4f4d\u7f6e");
                            bt_changedir.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 12));
                            panel16.add(bt_changedir);
                        }
                        panel8.add(panel16);
                    }
                    panel7.add(panel8);

                    //======== panel13 ========
                    {
                        panel13.setLayout(new GridLayout(1, 2));

                        //======== panel14 ========
                        {
                            panel14.setLayout(new BoxLayout(panel14, BoxLayout.Y_AXIS));

                            //---- label2 ----
                            label2.setText("\u4f7f\u7528\u72d0\u8fdeApp\u626b\u63cf\u4e8c\u7ef4\u7801\u8fde\u63a5");
                            label2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 12));
                            label2.setBorder(new EmptyBorder(0, 5, 5, 5));
                            panel14.add(label2);

                            //---- QRcodePic ----
                            QRcodePic.setIcon(new ImageIcon(getClass().getResource("/drawable/emote.png")));
                            panel14.add(QRcodePic);
                        }
                        panel13.add(panel14);

                        //======== panel15 ========
                        {
                            panel15.setLayout(new BoxLayout(panel15, BoxLayout.Y_AXIS));

                            //======== scrollPane1 ========
                            {

                                //---- ta_commandline ----
                                ta_commandline.setBackground(new Color(0xf0f0f0));
                                ta_commandline.setRows(10);
                                ta_commandline.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 10));
                                scrollPane1.setViewportView(ta_commandline);
                            }
                            panel15.add(scrollPane1);
                        }
                        panel13.add(panel15);
                    }
                    panel7.add(panel13);
                }
                panel6.add(panel7);
            }
            panel1.add(panel6, BorderLayout.CENTER);

            //======== panel5 ========
            {
                panel5.setLayout(new BoxLayout(panel5, BoxLayout.X_AXIS));
                panel5.add(hSpacer2);

                //---- button1 ----
                button1.setText("\u9000\u51fa");
                button1.setFocusPainted(false);
                panel5.add(button1);
            }
            panel1.add(panel5, BorderLayout.SOUTH);
        }
        contentPane.add(panel1, "ConnectPage");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JLabel tv_icon_phone;
    JLabel tv_WaittingConnect;
    private JPanel hSpacer1;
    private JLabel label1;
    private JPanel panel6;
    private JSeparator separator1;
    private JPanel panel7;
    JButton bt_sendfile;
    private JPanel panel8;
    private JPanel panel10;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JPanel panel9;
    private JCheckBox checkBox1;
    private JPanel panel11;
    private JButton bt_getphoneinfo;
    private JButton bt_manage;
    private JButton button6;
    private JPanel panel12;
    JButton bt_changedevicename;
    private JPanel panel16;
    JButton bt_changedir;
    private JPanel panel13;
    private JPanel panel14;
    private JLabel label2;
    JLabel QRcodePic;
    private JPanel panel15;
    private JScrollPane scrollPane1;
    JTextArea ta_commandline;
    private JPanel panel5;
    private JPanel hSpacer2;
     JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
