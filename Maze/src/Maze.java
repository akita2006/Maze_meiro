import java.util.Random;

public class Maze extends MyFrame {

	public Maze() {
		addKeyListener(new Reset());
	}

	int path = 0;
	int walls = 1;

	// 棒倒し法による迷路生成
	public void run() {

		while (true) {
			if (Flag.spacePressed) {

				int width = 15;
				int height = 15;
				Flag.spacePressed = false;

				// 指定サイズで生成し外周を壁にする
				int[][] maze = new int[width][height];
				for (int x = 0; x < width; x++)
					for (int y = 0; y < height; y++)
						if (x == 0 || y == 0 || x == width - 1 || y == height - 1) {
							maze[x][y] = walls;
						} // 外周はすべて壁        		
						else {
							maze[x][y] = path;
						} // 外周以外は通路 

				Create(width, height, maze);
			}
			sleep(0.1);
		}
	}

	//迷路生成
	public void Create(int width, int height, int[][] maze) {
		var rnd = new Random();

		for (int x = 2; x < width - 1; x += 2) {
			clear();
			for (int y = 2; y < height - 1; y += 2) {
				maze[x][y] = walls; // 棒を立てる
				// Wall wall=new Wall(x,y);
				//wall.draw();                          
				// 倒せるまで繰り返す 

				while (true) {
					// 1行目のみ上に倒せる
					int direction;
					if (y == 2)
						direction = rnd.nextInt(4);
					else
						direction = rnd.nextInt(3);

					// 棒を倒す方向を決める
					int wallX = x;
					int wallY = y;
					switch (direction) {
					case 0: // 右
						wallX++;
						break;
					case 1: // 下
						wallY++;
						break;
					case 2: // 左
						wallX--;
						break;
					case 3: // 上
						wallY--;
						break;
					}
					// 壁じゃない場合のみ倒して終了
					if (maze[wallX][wallY] != walls) {
						maze[wallX][wallY] = walls;
						break;
					}
				}

				display(width, height, maze);
			}
		}

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
	//表示    
	public void display(int x, int y, int[][] maze) {
		
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (maze[i][j] == walls) {
					draw(i, j);
				} else if (i == 1 && j == 1) {
					drawstart(i, j);
				} else if (i == 13 && j == 13) {
					drawgoal(i, j);
				}

			}

		}

	}
}
