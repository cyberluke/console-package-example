package com.banking.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestFeeService {

	@Test
	public void testGetFeeWithMarginValue() {
		FeeService.initilizingFeeData("data/feeData");
		assertEquals(0.5, FeeService.getFee(0.2).doubleValue());
		assertEquals(0.7, FeeService.getFee(0.5).doubleValue());
		assertEquals(1.0, FeeService.getFee(1.0).doubleValue());
		assertEquals(1.5, FeeService.getFee(2.0).doubleValue());
		assertEquals(2.0, FeeService.getFee(3.0).doubleValue());
		assertEquals(2.5, FeeService.getFee(5.0).doubleValue());
		assertEquals(5.0, FeeService.getFee(10.0).doubleValue());
	}
	
	@Test
	public void testGetFeeWithNormalValue() {
		FeeService.initilizingFeeData("data/feeData");
		assertEquals(0.0, FeeService.getFee(0.15).doubleValue());
		assertEquals(0.5, FeeService.getFee(0.35).doubleValue());
		assertEquals(0.7, FeeService.getFee(0.8).doubleValue());
		assertEquals(1.0, FeeService.getFee(1.7).doubleValue());
		assertEquals(1.5, FeeService.getFee(2.9).doubleValue());
		assertEquals(2.0, FeeService.getFee(4.5).doubleValue());
		assertEquals(2.5, FeeService.getFee(8.0).doubleValue());
		assertEquals(5.0, FeeService.getFee(12.0).doubleValue());
	}
}
