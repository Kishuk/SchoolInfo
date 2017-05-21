package com.school.helper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;


public class FileHelper {
  private static final String FILE_NAME = "/WEB-INF/Bangalore_schools.csv";
  private static List<Map<String, String>> schoolsData = new ArrayList<>();
  private static boolean isInitialized = false;

  public static List<Map<String, String>> getSchoolData(ServletContext sc) {
    if (!isInitialized) {
      readSchoolsData(sc);
    }
    
    return schoolsData;
  }

  private static synchronized void readSchoolsData(ServletContext sc) {
    String[] headers = new String[]{};
    String[] data = new String[]{};
    String line;
    try {
      InputStream fis = sc.getResourceAsStream(FILE_NAME);
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis, Charset.forName("utf-8")));
      
      while ((line = bufferedReader.readLine()) != null) {
        if (line.isEmpty() || line.startsWith("-")) {
          continue;
        }
        line = line.trim();
        headers = line.split("\\|");
        break;
      }   
      
      while ((line = bufferedReader.readLine()) != null) {
        if (line.isEmpty() || line.startsWith("-")) {
          continue;
        }
        line = line.trim();
        data = line.split("\\|");
        Map<String,String> schoolData = new HashMap<>();
        for (int i = 0; i < headers.length; i++) {
          System.out.println(headers[i] +"    ,  "+ data[i]);
          schoolData.put(headers[i], data[i]);
          
        }
        schoolsData.add(schoolData);
      }
      bufferedReader.close();
      isInitialized = true;
    } catch (FileNotFoundException ex) {
      System.out.println("Unable to open file '" + FILE_NAME + "'");
    } catch (IOException ex) {
      System.out.println("Error reading file '" + FILE_NAME + "'");
    }
  }

}
