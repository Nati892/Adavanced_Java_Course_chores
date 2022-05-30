public class Snake extends Reptile {
    /**
     * Snake Constructor
     *
     * @param name
     * @param age
     * @param color
     */
    public Snake(String name, int age, String color) {
        super(name, age, color);
    }

    /**
     * Snake's override for eating method
     */
    @Override
    public void eat() {
        System.out.println("The snake: " + this.get_name() + " is eating well a small mouse");
    }
    /**
     * Snake's override for sleeping method
     */
    @Override
    public void sleep() {
        System.out.println("The snake: " + this.get_name() + " is asleep in the bushes");
    }
    /**
     * Snake's override for the Reptile's hissing method
     */
    @Override
    public void hiss() {
        // TODO Auto-generated method stub
        System.out.println("The snake: " + this.get_name() + ": hisssssssss");
    }
    /**
     * Snake's override for Reptile's crawling method
     */
    @Override
    public void crawl() {
        // TODO Auto-generated method stub
        System.out.println("The snake: " + this.get_name() + " is crawling but really fast!!");
    }

    @Override
    public Object clone() {
        return new Snake(this._name, this._age, this._color);
    }

    @Override
    public boolean equals(Object obj) {


        if (obj instanceof Snake) {
            if (((Animal) obj).get_age() == this._age && ((Animal) obj).get_color().equals(this._color) && ((Animal) obj).get_name().equals(this._name)) {
                return true;


            }

        }
        return false;
    }

    @Override
    public String toString() {
        String returnedString = "Snake: ";
        returnedString += super.toString();
        return returnedString;
    }
}
