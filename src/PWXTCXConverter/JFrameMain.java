/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PWXTCXConverter;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author m336080
 */

public class JFrameMain extends javax.swing.JFrame {

    /**
     * Creates new form JFrameMain
     */
    public JFrameMain() {
        initComponents();
        //full screen size
        //this.setExtendedState(this.MAXIMIZED_BOTH);  
        //center of the screen
        this.setLocationRelativeTo(null);   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        FileChooser = new javax.swing.JFileChooser();
        jProgressBar1 = new javax.swing.JProgressBar();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuBar4 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        ButtonLoadFile = new javax.swing.JButton();
        TextFiledIn = new javax.swing.JTextField();
        TextFiledOut = new javax.swing.JTextField();
        ButtonConvert = new javax.swing.JButton();
        ButtonLoadFileOut = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar5 = new javax.swing.JMenuBar();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        FileChooser.setDialogTitle("Choose the file");

        jMenu4.setText("File");
        jMenuBar3.add(jMenu4);

        jMenu5.setText("Edit");
        jMenuBar3.add(jMenu5);

        jMenu6.setText("File");
        jMenuBar4.add(jMenu6);

        jMenu7.setText("Edit");
        jMenuBar4.add(jMenu7);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PWX->TCX Converter");
        setResizable(false);

        ButtonLoadFile.setText("Load PWX File ");
        ButtonLoadFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonLoadFileActionPerformed(evt);
            }
        });

        TextFiledIn.setEditable(false);

        TextFiledOut.setEditable(false);

        ButtonConvert.setText("Convert");
        ButtonConvert.setToolTipText("");
        ButtonConvert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonConvertActionPerformed(evt);
            }
        });

        ButtonLoadFileOut.setText("Path to TCX File");
        ButtonLoadFileOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonLoadFileOutActionPerformed(evt);
            }
        });

        jLabel1.setText("Please specify the PWX file to convert:");

        jLabel2.setText("Please specify the path where the new file will be created:");

        jMenu8.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Load PCX file");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Select the TCX file location");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem2);
        jMenu8.add(jSeparator1);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem3.setText("Exit");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem3);

        jMenuBar5.add(jMenu8);

        jMenu3.setText("Help");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("About");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuBar5.add(jMenu3);

        setJMenuBar(jMenuBar5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TextFiledIn)
                            .addComponent(TextFiledOut, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ButtonLoadFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ButtonLoadFileOut, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)))
                    .addComponent(jLabel2)
                    .addComponent(ButtonConvert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextFiledIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonLoadFile))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextFiledOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonLoadFileOut))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonConvert, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private String setfilenameout() {
        DateFormat dateFormat = new SimpleDateFormat("'sz'yyyyMMdd'.tcx'");
        Date date = new Date();
        String date_final=dateFormat.format(date);        
        return date_final;
    }
    private void ButtonLoadFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLoadFileActionPerformed
         
         FileNameExtensionFilter filter = new FileNameExtensionFilter("PWX Files", "pwx");            
         JFileChooser FileChooserIn = new JFileChooser();
         FileChooserIn.setFileFilter(filter);
        
        int returnVal = FileChooserIn.showOpenDialog(this);
            if (returnVal == FileChooserIn.APPROVE_OPTION) {                
                File file = FileChooserIn.getSelectedFile();
                TextFiledIn.setText(file.getAbsolutePath());
                GlobalClassFiles gcf = new GlobalClassFiles();
                gcf.FileIN=file.getAbsolutePath();
                //gcf.FileOut=
                //System.out.println(gcf.FileIN);
                //try {
                    //TextArea.read( new FileReader( file.getAbsolutePath() ), null );
                    
               // } catch (IOException ex) {
               //     System.out.println("problem accessing file"+file.getAbsolutePath());
               // }
            } else {
                System.out.println("File access cancelled by user.");
            }
    }//GEN-LAST:event_ButtonLoadFileActionPerformed

    private void ButtonConvertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonConvertActionPerformed
        GlobalClassFiles gcf = new GlobalClassFiles();        
        SampleDOM Sd = new SampleDOM();
        //do zmiany"
        //gcf.FileOut="c:\\testxml.xml";
        if ((gcf.FileIN.length()>0) & (gcf.FileOut.length()>0)) {
            Sd.sampledomrun(new File(gcf.FileIN), new File(gcf.FileOut));
        } else {
            JOptionPane.showMessageDialog(null,"Please choose the file to convert and path to the converted file.");
        }
    }//GEN-LAST:event_ButtonConvertActionPerformed

    private void ButtonLoadFileOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLoadFileOutActionPerformed
         //customization of FileChooser
         FileNameExtensionFilter filter = new FileNameExtensionFilter("TCX Files", "tcx");            
         JFileChooser FileChooserOut = new JFileChooser();
         FileChooserOut.setFileFilter(filter);
         //directory name when the new file will be created
         FileChooserOut.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);  
         int returnVal = FileChooserOut.showOpenDialog(this);
         if (returnVal == FileChooserOut.APPROVE_OPTION) {                
                String fn = setfilenameout();
                File file = FileChooserOut.getSelectedFile();
                TextFiledOut.setText(file.getAbsolutePath()+"\\"+fn);
                GlobalClassFiles gcf = new GlobalClassFiles();
                gcf.FileOut=file.getAbsolutePath()+"\\"+fn;
            } else {
                System.out.println("File access cancelled by user.");
            }        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonLoadFileOutActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        ButtonLoadFileActionPerformed(evt);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       ButtonLoadFileOutActionPerformed(evt);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
         System.exit(0); 
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
      jFrameAbout FrameAbout = new jFrameAbout();
      //this.setVisible(false);      
      FrameAbout.setVisible(true);        
    }//GEN-LAST:event_jMenuItem4ActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameMain().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonConvert;
    private javax.swing.JButton ButtonLoadFile;
    private javax.swing.JButton ButtonLoadFileOut;
    private javax.swing.JFileChooser FileChooser;
    private javax.swing.JTextField TextFiledIn;
    private javax.swing.JTextField TextFiledOut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JMenuBar jMenuBar5;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables

    boolean isVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
