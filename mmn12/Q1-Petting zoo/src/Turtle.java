
public class Turtle extends Reptile {
    /**
     * Turtle Constructor
     *
     * @param name
     * @param age
     * @param color
     */
    public Turtle(String name, int age, String color) {
        super(name, age, color);
    }


    /**
     * Turtle's override for eating method
     */
    @Override
    public void eat() {
        System.out.println("The turtle: " + this.get_name() + " is eating some lettuce");
    }

    /**
     * Turtle's override for sleeping method
     */
    @Override
    public void sleep() {
        System.out.println("The turtle: " + this.get_name() + " is asleep in his shell");
    }

    /**
     * Turtle's override for the Reptile's hissing method
     */
    @Override
    public void hiss() {
        // TODO Auto-generated method stub
        System.out.println("The turtle: " + this.get_name() + " is silent...");
    }

    /**
     * Turtle's override for Reptile's crawling method
     */
    @Override
    public void crawl() {
        // TODO Auto-generated method stub
        System.out.println("The turtle: " + this.get_name() + " is crawling around really slowly");
    }

    @Override
    public boolean equals(Object obj) {


        if (obj instanceof Turtle) {
            if (((Animal) obj).get_age() == this._age && ((Animal) obj).get_color().equals(this._color)
                    && ((Animal) obj).get_name().equals(this._name)) {
                return true;


            }

        }
        return false;
    }

    @Override
    public Object clone() {
        return new Turtle(this._name, this._age, this._color);
    }

    @Override
    public String toString() {
        String returnedString = "Turtle: ";
        returnedString += super.toString();
        return returnedString;
    }

}
