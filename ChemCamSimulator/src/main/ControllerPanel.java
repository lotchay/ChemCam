/*
 * @author Loc Truong
 */
package main;
import json.Command;
import chemcam.*;
import java.io.*;
import java.util.*;
import com.google.gson.*;
import javax.swing.JOptionPane;
public class ControllerPanel extends javax.swing.JPanel{
    int AgentPort = 9111;
    int ControllerPort = 9011;
    public RoverThread controllerListenThread;
    private RoverThread controllerConnectThread;
    public ControllerPanel(){
        ControllerRunnable controller = null;
        initComponents();        
        try{
            controller = new ControllerRunnable(ControllerPort){
                @Override
                public void run(){
                    try{
                        while(true){
                            jTextArea1.append("Controller - Server Thread: Waiting for report.\n");
                            getRunnableServerSocket().openSocket();
                            ObjectInputStream ois = new ObjectInputStream(getRunnableServerSocket().getSocket().getInputStream());
                            ObjectOutputStream oos = new ObjectOutputStream(getRunnableServerSocket().getSocket().getOutputStream());  
                            String jsonString = (String)ois.readObject();
                            if(!jsonString.isEmpty()){
                                jTextArea1.append("Controller - Server Thread: Report recieved from Agent.\n");
                                jTextArea1.append("Controller - Server Thread: Storing report to database.\n");
                                // TO_DO
                            }
                            ois.close();
                            oos.close();
                        }
                    } 
                    catch(IOException | ClassNotFoundException exception) {
                        Utils.log("Exception: " + exception + "\n");
                    }
                }
            };
        }
        catch(IOException socketException){
            Utils.log("IOException on creating new socket: " + socketException + "\n");
        }
        controllerListenThread = new RoverThread(controller, "Controller Server Thread");
        jTextArea2.setText("Command Sequence:\n");
    }
    public RoverThread getControllerListenThread(){
        return controllerListenThread;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton3 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jSplitPane1.setDividerSize(2);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select A Command", "CCAM_POWER_ON", "CCAM_COOLER_ON", "CCAM_LASER_ON", "CCAM_CWL_WARM", "CCAM_SET_FOCUS", "CCAM_LIBS_WARM", "CCAM_FIRE_LASER", "CCAM_LASER_OFF", "CCAM_COOLER_OFF", "CCAM_POWER_OFF" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Send");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jCheckBox1.setText("High Priority");

