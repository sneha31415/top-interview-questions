package C15_greedy_algos;
import java.util.*;

public class A5_Maximum_Undefended_area {
//    1 indexed cordinates
    public static int maximumUndefendedArea(List<int[]> towerCordinates, int gridRows, int gridCols) {
        List<Integer> X = new ArrayList<>();
        List<Integer> Y = new ArrayList<>();
        for (int[] towerCordinate : towerCordinates){
            X.add(towerCordinate[0]);
            Y.add(towerCordinate[1]);
        }
//        no  tower case
        if (X.size() == 0 || Y.size() == 0) return gridRows * gridCols;
        Collections.sort(X);
        Collections.sort(Y);

        List<Integer> deltaX = new ArrayList<>();
        List<Integer> deltaY = new ArrayList<>();

        int startX = 0;
        int startY = 0;
        for (int i = 0; i < X.size(); i++) {
            deltaX.add(X.get(i) - startX - 1);
            startX = X.get(i);

            deltaY.add(Y.get(i) - startY - 1);
            startY = Y.get(i);
        }

//        for the last tower
        deltaX.add( gridRows - X.get(X.size() - 1) );
        deltaY.add( gridCols - Y.get(Y.size() - 1) );

//        maximum area is the multiplication of maxdelta x and maxdelta y
        int maxDeltaX = Collections.max(deltaX);
        int maxDeltaY = Collections.max(deltaY);
        return maxDeltaX * maxDeltaY;
    }

    public static int maximumUndefendedAreaNeater(List<int[]> towerCordinates, int gridRows, int gridCols) {
        List<Integer> X = new ArrayList<>();
        List<Integer> Y = new ArrayList<>();
        for (int[] towerCordinate : towerCordinates){
            X.add(towerCordinate[0]);
            Y.add(towerCordinate[1]);
        }
//        no  tower case
        if (X.size() == 0) return gridRows * gridCols;
        Collections.sort(X);
        Collections.sort(Y);

        int maxDeltaX = X.get(0) - 0 - 1;
        int maxDeltaY = Y.get(0) - 0 - 1;
        for (int i = 1; i < X.size(); i++) {
            maxDeltaX = Math.max(maxDeltaX, X.get(i) - X.get(i - 1) - 1);
            maxDeltaY = Math.max(maxDeltaY, Y.get(i) - Y.get(i - 1) - 1);
        }

//        for the last tower(gap between it(last tower) and the last row/col)
        maxDeltaX = Math.max(maxDeltaX, gridRows - X.get(X.size() - 1) );
        maxDeltaY = Math.max(maxDeltaY, gridCols - Y.get(Y.size() - 1) );

//        maximum area is the multiplication of maxdelta x and maxdelta y
        return maxDeltaX * maxDeltaY;
    }
    public static void main(String[] args) {
        int gridRows = 15;
        int gridCols = 8;
        List<int[]> towerCordinates = new ArrayList<>();
        Collections.addAll(towerCordinates, new int[]{3, 8}, new int[]{8, 6}, new int[]{11, 2});
        System.out.println(maximumUndefendedArea(towerCordinates, gridRows, gridCols));
        System.out.println(maximumUndefendedAreaNeater(towerCordinates, gridRows, gridCols));
    }
}
