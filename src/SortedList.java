import java.util.ArrayList;
import java.util.Arrays;
public class SortedList {
    public static int searchDataSet(ArrayList<String> toSearch, String searchFor) {
        String[] sortedArray = new String[toSearch.size()];
            toSearch.toArray(sortedArray);
            Arrays.sort(sortedArray);
        int left = 0;
            int right = sortedArray.length - 1;
        while (left <= right) {
            int center = left + (right - left) / 2;
            if (sortedArray[center].equals(searchFor)) {
                    return center;
                }
            if (sortedArray[center].compareTo(searchFor) < 0) {
                    left = center + 1;
                } else {
                    right = center - 1;
                }
        }
        return 400;
    }
}