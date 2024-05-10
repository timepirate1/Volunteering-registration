package volunteering;

import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import static volunteering.home.conn;
import static volunteering.home.password;
import static volunteering.home.url;
import static volunteering.home.user;
import static volunteering.home.pst;
import static volunteering.home.rs;


public class event_registration extends javax.swing.JFrame {
public String username;






    public event_registration() {
        initComponents();
    }
    
    public event_registration(String name) {
        username = name;
        System.out.println(username);
        initComponents();
    }

   public  void connect(){
        try {
            conn = DriverManager.getConnection(url,user,password);
            
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        reg_btn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        citybox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setText("Search City");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Event ID", "Event Name", "Date", "Description"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        reg_btn.setBackground(new java.awt.Color(153, 204, 255));
        reg_btn.setForeground(new java.awt.Color(255, 255, 255));
        reg_btn.setText("Register");
        reg_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reg_btnActionPerformed(evt);
            }
        });

        jLabel2.setText("Select Event to Register");

        citybox.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N
        citybox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a city","Bangalore", "Kolkata", "Hyderabad" }));
        citybox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cityboxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 808, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(reg_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(8, 8, 8)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(citybox, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(citybox)
                        .addGap(3, 3, 3))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reg_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(90, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reg_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reg_btnActionPerformed
    
       
       int eid_int = Integer.parseInt(value.toString());
        String insert_query = "INSERT INTO reg(user,eid) VALUES ('"+username+"',"+value+")";
        try {
        connect();
        PreparedStatement pstmt = conn.prepareStatement(insert_query);
        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Data inserted successfully.");
        } else {
            System.out.println("No rows affected.");
        }
        
        // Close the PreparedStatement
        pstmt.close();
    } catch (SQLException ex) {
        Logger.getLogger(event_registration.class.getName()).log(Level.SEVERE, null, ex);
    }

    }//GEN-LAST:event_reg_btnActionPerformed

    private void cityboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cityboxActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        Object sel_city = citybox.getSelectedItem();
        citybox.removeItem("Select a city");
         if (sel_city != null){
            String city = sel_city.toString();
            String Query= "";
            if (city.equals("Bangalore")){
                Query="SELECT * FROM events WHERE location ='Bangalore' ";
            }else if(city.equals("Kolkata")){
                Query="SELECT * FROM events WHERE location ='Kolkata' ";
            }
            else if(city.equalsIgnoreCase("Hyderabad")){
                Query="SELECT * FROM events WHERE location ='Hyderabad' ";
            }
            try {
                model.setRowCount(0); 
                connect();
                pst= conn.createStatement();
                rs= pst.executeQuery(Query); 
                while(rs.next()){
                    int id= rs.getInt("id");
                    String event = rs.getString("event");
                    String desc = rs.getString("description");
                    String date = rs.getString("date");
                    model.addRow(new Object[]{id,event,date,desc});
                }
                }catch (SQLException ex) {
                    Logger.getLogger(event_registration.class.getName()).log(Level.SEVERE, null, ex);
                }
         }else{
                System.out.println("No city selected");
         
         
         }
    }//GEN-LAST:event_cityboxActionPerformed
public Object value;
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        value = jTable1.getValueAt(row,0);
        //
    }//GEN-LAST:event_jTable1MouseClicked

   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(event_registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(event_registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(event_registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(event_registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new event_registration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> citybox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton reg_btn;
    // End of variables declaration//GEN-END:variables
}
