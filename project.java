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
import java.util.List;
import java.util.Map;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;



/**
 *
 * @author Isaac
 * Java Submission for OOProject, choosing the search engine for files.

In this file, i created a GUI that will show multiple outputs, and requires certain input from the user, for example the selection asks for the user to input, to be searched on the file system, and then they will be required to check and choose which files they would like too search the terms in.

I used J file chooser for my file choice class, this allows the user to select the directory and different types of folders, I then read the file in with a buffered reader input stream, which will read the line, line by line.

The app then asks for the user to input the searchable terms, When given a correct search term, the jarea box will output the matches found, and where matches where not mad that will also be highlighted.

In the background its also checking against each files to ensure the files content has what is desired to be searched.

The type of error checking is the try catches, and exception errors, this is in place to ensure the user inputs the right file, The right primitive data to be searched within the file, and if any errors arise it will let the user know through the application window

 */
public class SearchGUI extends javax.swing.JFrame{

    /**
     * Creates new form SearchGUI
     */
	private void filereading() {
		// TODO Auto-generated method stub
		// This J File choose will allow us too select what type of file we want to use
    	JFileChooser filechoose = new JFileChooser();
        filechoose.setMultiSelectionEnabled(true); // allows multi selection of files
        
        JTextArea area=new JTextArea();  // constructor for area jtext area
    
        // will set the scrolling pane on the jtext area, to allow for scrolling 
        JScrollPane pane = new JScrollPane(area);
        pane.setPreferredSize(new Dimension(500, 200)); // sets pane dimensions which are proportional too jarea 
        pane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // allows vertical scroll bar
        
        
        
        int section = filechoose.showOpenDialog(jLabel1); // this is for the open dialog selection, 
        if(section == JFileChooser.APPROVE_OPTION){
            File[] multiFile = filechoose.getSelectedFiles(); // this is putting the files into a multi file array which gets all selected files
            //jLabel5.setText("The File(s) " + multiFile +" Have been selected");
            String fileName = " "; // sets file name to empty string to be given a value
            long count = multiFile.length; // counts the number of files that are going to be uploaded
            //System.out.print("Number of files is" + count);
            for(File file: multiFile){ // for statement while file is MultiFIle we will start the buffered input reader
            	BufferedReader inputStream =null;
            	String liner; // This will be each line that is read in by the file reader.
            	String data = jTextField1.getText(); // will be the value that the user supplied data will be in, 
            	// starting the file buffered input stream
            	//Map<String, String> fileIndexer = new HashMap<String,String>();
            	
            		try {
            		inputStream = new BufferedReader(new FileReader(file)); // starts the file reading on the files
            		//System.out.print(multiFile[1]);
            		
            		
            		while((liner=inputStream.readLine()) != null) {
            		
            			String[] parts = liner.split(":");
            			//jLabel5.setText("File Contains" + liner);
            			//System.out.print(liner);
            			if(liner.contains(data)){ // if the liner is contained within the selected data append the jarea on the line
            				
            				//fileIndexer.put(file.getName(), file.getAbsolutePath());
							//System.out.print("Match Found in " +fileName);
            				
            				//textArea1.setText("Match Found in \n" + multiFile[0] + "\n on line"+liner);
            				textArea1.append("\n!Match Found in \n" +file +" On line: " + liner);
            				//textArea1.append("\nOn line: " + liner);
            			 
            				//System.out.print(fileIndexer);
            			}
            			else {
            				//System.out.print("No Match found in" +fileName);
            				
            				for (int i =0; i<count; i ++) {
            				   
            				textArea1.append("\n No match found in \n" + multiFile +" On line " + i);  
            				
            				}
            			}
            		}
            	}catch(IOException e) {
            		System.out.println(e); // catching system io exception errors
            	}
            	finally {
            		if(inputStream != null) {
            			try {
							inputStream.close(); // closing the stream when no data is to be read any more, aka when null
						} catch (IOException e) { // Printing stack and trace on error find for IO exception
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
            		}
            	}
             	/*try {
            		inputStream = new BufferedReader(new FileReader(multiFile[1]));
            		//System.out.print(multiFile[1]);
            		
            		
            		while((liner=inputStream.readLine()) != null) {
            			

            			if(liner.contains(data)){
            				fileIndexer.put(file.getName(), file.getAbsolutePath());
            				//System.out.print("success");
            				
            				//textArea1.setText("Match Found in \n" + multiFile[1] + "\n on line"+liner);
            				textArea1.append("\n!Match Found in \n" +multiFile[1] +" On line: "  + liner);
            				//textArea1.append("\nOn line" + liner);
							//System.out.print("Match Found in " +fileName);
            				//textArea1.setText("Match Found in \n" + multiFile[0] + "\n on line"+liner);   
            				//System.out.print(fileIndexer);
            			}
            			else {
            				
							
							//textArea1.append("\nNo match found in \n "+ multiFile[1]);							//System.out.print("No Match found in" +fileName);
            				textArea1.append("\nNo Match found in \n" +multiFile[1]);            				
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
            	*/
                fileName += file.getName() + ""; // setter for get name file atribute
                this.add(pane, BorderLayout.CENTER); // adds the area pane to center layout
            
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
        initComponents(); // Init of main component
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

    	// Classification of all java swing labels
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
        // setting the background, and close operations to exit on close, also allowing allways on top on
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(22, 242, 242));
        // sets font and text for the specific jlabels
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Java File Search Engine");
     // sets font and text for the specific jlabels
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Please Select the file(s) you would like too search");
     // sets font and text for the specific JBUTTONS
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Select File(s)");
        // ADDS an action listener to the java event for jbutton 1 to allow multi file chooser to be selected
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        // Action listener for tjext field action performed which is key entry and click of button
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Please enter the text");

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setText("Search for text");
        // Second action listener for jbutton 2 for searching purposes
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        // for setting the scroll panel on the jtextpane 1 
        jScrollPane1.setViewportView(jTextPane1);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        // sets the group layout for getting the content page 
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        // self generated GUI code for layout and placement with gaps and components added
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
        // vertical layout setup for javaswing with gaps and components for different allignments
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
        
    	filereading();    // will call on the file read function when button 1 is clicked, the search file function
        }                                       
                                     

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    	String data = jTextField1.getText();
    	// clasifies the data in the field and will use same function to search the program
    	
    	//jTextPane1.setText("The Term '" + data +"' Have been selected and will now be searched");
    	
    		
    	}                                     

    /**
     * @param args the command line arguments
     */
 // Refer to control, this is for demo purposes only
    public static void main(String args[]) {

        try {
        	// Auto generation for the Looks and feels class of java swing generated with nimbus java
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            // catches for class not found exceptions for the get name on search GUI classes
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

    // Variables declaration - do not modify this is for private variables to have handlers                    
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
