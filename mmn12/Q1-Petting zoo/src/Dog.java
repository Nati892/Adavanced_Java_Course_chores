public class Dog extends Mammal {
    private Owner _owner;

    /**
     * constructor for wild Dog (owner set to null)
     *
     * @param name
     * @param age
     * @param color
     */
    public Dog(String name, int age, String color) {
        super(name, age, color);
        this._owner = null;
    }

    /**
     * constructor for Dog that includes owner details
     *
     * @param name
     * @param age
     * @param color
     * @param owner_name
     * @param phone_number
     */
    public Dog(String name, int age, String color, String owner_name, String phone_number) {
        super(name, age, color);
        this._owner = new Owner(owner_name, phone_number);
    }

    /**
     * sets a new owner for Dog
     *
     * @param owner the Dog's owner, passes by reference
     */
    public void setOwner(Owner owner) {
        this._owner = owner;
    }

    /**
     * @return owner of Dog by reference, returns null for wild Dog
     */
    public Owner getOwner() {
        return this._owner;

    }

    /**
     * Dog's override for eating method
     */
    @Override
    public void eat() {
        System.out.println("The dog: " + this.get_name() + " is eating dog food!");
    }

    /**
     * Dog's override for sleeping method
     */
    @Override
    public void sleep() {
        System.out.println("The dog: " + this.get_name() + " is asleep");
    }

    /**
     * Dog's override for the mammal's roaring method
     */
    @Override
    public void roar() {
        // TODO Auto-generated method stub
        System.out.println("The dog: " + this.get_name() + ":\"woof woof!\" ");
    }

    /**
     * Dog's override for mammal's walking method
     */
    @Override
    public void walk() {
        // TODO Auto-generated method stub
        System.out.println("The dog: " + this.get_name() + " is walking around with his tongue dangling out of its mouth");
    }

    @Override
    public Object clone() {
        Dog returned_dog;
        if (this._owner == null) {
            returned_dog = new Dog(this._name, this._age, this._color);
        } else {
            returned_dog = new Dog(this._name, this._age, this._color, getOwner().get_name(), this._owner.getPhone_number());
        }
        return returned_dog;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Dog) {
            if (((Animal) obj).get_age() == this._age && ((Animal) obj).get_color().equals(this._color) && ((Animal) obj).get_name().equals(this._name)) {//check attributes equality
                if (((Dog) obj)._owner != null && this._owner != null) {//check owners equality
                    if (((Dog) obj)._owner.equals(this._owner)) {
                        return true;
                    } else {
                        if (this._owner == null && ((Dog) obj).getOwner() == null) return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String returnedString = "Dog: ";
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
