
public class Owner {
    private String _name;
    private String phone_number;

    /**
     * Owner's constructor
     *
     * @param _name
     * @param phone_number
     */
    public Owner(String _name, String phone_number) {
        super();
        this._name = _name;
        this.phone_number = phone_number;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Owner)
            if (((Owner) obj).getPhone_number().equals(this.phone_number) && ((Owner) obj).get_name().equals(this._name))
                return true;
        return false;
    }


    @Override
    public String toString() {
        return "name: " + this._name + ", phone number: " + this.phone_number;

    }

}
