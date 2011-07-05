/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * parameterJPanel.java
 *
 * Created on Jun 24, 2011, 6:23:51 PM
 */
package presentation.guiForDataVisualization;

import java.util.Date;
import java.util.TreeMap;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;

import layout.TableLayout;

/**
 *
 * @author Dinh
 */
public class ParameterJPanel extends javax.swing.JPanel {

    private TreeMap<String, Class> parameterList;
    private TreeMap<String, JComponent> componentList;

    /** Creates new form parameterJPanel */
    public ParameterJPanel(TreeMap<String, Class> parameterList) {
        this.parameterList = parameterList;
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 114, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 121, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    private void initOtherComponents() {

        //create table layout
        int borderLeft = 10;
        int borderTop = 10;
        int spaceBetweenColumns = 15;
        int spaceBetweenRows = 10;
        double size[][] = new double[2][];

        //column
        int columnInputSize = 80;
        size[0] = new double[4];
        size[0][0] = borderLeft;
        size[0][1] = TableLayout.PREFERRED;
        size[0][2] = spaceBetweenColumns;
        size[0][3] = columnInputSize;

        //row
        size[1] = new double[parameterList.size()*2 + 1];
        size[1][0] = borderTop;
        for (int i = 1; i+1 < size[1].length; i+=2) {
            size[1][i] = TableLayout.PREFERRED;
            size[1][i+1] = spaceBetweenRows;
        }

        this.setLayout(new TableLayout(size));

        //add components
        componentList = new TreeMap<String, JComponent>();
        int i = 1;
        for (String parameterName : parameterList.keySet()) {
            JLabel jLabel = new JLabel(parameterName + ":");
            this.add(jLabel, "1, " + i);

            if (parameterList.get(parameterName) == Date.class) {
                JSpinner jSpinner = new JSpinner(new SpinnerDateModel());
                jSpinner.setEditor(new JSpinner.DateEditor(jSpinner, "MM/dd/yyyy"));
                componentList.put(parameterName, jSpinner);
            } else if (parameterList.get(parameterName).getSuperclass() == Number.class) {
                JSpinner jSpinner = null;
                
                if (parameterList.get(parameterName) == Integer.class) {
                    jSpinner = new JSpinner(new SpinnerNumberModel(Integer.valueOf(0), null, null,Integer.valueOf(1)));
                } else if (parameterList.get(parameterName) == Double.class) {
                    jSpinner = new JSpinner(new SpinnerNumberModel(Double.valueOf(0), null, null,Double.valueOf(0.1)));
                }
                
                componentList.put(parameterName, jSpinner);
            } else if (parameterList.get(parameterName) == String.class) {
                JTextField jTextField = new JTextField();
                componentList.put(parameterName, jTextField);
            }

            if (componentList.get(parameterName) != null) {
                this.add(componentList.get(parameterName), "3, " + i);
            }

            i += 2;
        }

    }

    public Object getValue(String parameterName) {
        if (parameterList.get(parameterName) == Date.class
                || parameterList.get(parameterName).getSuperclass() == Number.class) {
            JSpinner jSpinner = (JSpinner) componentList.get(parameterName);
            return jSpinner.getValue();
        } else if (parameterList.get(parameterName) == String.class) {
            JTextField jTextField = (JTextField) componentList.get(parameterName);
            return jTextField.getText();
        }
        return null;
    }

    public boolean setValue(String parameterName, Object value) {
        if (parameterList.get(parameterName) == Date.class
                || parameterList.get(parameterName).getSuperclass() == Number.class) {
            JSpinner jSpinner = (JSpinner) componentList.get(parameterName);
            jSpinner.setValue(value);
            return true;
        } else if (parameterList.get(parameterName) == String.class) {
            JTextField jTextField = (JTextField) componentList.get(parameterName);
            jTextField.setText((String) value);
            return true;
        }
        
        return false;
    }
}
