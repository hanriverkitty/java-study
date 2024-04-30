package structural.decorator;

public class ParentheseDecorator extends Decorator {

	public ParentheseDecorator(Component component) {
		super(component);
		
	}

	@Override
	public String operation() {
		String text = component.operation();
		return "("+text+")";
	}

}
