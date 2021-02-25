package com.banking;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.banking.service.DisplayService;
import com.banking.service.FeeService;
import com.banking.service.DataService;

/**
 * Hello world!
 *
 */
public class App {

	private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(1);

	public static void main(String[] args) {
		String inputFile = null;
		if (args.length >= 1) {
			inputFile = args[0];
		}
		String feeFile = null;
		if (args.length >= 2) {
			feeFile = args[1];
		}
		
		FeeService.initilizingFeeData(feeFile);
		System.out.println("=== Package Delivery System starts ===");
		EXECUTOR_SERVICE.execute(new DisplayService(feeFile != null && !"".equals(feeFile)));
		(new DataService(inputFile)).start();
		EXECUTOR_SERVICE.shutdownNow();
		System.out.println("=== Package Delivery System stops ===");
	}

}
