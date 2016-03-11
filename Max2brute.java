/*
Author: Sunny Desai
Class:COMP 610
Project
 */
package final610;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * @author reallysunny
 */
public class Max2brute {
   static int satisfy=0;
    public static void main(String[] args) throws FileNotFoundException {

    }
    void bruteMax() throws FileNotFoundException{
    
        Truthtable tt = new Truthtable();
        
    int count=0,
        neg_count=0,
        j,k,
            n;//number of unique elements
       
    ArrayList arr=new ArrayList(); 
    ArrayList arr1=new ArrayList();
    File file = new File("/Users/reallysunny/Desktop/610/ut.txt");//path of file
    //Saving the elements in one array
    Scanner sc = new Scanner(file);
    while (sc.hasNextLine()) {
        
        int i = sc.nextInt();
        arr.add(i);
        
        
    }
    //System.out.println("Stage 2");
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
    
    n=arr1.size();//number of elements
    int a =(int) Math.pow(2,n);//number of truth assignments
    int[][] ttable=new int[a][n];
    int[][] new_table=new int[a][n];
    ttable = tt.truthAssignments(n);
    /*
    for (int i=0; i<a; i++) {
            for (j=n-1; j>=0; j--) {
                System.out.print(ttable[i][j]);
            }
            System.out.println();
        }*/
    
   ArrayList[] truthlist = new ArrayList[a]; 
   for (int i=0; i<a; i++) {
            for (j=0; j<n; j++) {
                
                 //StringBuffer sb=new StringBuffer(ttable[i][j]);
                 //System.out.println(sb.length());
                 //System.out.println(arr1.size());
                 //System.out.println(ttable[i][j] + ": i " + i + ": j " + j);
                int x=(int) ttable[i][j];
                     if(x== 0)
                     {
                         new_table[i][j]=Integer.parseInt(arr1.get(j).toString()) * -1;
                         //System.out.println(Integer.parseInt(arr1.get(j).toString()));
                        // System.out.print(truthlist[i].get(j));
                     }
                     else if(x == 1)
                     {
                         //System.out.println(Integer.parseInt(arr1.get(j).toString()));
                        new_table[i][j]=Integer.parseInt(arr1.get(j).toString());
                         //System.out.print(truthlist[i].get(j));
                     }
                 
            }
            
        }
   //display all the truth table:
   /*
   for (int i=0; i<a; i++) {
            for (j=0; j<n; j++) {
               System.out.print(new_table[i][j]);
            }
            System.out.println();
        } */
   
    //Math.abs(Integer.parseInt(arr.get(j).toString())) == Math.abs(Integer.parseInt(arr1.get(k).toString()))
       // int z[]=new int[arr1.size()]; 
     /*   
        //System.out.println("Stage 3");
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
    
    for(int i=0;i<z.length;i++)
    {
    System.out.println(z[i]);
    
    }
   */
   int temp=0,curr=0,nxt=0,max=0,row_num=0,curr_n=0,nxt_n=0;
   //for loop for checking each truth assignment
   for(int y=0;y<a;y++){
       satisfy=0;
       //for loop for inputing and checking each element
       for(int p=0; p<arr.size();p=p+2)
            {  temp=j+1;
            curr=Integer.parseInt(arr.get(p).toString());
            nxt=Integer.parseInt(arr.get(temp).toString());
            //for loop for changing each of the element according to truth assignment
            for(int z=0;z<arr1.size();z++)
            {   //if absolute values match then, it will go further and will multiply the value for first literal of clause
                if(Math.abs(curr)==Math.abs(new_table[y][z])){
                curr_n=curr * new_table[y][z];
            }//if end
                
                //if absolute values match then, it will go further and will multiply the value for second literal of clause
            else if(Math.abs(curr)==Math.abs(new_table[y][z])){
            nxt_n=nxt * new_table[y][z];
            }
            }
                //if first element is negative
                if(curr_n>0){
                satisfy++;
                continue;
                }
                //if first element is negative
                else if(nxt_n>0){
                satisfy++;
                //continue;
                }
                //System.out.println(satisfy);
            }
    if(satisfy>=max)
    {
    max=satisfy;
    row_num= y;
    //System.out.println(max);
    }
    //System.out.println(satisfy);
    
    }
        
        for(int i=0;i<n;i++){
    System.out.println(new_table[row_num][i] );
    }
        System.out.println(max);
    }
}
