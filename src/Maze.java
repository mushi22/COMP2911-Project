import java.util.ArrayList;

/*
 * 
 * implements prim algothrim 
 * 
 * sohaib working on this
 * 
 */

public class Maze {
	private char[][] maz;
	private Point start;
	private Point end;
	public char[][] getMaz() {
		return maz;
	}


	public void setMaz(int row, int column) {
		this.maz = new char[row][column];
	}


/*	public static void main(String[]args)
    {
    	// dimensions of generated maze
    	int row=20;
    	int column=20;
    	Maze mz = new Maze();
    	mz.generateMaze(row, column);
    	
    }*/
 

	public String generateMaze(int row, int column){
		// build maze and initialize with only walls
        StringBuilder sb = new StringBuilder(column);
        for(int i=0;i<column; i++){
        	sb.append('*');
        }	
        setMaz(row, column);
        for(int x=0;x<row;x++) {
        	getMaz()[x] = sb.toString().toCharArray();
        }
        
 
        // select random point and open as start node
        start = new Point((int)(Math.random()*row),(int)(Math.random()*column),null);
        getMaz()[start.r][start.c] = 'S';
        
 
        // iterate through direct neighbors of node
        ArrayList<Point> fmaze = new ArrayList<Point>();
        for(int i=-1;i<=1;i++){
        	for(int k=-1;k<=1;k++){
        		if(i==0 && k==0 || i!=0 && k!=0){
        			continue;
        		}	
        		try{
        			if(getMaz()[start.r+i][start.c+k]=='.') continue;
        		}catch(Exception e){ // ignore ArrayIndexOutOfBounds
        			continue;
        		}
        		// add eligible points to frontier
        		fmaze.add(new Point(start.r+i,start.c+k,start));
        	}
        }
 
        end=null;
        while(!fmaze.isEmpty()){
 
        	// pick current node at random
        	Point currentnode = fmaze.remove((int)(Math.random()*fmaze.size()));
        	Point currentopp = currentnode.opposite();
        	try{
        		// if both node and its opposite are walls
        		if(getMaz()[currentnode.r][currentnode.c]=='*'){
        			if(getMaz()[currentopp.r][currentopp.c]=='*'){
 
        				// open path between the nodes
        				getMaz()[currentnode.r][currentnode.c]='.';
        				getMaz()[currentopp.r][currentopp.c]='.';
 
        				// store end node in order to mark it later
        				end = currentopp;
 
        				// iterate through direct neighbors of node, same as earlier
        				for(int i=-1; i<=1; i++){
				        	for(int k=-1; k<=1; k++){
				        		if(i==0 && k==0 || i !=0 && k!=0)
				        			continue;
				        		try{
				        			if(getMaz()[currentopp.r+i][currentopp.c+k]=='.') continue;
				        		}catch(Exception e){
				        			continue;
				        		}
				        		fmaze.add(new Point(currentopp.r+i,currentopp.c+k,currentopp));
				        	}
        				}
        			}
        		}
        	}catch(Exception e){ // ignore NullPointer and ArrayIndexOutOfBounds
        	}
 
        	// if algorithm has resolved, mark end node
        	if(fmaze.isEmpty()){
        		getMaz()[end.r][end.c]='E';
        	}
        }
        
        String mazeString = "";
		// print final maze
		for(int i=0;i<row;i++){
			for(int j=0;j<column;j++){
				//System.out.print(getMaz()[i][j]);
				mazeString = mazeString.concat(Character.toString(getMaz()[i][j]));
			}
			//System.out.println();
			mazeString = mazeString.concat("\n");
		}
		
		return mazeString;
	}
    static class Point{
    	Integer r;
    	Integer c;
    	Point parent;
    	public Point(int x, int y, Point p){
    		r=x;c=y;parent=p;
    	}
    	// compute opposite node given that it is in the other direction from the parent
    	public Point opposite(){
    		if(this.r.compareTo(parent.r)!=0)
    			return new Point(this.r+this.r.compareTo(parent.r),this.c,this);
    		if(this.c.compareTo(parent.c)!=0)
    			return new Point(this.r,this.c+this.c.compareTo(parent.c),this);
    		return null;
    	}
    }
}
