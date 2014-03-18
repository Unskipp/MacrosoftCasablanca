/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Presentation.ListFrames.ClientList;
import Presentation.ListFrames.EmployeesList;
import Presentation.ListFrames.FacilityList;
import Presentation.ListFrames.ReservationList;
import Presentation.ListFrames.RoomList;

/**
 *
 * @author Unskipp
 */
public class MainPage extends javax.swing.JFrame
{

    /**
     * Creates new form MainPage
     */
    public MainPage()
    {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuRomms = new javax.swing.JMenuItem();
        jMenuClients = new javax.swing.JMenuItem();
        jMenuFacilities = new javax.swing.JMenuItem();
        jMenuEmployees = new javax.swing.JMenuItem();
        jMenuReservations = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(691, 421));

        jMenu1.setText("HOME");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Account");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Book");
        jMenuBar1.add(jMenu3);

        jMenu4.setText("List");

        jMenuRomms.setText("Rooms");
        jMenuRomms.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuRommsActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuRomms);

        jMenuClients.setText("Clients");
        jMenuClients.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuClientsActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuClients);

        jMenuFacilities.setText("Facilities");
        jMenuFacilities.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuFacilitiesActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuFacilities);

        jMenuEmployees.setText("Employees");
        jMenuEmployees.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuEmployeesActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuEmployees);

        jMenuReservations.setText("Reservations");
        jMenuReservations.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuReservationsActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuReservations);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Help");
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 712, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 369, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuRommsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuRommsActionPerformed
    {//GEN-HEADEREND:event_jMenuRommsActionPerformed
        RoomList frame = new RoomList();
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuRommsActionPerformed

    private void jMenuClientsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuClientsActionPerformed
    {//GEN-HEADEREND:event_jMenuClientsActionPerformed
        ClientList frame = new ClientList();
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuClientsActionPerformed

    private void jMenuFacilitiesActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuFacilitiesActionPerformed
    {//GEN-HEADEREND:event_jMenuFacilitiesActionPerformed
        FacilityList frame = new FacilityList();
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuFacilitiesActionPerformed

    private void jMenuEmployeesActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuEmployeesActionPerformed
    {//GEN-HEADEREND:event_jMenuEmployeesActionPerformed
        EmployeesList frame = new EmployeesList();
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuEmployeesActionPerformed

    private void jMenuReservationsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuReservationsActionPerformed
    {//GEN-HEADEREND:event_jMenuReservationsActionPerformed
        ReservationList frame = new ReservationList();
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuReservationsActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jMenu1MouseClicked
    {//GEN-HEADEREND:event_jMenu1MouseClicked
        // TODO add your handling code here:
        MainPage frame = new MainPage();
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new MainPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuClients;
    private javax.swing.JMenuItem jMenuEmployees;
    private javax.swing.JMenuItem jMenuFacilities;
    private javax.swing.JMenuItem jMenuReservations;
    private javax.swing.JMenuItem jMenuRomms;
    // End of variables declaration//GEN-END:variables
}
