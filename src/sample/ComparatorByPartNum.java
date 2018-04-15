package sample;
import basic.BikePart;

import java.util.Comparator;
/**ComparatorByPartNum
 * a specification of what will be sorted in a inventory ArrayList by Part Number
 *  @author scoronado
 */
public class ComparatorByPartNum implements Comparator<BikePart> {

    /** compare(o1, o2)
     * @param o1 - one BikePart
     * @param o2 - another BikePart
     * @return - compared Order of two BikeParts
     */
    @Override
    public int compare(BikePart o1, BikePart o2) {
        //syntax fetched from https://stackoverflow.com/questions/2839137/how-to-use-comparator-in-java-to-sort
        return o1.getPartNumber() < o2.getPartNumber() ? -1 : o1.getPartNumber() == o2.getPartNumber() ? 0 : 1;
    }
}
