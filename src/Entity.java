import java.awt.Point;

/*
 * Basic class to describe everything ON the board.
 * Classes such as the player, any objects/items and NPCs, if any, will
 *  inherit this class.
 *  
 *  Arien working on this.
 */
public class Entity {
	//Position of thing on the board
	Point position;
	
	void setPosition(int x, int y){
		position.setLocation(x,y);
	}
	
	Point getPosition(){
		return position;
	}
}