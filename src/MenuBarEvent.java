import java.util.EventObject;


public class MenuBarEvent extends EventObject {
	private static final long serialVersionUID = -2774836427750315280L;
	
	private String menuName;
	private String text;
	
	public MenuBarEvent(Object source, String menuName, String text) {
		super(source);
		this.menuName = menuName;
		this.text = text;
	}
	
	public String getMenuName(){
		return menuName;
	}
	
	public String getText(){
		return text;
	}
}
