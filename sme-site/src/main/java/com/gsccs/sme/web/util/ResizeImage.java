package com.gsccs.sme.web.util;

  
import javax.imageio.ImageIO;  

import java.awt.image.BufferedImage;  
import java.util.HashMap;  
import java.util.List;  
import java.util.ArrayList;  
import java.io.File;  
import java.io.IOException;  
import java.util.Map;  
  
/**
 * �̼��ϴ�ͼƬ��,����ͼƬ�Ĵ�С,
 * ����ͼƬ����ҳ̫��,���ʱ�Ῠ
 * @author Degree
 * 2012-6-13  ����3:41:18
 */
public class ResizeImage {  
  
    /** 
     * @param im            ԭʼͼ�� 
     * @param resizeTimes   ��Ҫ��С�ı�����С2��Ϊԭ����1/2 �������ֵԽ�󣬷��ص�ͼƬԽС 
     * @return              ���ش�����ͼ�� 
     */  
    public BufferedImage resizeImage(BufferedImage im, float resizeTimes) {  
        /*ԭʼͼ��Ŀ�Ⱥ͸߶�*/  
        int width = im.getWidth();  
        int height = im.getHeight();  
  
        /*������ͼƬ�Ŀ�Ⱥ͸߶�*/  
        int toWidth = (int) (Float.parseFloat(String.valueOf(width)) / resizeTimes);  
        int toHeight = (int) (Float.parseFloat(String.valueOf(height)) / resizeTimes);  
        
        /*����ɽ��ͼƬ*/  
        BufferedImage result = new BufferedImage(toWidth, toHeight, BufferedImage.TYPE_INT_RGB);  
  
        result.getGraphics().drawImage(im.getScaledInstance(toWidth, toHeight, java.awt.Image.SCALE_SMOOTH), 0, 0, null);  
        return result;  
    }  
  
    /** 
     * @param im            ԭʼͼ�� 
     * @param resizeTimes   ����,����0.5������Сһ��,0.98�ȵ�double���� 
     * @return              ���ش�����ͼ�� 
     */  
    public BufferedImage zoomImage(BufferedImage im, float resizeTimes) {  
        /*ԭʼͼ��Ŀ�Ⱥ͸߶�*/  
        int width = im.getWidth();  
        int height = im.getHeight();  
  
        /*������ͼƬ�Ŀ�Ⱥ͸߶�*/  
        int toWidth = (int) (Float.parseFloat(String.valueOf(width)) * resizeTimes);  
        int toHeight = (int) (Float.parseFloat(String.valueOf(height)) * resizeTimes);  
        
        /*����ɽ��ͼƬ*/  
        BufferedImage result = new BufferedImage(toWidth, toHeight, BufferedImage.TYPE_INT_RGB);  
  
        result.getGraphics().drawImage(im.getScaledInstance(toWidth, toHeight, java.awt.Image.SCALE_SMOOTH), 0, 0, null);  
        return result;  
    }  
    
    /** 
     * ��ͼƬ�ı�Ϊ277*277
     * @param im            ԭʼͼ�� 
     * @return              ���ش�����ͼ�� 
     */  
    public BufferedImage changeImage(BufferedImage im, int width, int height) {  
        /*������ͼƬ�Ŀ�Ⱥ͸߶�*/  
        int toWidth = width;  
        int toHeight = height;  
        
        /*����ɽ��ͼƬ*/  
        BufferedImage result = new BufferedImage(toWidth, toHeight, BufferedImage.TYPE_INT_RGB);  
  
        result.getGraphics().drawImage(im.getScaledInstance(toWidth, toHeight, java.awt.Image.SCALE_SMOOTH), 0, 0, null);  
        return result;  
    }
  
