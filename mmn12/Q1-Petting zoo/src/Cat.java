public class Cat extends Mammal {

    private Owner _owner;

    /**
     * constructor for wild Cat (owner set to null)
     *
     * @param name
     * @param age
     * @param color
     */
    public Cat(String name, int age, String color) {
        super(name, age, color);
        this._owner = null;
    }

    /**
     * constructor for Cat that includes owner details
     *
     * @param name
     * @param age
     * @param color
     * @param owner_name
     * @param owner_phone_num
     */
    public Cat(String name, int age, String color, String owner_name, String owner_phone_num) {
        super(name, age, color);
        _owner = new Owner(owner_name, owner_phone_num);
    }

    /**
     * sets a new owner for cat
     *
     * @param owner the cat's owner, passes by reference
     */
    public void setOwner(Owner owner) {
        this._owner = owner;
    }

    /**
     * @return owner of cat by reference, returns null for wild cat
     */
    public Owner getOwner() {
        return this._owner;

    }

    /**
     * Cat's override for eating method
     */
    @Override
    public void eat() {
        System.out.println("The cat: " + this.get_name() + " is eating a mouse!");
    }

    /**
     * Cat's override for sleeping method
     */
    @Override
    public void sleep() {
        System.out.println("The cat: " + this.get_name() + " is asleep");
    }

    /**
     * Cat's override for the mammal's roaring method
     */
    @Override
    public void roar() {
        // TODO Auto-generated method stub
        System.out.println("The cat: " + this.get_name() + ":\"meow!\" ");
    }

    /**
     * Cat's override for mammal's walking method
     */
    @Override
    public void walk() {
        // TODO Auto-generated method stub
        System.out.println("The cat: " + this.get_name() + " is walking around all fluffy and cute like a cat ");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Cat) {
            if (((Animal) obj).get_age() == this._age && ((Animal) obj).get_color().equals(this._color) && ((Animal) obj).get_name().equals(this._name)) {//check attributes equality
                if (((Cat) obj)._owner != null && this._owner != null) {//check owners equality
                    if (((Cat) obj)._owner.equals(this._owner)) {
                        return true;
                    } else {
                        if (this._owner == null && ((Cat) obj).getOwner() == null) return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public Object clone() {
        Cat returned_cat;
        if (this._owner == null) {
            returned_cat = new Cat(this._name, this._age, this._color);
        } else {
            returned_cat = new Cat(this._name, this._age, this._color, getOwner().get_name(), this._owner.getPhone_number());
        }

        return returned_cat;

    }

    @Override
    public String toString() {
        String returnedString = "Cat: ";
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
