import java.util.ArrayList;
//"cat" "ide" "dolphin" "alpaca" "meow" "deer"
public class SortedListWorksCheck {
    public static void main(String[] args) {
        ArrayList<String> test0 = new ArrayList<>();
            test0.add("cat");
            test0.add("ide");
            test0.add("dolphin");
            test0.add("alpaca");
            test0.add("meow");
            test0.add("deer");
            String test1 = "ide";
        System.out.println(SortedList.searchDataSet(test0, test1));
    }
}