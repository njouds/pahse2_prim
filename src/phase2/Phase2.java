
package phase2;

import java.util.Random;
import java.util.Scanner;

public class Phase2 {

    static Graph graph;// declaring a graph as global
    
    public static void make_graph(int caseN){//this method will randomly generate the graph based on the case number
        
        int verticesNum = 0,edgeNum=0; //declaring the vertices number and edge number
        
        switch(caseN){//based on the method parameter which is the case number vertices number and edge number will be assigned
            case 1:
                verticesNum=1000;
                edgeNum=10000;
                break;
            case 2:
                verticesNum=1000;
                edgeNum=15000;
                break;  
            case 3:
                verticesNum=1000;
                edgeNum=25000;
                break;
            case 4:
                verticesNum=5000;
                edgeNum=15000;
                break;    
            case 5:
                verticesNum=5000;
                edgeNum=25000;
                break;   
            case 6:
                verticesNum=10000;
                edgeNum=15000;
                break;
            case 7:
                verticesNum=10000;
                edgeNum=25000;
                break;    
            case 8:
                verticesNum=20000;
                edgeNum=200000;
                break; 
            case 9:
                verticesNum=20000;
                edgeNum=300000;
                break;    
            case 10:
                verticesNum=50000;
                edgeNum=1000000;
                break;    
        }  
        
        graph=new Graph(verticesNum);// declaring the graph based on the vertices number from the case
        Random rn = new Random(); //creating a random object to generate random numbers 
        int countEgde=0;// a counter to count if the number of edges we assigned match the desired assigned edgeNum based on the case
        while (edgeNum!=countEgde){ //while the edge number is not yet reached
            
            int ver1=rn.nextInt(verticesNum);//generate 2 random vertices to connect them
            int ver2=rn.nextInt(verticesNum);
            if (!(graph.existEdge(ver1, ver2))&&(ver1!=ver2)){//checking if theres no edge between the two vertices and if the verices are not the same 
                int weight = rn.nextInt(10) + 1;// generate wieght with a random number from 1 to 10
                graph.addEgde(ver1, ver2, weight);//assigning the wight to the edge between these two vertices
                countEgde++;//incrementing the edge count because we have assigned an edge
            }
            
            
        }
        
    }
    
    
    public static void main(String[] args) {
       
        Scanner input = new Scanner(System.in);//creting a Scanner object
        int caseN=0;//declaring case number 
        while(true){
        System.out.println("Enter Case number (between 1 and 10) : ");//prompt the user to enter a case number 
        caseN = input.nextInt();//read the case number from the user
        if(caseN<=10&&caseN>=1){//checking if the entered case number is between 1 and 10
           break;//if correct break the loop of prompting the user
        }
        System.out.println("Wrong Case number");//if the case number is wrong show the messege 
        
       }
        make_graph(caseN);//calling the make graph function to generate a random graph and sending the case number entered by user to it
       graph.printGraph();
        
        
        
        
        
        
    }
    
    
    
}
