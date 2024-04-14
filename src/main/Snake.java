package main;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Snake extends JPanel implements ActionListener, KeyListener
{
	public static int num = 0;
	public static boolean pause = false;
	
	Timer tm = new Timer(150, this);
	public int x = 30, y = 30, velX = 0, velY = 0;
	public int x1 = 0, y1 = 0, x2 = 0, y2 = 0, x3 = 0, y3 = 0, x4 = 0, y4 = 0, x5 = 0, y5 = 0;
	public int x6 = 0, y6 = 0, x7 = 0, y7 = 0, x8 = 0, y8 = 0, x9 = 0, y9 = 0, x10 = 0, y10 = 0;
	public int x11 = 0, y11 = 0, x12 = 0, y12 = 0, x13 = 0, y13 = 0, x14 = 0, y14 = 0, x15 = 0, y15 = 0;
	public int x16 = 0, y16 = 0, x17 = 0, y17 = 0, x18 = 0, y18 = 0, x19 = 0, y19 = 0, x20 = 0, y20 = 0;
	
	public int score = 0;
	public int best = 0;
	
	public static BufferedImage img = null;
	public static BufferedImage bodyimg = null;
	public static BufferedImage appleimg = null;
	public static boolean body1 = false;
	public static boolean body2 = false;
	public static boolean body3 = false;
	public static boolean body4 = false;
	public static boolean body5 = false;
	public static boolean body6 = false;
	public static boolean body7 = false;
	public static boolean body8 = false;
	public static boolean body9 = false;
	public static boolean body10 = false;
	public static boolean body11 = false;
	public static boolean body12 = false;
	public static boolean body13 = false;
	public static boolean body14 = false;
	public static boolean body15 = false;
	public static boolean body16 = false;
	public static boolean body17 = false;
	public static boolean body18 = false;
	public static boolean body19 = false;
	public static boolean body20 = false;
	
	public static boolean currentlyMoving = false;
	
	public static boolean goingLeft = false;
	public static boolean goingRight = true;
	public static boolean goingUp = false;
	public static boolean goingDown = false;
	
	double randNumber = Math.random();
	double dx = randNumber * 16;
	int randX = (int)dx * 30 + 6;
	
	double randNumber1 = Math.random();
	double dy = randNumber1 * 9;
	int randY = (int)dy * 30 + 6;
	
    public Snake ()
    {
    	tm.start(); //starts timer
    	addKeyListener(this); //this referring to KeyListener
    	setFocusable(true); //enable KeyListener
    	setFocusTraversalKeysEnabled(false); //shift or tab is not use so F
    }
	public void paintComponent(Graphics g)
	{   
		requestFocus(true);
		super.paintComponent(g);
		g.setColor(Color.black);
		for(int num = 30; num < 520; num+=30)
		{
			g.drawLine(num, 30, num, 300);
		}
		for(int num1 = 30; num1 < 330; num1+=30)
		{
			g.drawLine(30, num1, 510, num1);
		}
		if(randX < 30)
		{
			randX += 30;
		}
		if(randY < 30)
		{
			randY += 30;
		}
		try {
			appleimg = ImageIO.read(Snake.class.getResource("Images/apple.png"));
		} catch (IOException e1) {
			System.out.println("Can't find Image!");
		}
		g.drawImage(appleimg, randX, randY, 20, 20, this);
		//g.setColor(Color.green);
		//g.fillRect(x,y,30,30);
		g.setColor(Color.black);
		img = null;
		if(goingLeft)
		{
			try {
				img = ImageIO.read(Snake.class.getResource("Images/snakeleft.png"));
			} catch (IOException e1) {
				System.out.println("Can't find Image!");
			}
		}
		else if(goingUp)
		{
			try {
				img = ImageIO.read(Snake.class.getResource("Images/snakeup.png"));
			} catch (IOException e1) {
				System.out.println("Can't find Image!");
			}
		}
		else if(goingRight)
		{
			try {
				img = ImageIO.read(Snake.class.getResource("Images/snakeright.png"));
			} catch (IOException e1) {
				System.out.println("Can't find Image!");
			}
		}
		else if(goingDown)
		{
			try {
				img = ImageIO.read(Snake.class.getResource("Images/snakedown.png"));
			} catch (IOException e1) {
				System.out.println("Can't find Image!");
			}
		}
		try {
			bodyimg = ImageIO.read(Snake.class.getResource("Images/body.png"));
		} catch (IOException e1) {
			System.out.println("Can't find Image!");
		}
		g.drawImage(img, x, y, 30, 30, this);
		g.setFont(new Font("", Font.BOLD, 14)); 
		if(body1)
		{
			g.drawImage(bodyimg, x1, y1, 30, 30, this);
			if(body2)
			{
				g.drawImage(bodyimg, x2, y2, 30, 30, this);
				if(body3)
				{
					g.drawImage(bodyimg, x3, y3, 30, 30, this);
					if(body4)
					{
						g.drawImage(bodyimg, x4, y4, 30, 30, this);
						if(body5)
						{
							g.drawImage(bodyimg, x5, y5, 30, 30, this);
							if(body6)
							{
								g.drawImage(bodyimg, x6, y6, 30, 30, this);
								if(body7)
								{
									g.drawImage(bodyimg, x7, y7, 30, 30, this);
									if(body8)
									{
										g.drawImage(bodyimg, x8, y8, 30, 30, this);
										if(body9)
										{
											g.drawImage(bodyimg, x9, y9, 30, 30, this);
											if(body10)
											{
												g.drawImage(bodyimg, x10, y10, 30, 30, this);
												if(body11)
												{
													g.drawImage(bodyimg, x11, y11, 30, 30, this);
													if(body12)
													{
														g.drawImage(bodyimg, x12, y12, 30, 30, this);
														if(body13)
														{
															g.drawImage(bodyimg, x13, y13, 30, 30, this);
															if(body14)
															{
																g.drawImage(bodyimg, x14, y14, 30, 30, this);
																if(body15)
																{
																	g.drawImage(bodyimg, x15, y15, 30, 30, this);
																	if(body16)
																	{
																		g.drawImage(bodyimg, x16, y16, 30, 30, this);
																		if(body17)
																		{
																			g.drawImage(bodyimg, x17, y17, 30, 30, this);
																			if(body18)
																			{
																				g.drawImage(bodyimg, x18, y18, 30, 30, this);
																				if(body19)
																				{
																					g.drawImage(bodyimg, x19, y19, 30, 30, this);
																					if(body20)
																					{
																						g.drawImage(bodyimg, x20, y20, 30, 30, this);
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		g.drawString("Score: "+score, 450, 321);
		g.drawString("Best: "+best, 29, 321);
		g.drawString("Use WASD or Arrow Keys to move", 153, 321);
		g.drawString("Created by Kyler Tran", 364, 21);
		((Graphics2D) g).setStroke(new BasicStroke(5));
		g.drawLine(27, 27, 513, 27);
		g.drawLine(27, 27, 27, 300);
		g.drawLine(27, 302, 513, 302);
		g.drawLine(513, 27, 513, 300);
	}  
	public void actionPerformed(ActionEvent e)
	{
		if(!pause)
		{
			if(x < 30)
			{
				velX=0;
				x = 30;  
				y = 30;
				velY = 0;
				score = 0;
				body1 = false;
				body2 = false;
				body3 = false;
				body4 = false;
				body5 = false;
				body6 = false;
				body7 = false;
				body8 = false;
				body9 = false;
				body10 = false;
				body11 = false;
				body12 = false;
				body13 = false;
				body14 = false;
				body15 = false;
				body16 = false;
				body17 = false;
				body18 = false;
				body19 = false;
				body20 = false;
				goingLeft = false;
				goingRight = true;
				goingUp = false;
				goingDown = false;
			}
		
			if(x > 480)
			{
				velX=0;
				x = 30;  
				y = 30;
				velY = 0;
				score = 0;
				body1 = false;
				body2 = false;
				body3 = false;
				body4 = false;
				body5 = false;
				body6 = false;
				body7 = false;
				body8 = false;
				body9 = false;
				body10 = false;
				body11 = false;
				body12 = false;
				body13 = false;
				body14 = false;
				body15 = false;
				body16 = false;
				body17 = false;
				body18 = false;
				body19 = false;
				body20 = false;
				goingLeft = false;
				goingRight = true;
				goingUp = false;
				goingDown = false;
			}
		
			if(y < 30)
			{
				velX=0;
				x = 30;  
				y = 30;
				velY = 0; 
				score = 0;
				body1 = false;
				body2 = false;
				body3 = false;
				body4 = false;
				body5 = false;
				body6 = false;
				body7 = false;
				body8 = false;
				body9 = false;
				body10 = false;
				body11 = false;
				body12 = false;
				body13 = false;
				body14 = false;
				body15 = false;
				body16 = false;
				body17 = false;
				body18 = false;
				body19 = false;
				body20 = false;
				goingLeft = false;
				goingRight = true;
				goingUp = false;
				goingDown = false;
			}
		
			if(y > 270)
			{
				velX=0;
				x = 30;  
				y = 30;
				velY = 0;
				score = 0;
				body1 = false;
				body2 = false;
				body3 = false;
				body4 = false;
				body5 = false;
				body6 = false;
				body7 = false;
				body8 = false;
				body9 = false;
				body10 = false;
				body11 = false;
				body12 = false;
				body13 = false;
				body14 = false;
				body15 = false;
				body16 = false;
				body17 = false;
				body18 = false;
				body19 = false;
				body20 = false;
				goingLeft = false;
				goingRight = true;
				goingUp = false;
				goingDown = false;
			}
			x20 = x19;
			y20 = y19;
			x19 = x18;
			y19 = y18;
			x18 = x17;
			y18 = y17;
			x17 = x16;
			y17 = y16;
			x16 = x15;
			y16 = y15;
			x15 = x14;
			y15 = y14;
			x14 = x13;
			y14 = y13;
			x13 = x12;
			y13 = y12;
			x12 = x11;
			y12 = y11;
			x11 = x10;
			y11 = y10;
			x10 = x9;
			y10 = y9;
			x9 = x8;
			y9 = y8;
			x8 = x7;
			y8 = y7;
			x7 = x6;
			y7 = y6;
			x6 = x5;
			y6 = y5;
			x5 = x4;
			y5 = y4;
			x4 = x3;
			y4 = y3;
			x3 = x2;
			y3 = y2;
			x2 = x1;
			y2 = y1;
			x1 = x;
			y1 = y;
			x = x + velX;
			y = y + velY;
			currentlyMoving = false;
			repaint();
			collsion();
		}
	}
	public void keyPressed(KeyEvent e)
	{
		int c = e.getKeyCode();
		if (c == KeyEvent.VK_LEFT || c == KeyEvent.VK_A) // VK_Left is left arrow 
		{
			if(!goingRight)
			{
				if(!currentlyMoving)
				{
					currentlyMoving = true;
					velX = -30;
					velY = 0;
					goingLeft = true; 
					goingRight = false;
					goingUp = false;
					goingDown = false;
					try {
						img = ImageIO.read(Snake.class.getResource("Images/snakeleft.png"));
					} catch (IOException e1) {
						System.out.println("Can't find Image!");
					}
					refreshImgs(getGraphics());
				}
			}
		}
		if (c == KeyEvent.VK_UP || c == KeyEvent.VK_W) // VK_UP is up arrow 
		{
			if(!goingDown)
			{
				if(!currentlyMoving)
				{
					currentlyMoving = true;
					velX = 0;
					velY = -30; // means up 
					goingUp = true;
					goingRight = false;
					goingLeft = false;
					goingDown = false;
					try {
						img = ImageIO.read(Snake.class.getResource("Images/snakeup.png"));
					} catch (IOException e1) {
						System.out.println("Can't find Image!");
					}
					refreshImgs(getGraphics());
				}
			}
		}
		if (c == KeyEvent.VK_RIGHT || c == KeyEvent.VK_D)  
		{
			if(!goingLeft)
			{
				if(!currentlyMoving)
				{
					currentlyMoving = true;
					velX = 30;
					velY = 0; 
					goingRight = true;
					goingLeft = false;
					goingUp = false;
					goingDown = false;
					try {
						img = ImageIO.read(Snake.class.getResource("Images/snakeright.png"));
					} catch (IOException e1) {
						System.out.println("Can't find Image!");
					}
					refreshImgs(getGraphics());
				}
			}
		}
		if (c == KeyEvent.VK_DOWN || c == KeyEvent.VK_S)  
		{
			if(!goingUp)
			{
				if(!currentlyMoving)
				{
					currentlyMoving = true;
					velX = 0;
					velY = 30; 
					goingDown = true;
					goingRight = false;
					goingUp = false;
					goingLeft = false;
					try {
						img = ImageIO.read(Snake.class.getResource("Images/snakedown.png"));
					} catch (IOException e1) {
						System.out.println("Can't find Image!");
					}
					refreshImgs(getGraphics());
				}
			}
		}
		if (c == KeyEvent.VK_P)  
		{
			pause = !pause;
		}
	}
	public void refreshImgs(Graphics g)
	{
		g.drawImage(img, x, y, 30, 30, this);
	}
	public void keyTyped(KeyEvent e)
	{}
	public void keyReleased(KeyEvent e)
	{}
	public void point()
	{
		randNumber = Math.random();
		dx = randNumber * 16;
		randX = (int)dx * 30 + 6;
		randNumber1 = Math.random();
		dy = randNumber1 * 9;
		randY = (int)dy * 30 + 6;
		score++;
		if(score > best)
		{
			best++;
		}
		if(body19)
		{
			body20 = true;
		}
		if(body18)
		{
			body19 = true;
		}
		if(body17)
		{
			body18 = true;
		}
		if(body16)
		{
			body17 = true;
		}
		if(body15)
		{
			body16 = true;
		}
		if(body14)
		{
			body15 = true;
		}
		if(body13)
		{
			body14 = true;
		}
		if(body12)
		{
			body13 = true;
		}
		if(body11)
		{
			body12 = true;
		}
		if(body10)
		{
			body11 = true;
		}
		if(body9)
		{
			body10 = true;
		}
		if(body8)
		{
			body9 = true;
		}
		if(body7)
		{
			body8 = true;
		}
		if(body6)
		{
			body7 = true;
		}
		if(body5)
		{
			body6 = true;
		}
		if(body4)
		{
			body5 = true;
		}
		if(body3)
		{
			body4 = true;
		}
		if(body2)
		{
			body3 = true;
		}
		if(body1)
		{
			body2 = true;
		}
		body1 = true;
	}
	public void collsion()
	{
		for(num = 0; num <= 15; num++)
		{
			//System.out.println(+Math.abs(x - randX)+" "+Math.abs(randY - y)+" "+num);
			if(Math.abs(x - randX) <= num)
			{
				if((Math.abs(randY - y) <= num))
				{
					point();
				}
			}
		}
		num = 0;
	}
	public static void main(String[] args)
	{ 
		Snake g = new Snake();
		JFrame jf = new JFrame();
		jf.setBackground(Color.WHITE);
		jf.setTitle("Snake");
		jf.setSize(556,370);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Snake g1 = new Snake();
		jf.add(g1); 
	}
}