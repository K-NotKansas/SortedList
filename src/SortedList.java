import java.util.Arrays;
public class SortedList {
    public static int searchDataSet(String[] toSearch, String searchFor) {
        Arrays.sort(toSearch);
        int left = 0;
            int right = toSearch.length - 1;
        while (left <= right) {
            int center = left + (right - left) / 2;
                if (toSearch[center].equals(searchFor)) {
                    return center;
                }
                if (toSearch[center].compareTo(searchFor) < 0) {
                    left = center + 1;
                } else {
                    right = center - 1;
                }
        }
        return 400;
    }
}