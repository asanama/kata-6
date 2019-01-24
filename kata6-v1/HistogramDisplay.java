package kata6;

import java.awt.Dimension;
import java.util.Map;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay extends ApplicationFrame {

    Map <Integer, Integer> map;

    public HistogramDisplay(Map<Integer, Integer> map) {
        super("Histogram");
        this.map = map;

        this.setContentPane(CreatePanel());
        pack();
    }

    private JPanel CreatePanel() {
        ChartPanel chartPanel = new  ChartPanel(CreateChart(CreateDataSet()));
        chartPanel.setPreferredSize(new Dimension(500,400));

        return chartPanel;
    }

      private JFreeChart CreateChart (DefaultCategoryDataset dataSet){
        JFreeChart chart;
        chart = ChartFactory.createBarChart("Histogram FreeChart",
                "Tamaño del fichero","Numero de ficheros del mismo tamaño", dataSet,PlotOrientation.VERTICAL,
                false,false,rootPaneCheckingEnabled);
        return chart;
    }

    private DefaultCategoryDataset CreateDataSet(){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();


        for (Integer key : map.keySet()) {
            dataSet.addValue(map.get(key), "", key);
        }
        return dataSet;
    }

    public void execute(){
        this.setVisible(true);
    }
}
