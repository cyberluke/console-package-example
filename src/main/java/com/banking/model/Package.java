package com.banking.model;

public class Package {

	private double weight;
	private String postalCode;

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Package(double weight, String postalCode) {
		super();
		this.weight = weight;
		this.postalCode = postalCode;
	}

	@Override
	public String toString() {
		return "Package [weight=" + weight + ", postalCode=" + postalCode + "]";
	}

}
