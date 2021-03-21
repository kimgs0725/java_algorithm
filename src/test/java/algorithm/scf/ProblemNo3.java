package algorithm.scf;

import java.text.DecimalFormat;
import java.util.*;

public class ProblemNo3 {

    private String findNumberOfCaseBySize(int[][] space) {
        return "";
    }
}

class Content {
    char genre;
    float preference;
    int x;
    int y;

    @Override
    public String toString() {
        return genre + " "
                + Float.toString(preference) + " "
                + Integer.toString(x) + " "
                + Integer.toString(y);
    }
}
