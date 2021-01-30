import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

class login extends JFrame implements ActionListener {
    JButton B1,B2;
    JPanel panel;
    JLabel lb;
    login() {
        B1=new JButton("MAX");
        B2=new JButton("MIN");
        lb=new JLabel("press above MAX button to check maximum salary and MIN for minimum salary ");
        panel = new JPanel(new GridLayout(3,1));
        panel.add(B1);panel.add(B2);panel.add(B1);
        panel.add(lb);
        add(panel);
        B1.addActionListener(this);
        B2.addActionListener(this);
       
    }
    public void actionPerformed(ActionEvent ae) {
        String bu = ae.getActionCommand();
        java.sql.Connection conn = null;
        try {
            String URL = "jdbc:mysql://localhost/ACCOUNTS?user=root&password=Rakshithhn@123";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = java.sql.DriverManager.getConnection(URL);
        }

        catch(Exception e) {
            System.out.println("error in connection"+e);
            System.exit(0);
        }

        System.out.println("connection established");
        try{
            java.sql.Statement s = conn.createStatement();
            String query1 ="SELECT * FROM EMPLOYEE WHERE emp_sal=(select MAX(emp_sal) from EMPLOYEE);";
            String query2 ="SELECT * FROM EMPLOYEE WHERE emp_sal=(select MIN(emp_sal) from EMPLOYEE);";
            if(bu.equals("MAX"))
            {
            java.sql.ResultSet r = s.executeQuery(query1);
            if(r.next()){
                        lb.setText(r.getString("emp_id")+ " | " +
                        r.getString("emp_name") + " | Rs " +
                        r.getString("emp_sal") + "/-");
                    }
            }
            else
            {
            java.sql.ResultSet r = s.executeQuery(query2);
            if(r.next()){
                    lb.setText(r.getString("emp_id")+ " | " +
                    r.getString("emp_name") + " | Rs " +
                    r.getString("emp_sal") + "/-");
                }
            }
        }
        catch(Exception e) {
            System.out.println(e);
            System.exit(0);
        }
    }
}
class EmployeeDB{
    public static void main(String args[]) {
        try{
            login l = new login();
            l.setSize(500,500);
            l.setVisible(true);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
}

