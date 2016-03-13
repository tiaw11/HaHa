package test;

import java.util.Scanner;

public class BagTest
{
	 @SuppressWarnings("resource")
    public static void main(String[] args)
    {  
		 /*
		  * @author 土豆
		  */
     /*==============程序的输入部分==================
      *        bagVolume       背包总容量
      *        number          可选物品的数量
      *        singleVolume    单个物品的重量
      *        singlePrice     对应物品的金额
	   ==============================================*/ 
	  Scanner cin = new Scanner(System.in); 
      //包能容纳的总质量
      System.out.print("===请输入书包的容量===");
      System.out.println("");
      int bagVolume = cin.nextInt(); 
      //能选择的物品的个数
      System.out.print("===请输入物品的总数量===");
      System.out.println("");
      int number = cin.nextInt();
      
      int singleVolume[] = new int[number];
      int singlePrice[] = new int[number];
      System.out.print("===循环输入"+number+"个物品的质量===");
      System.out.println("");
      for(int i=0;i<number;i++) //循环输入每个物品的质量
      {
    	  singleVolume[i] = cin.nextInt();
      }
      System.out.print("===循环对应输入"+number+"个物品的价格===");
      System.out.println("");
      for(int i=0;i<number;i++) //循环输入每个物品的价格
      {
    	  singlePrice[i] = cin.nextInt();
      }
      
      /*==============背包程序开始================*/
      int Value[][] = new int[number][bagVolume];
      int temp1,temp2;
      for(int i=0;i<number;i++)
    	  for(int j=0;j<bagVolume;j++)
    		  {
    		  //将第一行先填写起来
    		  if(i==0)
    		  {
    			  if((j+1>=singleVolume[i]))
    				  Value[i][j]=singlePrice[i];
    			  else
    				  Value[i][j]=0;					  
    		  }
    		  else
    		  {
    			  //初始化temp1,2的值
    			  temp1=0;temp2=0;
    			  //temp中存不放入该物品的最大价值
    			  temp1 = Value[i-1][j];
    			  //存放该物品的最大价值
    			  if(j+1>=singleVolume[i])   				  
    				  {
    				  if(j+1==singleVolume[i]) temp2=singlePrice[i];//刚好存放该物品的价值
    				  else temp2=singlePrice[i]+Value[i-1][j+1-singleVolume[i]-1];//剩余空间的最大价值
    				  }
    			  else
    				  temp2=Value[i-1][j];
    			 Value[i][j]=temp1>temp2?temp1:temp2; 
    			  
    		  }
    		  }
      for(int i=0;i<number;i++)
      {   	  
    	  for(int j=0;j<bagVolume;j++)
    		  {
    		System.out.print(Value[i][j]+"  ");
    		  }  
    	  System.out.println("");
      }
      System.out.println("容量为"+bagVolume+"千克的包能装最多价值为"+Value[number-1][bagVolume-1]);      
    }
}