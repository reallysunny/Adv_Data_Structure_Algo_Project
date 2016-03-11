/*
Author: Sunny Desai
Class:COMP 610
Project: So here what I am trying to do is getting the maximum of each truth 
assignment as if X1 has 10 true and 8 false, then we will take it as it is and if
for any other say X3 has 8 true and 10 false we will take it as false.
 */
package final610;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author reallysunny
 */
public class MaxSat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
    
    
    
    }
    void firstFast() throws FileNotFoundException{
    
        int count=0,
            neg_count=0,
            j,k;
       
        ArrayList arr=new ArrayList();
        ArrayList arr1=new ArrayList();
        ArrayList arr2=new ArrayList();
        System.out.println("Stage 1");
    File file = new File("/Users/reallysunny/Desktop/610/ut.txt");//path of file
    //Saving the elements in one array
    Scanner sc = new Scanner(file);
    while (sc.hasNextLine()) {
        
        int i = sc.nextInt();
        arr.add(i);
        
        
    }
    System.out.println("Stage 2");
    //Getting Unique string
    for(j=0;j<arr.size();j++){
        
        int flag=1;
        for(k=0;k<arr1.size();k++){
        if(Math.abs(Integer.parseInt(arr.get(j).toString())) == Math.abs(Integer.parseInt(arr1.get(k).toString())))
        {
        flag=0;
        }
        }
        if(flag==1)
        {
        arr1.add(Math.abs(Integer.parseInt(arr.get(j).toString())));
        }
            }
    //Math.abs(Integer.parseInt(arr.get(j).toString())) == Math.abs(Integer.parseInt(arr1.get(k).toString()))
        int z[]=new int[arr1.size()]; 
        
        System.out.println("Stage 3");
        //comparing for maximum individual
    for(j=0;j<arr1.size();j++){
        int temp=(int) arr1.get(j);
        int neg_temp=temp * -1;
        int flag=1;
        int c=0, cn=0;
        for(k=0;k<arr.size();k++){
        if(arr.get(k).equals(temp))
        {
          c++;
        }
        else if(arr.get(k).equals(neg_temp))
        {
            cn++;
        }
       
        }
        if(cn>c){
            z[j]=-1;
        }
        else if(c>=cn){
            z[j]=1;
        }
        
            }
    
    
    System.out.println("Stage 4");
    for(k=0;k<z.length;k++){
    int t=(int) arr1.get(k);//positive temp
    int n_t=t * -1;//negative temp
    //System.out.println(t + " : " + n_t);
    //if 
    if(z[k]<0){
        
    for(int i=0;i<arr.size();i++)
    {   
        if(arr.get(i).equals(t))
        {
            
            arr.set(i, n_t);
            
        }
        else if(arr.get(i).equals(n_t))
        {
            arr.set(i,t);
            
        }
    
    }
    
    }//if condition
    
    }//for end
    int satisfy=0, temp=0;
    for(int a=0; a<arr.size();a=a+2)
            {  temp=j+1;
                //if first element is negative
                if(Integer.parseInt(arr.get(a).toString())>0){
                satisfy++;
                continue;
                }
                //if first element is negative
                else if(Integer.parseInt(arr.get(temp).toString())>0){
                satisfy++;
                //continue;
                }
            }
    
    System.out.println(satisfy);
    
    
    
    
    
    }
    
    
    
    
    
    }
    

