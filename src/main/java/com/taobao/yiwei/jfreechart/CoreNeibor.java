package com.taobao.yiwei.jfreechart;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.io.File;
import java.io.IOException;
 
import javax.swing.JPanel;
 
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
 
public class CoreNeibor extends ApplicationFrame {
	
	private static final long serialVersionUID = 1L;

	public CoreNeibor(String s) {
        super(s);
        setContentPane(createDemoLine());
    }
	
	public static void main(String[] args) {
	    CoreNeibor fjc = new CoreNeibor("折线图");
	    fjc.pack();
	    RefineryUtilities.centerFrameOnScreen(fjc);
	    fjc.setVisible(true);
	}
 
    // 生成显示图表的面板
    public static JPanel createDemoLine() {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }
 
    // 生成图表主对象JFreeChart
    public static JFreeChart createChart(DefaultCategoryDataset linedataset) {
        //创建主题样式        
        StandardChartTheme standardChartTheme=new StandardChartTheme("CN");       
        //设置标题字体        
        standardChartTheme.setExtraLargeFont(new Font("隶书",Font.BOLD,20));       
        //设置图例的字体       
        standardChartTheme.setRegularFont(new Font("宋书",Font.PLAIN,15));       
        //设置轴向的字体      
        standardChartTheme.setLargeFont(new Font("宋书",Font.PLAIN,15));       
        //应用主题样式     
        ChartFactory.setChartTheme(standardChartTheme);
        //定义图表对象
        JFreeChart chart = ChartFactory.createLineChart("折线图", // chart title
                "Eps", // domain axis label
                "", // range axis label
                linedataset, // data
                PlotOrientation.VERTICAL, // orientation
                true, // include legend
                true, // tooltips
                false // urls
                );
        chart.setBackgroundPaint(new GradientPaint(0,0,Color.white,500,0,Color.LIGHT_GRAY));
        CategoryPlot plot = chart.getCategoryPlot();
        // customise the range axis...
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangeAxis.setAutoRangeIncludesZero(true);
        rangeAxis.setUpperMargin(0.20);
        rangeAxis.setLabelAngle(Math.PI / 2.0);
        plot.setForegroundAlpha(1.0f);
        plot.getRenderer().setSeriesPaint(0, Color.red) ;
        plot.getRenderer().setSeriesPaint(1, Color.blue) ;
 
        //获取折线对象
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();        
        BasicStroke realLine = new BasicStroke(3.6f);       //设置实线
        float dashes[] = { 8.0f };                      //定义虚线数组
        BasicStroke brokenLine = new BasicStroke(3.6f,      //线条粗细
                BasicStroke.CAP_SQUARE,             //端点风格
                BasicStroke.JOIN_MITER,                 //折点风格
                8.f,                                //折点处理办法
                dashes,                         //虚线数组
                0.0f);                          //虚线偏移量
        renderer.setSeriesStroke(1, brokenLine);     //利用虚线绘制
 
        renderer.setSeriesStroke(0, realLine);    //利用实线绘制
         
        try {
            ChartUtilities.saveChartAsPNG(new File("C:/Users/zhigang.xzg/Downloads/coreNeibor.png"), chart, 500, 500);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
 
 
        return chart;
    }
 
    //生成数据
    public static DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset linedataset = new DefaultCategoryDataset();
        // 各曲线名称
        String series1 = "核心点数";
        String series2 = "簇数";
 
        //    横轴名称(列名称)
        String type1 = "0.1";
        String type2 = "0.2";
        String type3 = "0.25";
        String type4 = "0.3";
        String type5 = "0.4";
 
        linedataset.addValue(900, series1, type1);
        linedataset.addValue(1500, series1, type2);
        linedataset.addValue(2010, series1, type3);
        linedataset.addValue(2501, series1, type4);
        linedataset.addValue(3500, series1, type5);
 
        linedataset.addValue(300, series2, type1);
        linedataset.addValue(600, series2, type2);
        linedataset.addValue(800, series2, type3);
        linedataset.addValue(604, series2, type4);
        linedataset.addValue(590, series2, type5);
 
 
        return linedataset;
    }
 
}