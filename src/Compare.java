import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Compare implements java.util.Comparator<Passenger> {

    /**
     *
     * compare the two values and sort them in the ascending order
     */

    @Override
    public int compare(Passenger p1, Passenger p2) {
        return p1.getName().compareTo(p2.getName());
    }

}
