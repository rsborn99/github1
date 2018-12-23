package com.airwallex.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;

/**
 *
 * @author juweiwei
 * @version $Id CSVUtil.java  v0.1 2018.12.22 19:28:01 juweiwei Exp$
 */
public class CSVUtil implements Iterator<Object[]> {
    BufferedReader in;
    ArrayList<String> csvList=new ArrayList<String>();
    int rowNum=0;
    int columnNum=0;
    int curRowNo=0;
    String columnName[];
    /**
     * @param fileName
     * @throws IOException
     */
    public CSVUtil(String fileName) {
        File directory=new File(".");
        String path=".src.test.resources.testcase.";

        try {
            if (System.getProperties().getProperty("os.name").contains("Windows")) {
                path = path.replaceAll("\\.", Matcher.quoteReplacement("\\")) + fileName;
            }else {
                path = path.replaceAll("\\.", Matcher.quoteReplacement("/")) + fileName;
            }
            String absolutePath=directory.getCanonicalPath()+path;
            System.out.println(absolutePath);
            File csv=new File(absolutePath);
            in=new BufferedReader(new FileReader(csv));
            while (in.ready()) {
                csvList.add(in.readLine());
                this.rowNum++;
            }
        }catch (Throwable t){
            System.out.println("error!!!");
        }


        String[] str=csvList.get(0).split("\\|");
        this.columnNum=str.length;
        columnName=new String[columnNum];

        for (int i = 0; i < columnNum; i++) {
            columnName[i]=str[i];
        }
        this.curRowNo++;
    }
    @Override
    public boolean hasNext() {
        if(rowNum==0||curRowNo>=rowNum){
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }else{
            return true;
        }
    }
    /**
     *
     */
    @Override
    public Object[] next() {
        Map<String,String> s=new TreeMap<String,String>();
        String csvCell[]=csvList.get(curRowNo).split("\\|");
        for(int i=0;i<this.columnNum;i++){
            s.put(columnName[i], csvCell[i]);
        }
        Object[] d=new Object[1];
        d[0]=s;
        this.curRowNo++;
        return d;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove unsupported");
    }

}