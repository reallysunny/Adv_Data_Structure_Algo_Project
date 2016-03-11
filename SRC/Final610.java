/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final610;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author reallysunny
 */
public class Final610 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Max2 sec=new Max2();
        Max2brute b=new Max2brute();
        MaxSat first=new MaxSat();
        
        System.out.println("Hello, Enter the method you want to Execute:");
        System.out.println("Enter 1 for Brute Force method:");
        System.out.println("Enter 2 for First Fast method:");
        System.out.println("Enter 3 for Second Fast method:");
        System.out.println("Enter 4 for Exit:");
        Scanner scan=new Scanner(System.in);
        int x=scan.nextInt();
        
        switch(x){
        
        case 1:
            b.bruteMax();
            break;
        case 2:
            sec.secondFast();
            break;
        case 3:
            first.firstFast();
            break;
        case 4:
            break;
        
        
        }
            
    }
    
}
