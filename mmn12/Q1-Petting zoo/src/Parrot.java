
public class Parrot extends Bird {
    private Owner _owner;

    /**
     * constructor for wild Parrot (owner set to null)
     *
     * @param name
     * @param age
     * @param color
     */
    public Parrot(String name, int age, String color) {
        super(name, age, color);
        this._owner = null;
    }

    /**
     * constructor for Parrot that includes owner details
     *
     * @param name
     * @param age
     * @param color
     * @param owner_name
     * @param owner_phone_num
     */
    public Parrot(String name, int age, String color, String owner_name, String owner_phone_num) {
        super(name, age, color);
        this._owner = new Owner(owner_name, owner_phone_num);
    }

    /**
     * sets a new owner for Parrot
     *
     * @param owner the Parrot's owner, passes by reference
     */
    public void setOwner(Owner owner) {
        this._owner = owner;
    }

    /**
     * @return owner of Parrot by reference, returns null for wild Parrot
     */
    public Owner getOwner() {
        return this._owner;

    }

    /**
     * Parrot's override for eating method
     */
    @Override
    public void eat() {
        System.out.println("The parrot: " + this.get_name() + " is eating sunflower seeds");
    }

    /**
     * Parrot's override for sleeping method
     */
    @Override
    public void sleep() {
        System.out.println("The parrot: " + this.get_name() + " is asleep on my shoulder");
    }

    /**
     * Parrot's override for the Bird's tweeting method
     */
    @Override
    public void tweet() {
        // TODO Auto-generated method stub
        System.out.println("The parrot: " + this.get_name() + " Just repeated after you");
    }

    /**
     * Parrot's override for the flying method in Bird
     */
    @Override
    public void fly() {
        // TODO Auto-generated method stub
        System.out.println("The parrot: " + this.get_name() + " flying around and being all beautiful");
    }

    @Override
    public Object clone() {
        Parrot returned_parrot;
        if (this._owner == null) {
            returned_parrot = new Parrot(this._name, this._age, this._color);
        } else {
            returned_parrot = new Parrot(this._name, this._age, this._color, getOwner().get_name(),
                    this._owner.getPhone_number());
        }

        return returned_parrot;

    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Cat) {
            if (((Animal) obj).get_age() == this._age && ((Animal) obj).get_color().equals(this._color)
                    && ((Animal) obj).get_name().equals(this._name)) {//check attributes equality
                if (((Parrot) obj)._owner != null && this._owner != null) {//check owners equality
                    if (((Parrot) obj)._owner.equals(this._owner)) {
                        return true;
                    } else {
                        if (this._owner == null && ((Parrot) obj).getOwner() == null)
                            return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String returnedString = "Parrot: ";
        returnedString += super.toString();
        returnedString += ",owner: ";
        if (_owner == null) {
            returnedString += "none!";
        } else {
            returnedString += _owner.toString();
            ;
        }
        return returnedString;
    }

}
