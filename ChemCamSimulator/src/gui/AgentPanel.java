/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import chemcam.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import org.json.simple.JSONObject;
/**
 *
 * @author truol014
 */
public class AgentPanel extends javax.swing.JPanel{
    private AgentRunnable agent;
    public RoverThread agentThread;
    public AgentPanel(){       
        initComponents();   
        try{
            agent = new AgentRunnable(9011){
                @Override
                public void run(){
                    try{
                        jTextArea1.append("Agent: Waiting for command\n");
                        getAgentSocket().openSocket();  
                        ObjectInputStream ois = new ObjectInputStream(getAgentSocket().getSocket().getInputStream());
                        ObjectOutputStream oos = new ObjectOutputStream(getAgentSocket().getSocket().getOutputStream());
                        while(true){
                            JSONObject message = (JSONObject)ois.readObject();
                            jTextArea1.append("Agent: Command Received from Controller\n" + message.toJSONString() + "\n");
                            if(message.toString().contains("Terminate")){
                                break;
                            }                            
                        }                        
                        jTextArea1.append("Agent: Shutting down Socket Agent!!\n");
                        ois.close();
                        oos.close();                        
                        closeAll(); 
                    } 
                    catch(IOException | ClassNotFoundException exception) {
                        jTextArea1.append("Exception: " + exception + "\n");
                    } 
                }
            };
        }
        catch(IOException socketException){
            jTextArea1.append("IOException on creating new socket: " + socketException + "\n");
        }
        agentThread = new RoverThread(agent, "Agent Thread");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        jTextArea1.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(51, 153, 0));
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}