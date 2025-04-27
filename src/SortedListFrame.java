import javax.swing.*;
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class SortedListFrame extends JFrame {
    JPanel MAIN;
        JPanel ACTIONSAREA;
        JTextArea SEARCHBAR,DATABAR,RESULT;
        JScrollPane RESULTPANE;
        JButton SEARCH,QUIT,ADDDATA;
        GridLayout LAYOUTMAIN, SUBLAYOUT0;
        int INDEXOFQUERYFIRSTOCCURENCE;
    public SortedListFrame(){
        MAIN = new JPanel();
            LAYOUTMAIN = new GridLayout(1,1);
            MAIN.setLayout(LAYOUTMAIN);
        BUILDACTIONSAREA();
            MAIN.add(ACTIONSAREA);
        add(MAIN);
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void BUILDACTIONSAREA(){
        ACTIONSAREA = new JPanel();
            SUBLAYOUT0 = new GridLayout(3,2);
            ACTIONSAREA.setLayout(SUBLAYOUT0);
            DATABAR = new JTextArea();
            SEARCHBAR = new JTextArea();
            RESULT = new JTextArea();
            SEARCH = new JButton("SEARCH");
            QUIT = new JButton("QUIT");
        RESULTPANE = new JScrollPane();
            RESULT.setEditable(false);
            RESULT.setText("Result appears here after use");
            RESULTPANE.add(RESULT);
        ACTIONSAREA.add(DATABAR);
            ACTIONSAREA.add(SEARCHBAR);
            ACTIONSAREA.add(SEARCH);
            ACTIONSAREA.add(RESULT);
            ACTIONSAREA.add(QUIT);
        DATABAR.setText("Put your data here " +
                "(Place a newline between each piece of data)");
            SEARCHBAR.setText("Input your query here");
        SEARCH.addActionListener((ActionEvent ae) -> {
            String LOOKFOR = SEARCHBAR.getText();
                ArrayList<String> WOWITSALISTNOW = new ArrayList<>();
                String[] IAMMAKINGTHISINTOANARRAYLIST = DATABAR.getText().split("\n");
            for (String GOESINPLZWORK : IAMMAKINGTHISINTOANARRAYLIST) {
                if (!GOESINPLZWORK.trim().isEmpty()) {
                    WOWITSALISTNOW.add(GOESINPLZWORK.trim().toLowerCase());
                }
            }
           String[] WOWITSALISTNOWSORTED = new String[WOWITSALISTNOW.size()];
               WOWITSALISTNOW.toArray(WOWITSALISTNOWSORTED);
               Arrays.sort(WOWITSALISTNOWSORTED);
                    StringBuilder sortedDatasetBuilder = new StringBuilder();
               for (String s : WOWITSALISTNOWSORTED) {
                    sortedDatasetBuilder.append(s).append("\n");
               }
               String SORTED_DATASET_TEXT = sortedDatasetBuilder.toString().trim();
               INDEXOFQUERYFIRSTOCCURENCE = SortedList.searchDataSet(WOWITSALISTNOW, LOOKFOR.toLowerCase(Locale.ROOT));
               RESULT.setText("String: " + LOOKFOR +
                        " occurs at index: " + INDEXOFQUERYFIRSTOCCURENCE +
                        " of your dataset for the first time."  +
                        "\n" + "Sorted dataset: \n" + SORTED_DATASET_TEXT);
        });
        QUIT.addActionListener((ActionEvent ae) -> {
            System.exit(0);
        });
    }
}
