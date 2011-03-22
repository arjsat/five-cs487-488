/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SettingPanel.java
 *
 * Created on Mar 21, 2011, 12:32:27 PM
 */

package autotrade.gui.panel;

import autotrade.core.AutoTrade;
import autotrade.core.AutoTradeLocalData;
import autotrade.core.User;
import autotrade.gui.MainFrame;
import java.util.Calendar;
import java.util.Date;
import javax.jws.soap.SOAPBinding.Use;
import javax.swing.JSpinner;

/**
 *
 * @author Dinh
 */
public class SettingPanel extends javax.swing.JPanel {

    private MainFrame mainFrame;

    /** Creates new form SettingPanel */
    public SettingPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        currentDatejSpinner = new javax.swing.JSpinner();
        numberOfDayjSpinner = new javax.swing.JSpinner();
        centerDateJSpinner = new javax.swing.JSpinner();
        saveJButton = new javax.swing.JButton();
        cancelJButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setText("Current Date:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setText("Number of Day: ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel3.setText("Center Date:");

        Date earliestDate = new Date(autotrade.core.AutoTrade.getEarliestTimeInDatabase());
        Date latestDate = new Date(autotrade.core.AutoTrade.getLatestTimeInDatabase());
        currentDatejSpinner.setModel(new javax.swing.SpinnerDateModel(AutoTradeLocalData.load().getCurrentDate(), earliestDate, latestDate, Calendar.DAY_OF_MONTH));
        currentDatejSpinner.setEditor(new JSpinner.DateEditor(currentDatejSpinner, "MM/dd/yyyy"));
        currentDatejSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                currentDatejSpinnerStateChanged(evt);
            }
        });

        numberOfDayjSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(AutoTradeLocalData.load().getNumber_of_day()), Integer.valueOf(0), null, Integer.valueOf(1)));

        Date earliestCenterDate = new Date(autotrade.core.AutoTrade.getEarliestTimeInDatabase());
        centerDateJSpinner.setModel(new javax.swing.SpinnerDateModel(AutoTradeLocalData.load().getCenter_date(), earliestCenterDate, AutoTradeLocalData.load().getCurrentDate(), Calendar.DAY_OF_MONTH));
        centerDateJSpinner.setEditor(new JSpinner.DateEditor(centerDateJSpinner, "MM/dd/yyyy"));

        saveJButton.setText("Save");
        saveJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveJButtonActionPerformed(evt);
            }
        });

        cancelJButton.setText("Cancel");
        cancelJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(currentDatejSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(centerDateJSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                            .addComponent(numberOfDayjSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(138, 138, 138)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(saveJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cancelJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(currentDatejSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveJButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(numberOfDayjSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelJButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(centerDateJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cancelJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelJButtonActionPerformed
        mainFrame.settingDialog.dispose();
    }//GEN-LAST:event_cancelJButtonActionPerformed

    private void saveJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveJButtonActionPerformed
        AutoTradeLocalData.load().setCurrentDate((Date)currentDatejSpinner.getValue());
        AutoTradeLocalData.load().setCenter_date((Date)centerDateJSpinner.getValue());
        AutoTradeLocalData.load().setNumber_of_day((Integer)numberOfDayjSpinner.getValue());
        mainFrame.settingDialog.dispose();
        mainFrame.dispose();
        User.LIST_ALL_USER = User.getAllUsers();
        MainFrame.main(null);
    }//GEN-LAST:event_saveJButtonActionPerformed

    private void currentDatejSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_currentDatejSpinnerStateChanged
        Calendar calendar = Calendar.getInstance();
        calendar.setTime((Date) currentDatejSpinner.getValue());
        centerDateJSpinner.setValue(calendar.getTime());
    }//GEN-LAST:event_currentDatejSpinnerStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelJButton;
    private javax.swing.JSpinner centerDateJSpinner;
    private javax.swing.JSpinner currentDatejSpinner;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSpinner numberOfDayjSpinner;
    private javax.swing.JButton saveJButton;
    // End of variables declaration//GEN-END:variables

}
