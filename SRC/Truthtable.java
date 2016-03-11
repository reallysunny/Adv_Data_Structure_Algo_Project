/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final610;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author reallysunny
 */
public class Truthtable {
    

    /**
     * @param args the command line arguments
     */
   /* public static void main(String[] args) {
    System.out.println("Enter any number to generate truth table");
    Scanner sc=new Scanner(System.in);
    int x=sc.nextInt();
    truthAssignments(x);
    }*/
    
   
    static int[][] truthAssignments(int n) {
        int num = (int) Math.pow(2,n); //total number of assignments
        int[][] b = new int[num][n];//creating the array to save the assignments
       
        //ArrayList tTable=new ArrayList();
        for (int i=0; i<num; i++) {
            for (int j=n-1; j>=0; j--) {
                b[i][j]=(i/(int) Math.pow(2, j))%2;//here,it will give 1 or 0 for the number.
            }
            
        }
        
        /*for (int i=0; i<num; i++) {
            for (int j=n-1; j>=0; j--) {
                System.out.print(b[i][j]);
            }
            System.out.println();
        }*/
        return b;
    }

  
   



}
