/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AddNewUserJPanel.java
 *
 * Created on Jun 8, 2011, 12:39:21 PM
 */
package presentation.guiForVirtualTrading;

import business.virtualTrading.User;
import javax.swing.JDialog;

/**
 *
 * @author Dinh
 */
public class AddNewUserJPanel extends javax.swing.JPanel {

    private JDialog parent = null;
    private User newUser;
    private boolean add = false;

    public boolean isAdd() {
        return add;
    }

    public User getNewUser() {
        return newUser;
    }

    /** Creates new form AddNewUserJPanel */
    public AddNewUserJPanel(JDialog jDialog) {
        this.parent = jDialog;
        initComponents();
        initOtherComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userNameJLabel = new javax.swing.JLabel();
        userNameJTextField = new javax.swing.JTextField();
        cashRemainJLabel = new javax.swing.JLabel();
        cashRemainJSpinner = new javax.swing.JSpinner();
        vndJLabel = new javax.swing.JLabel();
        portfolioJLabel = new javax.swing.JLabel();
        addPortfolioEntryJButton = new javax.swing.JButton();
        removePortfolioEntryJButton = new javax.swing.JButton();
        cancelJButton = new javax.swing.JButton();
        okJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        portfolioJTable = new javax.swing.JTable();

        userNameJLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        userNameJLabel.setText("User Name:");

        cashRemainJLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        cashRemainJLabel.setText("Cash Remain:");

        cashRemainJSpinner.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0d), null, null, Double.valueOf(100.0d)));

        vndJLabel.setText("x1000 VND");

        portfolioJLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        portfolioJLabel.setText("User Portfolio:");

        addPortfolioEntryJButton.setText("Add");
        addPortfolioEntryJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPortfolioEntryJButtonActionPerformed(evt);
            }
        });

        removePortfolioEntryJButton.setText("Remove");
        removePortfolioEntryJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePortfolioEntryJButtonActionPerformed(evt);
            }
        });

        cancelJButton.setText("Cancel");
        cancelJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelJButtonActionPerformed(evt);
            }
        });

        okJButton.setText("OK");
        okJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okJButtonActionPerformed(evt);
            }
        });

        portfolioJTable.setModel(new PortfolioTableModel());
        jScrollPane1.setViewportView(portfolioJTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(userNameJLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(cashRemainJLabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cashRemainJSpinner)
                            .addComponent(userNameJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vndJLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(portfolioJLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addPortfolioEntryJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(removePortfolioEntryJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(407, Short.MAX_VALUE)
                .addComponent(okJButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelJButton)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addPortfolioEntryJButton, removePortfolioEntryJButton});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelJButton, okJButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userNameJLabel)
                    .addComponent(userNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cashRemainJLabel)
                    .addComponent(cashRemainJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vndJLabel))
                .addGap(18, 18, 18)
                .addComponent(portfolioJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addPortfolioEntryJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(removePortfolioEntryJButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelJButton)
                    .addComponent(okJButton))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {addPortfolioEntryJButton, removePortfolioEntryJButton});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cancelJButton, okJButton});

    }// </editor-fold>//GEN-END:initComponents

    private void okJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okJButtonActionPerformed
        add = true;

        //Add new user
        newUser.addCash((Double)cashRemainJSpinner.getValue());
        newUser.setName(userNameJTextField.getText());

        //Add user to database
        newUser.add();
        newUser.addPortfolioToDatabase();

        this.parent.dispose();
    }//GEN-LAST:event_okJButtonActionPerformed

    private void cancelJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelJButtonActionPerformed
        add = false;
        this.parent.dispose();
    }//GEN-LAST:event_cancelJButtonActionPerformed

    private void addPortfolioEntryJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPortfolioEntryJButtonActionPerformed
        addNewPortfolioJPanel.getDialogParent().setVisible(true);

        if (!addNewPortfolioJPanel.isAdd()) {
            return;
        }
        PortfolioTableModel portfolioTableModel = (PortfolioTableModel) this.portfolioJTable.getModel();
        portfolioTableModel.addRow(addNewPortfolioJPanel.getPortfolioEntry());
        portfolioJTable.updateUI();

        newUser.addPortfolio(addNewPortfolioJPanel.getPortfolioEntry());
    }//GEN-LAST:event_addPortfolioEntryJButtonActionPerformed

    private void removePortfolioEntryJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removePortfolioEntryJButtonActionPerformed
        PortfolioTableModel portfolioTableModel = (PortfolioTableModel) this.portfolioJTable.getModel();
        portfolioTableModel.deleteRows(portfolioJTable.getSelectedRows());
        portfolioJTable.updateUI();
    }//GEN-LAST:event_removePortfolioEntryJButtonActionPerformed

    public JDialog newAddNewPortfolioJDialog() {
        JDialog jDialog = new JDialog(parent, true);
        addNewPortfolioJPanel = new AddNewPortfolioJPanel(jDialog);
        jDialog.add(addNewPortfolioJPanel);
        jDialog.pack();
        return jDialog;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPortfolioEntryJButton;
    private javax.swing.JButton cancelJButton;
    private javax.swing.JLabel cashRemainJLabel;
    private javax.swing.JSpinner cashRemainJSpinner;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton okJButton;
    private javax.swing.JLabel portfolioJLabel;
    private javax.swing.JTable portfolioJTable;
    private javax.swing.JButton removePortfolioEntryJButton;
    private javax.swing.JLabel userNameJLabel;
    private javax.swing.JTextField userNameJTextField;
    private javax.swing.JLabel vndJLabel;
    // End of variables declaration//GEN-END:variables

    private AddNewPortfolioJPanel addNewPortfolioJPanel;

    private void initOtherComponents() {
        newAddNewPortfolioJDialog();

        newUser = new User("", 0);
    }

    public JDialog getParentDialog() {
        return this.parent;
    }
}
