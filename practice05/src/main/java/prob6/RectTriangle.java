package prob6;

public class RectTriangle extends Shape implements Resizable {
	private double w;
	private double h;
	
	public RectTriangle(double w,double h) {
		this.w = w;
		this.h = h;
	}
	
	
	@Override
	public void resize(double s) {
		w*=s;
		h*=s;
	}

	@Override
	public double getArea() {
		return w*h*0.5;
	}

	@Override
	public double getPerimeter() {
		return w+h+Math.sqrt(w*w+h*h);
	}

}
