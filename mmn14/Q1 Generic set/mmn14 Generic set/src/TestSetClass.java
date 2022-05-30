import java.util.Random;
import java.util.Scanner;

public class TestSetClass {
    private static final int UPPERBOUND = 100;
    private static Random rand = new Random();
    private static final int SETSIZE = 10;
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);//init scanner

        runfirstTests();//tests from first section
        runsecondTests();//tests from second section

    }


    private static void runfirstTests() {
        System.out.println("testing 3 Integer sets");

        Set<Integer> set1 = new Set<Integer>();
        Set<Integer> set2 = new Set<Integer>();
        Set<Integer> set3 = new Set<Integer>();

        fillIntegerSet(set1);
        fillIntegerSet(set2);
        fillIntegerSet(set3);

        //created sets
        System.out.println("First set: " + set1);
        System.out.println("Second set: " + set2);
        System.out.println("Third set: " + set3);

        //uniting set1 and set2
        set1.union(set2);
        System.out.println("\n\nUnion of set1 and set2(saved in set1): " + set1);


        //intersecting set1 and set3
        set1.intersect(set3);
        System.out.println("\n\nIntersect of set1 and set3(saved in set1): " + set1);


        Set<Integer> set4 = new Set<Integer>();
        System.out.println("\n\nCreating a 4'th set from two ints that you are going to input");


        System.out.println("input 2 numbers to a new set4");
        set4.insert(new Integer(inputNum()));
        set4.insert(new Integer(inputNum()));

        //checking subset method of set4 in other sets
        System.out.println("set4: " + set4);

        if (set1.isSubset(set4))
            System.out.println("the new set is a subset of set1");
        else
            System.out.println("the new set isn't a subset of set1");

        if (set2.isSubset(set4))
            System.out.println("the new set is a subset of set2");
        else
            System.out.println("the new set isn't a subset of set2");

        if (set3.isSubset(set4))
            System.out.println("the new set is a subset of set3");
        else
            System.out.println("the new set isn't a subset of set3");

        //now getting number and making a couple of things with it
        System.out.println("\n\nnow receiving another num and checking all kinds of stuff with it");
        Integer userInput = new Integer(inputNum());

        if (set1.isMember(userInput)) {
            System.out.println(userInput + " is a member of set1");
        } else {
            System.out.println(userInput + " isn't a member of set1");
        }
        System.out.println("set1: " + set1);


        set2.insert(userInput);
        System.out.println("set2 after inserting " + userInput + " is: " + set2);

        set3.delete(userInput);
        System.out.println("set3 after deleting " + userInput + " is: " + set3);


    }


    private static void runsecondTests() {
        Set<Person> personSet = new Set<Person>();


        //populating set with persons
        personSet.insert(new Person("012345678", "firstPerson", "firstLastName", "1999"));
        personSet.insert(new Person("123456789", "secondPerson", "secondLastName", "2000"));
        personSet.insert(new Person("987654321", "my kid!", "gindi", "2028"));
        personSet.insert(new Person("000000000", "jesus", "christ", "0000"));
        personSet.insert(new Person("654789123", "niceGuy", "timeTravelers", "4585"));
        System.out.println("\n\n\ncreated a set of Persons, here it is: " + personSet);

        GenericMin genericMin = new GenericMin();

        System.out.println("\n\nactivating the generic min function, the guy with the lowest id here is : " + genericMin.Min(personSet));

    }


    //fills the Set with 10random numbers in range 0-100
    private static void fillIntegerSet(Set<Integer> set) {

        for (int i = 0; i < SETSIZE; i++) {

            //could enter duplicates, so making sure that there are SIZE amount in each group
            while (set.size() < i + 1) {
                set.insert(rand.nextInt(UPPERBOUND));
            }

        }

    }

    //get an int from the user
    private static int inputNum() {
        int res = 0;
        boolean good_input = false;
        while (!good_input) {
            try {
                System.out.println("please enter an integer");
                res = Integer.parseInt(scanner.next());
                good_input = true;
            } catch (Exception e) {
                System.out.println("please re-enter integer");
            }
        }
        return res;
    }
}

