package com.taobao.yiwei.jfreechart;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

// Line Chart（折线图）     
public class LineChart { 
    /**
     * 创建JFreeChart Line Chart（折线图）
     * @throws IOException
     */ 
    public static void main(String[] args) throws IOException { 
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");  
    	Map<Date, Double> data = new HashMap<Date, Double>();
    	try {
			data.put(df.parse("2015-5-25"), 1.2);
	    	data.put(df.parse("2015-5-26"), 1.1);
	    	data.put(df.parse("2015-5-27"), 1.5);
	    	data.put(df.parse("2015-5-28"), 0.9);
	    	data.put(df.parse("2015-5-29"), 1.0);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	String chartName = "my chart";
    	String fileStr = "D:/test.png";
    	double baseLine = 1.1;
    	int width = 600;
    	int height = 450;
    	
        // 步骤1：创建CategoryDataset对象（准备数据）  
        CategoryDataset dataset = createDataset(sortMapByKey(data), baseLine); 
        // 步骤2：根据Dataset 生成JFreeChart对象，以及做相应的设置  
        JFreeChart freeChart = createChart(dataset, chartName, baseLine*2 , baseLine/5); 
        // 步骤3：将JFreeChart对象输出到文件，Servlet输出流等  
        ChartUtilities.saveChartAsPNG(new File(fileStr), freeChart, width, height);
    } 
    
    public static Map<Date, Double> sortMapByKey(Map<Date, Double> oriMap) {  
        if (oriMap == null || oriMap.isEmpty()) {  
            return null;  
        }  
        Map<Date, Double> sortedMap = new TreeMap<Date, Double>(new Comparator<Date>() {  
            public int compare(Date date1, Date date2) {  
                return date1.compareTo(date2);  
            }});  
        sortedMap.putAll(oriMap);  
        return sortedMap;  
    } 
 
    /**
     * 根据CategoryDataset创建JFreeChart对象  
     */ 
    public static JFreeChart createChart(CategoryDataset categoryDataset, String title, double upper, double unit) { 
        // 定义图表对象
        JFreeChart chart = ChartFactory.createLineChart(
        		title,  // chart title
                "date", // domain axis label
                "rt",   // range axis label
                categoryDataset, // data
                PlotOrientation.VERTICAL, // orientation
                true,   // include legend
                false,  // tooltips  
                false); // urls  
        // 使用CategoryPlot设置各种参数
        CategoryPlot plot = (CategoryPlot)chart.getPlot(); 
        plot.setBackgroundAlpha(0.0f);  // 背景色 透明度  
        plot.setBackgroundPaint(Color.GRAY); 
        plot.setRangeGridlinePaint(Color.BLACK); //设置网格横线颜色   
        plot.setForegroundAlpha(1.0f);  // 前景色 透明度  
        
        NumberAxis numberaxis = (NumberAxis) plot.getRangeAxis();
        //设置纵坐标值的间距
        numberaxis.setTickUnit(new NumberTickUnit(unit));
        numberaxis.setRangeWithMargins(0, upper);
        numberaxis.setTickMarkOutsideLength((float) 1);
        numberaxis.setTickMarkInsideLength((float) 1);
        
        ValueAxis valueAxis = plot.getRangeAxis();
        valueAxis.setStandardTickUnits(NumberAxis.createStandardTickUnits());//Y轴显示整数
        
        // 获取折线对象
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer(); 
        renderer.setSeriesPaint(0, Color.blue);  // 折线颜色
        renderer.setSeriesPaint(1, Color.red);
        renderer.setBaseShapesVisible(true); // series 点（即数据点）可见  
        renderer.setBaseLinesVisible(true);  // series 点（即数据点）间有连线可见  
        renderer.setUseSeriesOffset(false);  // 设置偏移量  
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator()); 
        renderer.setBaseItemLabelsVisible(false); 
        return chart; 
    } 
 
    /**
     * 创建CategoryDataset对象
     */ 
    public static CategoryDataset createDataset(Map<Date, Double> data, double baseLine) { 
    	SimpleDateFormat df = new SimpleDateFormat("MM-dd");
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        for (Date key : data.keySet()) {
    	    dataSet.addValue(baseLine, "BaseLine", df.format(key));
    	    dataSet.addValue(data.get(key), "Perf", df.format(key));
        }
        return dataSet;
    }
}
