package com.subrata.misc;

public class EqualHashCodeGeneration {
	int id;
	String name;
	char sex;
	long tax;
	double income;
	float length;
	
	public static void main(String[] args) {
		int p = 20;
		System.out.println(22 ^ (p >>> 32));
		System.out.println( (p >>> 32));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		long temp;
		temp = Double.doubleToLongBits(income);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Float.floatToIntBits(length);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + sex;
		result = prime * result + (int) (tax ^ (tax >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EqualHashCodeGeneration other = (EqualHashCodeGeneration) obj;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(income) != Double
				.doubleToLongBits(other.income))
			return false;
		if (Float.floatToIntBits(length) != Float.floatToIntBits(other.length))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sex != other.sex)
			return false;
		if (tax != other.tax)
			return false;
		return true;
	}
}
