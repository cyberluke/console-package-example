package com.banking.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.banking.model.InputError;

public class TestInputService {

	@Test
	public void testGetInputErrorShouldReturnNoError() {
		assertEquals(InputError.NONE, DataService.getInputError("1.2345 00000"));
	}

	@Test
	public void testGetInputErrorShouldReturnLineInputError() {
		assertEquals(InputError.LINE_ERROR, DataService.getInputError("1.2345 909090 xxxx"));
	}

	@Test
	public void testGetInputErrorShouldReturnWeightInputError() {
		assertEquals(InputError.WEIGHT_ERROR, DataService.getInputError("1.a2345 909090"));
	}

	@Test
	public void testGetInputErrorShouldReturnPostalInputError() {
		assertEquals(InputError.POSTAL_CODE_ERROR, DataService.getInputError("1.2345 000000"));
	}

}
