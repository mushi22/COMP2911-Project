import java.awt.Point;


public class Player{
	Point position;
	
	void setPosition(int x, int y){
		position.setLocation(x,y);
	}
	
	Point getPosition(){
		return position;
	}
	
	public Player(){
		position = new Point();
		setPosition(0, 0);
	}
	
	public Player(Maze maz){
		position = new Point();
		setPosition(maz.getStart());
	}
	
	private void setPosition(Point start) {
		setPosition((int)start.getX(), (int)start.getY());
	}

	boolean moveup(Maze maz){
		try{
			int[][] tMaz = maz.getMaz();
			if(tMaz[position.y - 1][position.x] != Maze.WALL){
				return true;
			}
			return false;
		} catch(Exception E){
			
		}
		return false;
	}
	
	boolean movedown(Maze maz){
		try{
			int[][] tMaz = maz.getMaz();
			if(tMaz[position.y + 1][position.x] != Maze.WALL){
				return true;
			}
			return false;
		} catch(Exception E){
			
		}
		return false;
	}
	boolean moveleft(Maze maz){
		
		try{
			int[][] tMaz = maz.getMaz();
			if(tMaz[position.y][position.x-1] != Maze.WALL){
				return true;
			}
			return false;
		} catch(Exception E){
			
		}
		return false;
	}

	boolean moveright(Maze maz){
		try{
			int[][] tMaz = maz.getMaz();
			if(tMaz[position.y][position.x+1] != Maze.WALL){
				return true;
			}
			return false;
		} catch(Exception E){
			
		}
		return false;
	}
	
	boolean checkWin(Maze maz) {
		try{
			int[][] tMaz = maz.getMaz();
			if(tMaz[position.y][position.x] == Maze.END){
				return true;
			}
			return false;
		} catch(Exception E){
			
		}
		return false;
	}
	
}
