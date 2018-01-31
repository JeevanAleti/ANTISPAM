package com.ibm.connection;




public class MinMax  
 {
	public static void main(String args[])
	{
		int num[]={33,3,333,100};
		int i,min,max;
		min=max=num[0];
	
		
	for(i=1;i<4;i++)
	{
		
	if(num[i]<min)
		min=num[i];
	if(num[i]>max)
		max=num[i];
	}
	System.out.println("Min and max are:"+min+" "+max);
	}
	}

	
	
	
 
