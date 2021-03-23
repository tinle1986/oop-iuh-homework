package com.ttlecom;

public class Triangle {
	private int ma;
	private int mb;
	private int mc;

	public int getMa() {
		return ma;
	}

	public void setMa(int ma) {
		if (isTriangle(ma, getMb(), getMc())) {
			this.ma = ma;
			return;
		}
		System.out.println("The value input is not valid!");
	}

	public int getMb() {
		return mb;
	}

	public void setMb(int mb) {
		if (isTriangle(getMa(), mb, getMc())) {
			this.mb = mb;
			return;
		}
		System.out.println("The value input is not valid!");
	}

	public int getMc() {
		return mc;
	}

	public void setMc(int mc) {
		if (isTriangle(getMa(), getMb(), mc)) {
			this.mc = mc;
			return;
		}
		System.out.println("The value input is not valid!");
	}

	public Triangle() {
		setMa(0);
		setMb(0);
		setMc(0);
	}

	public Triangle(int ma, int mb, int mc) {
		if (!isTriangle(ma, mb, mc)) {
			this.ma = 0;
			this.mb = 0;
			this.mc = 0;
			System.out.println("The values initialized are not valid!");
		} else {
			this.ma = ma;
			this.mb = mb;
			this.mc = mc;
		}
	}

	private boolean isTriangle(int ma, int mb, int mc) {
		return (ma + mb > mc) && (mb + mc > ma) && (mc + ma > mb);
	}

	public int calculatePerimeter(int ma, int mb, int mc) {
		return ma + mb + mc;
	}

	public double calculateArea(int ma, int mb, int mc) {
		double p = calculatePerimeter(ma, mb, mc) / 2.0;
		return Math.sqrt(p * (p - ma) * (p - mb) * (p - mc));
	}

	public boolean isSquareTriangle(int ma, int mb, int mc) {
		if (isTriangle(ma, mb, mc)) {
			return (ma * ma == mb * mb + mc * mc) || (mb * mb == ma * ma + mc * mc) || (mc * mc == ma * ma + mb * mb);
		}
		return false;
	}

	public boolean isEquilateralTriangle(int ma, int mb, int mc) {
		if (isTriangle(ma, mb, mc)) {
			return (ma == mb) && (mb == mc);
		}
		return false;
	}

	public boolean isIsoscelesTriangle(int ma, int mb, int mc) {
		if (isTriangle(ma, mb, mc)) {
			return (ma == mb) || (mb == mc) || (mc == ma);
		}
		return false;
	}

	@Override
	public String toString() {
		if (isTriangle(getMa(), getMb(), getMc())) {
			String isSquareTriangle;
			String isEquilateralTriangle;
			String isIsoscelesTriangle;
			String isNormalTriangle;
			int perimeter = calculatePerimeter(getMa(), getMb(), getMc());
			double area = calculateArea(getMa(), getMb(), getMc());

			if (isSquareTriangle(getMa(), getMb(), getMc())) isSquareTriangle = "Yes";
			else isSquareTriangle = "No";
			if (isEquilateralTriangle(getMa(), getMb(), getMc())) isEquilateralTriangle = "Yes";
			else isEquilateralTriangle = "No";
			if (isIsoscelesTriangle(getMa(), getMb(), getMc())) isIsoscelesTriangle = "Yes";
			else isIsoscelesTriangle = "No";

			if ((!isSquareTriangle(getMa(), getMb(), getMc()))
							&& (!isEquilateralTriangle(getMa(), getMb(), getMc()))
							&& (!isIsoscelesTriangle(getMa(), getMb(), getMc()))) {
				isNormalTriangle = "Yes";
			} else {
				isNormalTriangle = "No";
			}

			return String.format("Sizes: %d/%d/%d%n" +
							"Is a normal triangle: %s%n" +
							"Is a square triangle: %s%n" +
							"Is an equilateral triangle: %s%n" +
							"Is an isosceles triangle: %s%n" +
							"Perimeter: %d%n" +
							"Area: %.2f%n", getMa(), getMb(), getMc(), isNormalTriangle, isSquareTriangle, isEquilateralTriangle, isIsoscelesTriangle, perimeter, area);
		}
		return "[THE CURRENT OBJECT IS NOT A TRIANGLE]\n";
	}
}
