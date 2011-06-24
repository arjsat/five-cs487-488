package business.dataUpdate.DataProcessor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

import business.dataUpdate.DataGetter.AbstractDataGetter;
import business.dataUpdate.DataGetter.Cophieu68DataGetter;
import business.dataUpdate.DataGetter.ParamForCophieu68DataGetter;

import dataAccess.databaseManagement.entity.AssetEntity;
import dataAccess.databaseManagement.entity.ExchangeEntity;
import dataAccess.databaseManagement.entity.PriceEntity;
import dataAccess.databaseManagement.manager.AssetManager;
import dataAccess.databaseManagement.manager.ExchangeManager;
import dataAccess.databaseManagement.manager.PriceManager;

import Utility.ParamList;

public class Cophieu68DataProcessor extends AbstractDataProcessor {

	private PriceManager priceManager = null;
	private AssetManager assetManager = null;
	
	public Cophieu68DataProcessor()
	{
		priceManager = new PriceManager();
		assetManager = new AssetManager();
	}
	
	@Override
	public boolean processData(ParamList parameter) {
		// TODO Auto-generated method stub
		
		double open, high, low, close;
		double volume;
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String strLine, symbol;
		//String date = dateFormat.format(parameter.getParamList().get(1));
		String date = dateFormat.format(((ParamForCophieu68DataProcessor)parameter).getDate());
		BufferedReader br = ((ParamForCophieu68DataProcessor)parameter).getBr();
		String[] splitString;
		try {
			// Open an output stream
			br.readLine();
			while ((strLine = br.readLine()) != null) {
				// strLine is one line of text; readLine() strips the newline
				// character(s)

				// Print a line of text
				splitString = strLine.split(",");
				if (splitString[1].contentEquals(date))
				{
					symbol = splitString[0];
					open = Double.valueOf(splitString[2]);
					high = Double.valueOf(splitString[3]);
					low = Double.valueOf(splitString[4]);
					close = Double.valueOf(splitString[5]);
					volume = Integer.valueOf(splitString[6]);
					ArrayList<AssetEntity> listAssets = assetManager.getAssetsBySymbol(symbol);
					PriceEntity priceEntity = null;
					if (listAssets.size() > 0)
						priceEntity = new PriceEntity(listAssets.get(0).getAssetID(), new java.sql.Date(new Date().getTime()), null, volume, close, open, high, low);
					else
						System.out.println(symbol);
					priceManager.add(priceEntity);
					
					for (int i = 0; i < splitString.length; i++)
						System.out.println(splitString[i]);	
				}
			}
		}
		// Catches any error conditions
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static boolean addExchangeMarketsAndAssetsToDatabase(String strFile)
	{
		String symbol, exchangemarket, companyname;
		 
		//create BufferedReader to read csv file
		BufferedReader br;
		try 
		{
			br = new BufferedReader( new FileReader(strFile));
		
			// TODO Auto-generated catch block
			String strLine = "";
			StringTokenizer st = null;
			//read comma separated file line by line
			AssetManager assetManager = new AssetManager();
			ExchangeManager exchangeManager = new ExchangeManager();
			exchangeManager.add(new ExchangeEntity("HOSE", 0.05));
			exchangeManager.add(new ExchangeEntity("HASTC", 0.07));
			ExchangeEntity hose = null;
			ExchangeEntity hastc = null;
			hose = exchangeManager.getExchangeByName("HOSE");
			hastc = exchangeManager.getExchangeByName("HASTC");
			while( (strLine = br.readLine()) != null)
			{
				//break comma separated line using ","
				st = new StringTokenizer(strLine, ",");
				symbol = "";
				exchangemarket = "";
				companyname = "";
				int numOfTokens = st.countTokens();
				for (int i = 0; i < numOfTokens; ++i)
				{
					if (i == 0)
						symbol = st.nextToken();
					else if (i == 1)
						exchangemarket = st.nextToken();
					else if (i == 2)
						companyname = st.nextToken();
				}
				System.out.println(symbol + " " + exchangemarket + " " + companyname);
				if (exchangemarket.equals("HOSE"))
					assetManager.add(new AssetEntity(companyname, symbol, hose.getExchangeID(), "", 0.05));
				else
					assetManager.add(new AssetEntity(companyname, symbol, hastc.getExchangeID(), "", 0.07));
			}
			br.close();
			/*
			 * add VNINDEX and HASTC INDEX to asset table
			 * */
			AssetEntity vnIndex = new AssetEntity("VNINDEX", "VNINDEX", hose.getExchangeID(), "VNINDEX", 0.05);
			AssetEntity HASTC_index = new AssetEntity("HASTCIndex", "HASTCINDEX", hastc.getExchangeID(), "HASTCINDEX", 0.07);
			assetManager.add(vnIndex);
			assetManager.add(HASTC_index);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public static boolean updateHistoricalDataFromFile(String fileName, String exchangeName)
	{
		String strLine = "";
		StringTokenizer st = null;
		DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
		String symbol = "";
		String strDate = "";
		Date date = new Date();
		double open = 0;
		double close = 0;
		double high = 0;
		double low = 0;
		double volume = 0;
		
		PriceManager priceManager = new PriceManager();
		AssetManager assetManager = new AssetManager();
		AssetEntity assetEntity = null;
		try
		{
		//read comma separated file line by line
			BufferedReader br = new BufferedReader( new FileReader(fileName));
			strLine = br.readLine();
			while( (strLine = br.readLine()) != null)
			{
				//break comma separated line using ","
				st = new StringTokenizer(strLine, ",");
				int numOfTokens = st.countTokens();
				for (int i = 0; i < numOfTokens; ++i)
				{
					if (i == 0)
					{	
						symbol = st.nextToken();
						assetEntity = assetManager.getAssetBySymbolAndExchange(symbol, exchangeName);
					}
					else if (i == 1)
					{
						strDate = st.nextToken();
						date = dateformat.parse(strDate);
					}
					else if (i == 2)
						open = Double.parseDouble(st.nextToken());
					else if (i == 3)
						high = Double.parseDouble(st.nextToken());
					else if (i == 4)
						low = Double.parseDouble(st.nextToken());
					else if (i == 5)
						close = Double.parseDouble(st.nextToken());
					else if (i == 6)
						volume = Double.parseDouble(st.nextToken());
				}
				//System.out.println(symbol + " " + String.valueOf(date) + " " + String.valueOf(open) + " " + String.valueOf(high) + " " + String.valueOf(low) + " " + String.valueOf(close) + " " + String.valueOf(volume));
				PriceEntity priceEntity = new PriceEntity(assetEntity.getAssetID(), new java.sql.Date(date.getTime()), null, volume, close, open, high, low);
				priceManager.add(priceEntity);
			}
			
			br.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public static boolean updateDataFromSpecificDate(Date date)
	{	
		Date currentDate = new Date();
		if (date.after(currentDate))
			return false;
		
		AbstractDataGetter dataGetter = new Cophieu68DataGetter();
		AbstractDataProcessor dataProcessor = new Cophieu68DataProcessor();
		while (date.before(currentDate))
		{
			dataProcessor.processData(dataGetter.getData(new ParamForCophieu68DataGetter(date)));
			date = Utility.Utility.increaseDate(date);
		}
		return true;
	}
	
	public static void main(String args[])
	{
		//addExchangeMarketsAndAssetsToDatabase("company.csv");
		//updateHistoricalDataFromFile("HOSE.csv", "HOSE");
		//updateHistoricalDataFromFile("HASTC.csv", "HASTC");
		/*
		AbstractDataGetter dataGetter = new Cophieu68DataGetter();
		AbstractDataProcessor dataProcessor = new Cophieu68DataProcessor();
		dataProcessor.processData(dataGetter.getData(new ParamForCophieu68DataGetter(new Date(2011, 6, 12))));
		*/
		
		
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = null;
		try 
		{
			date = dateFormat.parse("20110607");
		} 
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		updateDataFromSpecificDate(date);
		
	}
}