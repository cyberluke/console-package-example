package com.banking.model;

public enum InputError {
	NONE("No error"), LINE_ERROR("Input should contain only two seperate words"), WEIGHT_ERROR(
			"Weight input is not parsable to double"), POSTAL_CODE_ERROR(
					"Postal Code must be in the correct format, example: 12345");
	private final String errorMessage;

	InputError(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}
