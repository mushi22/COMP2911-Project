import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;


/*
 * 
 * implements prim algothrim 
 * 
 * sohaib working on this
 * 
 */

public class Maze {
	public static final int START = 2;
	public static final int END = 3;
	private int[][] maz;
	private Point start;
	private Point end;
	
	public Point getStart() {
		return start;
	}


	public void setStart(Point start) {
		this.start = start;
	}
	
	public int[][] getMaz() {
		return maz;
	}


	public void setMaz(int row, int column) {
		this.maz = new int[row][column];
	}


	public static void main(String[]args)
    {
    	// dimensions of generated maze
    	int row=20;
    	int column=20;
    	Maze mz = new Maze();
    	mz.generateMaze(row, column);
    	
    }
 

	public String generateMaze(int row, int column){
        //default value of 0 for arrays of integral types is guaranteed by the language spec
        //int[] tRow= new int[column];
        setMaz(row, column);
        //for(int x=0;x<row;x++) {
        //	getMaz()[x] = tRow;
        //}
        
        //start = new Point((int)(Math.random()*row),(int)(Math.random()*column));
        start = new Point(0, 0);
        getMaz()[(int) start.getY()][(int) start.getX()] = START;
        
        // get neighbours (each key has a value of where it came from)
        ArrayList<Point> nextLine = new ArrayList<Point>();
        ArrayList<Point> ngh = getNGH(start, nextLine);
        		
 
        ArrayList<Point> endps=new ArrayList<Point>();
        while(!ngh.isEmpty()){
 
        	// pick current node at random
        	int temp = (int)(Math.random()*ngh.size());
        	Point currentnode = ngh.remove(temp);
        	Point currentopp = nextLine.remove(temp);
        	
        	
        	int diffy = (int) (currentnode.getY() - currentopp.getY());
        	int diffx = (int) (currentnode.getX() - currentopp.getX());
        	//one of these if's should always happen, add an exception handler because design course
        	if(diffy != 0 )
        		currentopp = new Point((int) currentnode.getX(),(int) currentnode.getY()+diffy);
        	else if(diffx != 0)
        		currentopp = new Point((int) currentnode.getX() +diffx,(int) currentnode.getY());
        	
        	try{
        		// if both node and its opposite are walls
        		if(getMaz()[(int) currentnode.getY()][(int) currentnode.getX()]==0 && getMaz()[(int) currentopp.getY()][(int) currentopp.getX()]==0){
    				// open path between the nodes
    				getMaz()[(int) currentnode.getY()][(int) currentnode.getX()]=1;
    				getMaz()[(int) currentopp.getY()][(int) currentopp.getX()]=1;
 
    				// store end node in order to mark it later
    				endps.add(currentopp);
 
        				// iterate through direct neighbors of node, same as earlier
    				ngh.addAll(getNGH(currentopp,nextLine));
        		}
        	}catch(Exception e){
        		//System.out.println("fgdsjkfgjhdsgkf");
        	}
        }
        
        do{
        	int ind = new Random().nextInt(endps.size());
        	end = endps.get(ind);
        }while(end.getX() < 7*maz[0].length/8 || end.getY() < 7*maz.length/8);
        getMaz()[(int) end.getY()][(int) end.getX()]=END;
 
        String mazeString = "";
        
		// print final maze
		for(int i=0;i<row;i++){
			for(int j=0;j<column;j++){
				//System.out.println(getMaz()[i][j]);
				mazeString = mazeString.concat(Integer.toString(getMaz()[i][j]));
			}
			mazeString = mazeString.concat("\n");
		}
		
		return mazeString;
	}
	
    private ArrayList<Point> getNGH(Point curr, ArrayList<Point> nextLine) {
    	ArrayList<Point> ls = new ArrayList<Point>();
        for(int i = -1;i<=1;i++){
        	for(int j = -1;j<= 1;j++){
        		if(i==0 && j==0 || i!=0 && j!=0){
        			continue;
        		}	
        		try{
        			if(getMaz()[(int) (curr.getY()+i)][(int) (curr.getX()+j)]==1) continue;
        		}catch(Exception e){
        			//skip
        			continue;
        		}
        		ls.add(new Point((int) (curr.getX()+i),(int) curr.getY()+j));
        		nextLine.add(curr);
        	}
        }
		return ls;
	}
}
