package sample;

import java.util.Comparator;

/**ComparatorByPartName()
 * a specification of what will be sorted in a inventory ArrayList by Part Name
 *  @author scoronado
 */

public class ComparatorByPartName implements Comparator<BikePart>{
    /** compare(o1, o2)
     * @param o1 - one BikePart
     * @param o2 -another BikePart
     * @return - compared Order of two BikeParts
     */
    @Override
    public int compare(BikePart o1, BikePart o2) {
        return o1.getPartName().compareToIgnoreCase(o2.getPartName());
    }
}
