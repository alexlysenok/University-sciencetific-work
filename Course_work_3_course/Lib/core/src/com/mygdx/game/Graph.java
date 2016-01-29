package com.mygdx.game;

public class Graph {

	
	public int[][] smatrix=new int[TestGame.nodesList.size()][TestGame.nodesList.size()];
	
	public Graph(){
		for(int i = 0; i < TestGame.nodesList.size(); i++) 
		{
		      for(int j = i; j < TestGame.nodesList.size(); j++)
		      {
		    	  smatrix[i][j]=0;		
		      }
	    }
		
		
		
		
	}
	
	
	public int getAloneNodesNumber() {
		int number = 0;
		boolean onlyZeros;
		for(int i = 0; i < TestGame.nodesList.size(); i++) {
			onlyZeros = true;
			for(int j = 0; j < TestGame.nodesList.size(); j++) {
				if(smatrix[i][j] != 0) {
					onlyZeros = false;
					break;
				}
			}
			if(onlyZeros) number++;
		}
		return number;
		
	}

	
	
	
	
	
	public void smatrix(){
	
	for(int i = 0; i < TestGame.nodesList.size(); i++) 
		{
		      for(int j = 0; j < TestGame.nodesList.size(); j++)
		      {
		        if(i!=j && Math.sqrt((Math.pow((TestGame.nodesList.get(i).myXx - TestGame.nodesList.get(j).myXx), 2)+Math.pow((TestGame.nodesList.get(i).myYy - TestGame.nodesList.get(j).myYy), 2))) < Node.radius) 
		        {
		        	smatrix[i][j]=1;
		        	smatrix[j][i]=1;
		        }
		        else {
		        smatrix[i][j]=0;
		        smatrix[j][i]=0;
		        }
		
		      }
	    }
	}
	

	
}

