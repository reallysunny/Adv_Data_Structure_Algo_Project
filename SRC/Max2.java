/*
Author: Sunny Desai
Date:8th May, 2015
Max2Sat with regulat all true and all false: if majority of instance is more than 70 percent
 */
package final610;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author reallysunny
 */
public class Max2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
    }
    
    void secondFast() throws FileNotFoundException, IOException{
    
        int count=0,//positive integer counter
                neg_count=0,//negative int counter
                l=0,//linecount
                count_l=0,//save num of lines
                satisfy=0;//maximum satisfiability
        ArrayList arr=new ArrayList();
FileInputStream fstream = new FileInputStream("/Users/reallysunny/Desktop/610/ut.txt");
BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

String lineStr;
//count number of lines
while ( br.readLine() != null)   {
    l++;
    
}
System.out.println ("Number of lines: " + l);
//Close the input stream
//br.close();

count_l=l;


//scan the file for positive negetives
    File file = new File("/Users/reallysunny/Desktop/610/ut.txt");//path of file
    Scanner sc = new Scanner(file);
    while (sc.hasNextLine()) {
        
        int i = sc.nextInt();
        if(i>=0){
          //  System.out.println(i);
            count++;
        }
        else
        {
           // System.out.println(i);
            neg_count++;
        }
        
    }
    sc.close();
    System.out.println("Positive Numbers:" + count);
        System.out.println("Negative Numbers:" + neg_count);
       // System.out.println("Number of Lines:" + l);
        
        double total= count + neg_count;
        
        
        
        
        //SECOND PART
        if(count>=((0.7)*total) || neg_count>=((0.7)*total) ){
        
        //if positives are greater than negative
        if(count>=neg_count){
            //positive
        try {
            ArrayList arr1 = new ArrayList();
            arr1.clear();
            satisfy=0;
           // System.out.println("I am  in Positive" );
        Scanner sc1 = new Scanner(file);
        while (sc1.hasNextLine()) {
            int i = sc1.nextInt();
            
            arr1.add(i);
            
            
            }
        int temp=0;
        for(int j=0; j<arr1.size();j=j+2)
            {   temp=j+1;
                // System.out.println("I am  in for" );
                //if first element is positive
                if(Integer.parseInt(arr1.get(j).toString())>0){
                   // System.out.println(arr1.get(j) );
                satisfy++;
                continue;
                }
                //if first element is positive
                else if(Integer.parseInt(arr1.get(temp).toString())<0){
                //satisfy++;
                    System.out.println(arr1.get(temp) + " " + temp );
                continue;
                }
             satisfy++;
            }
        sc1.close();
    }
    catch (FileNotFoundException e) {
        e.printStackTrace();
    }
        
        
        }
        
        //if negatives are greater than positive
        else if(count<neg_count){
            //negatve
        try {
            ArrayList arr1 = new ArrayList();
            arr1.clear();
            satisfy=0;
           // System.out.println("I am  in Positive" );
        Scanner sc1 = new Scanner(file);
        while (sc1.hasNextLine()) {
            int i = sc1.nextInt();
            
            arr1.add(i);
            
            
            }
        System.out.println("First Element" + arr1.get(11));
        for(int j=0; j<arr1.size();j=j+2)
            {  //if first element is negative
                if(Integer.parseInt(arr1.get(j).toString())>0){
                satisfy++;
                continue;
                }
                //if first element is negative
                else if(Integer.parseInt(arr1.get(++j).toString())>0){
                satisfy++;
                //continue;
                }
            }
        sc1.close();
    }
    catch (FileNotFoundException e) {
        e.printStackTrace();
    }
        
        
        }
        
        System.out.println("Maximum Satisfiability:" + satisfy);
        }
        else{
        System.out.println("minimum required ratio of 70% is not satisfied");
        }
    
    }
    
    
}
