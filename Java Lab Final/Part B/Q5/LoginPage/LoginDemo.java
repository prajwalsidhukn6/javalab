// Create a login page using swing components,
// after successful authentication; the application should
// display the valid email-id of the person.
// Java Code

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class login extends JFrame implements ActionListener {
    JButton SUBMIT;
    JPanel panel;
    JLabel usrLabel, pwdLabel, emailLabel;
    JTextField usrText, pwdText, emailText;
    static final String dbClass = "com.mysql.jdbc.Driver";
    login() {
        usrLabel = new JLabel();
        usrLabel.setText("username");
        usrText = new JTextField(25);
        pwdLabel = new JLabel();
        pwdLabel.setText("password");
        pwdText = new JPasswordField(25);
        emailLabel = new JLabel();
        emailLabel.setText("email");
        emailText = new JTextField(25);
        SUBMIT = new JButton("SUBMIT");
        panel = new JPanel(new GridLayout(4,2));
        panel.add(usrLabel);
        panel.add(usrText);
        panel.add(pwdLabel);
        panel.add(pwdText);
        panel.add(emailLabel);
        panel.add(emailText);
        panel.add(SUBMIT);
        add(panel,BorderLayout.CENTER);
        SUBMIT.addActionListener(this);
        setTitle("login form");
    }
    public void actionPerformed(ActionEvent ae) {
        String usn = usrText.getText();
        String pwd = pwdText.getText();
        String email = emailText.getText();
        java.sql.Connection conn = null;
        try {
            String URL = "jdbc:mysql://127.0.0.1:3306/accounts?allowPublicKeyRetrieval=true&useSSL=false";
            String DB_USERNAME = "root";
            String DB_PASSWORD = "Vishnu@1524";
            Class.forName(dbClass).newInstance();
            conn = java.sql.DriverManager.getConnection(URL, DB_USERNAME, DB_PASSWORD);
        }catch(ClassNotFoundException e){
            System.out.println("error in loading driver: "+e);
            System.exit(1);
        }

        catch(Exception e) {
            System.out.println("error in connection"+e);
            System.exit(0);
        }

        System.out.println("connection established");
        try{
            java.sql.Statement s = conn.createStatement();
            String query =
            "SELECT * FROM users WHERE username = '"+usn+"'and password = '"+pwd+"'";
            java.sql.ResultSet r = s.executeQuery(query);
            r.next();
            int x = r.getRow();
            if (x>0){
                JOptionPane.showMessageDialog(null,"Your Mail id : " + email);
            }
            else{
                JOptionPane.showMessageDialog(this,"incorrect login or password","error",JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(Exception e) {
            System.out.println(e);
            System.exit(0);
        }
    }
}
class LoginDemo{
    public static void main(String args[]) {
        try{
            login frame = new login();
            frame.setSize(500,500);
            frame.setVisible(true);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
}