        jButton3.setText("Load");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(2, 2, 2)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addContainerGap(105, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jCheckBox1)
                    .addComponent(jButton3))
                .addGap(9, 9, 9))
        );

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane3)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(jPanel1);

        jTextArea1.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(51, 153, 0));
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jSplitPane1.setRightComponent(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
    }// </editor-fold>//GEN-END:initComponents
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jTextArea2.setText("Command Sequence:\n");
    }//GEN-LAST:event_jButton1ActionPerformed
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String command = jComboBox1.getSelectedItem().toString();
        if(!command.equals("Select A Command") && !jTextArea2.getText().contains(command)){
            switch(command){
                case "CCAM_POWER_OFF":
                    if(!jTextArea2.getText().contains("CCAM_POWER_ON")){
                        JOptionPane.showMessageDialog(null, "Chemical Camera's Power is not ON!", "Add Command Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    else if(jTextArea2.getText().contains("CCAM_COOLER_ON") && !jTextArea2.getText().contains("CCAM_COOLER_OFF")){
                        JOptionPane.showMessageDialog(null, "Chemical Camera's Cooler needs to be turned OFF before turning OFF Power!", "Add Command Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    else if(jTextArea2.getText().contains("CCAM_LASER_ON") && !jTextArea2.getText().contains("CCAM_LASER_OFF")){
                        JOptionPane.showMessageDialog(null, "Chemical Camera's Laser needs to be turned OFF before turning OFF Power", "Add Command Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    else{
                        jTextArea2.append(command + "\n");
                    }
                    break;
                case "CCAM_COOLER_ON":
                    if(!jTextArea2.getText().contains("CCAM_POWER_ON")){
                        JOptionPane.showMessageDialog(null, "Chemical Camera's Power is not ON!", "Add Command Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    else if(jTextArea2.getText().contains("CCAM_POWER_OFF")){
                        JOptionPane.showMessageDialog(null, "Chemical Camera's Power is already OFF!", "Add Command Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    else{
                        jTextArea2.append(command + "\n");
                    }
                    break;
                case "CCAM_COOLER_OFF":
                    if(!jTextArea2.getText().contains("CCAM_POWER_ON")){
                        JOptionPane.showMessageDialog(null, "Chemical Camera's Power is not ON!", "Add Command Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    else if(jTextArea2.getText().contains("CCAM_POWER_OFF")){
                        JOptionPane.showMessageDialog(null, "Chemical Camera's Power is already OFF!", "Add Command Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    else if(!jTextArea2.getText().contains("CCAM_COOLER_ON")){
                        JOptionPane.showMessageDialog(null, "Chemical Camera's Cooler is not ON!", "Add Command Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    else{
                        jTextArea2.append(command + "\n");
                    }
                    break;
                case "CCAM_LASER_ON":
                    if(!jTextArea2.getText().contains("CCAM_POWER_ON")){
                        JOptionPane.showMessageDialog(null, "Chemical Camera's Power is not ON!", "Add Command Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    else if(jTextArea2.getText().contains("CCAM_POWER_OFF")){
                        JOptionPane.showMessageDialog(null, "Chemical Camera's Power is already OFF!", "Add Command Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    else{
                        jTextArea2.append(command + "\n");
                    }
                    break;
                case "CCAM_LASER_OFF":
                    if(!jTextArea2.getText().contains("CCAM_POWER_ON")){
                        JOptionPane.showMessageDialog(null, "Chemical Camera's Power is not ON!", "Add Command Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    else if(jTextArea2.getText().contains("CCAM_POWER_OFF")){
                        JOptionPane.showMessageDialog(null, "Chemical Camera's Power is already OFF!", "Add Command Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    else if(!jTextArea2.getText().contains("CCAM_LASER_ON")){
                        JOptionPane.showMessageDialog(null, "Chemical Camera's Laser is not ON!", "Add Command Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    else{
                        jTextArea2.append(command + "\n");
                    }
                    break;
                case "CCAM_CWL_WARM":
                    if(!jTextArea2.getText().contains("CCAM_POWER_ON")){
                        JOptionPane.showMessageDialog(null, "Chemical Camera's Power is not ON!", "Add Command Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    else if(jTextArea2.getText().contains("CCAM_POWER_OFF")){
                        JOptionPane.showMessageDialog(null, "Chemical Camera's Power is already OFF!", "Add Command Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    else{
                        jTextArea2.append(command + "\n");
                    }
                    break;
                case "CCAM_LIBS_WARM":
                    if(!jTextArea2.getText().contains("CCAM_POWER_ON")){
                        JOptionPane.showMessageDialog(null, "Chemical Camera's Power is not ON!", "Add Command Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    else if(jTextArea2.getText().contains("CCAM_POWER_OFF")){
                        JOptionPane.showMessageDialog(null, "Chemical Camera's Power is already OFF!", "Add Command Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    else{
                        jTextArea2.append(command + "\n");
                    }
                    break;
                case "CCAM_SET_FOCUS":
                    if(!jTextArea2.getText().contains("CCAM_POWER_ON")){
                        JOptionPane.showMessageDialog(null, "Chemical Camera's Power is not ON!", "Add Command Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    else if(jTextArea2.getText().contains("CCAM_POWER_OFF")){
                        JOptionPane.showMessageDialog(null, "Chemical Camera's Power is already OFF!", "Add Command Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    else if(!jTextArea2.getText().contains("CCAM_CWL_WARM")){
                        JOptionPane.showMessageDialog(null, "Chemical Camera's Continuous-Wave Laser is not Warmed Up!", "Add Command Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    else{
                        jTextArea2.append(command + "\n");
                    }
                    break;
                case "CCAM_FIRE_LASER":
                    if(!jTextArea2.getText().contains("CCAM_POWER_ON")){
                        JOptionPane.showMessageDialog(null, "Chemical Camera's Power is not ON!", "Add Command Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    else if(jTextArea2.getText().contains("CCAM_POWER_OFF")){
                        JOptionPane.showMessageDialog(null, "Chemical Camera's Power is already OFF!", "Add Command Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    else if(!jTextArea2.getText().contains("CCAM_COOLER_ON")){
                        JOptionPane.showMessageDialog(null, "Chemical Camera's Cooler is not ON!", "Add Command Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    else if(jTextArea2.getText().contains("CCAM_COOLER_OFF")){
                        JOptionPane.showMessageDialog(null, "Chemical Camera's Cooler is already OFF!", "Add Command Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    else if(!jTextArea2.getText().contains("CCAM_LASER_ON")){
                        JOptionPane.showMessageDialog(null, "Chemical Camera's Laser is not ON!", "Add Command Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    else if(jTextArea2.getText().contains("CCAM_LASER_OFF")){
                        JOptionPane.showMessageDialog(null, "Chemical Camera's Laser is already OFF!", "Add Command Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    else if(!jTextArea2.getText().contains("CCAM_SET_FOCUS")){
                        JOptionPane.showMessageDialog(null, "Chemical Camera's Focus is not Set!", "Add Command Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    else if(!jTextArea2.getText().contains("CCAM_LIBS_WARM")){
                        JOptionPane.showMessageDialog(null, "Chemical Camera's Laser-Induced Breakdown Spectroscopy is not Warmed Up!", "Add Command Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    else{
                        jTextArea2.append(command + "\n");
                    }
                    break;                    
                default:
                    jTextArea2.append(command + "\n");
                    break;
            }
        }
        else{
            // To do
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String[] commandList = jTextArea2.getText().split("\n");
        ArrayList<Command> sendList = new ArrayList<>();
        ControllerRunnable controller = null;
        boolean send = true;
        for(int i = 0; i < commandList.length; i++){
            if(send){
                switch(commandList[i]){
                    case "Command Sequence:":
                        break;
                    case "CCAM_POWER_ON":
                        if(!jTextArea2.getText().contains("CCAM_POWER_OFF")){
                            JOptionPane.showMessageDialog(null, "Chemical Camera's Power is not going to be turned OFF!", "Add Command Error", JOptionPane.ERROR_MESSAGE);
                            send = false;
                            break;
                        }
                        else{
                            Command cmd = new Command(i, commandList[i]);
                            sendList.add(cmd);
                            break;
                        }
                    case "CCAM_COOLER_ON":
                        if(!jTextArea2.getText().contains("CCAM_COOLER_OFF")){
                            JOptionPane.showMessageDialog(null, "Chemical Camera's Cooler is not going to be turned OFF!", "Add Command Error", JOptionPane.ERROR_MESSAGE);
                            send = false;
                            break;
                        }
                        else{
                            Command cmd = new Command(i, commandList[i]);
                            sendList.add(cmd);
                            break;
                        }
                    case "CCAM_LASER_ON":
                        if(!jTextArea2.getText().contains("CCAM_LASER_OFF")){
                            JOptionPane.showMessageDialog(null, "Chemical Camera's Laser is not going to be turned OFF!", "Add Command Error", JOptionPane.ERROR_MESSAGE);
                            send = false;
                            break;
                        }
                        else{
                            Command cmd = new Command(i, commandList[i]);
                            sendList.add(cmd);
                            break;
                        }
                    default:
                        Command cmd = new Command(i, commandList[i]);
                        sendList.add(cmd);
                        break;
                }
            }
            else{
                break;
            }
        }
        if(sendList.isEmpty()){
            JOptionPane.showMessageDialog(null, "There is no command to send!", "Add Command Error", JOptionPane.ERROR_MESSAGE);
        }
        if(send){
            Gson sendJSON = new Gson();
            final String jsonString = sendJSON.toJson(sendList);
            try{
                controller = new ControllerRunnable(AgentPort, null){
                    @Override
                    public void run(){
                        try{
                            ObjectOutputStream oos = new ObjectOutputStream(getRunnableSocket().getSocket().getOutputStream());
                            ObjectInputStream ois = new ObjectInputStream(getRunnableSocket().getSocket().getInputStream());
                            RoverThread.sleep(2000);
                            jTextArea1.append("Controller - Client Thread: Sending command to Agent\n");
                            oos.writeObject(jsonString);
                            RoverThread.sleep(1000);
                            ois.close();
                            oos.close(); 
                            closeAllRunnable();
                        }
                        catch(InterruptedException | IOException exception){
                            Utils.log("Exception: " + exception + "\n");
                        }
                    }
                };
            }
            catch(IOException socketException){
                Utils.log("Exception on creating new socket: " + socketException + "\n");
            }
            controllerConnectThread = new RoverThread(controller, "Controller Client Thread");
            controllerConnectThread.start();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(new File("src/data/commands.txt").getAbsoluteFile()));
        }
        catch(FileNotFoundException exception){
            Utils.log("Exception: " + exception + "\n");
        }
        if(br != null){
            String line;
            try{
                while((line = br.readLine()) != null){
                    jTextArea2.append(line+"\n");
                }
                br.close();
            }
            catch(IOException exception){
                Utils.log("Exception: " + exception + "\n");
            }
        }
        else{
            Utils.log("Failed to read from file. Should not be here...\n");
        }
    }//GEN-LAST:event_jButton3ActionPerformed
    
    

    
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
