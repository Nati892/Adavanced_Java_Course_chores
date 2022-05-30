public class Pigeon extends Bird {
    /**
     * constructor for Pigeon
     *
     * @param name
     * @param age
     * @param color
     */
    public Pigeon(String name, int age, String color) {
        super(name, age, color);
    }

    /**
     * Pigeon's override for eating method
     */
    @Override
    public void eat() {
        System.out.println("The pigeon: " + this.get_name() + " is eating worms");
    }

    /**
     * Pigeon's override for sleeping method
     */
    @Override
    public void sleep() {
        System.out.println("The pigeon: " + this.get_name() + " is asleep on a tree");
    }

    /**
     * Pigeon's override for the Bird's tweeting method
     */
    @Override
    public void tweet() {
        // TODO Auto-generated method stub
        System.out.println("The pigeon: " + this.get_name() + " brr brr");
    }

    /**
     * Pigeon's override for the Bird's flying method
     */
    @Override
    public void fly() {
        // TODO Auto-generated method stub
        System.out.println("The pigeon: " + this.get_name() + " flying around and bombing innocent pedestrians");
    }

    @Override
    public Object clone() {
        return new Pigeon(this._name, this._age, this._color);
    }


    @Override
    public boolean equals(Object obj) {


        if (obj instanceof Pigeon) {
            if (((Animal) obj).get_age() == this._age && ((Animal) obj).get_color().equals(this._color) && ((Animal) obj).get_name().equals(this._name)) {
                return true;


            }

        }
        return false;
    }

    @Override
    public String toString() {
        String returnedString = "Pigeon: ";
        returnedString += super.toString();
        return returnedString;
    }
}
