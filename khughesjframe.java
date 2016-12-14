/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package integration.of.ecs;

/**
 *
 * @author Tom
 */
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.awt.BorderLayout;
import java.sql.PreparedStatement;
import java.io.File;
import java.io.FileWriter;
import java.io.Reader;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class khughesjframe extends javax.swing.JFrame {

    Connection con;
    Statement stmt;
    ResultSet rs;
    
   
  
    /**
     * Creates new form khughesjframe
     */
    public khughesjframe() {
        initComponents();
        Doconnect();
        
    }
    private static final int BUFFER_SIZE = 4096;
    
    public void Doconnect(){
        try{
            String host = "jdbc:derby://localhost:1527/ECS";
            String uName = "Zino";
            String uPass= "zino1234";
            
        
            Connection con = DriverManager.getConnection( host, uName, uPass );
            System.out.println("Connected");
            
            stmt = con.createStatement( );
            String SQL = "SELECT * FROM COURSEWORK_TEMPLATES";
            rs = stmt.executeQuery( SQL );
            System.out.println("SQL OK");
            
            rs.next();
            String cw_deadline = rs.getString("DEADLINE");
            String moduleid = rs.getString("MODULEID");
            //String job = rs.getString("MARKER_COMMENTS");
            
            
            
            
            // moving to 340
            
            PreparedStatement  ps = con.prepareStatement(
                    "SELECT DATE_SUBMITTED, GRADE, MARKER_COMMENTS, CW_PDF FROM CT2340 " +
                    "WHERE CW_ID = ? ");
            ps.setString(1, moduleid);
            
            
            rs = ps.executeQuery();
            System.out.println("SQL OK");
            
            rs.next();
            //id_col = rs.getInt("CW_ID");
            String submittion_date = rs.getString("DATE_SUBMITTED");
            String grade = rs.getString("GRADE");
            String comments = rs.getString("MARKER_COMMENTS");
            
            
            String filePath = "C:/Users/Tom/Desktop/Kate.pdf";
            Blob blob = rs.getBlob("CW_PDF");
            InputStream inputStream = blob.getBinaryStream();
            OutputStream outputStream = new FileOutputStream(filePath);
 
                int bytesRead = -1;
                byte[] buffer = new byte[BUFFER_SIZE];
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
 
                inputStream.close();
                outputStream.close();
                System.out.println("File saved");
            //job = rs.getString("MARKER_COMMENTS");
            
            
            
            
            displayvariables(cw_deadline, submittion_date, grade, comments, moduleid);
            con.close();
            
            
            
        }
        catch ( SQLException err ) {
            System.out.println( err.getMessage( ) );
        } catch (IOException err) {
            System.out.println( err.getMessage( ) );
        }
}
    

    public void uploadblob(){
        try{
            String host = "jdbc:derby://localhost:1527/Courseworks";
            String uName = "kate";
            String uPass= "wooden64";
            
        
            Connection con = DriverManager.getConnection( host, uName, uPass );
            System.out.println("Connected");
            
            stmt = con.createStatement( );
            String SQL = "SELECT * FROM COURSEWORK_TEMPLATES";
            rs = stmt.executeQuery( SQL );
            System.out.println("SQL OK");
            
            rs.next();
            String cw_deadline = rs.getString("DEADLINE");
            String moduleid = rs.getString("MODULEID");
            //String job = rs.getString("MARKER_COMMENTS");
            
            
            
            
            // moving to 340
            
            PreparedStatement  ps = con.prepareStatement(
                    "SELECT CW_ID, DATE_SUBMITTED, GRADE, MARKER_COMMENTS, CW_PDF FROM CT2340 " +
                    "WHERE CW_ID = ? ");
            ps.setString(1, moduleid);
            
            
            rs = ps.executeQuery();
            System.out.println("SQL OK");
            
            rs.next();
            //id_col = rs.getInt("CW_ID");
            String cw_id =rs.getString("CW_ID");
            String submittion_date = rs.getString("DATE_SUBMITTED");
            String grade = rs.getString("GRADE");
            String comments = rs.getString("MARKER_COMMENTS");
            String subid = cw_id;
            con.close();
            con = DriverManager.getConnection( host, uName, uPass );
            

            ps = con.prepareStatement(
                    "UPDATE STUDENT " +
                    "SET CW_PDF = ? " +
                    "WHERE SUB_ID = ? ");
            ps.setString(2,subid);
            File filePath = new File("C:/Users/Tom/Desktop/Kate.pdf");
            FileInputStream fis = new FileInputStream(filePath);
            
            ps.setBinaryStream(1, fis, (int) filePath.length());
            System.out.println("Everything set up");
            ps.execute();
            con.commit();
            stmt.close();
            rs.close();
  
            System.out.println("Upload commited");
            fis.close();
            con.close();
            System.out.println("Upload successful");
            
            
            
            
            
            
            
        }
        catch ( SQLException err ) {
            System.out.println( err.getMessage( ) );
        } catch (IOException err) {
            System.out.println( err.getMessage( ) );
        }
    }
    
    
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dead_data = new javax.swing.JLabel();
        subdate_data = new javax.swing.JLabel();
        grade_data = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Comments_data = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        cw_title_data = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Coursework Title");

        jLabel2.setText("Deadline");

        jLabel3.setText("Date Submitted");

        jLabel4.setText("Grade");

        dead_data.setText("Deadline Data");

        subdate_data.setText("Sumbitted Data");

        grade_data.setText("Grade Data");

        jLabel8.setText("Marker Comments");

        Comments_data.setText("Comments Data");

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Download Submission");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Upload Submission");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        cw_title_data.setText("jLabel5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel8))
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Comments_data)
                                    .addComponent(grade_data)
                                    .addComponent(subdate_data)
                                    .addComponent(dead_data)
                                    .addComponent(cw_title_data)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(65, 65, 65)
                                .addComponent(jButton3)))
                        .addGap(0, 43, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1)
                    .addComponent(cw_title_data))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(dead_data))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(subdate_data))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(grade_data))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(Comments_data))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        new StudentSelections().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        uploadblob();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed
    
    private  void displayvariables(String cw_deadline,String submittion_date, String grade, String comments, String moduleid ){
        dead_data.setText(String.valueOf(cw_deadline));
        subdate_data.setText(String.valueOf(submittion_date));
        grade_data.setText(String.valueOf(grade));
        Comments_data.setText(String.valueOf(comments));
        cw_title_data.setText(String.valueOf(moduleid));
    }
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(khughesjframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(khughesjframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(khughesjframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(khughesjframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new khughesjframe().setVisible(true);
                
                
            }
        });
        
        
        
}
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Comments_data;
    private javax.swing.JLabel cw_title_data;
    public javax.swing.JLabel dead_data;
    private javax.swing.JLabel grade_data;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel subdate_data;
    // End of variables declaration//GEN-END:variables
}
