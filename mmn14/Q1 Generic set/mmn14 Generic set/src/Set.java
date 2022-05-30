import java.util.ArrayList;
import java.util.Iterator;

public class Set<T> {
    private ArrayList<T> _mySet;


    /**
     * empty constructor
     */
    public Set() {
        _mySet = new ArrayList<T>();
    }

    /**
     * constructs a set from a given array
     * the set will not have any duplicates
     *
     * @param other_set an array the same type of the generic class's type
     */
    public Set(T[] other_set) {
        _mySet = new ArrayList<T>();

        for (int i = 0; i < other_set.length; i++) {
            if (other_set[i] != null) {
                T curr = other_set[i];
                if (search(curr)==null) {
                    _mySet.add(curr);
                }
            }
        }
    }

    /**
     * unites two sets into the 'this' set
     *
     * @param otherSet the second set to unite with
     */
    public void union(Set<T> otherSet) {

        Iterator<T> oIterator = otherSet.iterator();
        if (oIterator == null)
            return;

        while (oIterator.hasNext()) {
            T curr = oIterator.next();
            if (search(curr)==null) {
                _mySet.add(curr);
            }
        }
    }

    /**
     * intersects two sets into the 'this' set
     *
     * @param otherSet the second set to intersect with
     */
    public void intersect(Set<T> otherSet) {

        Iterator<T> thisIterator = _mySet.iterator();

        if (thisIterator == null)
            return;

        while (thisIterator.hasNext()) {
            T curr = thisIterator.next();

            if (!otherSet.isMember(curr)) {
                thisIterator.remove();
            }
        }

    }

    /**
     * null counts as an empty set which is a subset of every other set
     *
     * @param otherSet the set to check if subset
     * @return boolean if it's a subset or not
     */

    public boolean isSubset(Set<T> otherSet) {
        boolean result = true;

        Iterator<T> otherIterator = otherSet.iterator();

        if (otherIterator != null) {
            while (otherIterator.hasNext() && result == true) {
                T curr = otherIterator.next();
                if (!this.isMember(curr)) {
                    result = false;
                }
            }
        }
        return result;
    }


    /**
     * this function checks if object is a member of current set
     *
     * @param member the object to check if member
     * @return boolean if it's a member or not
     */
    public boolean isMember(T member) {
        boolean result = false;
        if (member == null)
            return result;
        return (search(member)!=null);
    }

    /**
     * inserts a member to the current set
     *
     * @param newMember the member to be entered
     */
    public void insert(T newMember) {
        if (newMember == null)
            return;

        if (!this.isMember(newMember))
            _mySet.add(newMember);
    }

    /**
     * removes a member from this set(does nothing if not present in set)
     *
     * @param rmMember the member to be removed
     */
    public void delete(T rmMember) {
        if (rmMember == null)
            return;

        if (this.isMember(rmMember))
            _mySet.remove(rmMember);
    }


    /**
     * this function returns an iterator for the set type
     *
     * @return Iterator for the set<T> type
     */
    public Iterator<T> iterator() {
        if (_mySet != null)
            return _mySet.iterator();
        else
            return null;
    }

    //private method the helps search a member in the set
    private T search(T toFind) {
        T result = null;
        if (_mySet == null)
            return result;

        Iterator<T> iterator = _mySet.iterator();

        while (iterator.hasNext() && result==null) {
            T curr = iterator.next();
            if (curr.equals(toFind)) {
                result = curr;
            }
        }
        return result;
    }

    /**
     * @return an int indicating the sets size
     */
    public int size() {
        return _mySet.size();
    }

    public String toString() {
        return "Set: " + _mySet.toString();
    }


}

