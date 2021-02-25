package com.banking.service;


import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import com.banking.model.Package;
import static org.junit.jupiter.api.Assertions.*;

public class TestDisplayService {
	private static final DecimalFormat df3 = new DecimalFormat("0.0000");
	@Test
	public void testBuildDataMap() {
		List<Package> testData = DataService.initializingData("data/data");
		Map<String, Double> dataMap = DisplayService.buildDataMap(testData);
		assertEquals(6, dataMap.size());
		assertEquals(0.2, Double.parseDouble(df3.format(dataMap.get("44444").doubleValue())));
		assertEquals(0.222, Double.parseDouble(df3.format(dataMap.get("55555").doubleValue())));
		assertEquals(2.444, Double.parseDouble(df3.format(dataMap.get("66666").doubleValue())));
		assertEquals(4.888, Double.parseDouble(df3.format(dataMap.get("77777").doubleValue())));
		assertEquals(9.7760, Double.parseDouble(df3.format(dataMap.get("88888").doubleValue())));
		assertEquals(10.9980, Double.parseDouble(df3.format(dataMap.get("99999").doubleValue())));
	}
	

}
