package com.taobao.yiwei.jfreechart;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

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

//JFreeChart Line Chart（折线图）     
public class TestJfreeChart { 
    /**
     * 创建JFreeChart Line Chart（折线图）
     * @throws IOException
     */ 
    public static void main(String[] args) throws IOException { 
        // 步骤1：创建CategoryDataset对象（准备数据）  
        CategoryDataset dataset = createDataset(); 
        // 步骤2：根据Dataset 生成JFreeChart对象，以及做相应的设置  
        JFreeChart freeChart = createChart(dataset); 
        // 步骤3：将JFreeChart对象输出到文件，Servlet输出流等  
        ChartUtilities.saveChartAsJPEG(new File("C:/Users/zhigang.xzg/Downloads/aaaa.jpg"), freeChart, 800, 600);
//        saveAsFile(freeChart, "E:\\line.jpg", 600, 400); 
//
//  ByteArrayOutputStream bos = new ByteArrayOutputStream();
//  ChartUtilities.writeChartAsJPEG(bos, freeChart, 1000, 1000);
//  System.out.println(bos.toByteArray());
    } 
 
//    // 保存为文件  
//    public static void saveAsFile(JFreeChart chart, String outputPath, 
//            int weight, int height) { 
//        FileOutputStream out = null; 
//        try { 
//            File outFile = new File(outputPath); 
//            if (!outFile.getParentFile().exists()) { 
//                outFile.getParentFile().mkdirs(); 
//            } 
//            out = new FileOutputStream(outputPath); 
//            // 保存为PNG  
//            // ChartUtilities.writeChartAsPNG(out, chart, 600, 400);  
//            // 保存为JPEG  
//            ChartUtilities.writeChartAsJPEG(out, chart, 600, 400); 
//            out.flush(); 
//        } catch (FileNotFoundException e) { 
//            e.printStackTrace(); 
//        } catch (IOException e) { 
//            e.printStackTrace(); 
//        } finally { 
//            if (out != null) { 
//                try { 
//                    out.close(); 
//                } catch (IOException e) { 
//                    // do nothing  
//                } 
//            } 
//        } 
//    } 
 
    // 根据CategoryDataset创建JFreeChart对象  
    public static JFreeChart createChart(CategoryDataset categoryDataset) { 
        // 创建JFreeChart对象：ChartFactory.createLineChart  
        JFreeChart jfreechart = ChartFactory.createLineChart("Antibody Titration", // 标题  
                "Antibody Titration(X1000)", // categoryAxisLabel （category轴，横轴，X轴标签）  
                "OD 450", // valueAxisLabel（value轴，纵轴，Y轴的标签）  
                categoryDataset, // dataset  
                PlotOrientation.VERTICAL, true, // legend  
                false, // tooltips  
                false); // URLs  
        // 使用CategoryPlot设置各种参数。以下设置可以省略。  
        CategoryPlot plot = (CategoryPlot)jfreechart.getPlot(); 
        // 背景色 透明度  
        plot.setBackgroundAlpha(0.0f); 
        //设置网格横线颜色   
        plot.setBackgroundPaint(Color.white); 
        plot.setRangeGridlinePaint(Color.black);   
        // 前景色 透明度  
        plot.setForegroundAlpha(1.0f); 
        NumberAxis numberaxis = (NumberAxis) plot.getRangeAxis();
        ValueAxis valueAxis = plot.getRangeAxis();
        valueAxis.setStandardTickUnits(NumberAxis.createStandardTickUnits());//Y轴显示整数
        //设置纵坐标值的间距为10
        numberaxis.setTickUnit(new NumberTickUnit(0.80));
        numberaxis.setRangeWithMargins(0, 10);
        numberaxis.setTickMarkOutsideLength((float) 1);
        numberaxis.setTickMarkInsideLength((float) 1);
        // 其他设置 参考 CategoryPlot类  
        LineAndShapeRenderer renderer = (LineAndShapeRenderer)plot.getRenderer(); 
        renderer.setBaseShapesVisible(true); // series 点（即数据点）可见  
        renderer.setBaseLinesVisible(true); // series 点（即数据点）间有连线可见  
        renderer.setUseSeriesOffset(true); // 设置偏移量  
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator()); 
        renderer.setBaseItemLabelsVisible(false); 
        return jfreechart; 
    } 
 
    /**
     * 创建CategoryDataset对象
     * 
     */ 
    public static CategoryDataset createDataset() { 
//        String[] rowKeys = {"Antibody dilution (X1000)"}; 
//        String[] colKeys = {"1", "2", "4", "8", "16", "32", 
//                "64", "128", "256", "512"}; 
//        double[][] data = {{0.691, 2.554, 2.423, 2.283, 2.242, 2.059, 1.899, 1.518, 1.179, 0.921},}; 
////        // 或者使用类似以下代码  
////         DefaultCategoryDataset categoryDataset = new DefaultCategoryDataset();  
////         categoryDataset.addValue(10, rowKeys, colKeys);  
//        System.out.println(data.length);
//        return DatasetUtilities.createCategoryDataset(rowKeys, colKeys, data); 
     DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
     dataSet.addValue(1, "Rabbit1", "1");
     dataSet.addValue(2, "Rabbit1", "2");
     dataSet.addValue(3, "Rabbit1", "4");
     dataSet.addValue(4, "Rabbit1", "8");
     dataSet.addValue(5, "Rabbit1", "16");
     dataSet.addValue(6, "Rabbit1", "32");
     dataSet.addValue(7, "Rabbit1", "64");
     dataSet.addValue(7, "Rabbit1", "128");
     dataSet.addValue(8, "Rabbit1", "256");
     dataSet.addValue(9, "Rabbit1", "512");
     dataSet.addValue(10, "Rabbit2", "1");
     dataSet.addValue(0, "Rabbit2", "2");
     dataSet.addValue(9, "Rabbit2", "4");
     dataSet.addValue(6, "Rabbit2", "8");
     dataSet.addValue(4, "Rabbit2", "16");
     dataSet.addValue(6, "Rabbit2", "32");
     dataSet.addValue(9, "Rabbit2", "64");
     dataSet.addValue(3, "Rabbit2", "128");
     dataSet.addValue(2, "Rabbit2", "256");
     dataSet.addValue(6, "Rabbit2", "512");
     return dataSet;
    }
}
