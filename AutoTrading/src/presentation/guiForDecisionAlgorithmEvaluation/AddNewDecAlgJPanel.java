/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AddNewDecAlgJPanel.java
 *
 * Created on Jun 24, 2011, 5:56:08 AM
 */

package presentation.guiForDecisionAlgorithmEvaluation;

import java.util.TreeMap;

import javax.swing.JDialog;

import presentation.ParameterJPanel;
import business.algorithm.decisionAlgorithm.AbstractDecisionAlgorithm;

/**
 *
 * @author Dinh
 */
public class AddNewDecAlgJPanel extends javax.swing.JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDialog parent;
    private boolean ok = false;

    public JDialog getParentDialog() {
        return parent;
    }

    public boolean isOk() {
        return ok;
    }

    /** Creates new form AddNewDecAlgJPanel */
    public AddNewDecAlgJPanel(JDialog jDialog) {
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

        decAlgJComboBox = new javax.swing.JComboBox();
        decAlgParametersContainerJPanel = new javax.swing.JPanel();
        cancelJButton = new javax.swing.JButton();
        okJButton = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Decision Algorithm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        decAlgJComboBox.setModel(new javax.swing.DefaultComboBoxModel(business.algorithm.decisionAlgorithm.DecisionAlgorithmAPI.decisionAlgorithmList));
        decAlgJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decAlgJComboBoxActionPerformed(evt);
            }
        });

        decAlgParametersContainerJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Parameter"));
        decAlgParametersContainerJPanel.setLayout(new java.awt.GridLayout(1, 0));

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(decAlgJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(okJButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelJButton))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(decAlgParametersContainerJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelJButton, okJButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(decAlgJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(decAlgParametersContainerJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okJButton)
                    .addComponent(cancelJButton)))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cancelJButton, okJButton});

    }// </editor-fold>//GEN-END:initComponents

    private void okJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okJButtonActionPerformed
        //Add new decision algorithm
        ok = true;

        decAlg = business.algorithm.decisionAlgorithm.DecisionAlgorithmAPI.getDecisionAlgorithm((String) decAlgJComboBox.getSelectedItem());

        //Add new prediction algorithm
        TreeMap<String, Object> valueMap = new TreeMap<String, Object>();
        for (String name : decAlg.getParameterList().keySet()) {
            valueMap.put(name, decAlgParameterJPanel.getValue(name));
        }
        decAlg.setParameterValue(valueMap);

        this.parent.dispose();
    }//GEN-LAST:event_okJButtonActionPerformed

    private void cancelJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelJButtonActionPerformed
        ok = false;
        this.parent.dispose();
    }//GEN-LAST:event_cancelJButtonActionPerformed

    private void decAlgJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decAlgJComboBoxActionPerformed
        decAlgParametersContainerJPanel.removeAll();
        decAlg = business.algorithm.decisionAlgorithm.DecisionAlgorithmAPI.getDecisionAlgorithm((String) decAlgJComboBox.getSelectedItem());
        decAlgParameterJPanel = new ParameterJPanel(decAlg.getParameterList());
        decAlgParametersContainerJPanel.add(decAlgParameterJPanel);
        decAlgParametersContainerJPanel.updateUI();
    }//GEN-LAST:event_decAlgJComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelJButton;
    private javax.swing.JComboBox decAlgJComboBox;
    private javax.swing.JPanel decAlgParametersContainerJPanel;
    private javax.swing.JButton okJButton;
    // End of variables declaration//GEN-END:variables

    private AbstractDecisionAlgorithm decAlg;
    private ParameterJPanel decAlgParameterJPanel;

    private void initOtherComponents() {
        decAlg = business.algorithm.decisionAlgorithm.DecisionAlgorithmAPI.getDecisionAlgorithm((String) decAlgJComboBox.getSelectedItem());
        decAlgParameterJPanel = new ParameterJPanel(decAlg.getParameterList());
        decAlgParametersContainerJPanel.add(decAlgParameterJPanel);
    }

    public AbstractDecisionAlgorithm getDecAlg() {
        return decAlg;
    }

}
