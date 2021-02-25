package com.banking.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.banking.model.InputError;
import com.banking.model.Package;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DataService {
	
	
	private static final String QUIT = "QUIT";
	private static final Pattern POSTAL_CODE_PATTERN = Pattern.compile("^[0-9]{5}");
	private static List<Package> data = Collections.synchronizedList(new ArrayList<>());
	
	private final String inputFile;

	public DataService(String inputFile) {
		this.inputFile = inputFile;
	}

	public void start() {
		if (this.inputFile != null && !this.inputFile.isEmpty()) {
			data = initializingData(inputFile);
		}
		this.inputData();
	}

	public static List<Package> getData() {
		return data;
	}
	
	private void inputData() {
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println(
					"Enter weight and postal code, seperate by space, enter 'quit' when you want to get out. ");
			String input = in.nextLine();
			if (input.equalsIgnoreCase(QUIT)) {
				break;
			}
			InputError inputError = getInputError(input);
			if (inputError.equals(InputError.NONE)) {
				addToData(input);
			} else {
				System.out.println("Input Error: " + inputError.getErrorMessage());
			}
		}
	}

	public static List<Package> initializingData(String fileName) {
		List<Package> result = Collections.synchronizedList(new ArrayList<>());
		if (fileName == null || "".equals(fileName))
			return result;
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = br.readLine()) != null) {
				InputError inputError = getInputError(line);
				if (inputError.equals(InputError.NONE)) {
					String[] inputs = line.split(" ");
					Package pakage = new Package(Double.parseDouble(inputs[0].trim()), inputs[1].trim());
					result.add(pakage);
				}
			}
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return result;
	}

	public static InputError getInputError(String input) {
		String[] inputs = input.split(" ");
		if (inputs.length != 2)
			return InputError.LINE_ERROR;

		String weight = inputs[0].trim();
		try {
			Double.parseDouble(weight);
		} catch (NumberFormatException ex) {
			return InputError.WEIGHT_ERROR;
		}

		String postalCode = inputs[1].trim();
		if (!POSTAL_CODE_PATTERN.matcher(postalCode).matches()) {
			return InputError.POSTAL_CODE_ERROR;
		}
		return InputError.NONE;
	}

	private static void addToData(String input) {
		String[] inputs = input.split(" ");
		Package pakage = new Package(Double.parseDouble(inputs[0].trim()), inputs[1].trim());
		data.add(pakage);
	}

}
