/*
<<<<<<< HEAD:ChemCamSimulator/src/gui/MainFrame.java
 * @author truol014
 */
package gui;
public class MainFrame extends javax.swing.JFrame {
=======
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemCam_testMain;

import chemCam_testMain.ChemCam_TestMain;

/**
 *
 * @author truol014
 */
public class ChemCam_TestMain extends javax.swing.JFrame {
>>>>>>> 627a16564e19fa27b7a23519591f4bdebed7c7f4:ChemCamSimulator/src/chemCam_testMain/ChemCam_TestMain.java
    // Creates new form MainFrame
    public ChemCam_TestMain() {
        initComponents();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        controllerPanel1 = new chemCam_testMain.ControllerPanel();
        agentPanel1 = new chemCam_testMain.AgentPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane1.setDividerSize(2);
        jSplitPane1.setLeftComponent(controllerPanel1);
        jSplitPane1.setRightComponent(agentPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChemCam_TestMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // Create and display the form
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChemCam_TestMain().setVisible(true);
                try{
                    agentPanel1.agentListenThread.start();
                    controllerPanel1.controllerListenThread.start();
                } 
		catch(Exception e){
                    System.out.println("Exception Starting Agent Thread: " + e);
                }               
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static chemCam_testMain.AgentPanel agentPanel1;
    private static chemCam_testMain.ControllerPanel controllerPanel1;
    private javax.swing.JSplitPane jSplitPane1;
    // End of variables declaration//GEN-END:variables
}