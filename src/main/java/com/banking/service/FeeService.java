package com.banking.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.banking.model.FeeData;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FeeService {

	private static List<FeeData> feeDatas;

	public static Double getFee(Double weight) {
		if (feeDatas == null || feeDatas.size() == 0)
			return 0.0;
		for (int i = 0; i < feeDatas.size(); i++) {
			if (weight < feeDatas.get(i).getWeight()) {
				if (i == 0) {
					return 0.0;
				} else {
					return feeDatas.get(i-1).getFee();
				}
			}
		}
		return feeDatas.get(feeDatas.size() - 1).getFee();
	}

	public static void initilizingFeeData(String fileName) {
		feeDatas = Collections.synchronizedList(new ArrayList<FeeData>());
		if (fileName == null || "".equals(fileName))
			return;
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] inputs = line.split(" ");
				Double weight = Double.parseDouble(inputs[0].trim());
				Double fee = Double.parseDouble(inputs[1].trim());
				FeeData feeData = new FeeData(weight, fee);
				feeDatas.add(feeData);
			}
			Collections.sort(feeDatas);
		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}
}
