package kata6;

import java.io.FileNotFoundException;
import java.util.Map;

public class Kata6 {
    Map<Integer, Integer> map;

    public static void main(String[] args) throws FileNotFoundException {
        Kata6 kata6 = new Kata6();
        kata6.execute();
    }

    private void execute() {
        input();
        output();
    }

    private void input() {
        MapCreator mapCreator = new MapCreator();
        map = mapCreator.getMegabytesMap();
    }

    private void output() {
        HistogramDisplay histoDisplay = new HistogramDisplay(map);
        histoDisplay.execute();
    }
}
