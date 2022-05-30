
public abstract class Mammal extends Animal {
	/**
	 * Mammal constructor
	 * @param name
	 * @param age
	 * @param color
	 */
	public Mammal(String name, int age, String color) {
		super(name, age, color);
	}

	abstract public void roar();

	abstract public void walk();

	@Override
	public String toString() {
		return super.toString();
	}

}
