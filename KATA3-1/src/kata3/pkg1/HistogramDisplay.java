package kata3.pkg1;

import java.awt.Dimension;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;



public class HistogramDisplay extends ApplicationFrame {
    private final Histogram<String> histogram;

    public HistogramDisplay(Histogram<String> histogram) {
        super("HISTOGRAMA");
        this.histogram = histogram;
        setContentPane(createPanel());
        pack();
    }
    
    private ChartPanel createPanel(){ 
        ChartPanel chartPanel = new ChartPanel(createChart(createDataSet()));
        chartPanel.setPreferredSize(new Dimension(500, 400));
        return chartPanel;
    }
    //dataset--> conjunto de datos que va a recibir dataset
    private JFreeChart createChart(DefaultCategoryDataset dataset){
        JFreeChart chart = ChartFactory.createBarChart
        (null, "Dominio", "Nº Email", dataset, PlotOrientation.VERTICAL, true, true, false);
        return chart;
       
    }
    private DefaultCategoryDataset createDataSet(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(String key : histogram.keySet()){
            dataset.addValue(histogram.get(key), "", key);
        }
        return dataset;
    }
    public void execute(){
        setVisible(true);
    }
}
