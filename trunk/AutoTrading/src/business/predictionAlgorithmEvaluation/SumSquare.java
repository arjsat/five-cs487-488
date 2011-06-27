package business.predictionAlgorithmEvaluation;

import java.sql.Date;
import java.util.ArrayList;

import dataAccess.databaseManagement.entity.PriceEntity;
import dataAccess.databaseManagement.manager.PriceManager;

public class SumSquare extends PredictionCriteria{


	@Override
	public double evaluate() {
		long vnIndexID = 1;
		PriceManager priceManager = new PriceManager();
		Date beginDate = new java.sql.Date(priceList.getPriceList().get(0).getDate().getTime());
		Date endDate = new java.sql.Date(priceList.getPriceList().get(0).getDate().getTime());
		ArrayList<PriceEntity> realPrice = priceManager.getPriceInInterval(vnIndexID, beginDate, endDate);
		double sum = 0;
		double t;
		for (int i = 0; i < priceList.getPriceList().size(); i++) {
			t = (priceList.getPriceList().get(i).getPrice() - realPrice.get(i).getClose());
			sum += t * t;
		}
		
		// TODO Auto-generated method stub
		return sum;
	}

}
