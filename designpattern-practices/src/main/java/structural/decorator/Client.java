package structural.decorator;

public class Client {

	public static void main(String[] args) {
		System.out.println(new ConcreteComponent("Hello World").operation());
		System.out.println(new BracesDecorator(new ConcreteComponent("Hello World")).operation());
		System.out.println(new ParentheseDecorator(new BracesDecorator(new ConcreteComponent("Hello World"))).operation());
		
		System.out.println(new ParentheseDecorator(new ConcreteComponent("Hello World")).operation());
		System.out.println(new BracesDecorator(new ParentheseDecorator(new ConcreteComponent("Hello World"))).operation());
	}

}
