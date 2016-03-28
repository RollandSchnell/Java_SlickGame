package javagame;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Menu extends BasicGameState
{
	
	
	 int x = 100;
	 int y = 100;
	Image playNow;
	Image exitGame;
	
	
	public  Menu(int State)
	{
		
	}
	
	
	
	
	
	public void init(GameContainer gc,StateBasedGame stb) throws SlickException
	{
		
		  playNow = new Image("res/play.jpg");
		  exitGame = new Image("res/exit.jpg");
		
	}
	
	
	public void render(GameContainer gc,StateBasedGame stb,Graphics g) throws SlickException
	
{
		g.drawString("Wellcome!!!",350,50);
		
		playNow.draw(270,100);
		exitGame.draw(420,100);
		
		
		
		
}
	
	
	public void update(GameContainer gc,StateBasedGame stb,int delta) throws SlickException
	{
		int posX = Mouse.getX();
		int posY = Mouse.getY();
		
		System.out.println(posX+" "+posY);
		//play button
		
		if((posX>270 && posX<371) && (posY>399 && posY<501))
		{
			if(Mouse.isButtonDown(0))
			{
				stb.enterState(1);
			}
			
		}
		
		//exit button
		
		if((posX>420 && posX<521) && (posY>399 && posY<501))
		{
			if(Mouse.isButtonDown(0))
			{
				System.exit(0);
			}
			
		}
		
		
	}
	
	public int getID()
	{
		return 0;
	}
	
	
	
}