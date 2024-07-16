
public class Wall extends MyFrame{
	int x,y;
	public Wall(int x,int y) {
		this.x=x;
		this.y=y;		
	}	

	public void draw(int x, int y) {
		// TODO 自動生成されたメソッド・スタブ
		setColor(0,128, 0);
		fillRect(x*10+50, y*10+50, 10, 10);
	}
	public void drawstart(int x, int y) {
		// TODO 自動生成されたメソッド・スタブ
		setColor(0,0,128);
		fillRect(x*10+50, y*10+50, 10, 10);
	}
	public void drawgoal(int x, int y) {
		// TODO 自動生成されたメソッド・スタブ
		setColor(128,0, 0);
		fillRect(x*10+50, y*10+50, 10, 10);
	}
}
