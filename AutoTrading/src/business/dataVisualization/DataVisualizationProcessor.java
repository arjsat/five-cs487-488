/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.dataVisualization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.TreeMap;

import org.jfree.chart.JFreeChart;

import business.algorithm.decisionAlgorithm.AbstractDecisionAlgorithm;
import business.algorithm.predictAlgorithm.AbstractPredictAlgorithm;
import dataAccess.databaseManagement.entity.AssetEntity;
import dataAccess.databaseManagement.entity.PriceEntity;
import dataAccess.databaseManagement.manager.PriceManager;

/**
 *
 * @author Dinh
 */
public class DataVisualizationProcessor {

    public static final ChartStyle[] CHART_STYLES = {new ChartStyle(LineChart.class), new ChartStyle(CandleStickChart.class)};
    private static PriceManager priceManager = new PriceManager();
    private AssetEntity asset;
    private Date fromDate;
    private Date toDate;
    private Date startPreDate;
    private ArrayList<AbstractPredictAlgorithm> preAlgList = new ArrayList<AbstractPredictAlgorithm>();
    private ArrayList<AbstractDecisionAlgorithm> decAlgList = new ArrayList<AbstractDecisionAlgorithm>();
    private VisulizationChart visualizationChart;
    private ArrayList<PriceEntity> prices;

    public DataVisualizationProcessor(AssetEntity asset, Date fromDate, Date toDate, ChartStyle chartStyle) {
        try {
            this.asset = asset;
            this.fromDate = fromDate;
            this.toDate = toDate;

            updatePricesList();

            visualizationChart = (VisulizationChart) chartStyle.getChartClass().newInstance();
            visualizationChart.initalChart();
            visualizationChart.setPrices(prices);
            visualizationChart.updateChart();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
    }

    private void updatePricesList() {
        prices = priceManager.getPriceInInterval(asset.getAssetID(), new java.sql.Date(fromDate.getTime()), new java.sql.Date(toDate.getTime()));
        Collections.sort(prices, new Comparator<PriceEntity>() {

            @Override
            public int compare(PriceEntity o1, PriceEntity o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        });
    }

    public void updateChartData() {
        updatePricesList();
        visualizationChart.setPrices(prices);

        TreeMap<AssetEntity, ArrayList<PriceEntity>> map = new TreeMap<AssetEntity, ArrayList<PriceEntity>>();
    	map.put(asset, prices);

        //update prediction algorithms
        {
        	
            visualizationChart.removeAllPredictionPrice();

            //add new results of Algorithms
            for (AbstractPredictAlgorithm preAlgo : preAlgList) {
            	preAlgo.setPriceEntityList(map);
                try {
					visualizationChart.addPredictionPrices(preAlgo, preAlgo.runAlgorithm().getPredictionPriceList().get(asset));
				} catch (Exception e) {
					e.printStackTrace();
				}
            }

        }

        //update decision algorithms
        {
            visualizationChart.removeAllOrders();

            for (AbstractDecisionAlgorithm decAlgo : decAlgList) {
            	decAlgo.setPriceList(map);
                visualizationChart.addOrders(decAlgo, decAlgo.runAlgorithm().getOrderList());
            }

        }

        visualizationChart.updateChart();
    }

    public void changeChartType(ChartStyle chartStyle) {
        try {
            visualizationChart = (VisulizationChart) chartStyle.getChartClass().newInstance();
            visualizationChart.initalChart();
            this.updateChartData();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
    }

    public void addDecAlg(AbstractDecisionAlgorithm abstractDecisionAlgorithm) {
        decAlgList.add(abstractDecisionAlgorithm);
        TreeMap<AssetEntity, ArrayList<PriceEntity>> map = new TreeMap<AssetEntity, ArrayList<PriceEntity>>();
    	map.put(asset, prices);
    	abstractDecisionAlgorithm.setPriceList(map);
        visualizationChart.addOrders(abstractDecisionAlgorithm, abstractDecisionAlgorithm.runAlgorithm().getOrderList());
        visualizationChart.updateChart();
    }

    public void removeDecAlg(AbstractDecisionAlgorithm abstractDecisionAlgorithm) {
        decAlgList.remove(abstractDecisionAlgorithm);
        visualizationChart.removeOrder(abstractDecisionAlgorithm);
        visualizationChart.updateChart();
    }

    public void removeAllDecAlg() {
        decAlgList.clear();
        visualizationChart.removeAllOrders();
        visualizationChart.updateChart();
    }

    public void addPreAlg(AbstractPredictAlgorithm abstractPredictAlgorithm) {
        preAlgList.add(abstractPredictAlgorithm);
        TreeMap<AssetEntity, ArrayList<PriceEntity>> map = new TreeMap<AssetEntity, ArrayList<PriceEntity>>();
    	map.put(asset, prices);
    	abstractPredictAlgorithm.setPriceEntityList(map);
        try {
			visualizationChart.addPredictionPrices(abstractPredictAlgorithm, abstractPredictAlgorithm.runAlgorithm().getPredictionPriceList().get(asset));
		} catch (Exception e) {
			e.printStackTrace();
		}
        visualizationChart.updateChart();
    }

    public void removePreAlg(AbstractPredictAlgorithm abstractPredictAlgorithm) {
        preAlgList.remove(abstractPredictAlgorithm);
        visualizationChart.removePredictionPrice(abstractPredictAlgorithm);
        visualizationChart.updateChart();
    }

    public void removeAllPreAlg() {
        preAlgList.clear();
        visualizationChart.removeAllPredictionPrice();
        visualizationChart.updateChart();
    }

    public ArrayList<AbstractDecisionAlgorithm> getDecAlgList() {
        return decAlgList;
    }

    public void setDecAlgList(ArrayList<AbstractDecisionAlgorithm> decAlg) {
        this.decAlgList = decAlg;
    }

    public ArrayList<AbstractPredictAlgorithm> getPreAlgList() {
        return preAlgList;
    }

    public void setPreAlgList(ArrayList<AbstractPredictAlgorithm> preAlg) {
        this.preAlgList = preAlg;
    }

    public AssetEntity getAsset() {
        return asset;
    }

    public void setAsset(AssetEntity asset) {
        this.asset = asset;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getStartPreDate() {
        return startPreDate;
    }

    public void setStartPreDate(Date startPreDate) {
        this.startPreDate = startPreDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public JFreeChart getChart() {
        return visualizationChart.getChart();
    }
}
