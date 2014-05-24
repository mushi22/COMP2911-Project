import java.awt.Point;


public class Player extends Entity{
	
	public Player(){
		super();
		setPosition(0, 0);
	}
	
	public Player(Maze maz){
		setPosition(maz.getStart());
	}
	
	private void setPosition(Point start) {
		setPosition((int)start.getX(), (int)start.getY());
	}

	boolean moveup(Maze maz){
		try{
			int[][] tMaz = maz.getMaz();
			if(tMaz[position.y - 1][position.x] != 0){
				//position.y++;
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
			if(tMaz[position.y + 1][position.x] != 0){
				//position.y--;
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
			if(tMaz[position.y][position.x-1] != 0){
				//position.x--;
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
			if(tMaz[position.y][position.x+1] != 0){
				//position.x++;
				return true;
			}
			return false;
		} catch(Exception E){
			
		}
		return false;
	}


}
