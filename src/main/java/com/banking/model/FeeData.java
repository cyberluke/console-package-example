package com.banking.model;

public class FeeData implements Comparable<FeeData> {

	private Double weight;
	private Double fee;

	public FeeData(Double weight, Double fee) {
		this.weight = weight;
		this.fee = fee;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getFee() {
		return fee;
	}

	public void setFee(Double fee) {
		this.fee = fee;
	}

	@Override
	public int compareTo(FeeData another) {
		if (this.weight.equals(another.weight)) {
			return 0; // we can use Apache Commons Math library if we need to compare with epsilon (threshold compare)
		} else if (this.weight > another.weight) {
			return 1;
		}

		return -1;
	}

}
