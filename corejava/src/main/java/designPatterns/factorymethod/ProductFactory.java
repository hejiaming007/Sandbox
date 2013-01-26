package designPatterns.factorymethod;

/**
 * 
 * Factory methods are static methods that return an instance of the native
 * class.
 * 
 * <p>
 * Factory methods :
 * <li>have names, unlike constructors, which can clarify code.
 * 
 * <li>do not need to create a new object upon each invocation - objects can be
 * cached and reused, if necessary.
 * 
 * <li>can return a subtype of their return type - in particular, can return an
 * object whose implementation class is unknown to the caller. This is a very
 * valuable and widely used feature in many frameworks which use interfaces as
 * the return type of static factory methods.
 * 
 * 
 * @author hejiaming
 * 
 */
public class ProductFactory {

	/**
	 * can return a subtype of their return type - in particular, can return an
	 * object whose implementation class is unknown to the caller.
	 * 
	 * Common names for factory methods include getInstance and valueOf. These
	 * names are not mandatory - choose whatever makes sense for each case.
	 * 
	 * @param type
	 * @return
	 */
	public static Product getInstance(String type) {
		if ("A".equals(type)) {
			return new ProductA();
		}
		if ("B".equals(type)) {
			return new ProductB();
		} else
			return null;
	}

	public static void main(String[] args) {
		ProductFactory.getInstance("A").getName();
		ProductFactory.getInstance("B").getName();
	}
}

interface Product {
	public void getName();
}

class ProductB implements Product {

	public void getName() {
		System.out.println("  I am ProductB  ");
	}

}

class ProductA implements Product {

	public void getName() {
		System.out.println("  I am ProductA  ");
	}

}