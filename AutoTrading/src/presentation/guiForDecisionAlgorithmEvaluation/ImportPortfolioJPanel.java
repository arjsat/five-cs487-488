/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ImportPortfolioJPanel.java
 *
 * Created on Jun 23, 2011, 10:12:46 PM
 */

package presentation.guiForDecisionAlgorithmEvaluation;

import business.virtualTrading.PortfolioEntry;
import business.virtualTrading.User;
import dataAccess.databaseManagement.manager.PriceManager;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JDialog;
import presentation.guiForVirtualTrading.AddNewPortfolioJPanel;
import presentation.guiForVirtualTrading.PortfolioTableModel;

/**
 *
 * @author Dinh
 */
public class ImportPortfolioJPanel extends javax.swing.JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDialog parent = null;
    private User newUser;
    private Date currentDate;
    private ArrayList<PortfolioEntry> portfolioEntryList = new ArrayList<PortfolioEntry>();
    private boolean ok = false;
    private PriceManager priceManager = new PriceManager();

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        java.sql.Date date = new java.sql.Date(currentDate.getTime());
        while (!priceManager.isAvailableDate(date)) {
            date = priceManager.getNextDate(date);
        }

        this.currentDate = new Date(date.getTime());

        addNewPortfolioJPanel.setCurrentDate(date);
        currentDateJLabel.setText(date.toString());
    }


    /** Creates new form ImportPortfolioJPanel */
    public ImportPortfolioJPanel(JDialog jDialog) {
        this.parent = jDialog;
        initComponents();
        initOtherComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cashRemainJLabel = new javax.swing.JLabel();
        cashRemainJSpinner = new javax.swing.JSpinner();
        vndJLabel = new javax.swing.JLabel();
        portfolioJLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        portfolioJTable = new javax.swing.JTable();
        addJButton = new javax.swing.JButton();
        removeJButton = new javax.swing.JButton();
        cancelJButton = new javax.swing.JButton();
        okJButton = new javax.swing.JButton();
        currentDateJLabel = new javax.swing.JLabel();

        cashRemainJLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        cashRemainJLabel.setText("Cash Remain:");

        cashRemainJSpinner.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0d), null, null, Double.valueOf(100.0d)));

        vndJLabel.setText("x1000 VND");

        portfolioJLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        portfolioJLabel.setText("Portfolio:");

        portfolioJTable.setModel(new PortfolioTableModel());
        jScrollPane1.setViewportView(portfolioJTable);

        addJButton.setText("Add");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });

        removeJButton.setText("Remove");
        removeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeJButtonActionPerformed(evt);
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

        currentDateJLabel.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cashRemainJLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cashRemainJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vndJLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 270, Short.MAX_VALUE)
                                .addComponent(currentDateJLabel))
                            .addComponent(portfolioJLabel)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(removeJButton)
                            .addComponent(addJButton)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(411, Short.MAX_VALUE)
                        .addComponent(okJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelJButton)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addJButton, removeJButton});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelJButton, okJButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cashRemainJLabel)
                    .addComponent(cashRemainJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vndJLabel)
                    .addComponent(currentDateJLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(portfolioJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(removeJButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelJButton)
                    .addComponent(okJButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {addJButton, removeJButton});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cancelJButton, okJButton});

    }// </editor-fold>//GEN-END:initComponents

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed
        addNewPortfolioJPanel.getDialogParent().setVisible(true);

        if (!addNewPortfolioJPanel.isAdd()) {
            return;
        }
        PortfolioTableModel portfolioTableModel = (PortfolioTableModel) this.portfolioJTable.getModel();
        portfolioTableModel.addRow(addNewPortfolioJPanel.getPortfolioEntry());
        portfolioJTable.updateUI();

        portfolioEntryList.add(addNewPortfolioJPanel.getPortfolioEntry());
    }//GEN-LAST:event_addJButtonActionPerformed

    private void okJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okJButtonActionPerformed
        ok = true;
        //Add new user
        newUser = new User("",(Double)cashRemainJSpinner.getValue(), portfolioEntryList);
//        for (PortfolioEntry portfolioEntry : portfolioEntryList) {
//            newUser.addPortfolio(portfolioEntry);
//        }

        portfolioEntryList.clear();
        PortfolioTableModel portfolioTableModel = (PortfolioTableModel) this.portfolioJTable.getModel();
        portfolioTableModel.deleteAllData();

        this.parent.dispose();
    }//GEN-LAST:event_okJButtonActionPerformed

    private void cancelJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelJButtonActionPerformed
        ok = false;

        this.parent.dispose();
    }//GEN-LAST:event_cancelJButtonActionPerformed

    private void removeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeJButtonActionPerformed
        PortfolioTableModel portfolioTableModel = (PortfolioTableModel) this.portfolioJTable.getModel();
        portfolioTableModel.deleteRows(portfolioJTable.getSelectedRows());
        portfolioJTable.updateUI();
    }//GEN-LAST:event_removeJButtonActionPerformed

    public JDialog newAddNewPortfolioJDialog() {
        JDialog jDialog = new JDialog(parent, true);
        addNewPortfolioJPanel = new AddNewPortfolioJPanel(jDialog);
        jDialog.add(addNewPortfolioJPanel);
        jDialog.pack();
        return jDialog;
    }

    public User getNewUser() {
        return newUser;
    }

    public boolean isOk() {
        return ok;
    }

    public JDialog getParentDialog() {
        return parent;
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addJButton;
    private javax.swing.JButton cancelJButton;
    private javax.swing.JLabel cashRemainJLabel;
    private javax.swing.JSpinner cashRemainJSpinner;
    private javax.swing.JLabel currentDateJLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton okJButton;
    private javax.swing.JLabel portfolioJLabel;
    private javax.swing.JTable portfolioJTable;
    private javax.swing.JButton removeJButton;
    private javax.swing.JLabel vndJLabel;
    // End of variables declaration//GEN-END:variables

    private AddNewPortfolioJPanel addNewPortfolioJPanel;

    private void initOtherComponents() {
        newAddNewPortfolioJDialog();

    }
}
