
public abstract class Animal {

    protected String _name;
    protected int _age;
    protected String _color;

    /**
     * Animal constructor
     *
     * @param name
     * @param age
     * @param color
     */
    public Animal(String name, int age, String color) {
        this._age = age;
        this._color = color;
        this._name = name;
    }

    abstract public void eat();

    abstract public void sleep();

    public String get_name() {
        return this._name;
    }

    public int get_age() {
        return this._age;
    }

    public String get_color() {
        return this._color;
    }

    public void set_color(String color) {
        this._color = color;
    }

    public void set_age(int age) {
        this._age = age;
    }

    public void set_name(String name) {
        this._name = name;
    }

    /**
     * override of equals for this abstract class
     */
    @Override
    public boolean equals(Object obj) {
        System.out.println("another");
        if (obj instanceof Animal) {
            Animal temp = (Animal) obj;
            if (temp.get_age() == this._age && temp.get_color().equals(this._color)
                    && temp.get_name().equals(this._name)) {
                return true;
            }

        }
        return false;
    }

    public String toString() {
        return "name: " + this._name + ", age: " + this._age + ", color: " + this._color;
    }
}
