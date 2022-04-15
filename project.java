package searchEngine;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;



/**
 *
 * @author Isaac
 */
public class SearchGUI extends javax.swing.JFrame{

    /**
     * Creates new form SearchGUI
     */
	private void filesearching() {
		
		
		
	}
	private void filereading() {
		// TODO Auto-generated method stub
    	JFileChooser filechoose = new JFileChooser();
        filechoose.setMultiSelectionEnabled(true);
        
       // TextArea TextArea = new TextArea();
		//System.out.print("Match Found in " +fileName);
        JTextArea area=new JTextArea();  
    

        JScrollPane pane = new JScrollPane(area);
        pane.setPreferredSize(new Dimension(500, 200));
        pane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        
        
        int section = filechoose.showOpenDialog(jLabel1);
        if(section == JFileChooser.APPROVE_OPTION){
            File[] multiFile = filechoose.getSelectedFiles();
            String fileName = " ";
            long count = multiFile.length;
            //System.out.print("Number of files is" + count);
            for(File file: multiFile){
            	BufferedReader inputStream =null;
            	String liner;
            	String data = jTextField1.getText();
            	Map<String, String> fileIndexer = new HashMap<String,String>();
            		try {
            		inputStream = new BufferedReader(new FileReader(multiFile[0]));
            		//System.out.print(multiFile[1]);
            		
            		
            		while((liner=inputStream.readLine()) != null) {
            			
            			/*char[] arrline = new char[liner.length()];
            			
            			for(i =0; i< liner.length(); i++) {
            				arrline[i] = liner.charAt(i);
            				
            			}//
            			/*for(char c : arrline) {
            				System.out.print(c);
            			}*/
            			//String[] parts = liner.split(":");
            			//jLabel5.setText("File Contains" + liner);
            			//System.out.print(liner);
            			if(liner.contains(data)){
            				
            				//fileIndexer.put(file.getName(), file.getAbsolutePath());
            				//JTextArea jTextArea = new JTextArea();
							//System.out.print("Match Found in " +fileName);
            				
            				//textArea1.setText("Match Found in \n" + multiFile[0] + "\n on line"+liner);
            				textArea1.append("Match Found in \n" +multiFile[0] + textArea1.getText());
            			 
            				//System.out.print(fileIndexer);
            			}
            			else {
            				//System.out.print("No Match found in" +fileName);
            				   
            				textArea1.setText("No match found in \n" + multiFile[0]);  
            			}
            		}
            	}catch(IOException e) {
            		System.out.println(e);
            	}
            	finally {
            		if(inputStream != null) {
            			try {
							inputStream.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
            		}
            	}
             	try {
            		inputStream = new BufferedReader(new FileReader(multiFile[1]));
            		//System.out.print(multiFile[1]);
            		
            		
            		while((liner=inputStream.readLine()) != null) {
            			

            			if(liner.contains(data)){
            				fileIndexer.put(file.getName(), file.getAbsolutePath());
            				//System.out.print("success");
            				
            				//textArea1.setText("Match Found in \n" + multiFile[1] + "\n on line"+liner);
            				textArea1.append("Match Found in \n" +multiFile[1] + textArea1.getText());
							//System.out.print("Match Found in " +fileName);
            				//textArea1.setText("Match Found in \n" + multiFile[0] + "\n on line"+liner);   
            				//System.out.print(fileIndexer);
            			}
            			else {
            				
							
							textArea1.setText("No match found in \n "+ multiFile[1]);							//System.out.print("No Match found in" +fileName);
            				//textArea.setText("No Match found in\n" +multiFile[0]);            				
            			}
            		}
            	}catch(IOException e) {
            		System.out.println(e);
            	}
            	finally {
            		if(inputStream != null) {
            			try {
							inputStream.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
            		}
            	}
            	
                fileName += file.getName() + "";
                this.add(pane, BorderLayout.CENTER);
            
            jLabel5.setText("The File(s) " + fileName +" Have been selected");
        }}//k
        else{
            jLabel5.setText("Canceled open");
 
            }
}
	


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    public SearchGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        textArea1 = new java.awt.TextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(22, 242, 242));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Java File Search Engine");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Please Select the file(s) you would like too search");

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Select File(s)");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Please enter the text");

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setText("Search for text");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jTextPane1);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(148, 148, 148)
                                        .addComponent(jLabel1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(138, 138, 138)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel2)))
                                .addGap(7, 7, 7)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton2)
                                        .addGap(8, 8, 8)))))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(textArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(27, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jButton1))
                    .addGap(12, 12, 12)
                    .addComponent(jLabel4)
                    .addGap(27, 27, 27)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2))
                    .addGap(44, 44, 44)
                    .addComponent(textArea1, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel3)
                    .addContainerGap())
            );

        pack();
    }// </editor-fold>                      

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // Jfile chooser activate 
        
    	filereading();   
        }                                       

	private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    	// the input of the text will be here
    }                                           

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    	String data = jTextField1.getText();
    	
    	//jTextPane1.setText("The Term '" + data +"' Have been selected and will now be searched");
    	
    		
    	}                                     

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SearchGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    protected javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    protected javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextPane jTextPane1;
    private java.awt.TextArea textArea1;
    // End of variables declaration                   
}
