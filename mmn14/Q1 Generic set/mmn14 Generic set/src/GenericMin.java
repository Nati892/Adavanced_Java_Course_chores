import java.util.Iterator;

public class GenericMin {


    /**
     * This generic method receives a Set of a generic type that must implement comparable for the same type
     * and returns the minimal member
     *
     * @param mySet the given set of type E
     * @param <E>   the generic type that must implement Comparable
     * @return the minimal member in mySet
     */
    public <E extends Comparable<E>> E Min(Set<E> mySet) {

        Iterator<E> iterator = mySet.iterator();
        if (!iterator.hasNext())
            return null;

        E min = iterator.next();
        while (iterator.hasNext()) {
            E next = iterator.next();
            if (next.compareTo(min) < 0)
                min = next;
        }
        return min;
    }
}
