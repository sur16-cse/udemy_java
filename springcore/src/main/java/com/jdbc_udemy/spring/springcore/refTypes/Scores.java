package com.jdbc_udemy.spring.springcore.refTypes;

public class Scores {
	private double physics;
	private double chemistry;
	private double maths;
	public double getPhysics() {
		return physics;
	}
	public void setPhysics(double physics) {
		this.physics = physics;
	}
	public double getChemistry() {
		return chemistry;
	}
	public void setChemistry(double chemistry) {
		this.chemistry = chemistry;
	}
	public double getMaths() {
		return maths;
	}
	public void setMaths(double maths) {
		this.maths = maths;
	}
	@Override
	public String toString() {
		return "Scores [physics=" + physics + ", chemistry=" + chemistry + ", maths=" + maths + "]";
	}
	
	
}
