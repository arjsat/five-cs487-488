/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PredictionAlgorithmEvaluationJPanel.java
 *
 * Created on Jun 23, 2011, 4:41:06 PM
 */

package presentation.guiForPredictionAlgorithmEvaluation;

import java.util.Calendar;
import java.util.Date;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import layout.TableLayout;

import org.jfree.chart.ChartPanel;

import presentation.ComboKeyHandler;
import presentation.mainJFrame;
import presentation.guiForDecisionAlgorithmEvaluation.CriteriaOutputJPanel;
import business.algorithm.predictAlgorithm.AbstractPredictAlgorithm;
import business.dataVisualization.chart.ChartStyle;
import business.dataVisualization.chart.VisulizationChart;
import business.dataVisualization.dataProcessing.DataVisualizationProcessor;
import business.predictionAlgorithmEvaluation.PredictionCriteria;
import dataAccess.databaseManagement.entity.AssetEntity;
import dataAccess.databaseManagement.entity.ExchangeEntity;

/**
 * 
 * @author Dinh
 */
public class PredictionAlgorithmEvaluationJPanel extends javax.swing.JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Creates new form PredictionAlgorithmEvaluationJPanel */
	public PredictionAlgorithmEvaluationJPanel() {
		initComponents();
		initOtherComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateJPanel = new javax.swing.JPanel();
        startPredictDateJLabel = new javax.swing.JLabel();
        startPredictionDateJSpinner = new javax.swing.JSpinner();
        algorithmjPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        preAlgsJList = new javax.swing.JList();
        addPreAlgjButton = new javax.swing.JButton();
        removePreAlgjButton = new javax.swing.JButton();
        evaluationCriteriaJPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        preEvaCrisJList = new javax.swing.JList();
        addPreEvaCriteriajButton = new javax.swing.JButton();
        removePreEvaCriteriajButton = new javax.swing.JButton();
        comparisonTableJPanel = new javax.swing.JPanel();
        tableJPanel = new javax.swing.JPanel();
        refreshJButton = new javax.swing.JButton();
        visualizationChartJPanel = new javax.swing.JPanel();
        symbolOptionJPanel = new javax.swing.JPanel();
        assetJLabel = new javax.swing.JLabel();
        assetJComboBox = new javax.swing.JComboBox();
        fromJLabel = new javax.swing.JLabel();
        fromDateJSpinner = new javax.swing.JSpinner();
        toDateJLabel = new javax.swing.JLabel();
        toDateJSpinner = new javax.swing.JSpinner();
        exchangeJLabel = new javax.swing.JLabel();
        exchangeJComboBox = new javax.swing.JComboBox();
        chartStyleJLabel = new javax.swing.JLabel();
        charStyleJComboBox = new javax.swing.JComboBox();
        refreshJButton1 = new javax.swing.JButton();
        chartContainerJPanel = new javax.swing.JPanel();

        dateJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        startPredictDateJLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        startPredictDateJLabel.setText("Start Prediction:");

        startPredictionDateJSpinner.setModel(new javax.swing.SpinnerDateModel());
        startPredictionDateJSpinner.setEditor(new JSpinner.DateEditor(startPredictionDateJSpinner, "MM/dd/yyyy"));
        startPredictionDateJSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                startPredictionDateJSpinnerStateChanged(evt);
            }
        });

        javax.swing.GroupLayout dateJPanelLayout = new javax.swing.GroupLayout(dateJPanel);
        dateJPanel.setLayout(dateJPanelLayout);
        dateJPanelLayout.setHorizontalGroup(
            dateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dateJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(startPredictDateJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(startPredictionDateJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        dateJPanelLayout.setVerticalGroup(
            dateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dateJPanelLayout.createSequentialGroup()
                .addGroup(dateJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startPredictDateJLabel)
                    .addComponent(startPredictionDateJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        algorithmjPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PREDICTION ALGORITHM", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        preAlgsJList.setModel(new DefaultListModel());
        jScrollPane1.setViewportView(preAlgsJList);

        addPreAlgjButton.setText("Add");
        addPreAlgjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPreAlgjButtonActionPerformed(evt);
            }
        });

        removePreAlgjButton.setText("Remove");
        removePreAlgjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePreAlgjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout algorithmjPanelLayout = new javax.swing.GroupLayout(algorithmjPanel);
        algorithmjPanel.setLayout(algorithmjPanelLayout);
        algorithmjPanelLayout.setHorizontalGroup(
            algorithmjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(algorithmjPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(algorithmjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addPreAlgjButton)
                    .addComponent(removePreAlgjButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        algorithmjPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addPreAlgjButton, removePreAlgjButton});

        algorithmjPanelLayout.setVerticalGroup(
            algorithmjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(algorithmjPanelLayout.createSequentialGroup()
                .addComponent(addPreAlgjButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removePreAlgjButton))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        algorithmjPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {addPreAlgjButton, removePreAlgjButton});

        evaluationCriteriaJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PREDICTION EVALUATION CRITERIA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        preEvaCrisJList.setModel(new DefaultListModel());
        jScrollPane3.setViewportView(preEvaCrisJList);

        addPreEvaCriteriajButton.setText("Add");
        addPreEvaCriteriajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPreEvaCriteriajButtonActionPerformed(evt);
            }
        });

        removePreEvaCriteriajButton.setText("Remove");
        removePreEvaCriteriajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePreEvaCriteriajButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout evaluationCriteriaJPanelLayout = new javax.swing.GroupLayout(evaluationCriteriaJPanel);
        evaluationCriteriaJPanel.setLayout(evaluationCriteriaJPanelLayout);
        evaluationCriteriaJPanelLayout.setHorizontalGroup(
            evaluationCriteriaJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(evaluationCriteriaJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(evaluationCriteriaJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addPreEvaCriteriajButton)
                    .addComponent(removePreEvaCriteriajButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        evaluationCriteriaJPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addPreEvaCriteriajButton, removePreEvaCriteriajButton});

        evaluationCriteriaJPanelLayout.setVerticalGroup(
            evaluationCriteriaJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(evaluationCriteriaJPanelLayout.createSequentialGroup()
                .addComponent(addPreEvaCriteriajButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removePreEvaCriteriajButton))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        evaluationCriteriaJPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {addPreEvaCriteriajButton, removePreEvaCriteriajButton});

        comparisonTableJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "COMPARISON TABLE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        javax.swing.GroupLayout tableJPanelLayout = new javax.swing.GroupLayout(tableJPanel);
        tableJPanel.setLayout(tableJPanelLayout);
        tableJPanelLayout.setHorizontalGroup(
            tableJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 809, Short.MAX_VALUE)
        );
        tableJPanelLayout.setVerticalGroup(
            tableJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout comparisonTableJPanelLayout = new javax.swing.GroupLayout(comparisonTableJPanel);
        comparisonTableJPanel.setLayout(comparisonTableJPanelLayout);
        comparisonTableJPanelLayout.setHorizontalGroup(
            comparisonTableJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(comparisonTableJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(comparisonTableJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(refreshJButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tableJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        comparisonTableJPanelLayout.setVerticalGroup(
            comparisonTableJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(comparisonTableJPanelLayout.createSequentialGroup()
                .addComponent(refreshJButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tableJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        visualizationChartJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CHART", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        assetJLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        assetJLabel.setText("Asset:");

        assetJComboBox.setEditable(true);
        assetJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assetJComboBoxActionPerformed(evt);
            }
        });

        fromJLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        fromJLabel.setText("From:");

        fromDateJSpinner.setModel(new javax.swing.SpinnerDateModel());
        fromDateJSpinner.setEditor(new JSpinner.DateEditor(fromDateJSpinner, "MM/dd/yyyy"));
        fromDateJSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                fromDateJSpinnerStateChanged(evt);
            }
        });

        toDateJLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        toDateJLabel.setText("To:");

        toDateJSpinner.setModel(new javax.swing.SpinnerDateModel());
        toDateJSpinner.setEditor(new JSpinner.DateEditor(toDateJSpinner, "MM/dd/yyyy"));
        toDateJSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                toDateJSpinnerStateChanged(evt);
            }
        });

        exchangeJLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        exchangeJLabel.setText("Exchange:");

        exchangeJComboBox.setEditable(true);
        exchangeJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exchangeJComboBoxActionPerformed(evt);
            }
        });

        chartStyleJLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        chartStyleJLabel.setText("Chart Style:");

        charStyleJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        charStyleJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                charStyleJComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout symbolOptionJPanelLayout = new javax.swing.GroupLayout(symbolOptionJPanel);
        symbolOptionJPanel.setLayout(symbolOptionJPanelLayout);
        symbolOptionJPanelLayout.setHorizontalGroup(
            symbolOptionJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(symbolOptionJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(exchangeJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exchangeJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(assetJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(assetJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(fromJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fromDateJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(toDateJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toDateJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(chartStyleJLabel)
                .addGap(18, 18, 18)
                .addComponent(charStyleJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        symbolOptionJPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {fromDateJSpinner, toDateJSpinner});

        symbolOptionJPanelLayout.setVerticalGroup(
            symbolOptionJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(symbolOptionJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(symbolOptionJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exchangeJLabel)
                    .addComponent(exchangeJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(assetJLabel)
                    .addComponent(assetJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fromJLabel)
                    .addComponent(fromDateJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toDateJLabel)
                    .addComponent(toDateJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chartStyleJLabel)
                    .addComponent(charStyleJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        refreshJButton1.setText("Refresh");
        refreshJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButton1ActionPerformed(evt);
            }
        });

        chartContainerJPanel.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout visualizationChartJPanelLayout = new javax.swing.GroupLayout(visualizationChartJPanel);
        visualizationChartJPanel.setLayout(visualizationChartJPanelLayout);
        visualizationChartJPanelLayout.setHorizontalGroup(
            visualizationChartJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(visualizationChartJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(visualizationChartJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chartContainerJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE)
                    .addComponent(refreshJButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(symbolOptionJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        visualizationChartJPanelLayout.setVerticalGroup(
            visualizationChartJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(visualizationChartJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(refreshJButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chartContainerJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(symbolOptionJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(dateJPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(algorithmjPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(evaluationCriteriaJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comparisonTableJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(visualizationChartJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dateJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(algorithmjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(evaluationCriteriaJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(visualizationChartJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(comparisonTableJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents

	private void addPreAlgjButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_addPreAlgjButtonActionPerformed
		addNewPreAlgJPanel.getParentDialog().setVisible(true);

		if (!addNewPreAlgJPanel.isOk()) {
			return;
		}

		AbstractPredictAlgorithm preAlgo = addNewPreAlgJPanel.getPreAlg();
		DefaultListModel model = (DefaultListModel) this.preAlgsJList
				.getModel();
		model.addElement(preAlgo);

		dataVisualizationProcessor.addPreAlg(preAlgo);
	}// GEN-LAST:event_addPreAlgjButtonActionPerformed

	private void removePreAlgjButtonActionPerformed(
			java.awt.event.ActionEvent evt) {// GEN-FIRST:event_removePreAlgjButtonActionPerformed
		DefaultListModel model = (DefaultListModel) this.preAlgsJList
				.getModel();
		int[] selectedIndices = preAlgsJList.getSelectedIndices();
		int j = 0;

		for (int i : selectedIndices) {
			AbstractPredictAlgorithm preAlgo = (AbstractPredictAlgorithm) preAlgsJList
					.getModel().getElementAt(i);
			dataVisualizationProcessor.removePreAlg(preAlgo);
			model.remove(i - j);
			++j;
		}

		preAlgsJList.updateUI();
	}// GEN-LAST:event_removePreAlgjButtonActionPerformed

	private void addPreEvaCriteriajButtonActionPerformed(
			java.awt.event.ActionEvent evt) {// GEN-FIRST:event_addPreEvaCriteriajButtonActionPerformed
		addNewPreEvaCriteriaJPanel.getParentDialog().setVisible(true);

		if (!addNewPreEvaCriteriaJPanel.isOk()) {
			return;
		}

		DefaultListModel model = (DefaultListModel) this.preEvaCrisJList
				.getModel();
		model.addElement(addNewPreEvaCriteriaJPanel.getPredictionCriteria());
	}// GEN-LAST:event_addPreEvaCriteriajButtonActionPerformed

	private void removePreEvaCriteriajButtonActionPerformed(
			java.awt.event.ActionEvent evt) {// GEN-FIRST:event_removePreEvaCriteriajButtonActionPerformed
		DefaultListModel model = (DefaultListModel) this.preEvaCrisJList
				.getModel();
		int[] selectedIndices = preEvaCrisJList.getSelectedIndices();
		int j = 0;
		for (int i : selectedIndices) {
			model.remove(i - j);
			++j;
		}
		preEvaCrisJList.updateUI();
	}// GEN-LAST:event_removePreEvaCriteriajButtonActionPerformed

	private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_refreshJButtonActionPerformed
		updateComparisonTable();
	}// GEN-LAST:event_refreshJButtonActionPerformed

	private void assetJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_assetJComboBoxActionPerformed
		if (assetJComboBox.getSelectedIndex() == -1) {
			return;
		}

		dataVisualizationProcessor.setAsset((AssetEntity) assetJComboBox
				.getSelectedItem());
		dataVisualizationProcessor.updateChartData();
	}// GEN-LAST:event_assetJComboBoxActionPerformed

	private void fromDateJSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {// GEN-FIRST:event_fromDateJSpinnerStateChanged
		if (fromDateJSpinner.getValue() == null
				|| dataVisualizationProcessor == null) {
			return;
		}

		dataVisualizationProcessor.setFromDate((Date) fromDateJSpinner
				.getValue());
		dataVisualizationProcessor.updateChartData();
	}// GEN-LAST:event_fromDateJSpinnerStateChanged

	private void toDateJSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {// GEN-FIRST:event_toDateJSpinnerStateChanged
		if (toDateJSpinner.getValue() == null
				|| dataVisualizationProcessor == null) {
			return;
		}

		dataVisualizationProcessor.setToDate((Date) toDateJSpinner.getValue());
		dataVisualizationProcessor.updateChartData();
	}// GEN-LAST:event_toDateJSpinnerStateChanged

	private void exchangeJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_exchangeJComboBoxActionPerformed
		if (exchangeJComboBox.getSelectedIndex() == -1) {
			return;
		}

		assetJComboBox.setModel(new javax.swing.DefaultComboBoxModel(
				mainJFrame.mappingExchangeID_Assets
						.get((ExchangeEntity) exchangeJComboBox
								.getSelectedItem())));
		assetComboKeyHandler.updateListObjects();
		assetJComboBox.setSelectedIndex(0);
	}// GEN-LAST:event_exchangeJComboBoxActionPerformed

	private void charStyleJComboBoxActionPerformed(
			java.awt.event.ActionEvent evt) {// GEN-FIRST:event_charStyleJComboBoxActionPerformed
		dataVisualizationProcessor
				.changeChartType((ChartStyle) charStyleJComboBox
						.getSelectedItem());
		jFreeChartPanel.setChart(dataVisualizationProcessor.getChart());
	}// GEN-LAST:event_charStyleJComboBoxActionPerformed

	private void refreshJButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_refreshJButton1ActionPerformed
		dataVisualizationProcessor.updateChartData();
	}// GEN-LAST:event_refreshJButton1ActionPerformed

	private void startPredictionDateJSpinnerStateChanged(
			javax.swing.event.ChangeEvent evt) {// GEN-FIRST:event_startPredictionDateJSpinnerStateChanged
		startPreDate = (Date) startPredictionDateJSpinner.getValue();
		if (dataVisualizationProcessor == null) {
			return;
		}
		dataVisualizationProcessor.setStartPreDate(startPreDate);
		dataVisualizationProcessor.updateChartData();
	}// GEN-LAST:event_startPredictionDateJSpinnerStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPreAlgjButton;
    private javax.swing.JButton addPreEvaCriteriajButton;
    private javax.swing.JPanel algorithmjPanel;
    private javax.swing.JComboBox assetJComboBox;
    private javax.swing.JLabel assetJLabel;
    private javax.swing.JComboBox charStyleJComboBox;
    private javax.swing.JPanel chartContainerJPanel;
    private javax.swing.JLabel chartStyleJLabel;
    private javax.swing.JPanel comparisonTableJPanel;
    private javax.swing.JPanel dateJPanel;
    private javax.swing.JPanel evaluationCriteriaJPanel;
    private javax.swing.JComboBox exchangeJComboBox;
    private javax.swing.JLabel exchangeJLabel;
    private javax.swing.JSpinner fromDateJSpinner;
    private javax.swing.JLabel fromJLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList preAlgsJList;
    private javax.swing.JList preEvaCrisJList;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JButton refreshJButton1;
    private javax.swing.JButton removePreAlgjButton;
    private javax.swing.JButton removePreEvaCriteriajButton;
    private javax.swing.JLabel startPredictDateJLabel;
    private javax.swing.JSpinner startPredictionDateJSpinner;
    private javax.swing.JPanel symbolOptionJPanel;
    private javax.swing.JPanel tableJPanel;
    private javax.swing.JLabel toDateJLabel;
    private javax.swing.JSpinner toDateJSpinner;
    private javax.swing.JPanel visualizationChartJPanel;
    // End of variables declaration//GEN-END:variables

	private AddNewPreAlgJPanel addNewPreAlgJPanel;
	private AddNewPreEvaCriteriaJPanel addNewPreEvaCriteriaJPanel;
	private DataVisualizationProcessor dataVisualizationProcessor;
	private ComboKeyHandler exchangeComboKeyHandler;
	private ComboKeyHandler assetComboKeyHandler;

	private Date startPreDate;
	private ChartPanel jFreeChartPanel;

	private JDialog newAddPreAlgJDialog() {
		JDialog jDialog = new JDialog(mainJFrame.mainFrame, true);
		addNewPreAlgJPanel = new AddNewPreAlgJPanel(jDialog);
		jDialog.add(addNewPreAlgJPanel);
		jDialog.pack();
		return jDialog;
	}

	private JDialog newAddPreEvaCriteriaJDialog() {
		JDialog jDialog = new JDialog(mainJFrame.mainFrame, true);
		addNewPreEvaCriteriaJPanel = new AddNewPreEvaCriteriaJPanel(jDialog);
		jDialog.add(addNewPreEvaCriteriaJPanel);
		jDialog.pack();
		return jDialog;
	}

	private void initOtherComponents() {
		Calendar now = Calendar.getInstance();
		now.add(Calendar.DATE, -7);
		startPredictionDateJSpinner.setValue(now.getTime());
		now.add(Calendar.DATE, 7);
		toDateJSpinner.setValue(now.getTime());
		now.add(Calendar.MONTH, -6);
		fromDateJSpinner.setValue(now.getTime());

		// if (DataVisualizationJPanel.mappingExchangeID_Assets == null) {
		// DataVisualizationJPanel.mappingExchangeID_Assets = new
		// TreeMap<ExchangeEntity, Object[]>();
		// ArrayList<ExchangeEntity> listAllExchangeEntitys = (new
		// ExchangeManager()).getAllExchanges();
		// for (ExchangeEntity exchangeEntity : listAllExchangeEntitys) {
		// ArrayList<AssetEntity> listAssets = (new
		// AssetManager()).getAssetsByExchange(exchangeEntity.getExchangeID());
		// DataVisualizationJPanel.mappingExchangeID_Assets.put(exchangeEntity,
		// listAssets.toArray());
		// }
		// }

		charStyleJComboBox.setModel(new DefaultComboBoxModel(
				VisulizationChart.CHART_STYLES));

		exchangeJComboBox.setModel(new DefaultComboBoxModel(
				mainJFrame.mappingExchangeID_Assets.keySet().toArray()));
		exchangeComboKeyHandler = new ComboKeyHandler(exchangeJComboBox);
		JTextField fieldExchange = (JTextField) exchangeJComboBox.getEditor()
				.getEditorComponent();
		fieldExchange.addKeyListener(exchangeComboKeyHandler);

		assetJComboBox.setModel(new DefaultComboBoxModel(
				mainJFrame.mappingExchangeID_Assets
						.get((ExchangeEntity) exchangeJComboBox
								.getSelectedItem())));
		assetComboKeyHandler = new ComboKeyHandler(assetJComboBox);
		JTextField fieldSymbol = (JTextField) assetJComboBox.getEditor()
				.getEditorComponent();
		fieldSymbol.addKeyListener(assetComboKeyHandler);

		dataVisualizationProcessor = new DataVisualizationProcessor(
				(AssetEntity) assetJComboBox.getSelectedItem(),
				(Date) fromDateJSpinner.getValue(),
				(Date) toDateJSpinner.getValue(),
				(ChartStyle) charStyleJComboBox.getSelectedItem());
		startPreDate = (Date) startPredictionDateJSpinner.getValue();
		dataVisualizationProcessor.setStartPreDate(startPreDate);

		jFreeChartPanel = new ChartPanel(dataVisualizationProcessor.getChart());
		chartContainerJPanel.add(jFreeChartPanel);

		newAddPreAlgJDialog();
		newAddPreEvaCriteriaJDialog();
	}

	private void updateComparisonTable() {

		// create table layout
		double size[][] = new double[2][];
		size[0] = new double[preEvaCrisJList.getModel().getSize() + 1];
		for (int i = 0; i < size[0].length; ++i) {
			size[0][i] = TableLayout.PREFERRED;
		}

		size[1] = new double[preAlgsJList.getModel().getSize() + 1];
		for (int i = 0; i < size[1].length; ++i) {
			size[1][i] = TableLayout.PREFERRED;
		}

		tableJPanel.removeAll();
		tableJPanel.setLayout(new TableLayout(size));

		// add components
		for (int i = 1; i < size[0].length; ++i) {
			JLabel jLabel = new JLabel(preEvaCrisJList.getModel()
					.getElementAt(i - 1).toString());
			jLabel.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
			jLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
			jLabel.setBorder(javax.swing.BorderFactory
					.createLineBorder(new java.awt.Color(0, 0, 0)));
			tableJPanel.add(jLabel, i + ", 0");
		}

		for (int i = 1; i < size[1].length; ++i) {
			JLabel jLabel = new JLabel(preAlgsJList.getModel()
					.getElementAt(i - 1).toString());
			jLabel.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
			jLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
			jLabel.setBorder(javax.swing.BorderFactory
					.createLineBorder(new java.awt.Color(0, 0, 0)));
			tableJPanel.add(jLabel, "0, " + i);
		}

		// evaluation alg
		DefaultListModel algListModel = (DefaultListModel) preAlgsJList
				.getModel();
		DefaultListModel criteriaListModel = (DefaultListModel) preEvaCrisJList
				.getModel();
		for (int criteriaIndex = 0; criteriaIndex < size[0].length - 1; ++criteriaIndex) {
			for (int algIndex = 0; algIndex < size[1].length - 1; ++algIndex) {
				try {
					TreeMap<String, Double> output = new TreeMap<String, Double>();
					PredictionCriteria curPreCriteria = (PredictionCriteria) criteriaListModel
							.getElementAt(criteriaIndex);
					AbstractPredictAlgorithm curPreAlg = (AbstractPredictAlgorithm) algListModel
							.getElementAt(algIndex);

					curPreCriteria.setParametersValue(curPreAlg.runAlgorithm().getOutputValue());
					/*curPreCriteria.setParametersValue(PredictionCriteria
							.toParamOfPredictionCriteria(
									(AssetEntity) assetJComboBox
											.getSelectedItem(),
									new java.sql.Date(startPreDate.getTime()),
									curPreAlg.runAlgorithm()));*/
					output = curPreCriteria.evaluate();
					CriteriaOutputJPanel criteriaOutputJPanel = new CriteriaOutputJPanel(
							output);
					criteriaOutputJPanel.setBorder(javax.swing.BorderFactory
							.createLineBorder(new java.awt.Color(0, 0, 0)));
					tableJPanel.add(criteriaOutputJPanel, (criteriaIndex + 1)
							+ ", " + (algIndex + 1));
				} catch (Exception ex) {
					Logger.getLogger(
							PredictionAlgorithmEvaluationJPanel.class.getName())
							.log(Level.SEVERE, null, ex);
				}
			}
		}

		tableJPanel.updateUI();
	}

}
