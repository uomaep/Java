package SlimeGame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SlimeAttack {

	private final int FRAME_WIDTH = 30;
	private final int FRAME_HEIGHT = 60;
	private final int SCALE = 15;
	private final int SPEED = 15;
	private final int START_X = FRAME_WIDTH / 2 - 1;
	private final int START_Y = FRAME_HEIGHT / 2 + 10;

	int score = 0;
	float time = 30;
	float tempTime = 1.3f;
	float responTime = 1f;
	int tmp;
	boolean end = false;

	JFrame frame;

	Madi[] tank = new Madi[7];
	Madi head, leftBody, rightBody;
	int stepX = 0, stepY = 0;

	LinkedList<Madi> missiles = new LinkedList<>();
	int missileSpeed = 1;

	Madi slime;

	public SlimeAttack() {
		frame = new JFrame("슬라임 퇴치 대작전");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(FRAME_WIDTH * SCALE, FRAME_HEIGHT * SCALE);
		frame.addKeyListener(new GameKeyListener());

		makeTank();
		makeSlime(START_X, START_Y / 2);

		Container pane = frame.getContentPane();
		pane.add(new GamePanel());

		frame.setVisible(true);
	}

	public void go() {
		while (true) {
			time -= SPEED / 1000.0f; 
			tempTime += SPEED / 1000.0f;
			if ((int) tempTime % responTime == 0 && (int) tempTime != tmp) {
				tmp = (int) tempTime;
				moveSlime();
			}
			missile();
			moveTank(stepX, stepY);
			if (leftBody.getX() <= 0 || rightBody.getX() * SCALE + SCALE >= FRAME_WIDTH * SCALE)
				stepX = 0;
			if (head.getY() <= 0 || leftBody.getY() * SCALE + SCALE >= FRAME_HEIGHT * SCALE)
				stepY = 0;

			try {
				Thread.sleep(SPEED);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			frame.repaint();
			if (time <= 0) {
				end = true;
				break;
			}
		}
		frame.repaint();
	}

	class Madi {
		private int x, y;
		private Color color = Color.GREEN;

		public Madi(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public void changeColor() {
			Color[] colors = { Color.PINK, Color.BLUE, Color.GREEN, Color.ORANGE, Color.YELLOW, Color.DARK_GRAY,
					Color.LIGHT_GRAY, Color.MAGENTA };
			Color tmp = colors[(int) (Math.random() * colors.length)];
			while (tmp == color) {
				tmp = colors[(int) (Math.random() * colors.length) - 1];
			}
			color = tmp;

		}

		public Color getColor() {
			return color;
		}
	}

	class GamePanel extends JPanel {
		public void paintComponent(Graphics g) {

			drawTank(g);
			drawMissile(g);
			drawSlime(g);
			drawScore(g);
			drawTime(g);
			
			if (end) gameOver(g);
			
		}
		public void drawTank(Graphics g) {
			g.setColor(Color.DARK_GRAY);
			for (int i = 0; i < tank.length; i++) {
				Madi m = tank[i];
				g.fillRect(m.getX() * SCALE, m.getY() * SCALE, SCALE, SCALE);
			}
		}
		public void drawMissile(Graphics g) {
			for (int i = 0; i < missiles.size(); i++) {
				Madi missile = missiles.get(i);
				g.setColor(Color.BLACK);
				g.drawRect(missile.getX() * SCALE, missile.getY() * SCALE, SCALE, SCALE);
				g.drawOval(missile.getX() * SCALE, missile.getY() * SCALE - (SCALE / 2), SCALE, SCALE);

				g.setColor(Color.RED);
				g.fillRect(missile.getX() * SCALE, missile.getY() * SCALE, SCALE, SCALE);
				g.fillOval(missile.getX() * SCALE, missile.getY() * SCALE - (SCALE / 2), SCALE, SCALE);
			}
		}
		public void drawSlime(Graphics g) {
			g.setColor(slime.getColor());
			g.fillRoundRect(slime.getX() * SCALE, slime.getY() * SCALE, SCALE * 4, SCALE * 4, 30, 10);
			g.setColor(Color.BLACK);
			g.drawRoundRect(slime.getX() * SCALE, slime.getY() * SCALE, SCALE * 4, SCALE * 4, 30, 10);
//			g.fillRect((monster.getX() ) * SCALE, (monster.getY()+1) * SCALE, SCALE, SCALE );
//			g.fillRect((monster.getX() + 2) * SCALE, (monster.getY()+1) * SCALE, SCALE, SCALE);
			g.fillRoundRect((slime.getX()) * SCALE + 3, (slime.getY() + 1) * SCALE, (int) (SCALE / 1.5), SCALE, 7,
					7);
			g.fillRoundRect((slime.getX() + 2) * SCALE + 3, (slime.getY() + 1) * SCALE, (int) (SCALE / 1.5), SCALE,
					7, 7);
			g.setColor(Color.RED);
			g.fillRoundRect((slime.getX() + 1) * SCALE, (slime.getY() + 3) * SCALE, SCALE, (int) (SCALE / 1.8), 4,
					4);
		}
		public void drawScore(Graphics g) {
			g.setFont(new Font("Arial", Font.ITALIC, 30));
			g.drawString(String.format("점수 : %s", Integer.toString(score)), SCALE - 10, 2 * SCALE);	
		}
		public void drawTime(Graphics g) {
			g.drawString(String.format("제한 시간 : %.0f초", time), FRAME_WIDTH * SCALE / 2 + (2 * SCALE), 2 * SCALE);
		}
		public void gameOver(Graphics g) {
			g.setFont(new Font("Arial", Font.ITALIC, 70));
			g.drawString("GAME", START_X * SCALE / 2 + 1 * SCALE, START_Y * SCALE / 2 + 6 * SCALE);
			g.drawString("OVER", START_X * SCALE / 2 + 1 * SCALE, START_Y * SCALE / 2 + 10 * SCALE);
		}
	}

	class GameKeyListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				if (head.getY() <= 0)
					break;
				stepX = 0;
				stepY = -1;
				break;
			case KeyEvent.VK_DOWN:
				if (leftBody.getY() * SCALE + SCALE >= FRAME_HEIGHT * SCALE)
					break;
				stepX = 0;
				stepY = 1;
				break;
			case KeyEvent.VK_LEFT:
				if (leftBody.getX() <= 0)
					break;
				stepX = -1;
				stepY = 0;
				break;
			case KeyEvent.VK_RIGHT:
				if (rightBody.getX() * SCALE + SCALE >= FRAME_WIDTH * SCALE)
					break;
				stepX = 1;
				stepY = 0;
				break;
			case KeyEvent.VK_SPACE:
				missiles.add(new Madi(head.getX(), head.getY()));
				break;
			default:
				break;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_LEFT:
			case KeyEvent.VK_RIGHT:
				stepX = 0;
				stepY = 0;
				break;
			default:
				break;
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

	}

	public void missile() {
		for (int i = 0; i < missiles.size(); i++) {
			try {
				Madi missile = missiles.get(i);
				missile.setY(missile.getY() - missileSpeed);

				if (missile.getX() >= slime.getX() && missile.getX() <= (slime.getX() + 4)
						&& missile.getY() <= (slime.getY() + 4)) {
					missiles.remove(i);
					score++;
					moveSlime();
					slime.changeColor();
					tempTime = 1.3f;
				}

				else if (missile.getY() <= 0)
					missiles.remove(i);

			} catch (ArrayIndexOutOfBoundsException e) {
				continue;
			}

		}
	}

	public void moveTank(int stepX, int stepY) {
		for (int i = 0; i < tank.length; i++) {
			Madi m = tank[i];
			m.setX(m.getX() + stepX);
			m.setY(m.getY() + stepY);
		}
		head = tank[0];
		leftBody = tank[4];
		rightBody = tank[6];
	}

	public void makeTank() {
		tank[0] = new Madi(START_X, START_Y);
		tank[1] = new Madi(START_X, START_Y + 1);
		tank[2] = new Madi(START_X, START_Y + 2);
		tank[3] = new Madi(START_X - 1, START_Y + 1);
		tank[4] = new Madi(START_X - 1, START_Y + 2);
		tank[5] = new Madi(START_X + 1, START_Y + 1);
		tank[6] = new Madi(START_X + 1, START_Y + 2);

		head = tank[0];
		leftBody = tank[4];
		rightBody = tank[6];
	}

	public void makeSlime(int x, int y) {
		slime = new Madi(x, y);
	}

	public void moveSlime() {
		slime.setX((int) (Math.random() * (FRAME_WIDTH - 3)));
		slime.setY((int) (Math.random() * (FRAME_HEIGHT / 4) + SCALE));
	}
}
