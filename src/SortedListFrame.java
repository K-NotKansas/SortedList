import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class SortedListFrame extends JFrame {
    JPanel MAIN;
    JPanel ACTIONSAREA;
    JTextArea SEARCHBAR,DATABAR,RESULT;
    JScrollPane RESULTPANE;
    JButton SEARCH,QUIT;
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
        RESULTPANE.add(RESULT);

        ACTIONSAREA.add(DATABAR);
        ACTIONSAREA.add(SEARCHBAR);
        ACTIONSAREA.add(SEARCH);
        ACTIONSAREA.add(RESULT);
        ACTIONSAREA.add(QUIT);


        DATABAR.setText("Input your pieces of data here and press the appropriate button" + "\n" + "after every new piece");
        SEARCHBAR.setText("Input your query here (case sensitive)");

        SEARCH.addActionListener((ActionEvent ae) -> {
            String SEPARATEBY = ",";
            String lookFor = SEARCHBAR.getText();

            String[] searchThis = new String[]{DATABAR.getText()};

            //searchThis.(DATABAR.getText());

            INDEXOFQUERYFIRSTOCCURENCE = BinarySearchReturnsLocWDat.searchDataSet(searchThis, lookFor);

            RESULT.setText("String: " + lookFor + " occurs at index: " + INDEXOFQUERYFIRSTOCCURENCE + " of your dataset for the first time." );
        } );

        QUIT.addActionListener((ActionEvent ae) -> {
            System.exit(0);
        });

    }
    public static void main(String[] args) {
        JFrame frame = new SortedListFrame();
    }
}