    /** 
     * 
     * @param path  Ҫת����ͼ����ļ���,���Ǵ��ͼ����ļ���·�� 
     * @param type  ͼƬ�ĺ�׺����ɵ����� 
     * @return 
     */  
    public List<BufferedImage> getImageList(String path, String[] type) throws IOException{  
        Map<String,Boolean> map = new HashMap<String, Boolean>();  
        for(String s : type) {  
            map.put(s,true);   
        }  
        List<BufferedImage> result = new ArrayList<BufferedImage>();  
        File[] fileList = new File(path).listFiles();  
        for (File f : fileList) {  
            if(f.length() == 0)  
                continue;  
            if(map.get(getExtension(f.getName())) == null)  
                continue;  
            result.add(javax.imageio.ImageIO.read(f));  
        }  
        return result;  
    }  
    
    /** 
     * 
     * @param path  Ҫת����ͼ��ĵ�ַ 
     * @return 
     */  
    public BufferedImage getImage(String path) throws IOException{  

        File f = new File(path);   
        return javax.imageio.ImageIO.read(f);  
    }
  
    /** 
     * ��ͼƬд�������� 
     * 
     * @param im 
     * @param path     eg: C://home// ͼƬд����ļ��е�ַ 
     * @param fileName DCM1987.jpg  д��ͼƬ������ 
     * @return 
     */  
    public boolean writeToDisk(BufferedImage im, String path, String fileName) {  
        File f = new File(path + fileName);  
        String fileType = getExtension(fileName);  
        if (fileType == null)  
            return false;  
        try {  
            ImageIO.write(im, fileType, f);  
            im.flush();  
            return true;  
        } catch (IOException e) {  
            return false;  
        }  
    }  
  
  
    public boolean writeHighQuality(BufferedImage im, String fileFullPath) {  
        try {  
            return true;  
        } catch (Exception e) {  
            return false;  
        }  
    }  
    
    /**
     * ����ļ������
     * @param im
     * @param fileFullPath
     * @return
     * 2012-6-13  ����5:05:35 
     */
    public boolean writeHighQualityByName(BufferedImage im, String fileFullPath, String fileName) {  
        try {  
        	File saveFile=new File(fileFullPath+fileName);  
        	ImageIO.write(im,"JPEG",saveFile); 
            return true;  
        } catch (Exception e) {  
            return false;  
        }  
    }  
  
    /** 
     * �����ļ����ļ���׺�� 
     * 
     * @param fileName 
     * @return 
     */  
    public String getExtension(String fileName) {  
        try {  
            return fileName.split("\\.")[fileName.split("\\.").length - 1];  
        } catch (Exception e) {  
            return null;  
        }  
    }  
  
    public static void main(String[] args) throws Exception{  
  
    	  /**
    	   * ����һ���ļ���
    	   */
        String inputFoler = "F:/image_user/default/avatar" ; /*�����д����Ҫ��СͼƬ���ļ���ȫ��ַ*/  
        String outputFolder = "F:/image_user/default/avatar/w50/";  /*�����д��ת�����ͼƬ��ŵ��ļ���*/  
        float times = 0.5f; /*���������Ҫת���ɵı���,�����1����ת����1��*/  
  
  
        ResizeImage r = new ResizeImage();  
        List<BufferedImage> imageList = r.getImageList(inputFoler,new String[]{"jpg"});  
        //��ǿforѭ��
        int n = 0;
        for(BufferedImage i : imageList) {  
        	n++;
            r.writeHighQualityByName(r.changeImage(i, 50, 50),outputFolder, "w50_"+n+".jpg");  
        }  
    	
    	/**
    	 * ��һ��ͼƬ
    	 */
//    	ResizeImage r = new ResizeImage(); 
//    	String imageURL = "C:/Documents and Settings/Administrator/����/12/17_1203909601296.jpg";
//    	String outputFolder = "C:/Documents and Settings/Administrator/����/13/";
//    	r.writeHighQualityByName(r.changeImage(r.getImage(imageURL), 200, 250),outputFolder, "hello.jpg");
    }  
}  
