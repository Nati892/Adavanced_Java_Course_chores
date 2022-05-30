
public class Person implements Comparable<Person> {

    private String _id;
    private String _firstName;
    private String _familyName;
    private String _yearOfBirth;

    private final int IDLENGTH = 9;

    public Person(String _id, String _firstName, String _familyName, String _yearOfBirth) {
        if (_id == null) {//make sure id is 9 digits long
            this._id = "000000000";
        } else {
            if (_id.length() == IDLENGTH) this._id = _id;

            if (_id.length() > IDLENGTH) this._id = _id.substring(0, IDLENGTH + 1);

            if (_id.length() < IDLENGTH) {
                int add = IDLENGTH - _id.length();
                this._id = _id;
                for (int i = 0; i < add; i++)
                    _id += "0";
            }
        }

        this._firstName = _firstName;
        this._familyName = _familyName;
        this._yearOfBirth = _yearOfBirth;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_firstName() {
        return _firstName;
    }

    public void set_firstName(String _firstName) {
        this._firstName = _firstName;
    }

    public String get_familyName() {
        return _familyName;
    }

    public void set_familyName(String _familyName) {
        this._familyName = _familyName;
    }

    public String get_yearOfBirth() {
        return _yearOfBirth;
    }

    public void set_yearOfBirth(String _yearOfBirth) {
        this._yearOfBirth = _yearOfBirth;
    }

    @Override
    public int compareTo(Person o) {
        return compareLexicographic(this._id, o.get_id());
    }

    //this is a helper method that is basically the logic for the compareTo method
    //it compares the id of both members in a lexicographic order
    private int compareLexicographic(String first, String second) {
        int result = 0;
        if (first != null && second != null) {

            for (int i = 0; i < IDLENGTH && result == 0; i++) {//lexicographic comparison
                if (first.charAt(i) > second.charAt(i)) {
                    result = 1;
                } else {
                    if (first.charAt(i) < second.charAt(i)) {
                        result = -1;
                    }
                }
            }

        }
        else{
        if (first == null && second == null)
        {
            result = 0;}
        else {
            {

                if (first == null)
                    return -1;//second is big
                else
                    return 1;//first is big
            }


        }}
        return result;
    }

    @Override
    public String toString() {
        return "\nPerson{" +
                "_id='" + _id + '\'' +
                ", _firstName='" + _firstName + '\'' +
                ", _familyName='" + _familyName + '\'' +
                ", _yearOfBirth=" + _yearOfBirth +
                '}';
    }
}