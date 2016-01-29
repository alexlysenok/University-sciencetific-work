package com.mygdx.game;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class DataStreamer {

	public ArrayList<String> data= new ArrayList<String>();
	private String line=new String();
	private int tactsScaned=0;
	public DataStreamer()
	{
		
		
	}
	
    public void writeData(int tact)
    {
    	
    	
    	
    	try {

   	      PrintStream out = new PrintStream(new FileOutputStream(1+".txt"));
   	        for(int i=0;i<data.size();i++)
   	        { 
   	        	//System.out.println("v "+data.get(i));
   	        	out.println(data.get(i));
   	        	}
   	        out.close();

   	    } catch (FileNotFoundException e) {
   	      e.printStackTrace();
   	    }
    	
    }
	
    public void scanData(int tact)
    {
    	tactsScaned++;
    	
    	
    	line="";
    	for (int i=0;i<TestGame.nodesList.size();i++)
    	{
    		
    		//data.add(TestGame.nodesList.get(i).myXx+" "+TestGame.nodesList.get(i).myYy+"\n");
    		line+=((int)TestGame.nodesList.get(i).myXx+" "+(int)TestGame.nodesList.get(i).myYy+" ");
    	//	System.out.println(line);
    	}
    	data.add(tact+" "+line);
    	if(tactsScaned>=10)
    	{
    		tactsScaned=0;
    		writeData(tact);
    		data.clear();
    	}
    }
	
}
