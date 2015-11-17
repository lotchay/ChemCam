/*
 * @author Loc Truong
 */
package main;
import chemcam.*;
import java.io.*;
import org.json.simple.JSONObject;

public class AgentPanel extends javax.swing.JPanel{
    public RoverThread agentListenThread;
    
    public AgentPanel(){ 
        AgentRunnable agent = null;
        initComponents();   
        try{
            agent = new AgentRunnable(9011){
                @Override
                public void run(){
                    try{
                        while(true){
                            jTextArea1.append("Agent1 - Server Thread: Waiting for command.\n");
                            getRunnableServerSocket().openSocket();
                            ObjectInputStream ois = new ObjectInputStream(getRunnableServerSocket().getSocket().getInputStream());
                            ObjectOutputStream oos = new ObjectOutputStream(getRunnableServerSocket().getSocket().getOutputStream());                          
                            JSONObject commandsList = (JSONObject)ois.readObject();
                            if(commandsList.containsKey("Terminate")){
                                jTextArea1.append("Agent1 - Server Thread: Shutdown Command Received from Controller.\n");
                                jTextArea1.append("Agent1 - Server Thread: Shutting Down.\n");
                                break;
                            }
                            else{
                                jTextArea1.append("Agent1 - Server Thread: Commands Received from Controller.\n");
                                jTextArea1.append(commandsList + "\n");
                                jTextArea1.append("Agent1 - Server Thread: Work is Being Processed.\n");
                                executeCommands(commandsList);
                            }
                            ois.close();
                            oos.close();                            
                        }
                        closeAllRunnable();
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
        agentListenThread = new RoverThread(agent, "Agent Server Thread");
    }
    private void executeCommands(JSONObject commandsList) throws FileNotFoundException{
        // TO_DO
        JSONObject report = new JSONObject();
        int length = commandsList.size();
        System.out.println(length);
        BufferedReader br = new BufferedReader(new FileReader(new File("src/data/command_data.txt").getAbsoluteFile()));
       	String line = null;
        
	   
	   
   	 try {
			while((line = br.readLine()) != null) {
				jTextArea1.append(line+"\n");
				for(int i = 1; i <= length; i++){
					   commandsList.get(i);
				   }

			 }
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   

   	
	   
        
        
    } 
    public RoverThread getAgentListenThread(){
        return agentListenThread;
    }
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
