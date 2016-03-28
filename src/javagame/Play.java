package javagame;


import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState
{
	
	
	Animation front,movingUp,movingDown,movingLeft,movingRight;
	Image worldMap;
	boolean quit = false;
	int[] duration = {200,200};
	float positionX = 0;
	float positionY = 0;
	float shiftX = positionX + 360;
	float shiftY = positionY + 160;
	
	public Play(int state)
	{
		
	}
	
	public void init(GameContainer gc,StateBasedGame sbg) throws SlickException
	{
		worldMap = new Image("res/background.jpg");
		Image [] walkUp = {new Image("res/up.png"),new Image ("res/up.png")};
		Image [] walkDown = {new Image("res/down.jpg"),new Image ("res/down.jpg")};
		Image [] walkRight = {new Image("res/right.jpg"),new Image ("res/right.jpg")};
		Image [] walkLeft = {new Image("res/Left.jpg"),new Image ("res/Left.jpg")};
		
		
		movingUp = new Animation(walkUp,duration,false);
		movingDown = new Animation(walkDown,duration,false);
		movingRight = new Animation(walkRight,duration,false);
		movingLeft = new Animation(walkLeft,duration,false);
		front = movingDown;
		
	}
	
	public void render(GameContainer gc,StateBasedGame sbg,Graphics g) throws SlickException
	{
		worldMap.draw(positionX,positionY);
		front.draw(shiftX,shiftY);
		g.drawString("Player X: " + positionX + " Y: " + positionY, 550, 10);
		
		
		if(quit == true )
		{
			g.drawString("Resume (R)", 200, 100);
			g.drawString("Main Menu (M)", 200, 150);
			g.drawString("Quit Game (Q)", 200, 200);
			 if(quit == false)
			 {
				 g.clear();
			 }
			
		}
	}
	
	public void update(GameContainer gc,StateBasedGame sbg,int delta) throws SlickException
	{
		Input input = gc.getInput();
		
		if(input.isKeyDown(Input.KEY_UP))
		{
			front = movingUp;
			positionY += delta *.1f;
			if(positionY>161)
			{
				positionY -= delta * .1f;
			}
		}
		if(input.isKeyDown(Input.KEY_DOWN))
		{
			front = movingDown;
			positionY -= delta *.1f;
			if(positionY<-214)
			{
				positionY += delta * .1f;
			}
		}
		if(input.isKeyDown(Input.KEY_RIGHT))
		{
			front = movingRight;
			positionX -= delta *.1f;
			
			if(positionX<-337)
			{
				positionX += delta * .1f;
			}
		}
		if(input.isKeyDown(Input.KEY_LEFT))
		{
			front = movingLeft;
			positionX += delta *.1f;
			if(positionX>360)
			{
				positionX -= delta * .1f;
			}
		}
			
		if(input.isKeyDown(Input.KEY_ESCAPE))
		{
			quit = true;
		}
		
		if(quit == true)
		{
			if(input.isKeyDown(Input.KEY_R))
			{
				quit = false;
			}
			
			if(input.isKeyDown(Input.KEY_M))
			{
				sbg.enterState(0);
			}
			
			if(input.isKeyDown(Input.KEY_Q))
			{
				System.exit(0);
			}
			
		}
		
	}
	
	public int getID()
	{
		return 1;
	}

}
