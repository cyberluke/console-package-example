package com.banking.service;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import com.banking.model.Package;

public class DisplayService implements Runnable {
	private static final DecimalFormat df3 = new DecimalFormat("0.000");

	private boolean displayWithFee;
	
	public DisplayService(boolean displayWithFee) {
		this.displayWithFee = displayWithFee;
	}

	public void run() {
		while (true) {
			try {
				TimeUnit.MINUTES.sleep(1);
				Map<String, Double> dataMap = buildDataMap(DataService.getData());
				displayData(dataMap);
			} catch (InterruptedException e) {
				System.exit(0);
			}
		}
	}

	public static Map<String, Double> buildDataMap(List<Package> initialData) {
		Map<String, Double> dataMap = new HashMap<String, Double>();
		for (Package p : initialData) {
			if (dataMap.containsKey(p.getPostalCode())) {
				dataMap.put(p.getPostalCode(), dataMap.get(p.getPostalCode()) + p.getWeight());
			} else {
				dataMap.put(p.getPostalCode(), p.getWeight());
			}
		}
		return dataMap;
	}

	private void displayData(Map<String, Double> dataMap) {
		System.out.println("Pakage Weight Summary: ");
		for (String p : dataMap.keySet()) {
			if (!displayWithFee) {
				System.out.println(p.toString() + " " + df3.format(dataMap.get(p)));
			} else {
				System.out.println(p.toString() + " " + df3.format(dataMap.get(p)) + " "
						+ df3.format(FeeService.getFee(dataMap.get(p))));
			}
		}
	}

}
