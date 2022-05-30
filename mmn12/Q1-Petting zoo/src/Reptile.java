
public abstract class Reptile extends Animal {
	/**
	 * Reptile constructor
	 * @param name
	 * @param age
	 * @param color
	 */
	public Reptile(String name, int age, String color) {
		super(name, age, color);
	}

	abstract public void hiss();

	abstract public void crawl();

}
