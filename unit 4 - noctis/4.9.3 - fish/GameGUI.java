/*
* Activity 4.9.3 and 4.9.4
* A Fishing Game
* 
* V1.0
* 10/10/2019
* Copyright(c) 2019 PLTW to present. All rights reserved
*/
import java.lang.Math;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.io.File;
import javax.imageio.ImageIO;

/**
* A fishing game board to show all items in a fisherman/woman's inventory.
*/
public class GameGUI extends JComponent implements ActionListener
{
  private static final long serialVersionUID = 26L;

	// setup the default size and placement values
	private static final int WIDTH = 540;
	private static final int HEIGHT = 570;
	private static final int SPACE_SIZE = 60;
	private static final int GRID_W = 8;
  private static final int GRID_H = 2;
  private static final int GRID_X = 20;
  private static final int GRID_Y = 5;

	// grid image to show in background
	private Image bgImage;

	// game setup info
  private Player player;

	// inventory items
	private Image itemImage;
	private String[][] inventoryImages;
	private Rectangle[][] inventoryItems;

	// game frame
	private JFrame frame;
	private JTextField textInput;

	// output panel
	private JTextArea outputArea;
	private JPanel topPanel;
	private JTextArea topSpace;
	private JPanel midPanel;

	// command panel
	private JScrollPane outputScrollPane;
	private JPanel textPanel;
	private JLabel label;
	private JButton button;
	private JPanel subPanel;

	/**
	* Constructor for the GameGUI class.
	* Creates a frame with a background image and command textbox.
	*/
	public GameGUI(Player player) 
	{
		this.player = player;
		this.frame = new JFrame();
		this.topPanel = new JPanel();
		this.topSpace = new JTextArea("", 8, 50);
		this.midPanel = new JPanel();
		this.outputArea = new JTextArea("Welcome", 20, 44);
		this.outputScrollPane = new JScrollPane(outputArea); 
		this.textInput = new JTextField(25); 
		this.textPanel = new JPanel();
		this.label = new JLabel("Enter command:");
		this.button = new JButton("Execute");
		this.subPanel = new JPanel();
		
		setGameImages();
		setupPanel();
	}

  /**
   * Setup the game frame and GUI components
   */
	public void setupPanel()
	{
		// create the game frame
		frame.setTitle("FishingGame");
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setVisible(true);
		frame.setVisible(true);

		// create board elements; inventoryItems
		inventoryItems = new Rectangle[GRID_W][GRID_H];
		createInventoryItems();

		// create a section for the inventory
		topSpace.setEditable(false);
		topPanel.add(BorderLayout.NORTH, topSpace);
		frame.add(BorderLayout.PAGE_START, topPanel);

		// create a text output stream
		// These lines allow vertical scrolling but not horizontal.
		outputArea.setEditable(false);
		midPanel.add(BorderLayout.CENTER, outputScrollPane);
		midPanel.setSize(WIDTH, 20);
		frame.add(BorderLayout.CENTER, midPanel);
    outputArea.setText("");
    // autoscroll to text at bottom
    javax.swing.text.DefaultCaret caret = (javax.swing.text.DefaultCaret)outputArea.getCaret();
    caret.setUpdatePolicy(javax.swing.text.DefaultCaret.ALWAYS_UPDATE);

		// create command panel
		button.addActionListener(this);
		textPanel.add(label);
		textPanel.add(textInput);
		subPanel.add(BorderLayout.NORTH, textPanel);
		subPanel.add(BorderLayout.SOUTH, button);
		subPanel.setSize(WIDTH, 50);
		frame.add(BorderLayout.SOUTH, subPanel);

		// set cursor in textbox, enable enter key to execute command
		textInput.requestFocus();
		frame.getRootPane().setDefaultButton(button);

		// lock size of screen
		frame.setResizable(false);
	}

  /**
   * Setup the game images
   */ 
	public void setGameImages()
	{
    // load board images
    // a try is like an if statement, "throwing" an error if the body of the try fails
    try
    {
			bgImage = ImageIO.read(new File("Grid.png"));      
    } catch (Exception e) { System.err.println("Warning: Could not open file Grid.png");}      
    try
    {
			itemImage = ImageIO.read(new File("Wallet.png"));      
    } catch (Exception e) {	System.err.println("Warning: Could not open file Wallet.png");}
	}

	/*
	* Append to the output area
	* 
	* @param s a String to append to the output
	*/
	public void setOutput(String s)
	{
    this.outputArea.append(s + "\n");
	}

	/*
	* Add a player to the game and set the inventory and wallet values.
	* 
	* @param p player to be added
	*/
	public void playGame()
	{
		updateInventoryImages();
		goToForest();
	}

	/*---------- public methods not to be called directly ----------*/
	
	/*
	* Action listener for the execute button, invokes the
	* execCommand method.
	* Note: This method is used by the textbox and Execute
	* button and should not be called directly.
	*/
  public void actionPerformed(ActionEvent event)
  {
		String input = textInput.getText();
    boolean wasInt = false;

    // a try is like an if statement, "throwing" an error if the body of the try fails
    try
    {
			int inputInt = Integer.parseInt(input);
			execCommand(inputInt);
			wasInt = true;
    } catch (Exception e) { 
      // continue with string input
			execCommand(input);
		}
		textInput.setText("");
		updateInventoryImages();
	}

	/*
	* Manages the graphics buffer to paint inventory elements.
	* Note: This method is for JVM use only and should not be called directly.
	* Instead call repaint() to re-render board elements.
	*/
  public void paintComponent(Graphics g)
  {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;

		// draw inventory grid
		g2.drawImage(bgImage, GRID_X, GRID_Y, null);

		// add inventoryItems
		int imgRow = 0;
		int imgCol = 0;
		for (Rectangle[] row : inventoryItems)
		{
		  for (Rectangle item : row)
		  {
				setItemImage(imgRow, imgCol);
				// wallet inventoryItem is the first one at x=15 and y=15
				if ((item.getX() ==  15+GRID_X) && (item.getY() == 15))
				{
					int px = (int)item.getX() + GRID_X;
          int py = (int)item.getY() + GRID_Y;
					g2.drawImage(itemImage, px, py, null);
					g2.drawString("$"+player.getWallet(), px-5, py+43);
				}
				// Other inventory items
				else if (item.getWidth() > 0) 
				{
					int px = (int)item.getX() + GRID_X;
					int py = (int)item.getY() + GRID_Y;
					g2.drawImage(itemImage, px, py, null);
					
					LakeObject inventoryItem = player.getInventoryItems2D()[imgCol][imgRow];
					if (inventoryItem != null)
					{
						if (inventoryItem.getObjectName().equals("Hook"))
							g2.drawString("Pow: " + ((Hook)player.getInventoryItems2D()[imgCol][imgRow]).getStrength(), px-10, py+43);
						else
							g2.drawString("$"+player.getInventoryItems2D()[imgCol][imgRow].getCost(), px-5, py+43);
					}
				}
				imgCol++;
		  }
		  imgRow++;
		  imgCol = 0;
    }
  }

	/*---------- private/convenience methods ----------*/
	/*
	* Set the image for an inventory item
	*/
	private void setItemImage(int col, int row)
	{ 
		String imageName = "Empty";
		if (inventoryImages != null)
      imageName = inventoryImages[row][col];
    // a try is like an if statement, "throwing" an error if the body of the try fails
    try
    {
      itemImage = ImageIO.read(new File(imageName + ".png"));   
    } catch (Exception e) { System.err.println("Warning: Could not open file " + imageName + ".png"); }
	}

	/*
	* Update inventoryItems to what the player has.
	*/
	private void updateInventoryImages()
	{
		inventoryImages = player.getInventory2D();
		repaint();
	}

	/*
	* Add inventoryItems the player has.
	*/
	private void createInventoryItems()
	{
		int s = SPACE_SIZE; 
		for (int row = 0; row < inventoryItems.length; row++)
		{
			for (int column = 0; column < inventoryItems[row].length; column++)
			{
				Rectangle r;
				r = new Rectangle((row*s + 15), (column*s + 15), 15, 15);
				inventoryItems[row][column] = r;
			}
		}
  }
  
  /**
	* Execute the command entered by the player if the command is an integer
	*
	* @param input int command entered by the player
	*/
	private void execCommand(int input)
	{
		if (player.getCurrentLocation().equals("shop"))
		{
			sellFish(input);
		}
	}

	/**
	* Execute the command entered by the player if it's a String
	* 
	* @param input String command entered by the player
	*/
	private void execCommand(String input)
	{
		if (input.equalsIgnoreCase("quit")|| input.equalsIgnoreCase("q"))
		{
			setOutput("Thank you, bye!");
			frame.dispose();
		}   
		else if (input.equalsIgnoreCase("shop") || input.equals("S"))
		{
			goToShop();
		}
		else if (input.equalsIgnoreCase("lake") || input.equals("L"))
		{
			goToLake();
		}
		else if ((input.equalsIgnoreCase("yes") || input.equals("y")) && player.getCurrentLocation().equalsIgnoreCase("lake"))
		{
			goFish();
			goToLake();
		}
		else if ((input.equalsIgnoreCase("no") || input.equals("n")) && player.getCurrentLocation().equalsIgnoreCase("lake"))
		{
			goToForest();
    }
    else if ((input.equalsIgnoreCase("no") || input.equals("n")) && player.getCurrentLocation().equalsIgnoreCase("shop"))
    {
      goToForest();
    }
		else if ((input.equalsIgnoreCase("bait") || input.equals("b")) && player.getCurrentLocation().equalsIgnoreCase("shop"))
		{
      setOutput("Buy Bait");
			buyBait();
			goToShop();
		}
		else if ((input.equalsIgnoreCase("hook") || input.equals("h")) && player.getCurrentLocation().equalsIgnoreCase("shop"))
		{
      setOutput("Buy Hook");
			buyHook();
			goToShop();
		}
		else if (input.equalsIgnoreCase("leave") || input.equals("l"))
		{
      setOutput("Thank you, return anytime!");
      goToForest();
		}
		else if ((input.equalsIgnoreCase("sell") || input.equals("s")) && player.getCurrentLocation().equalsIgnoreCase("shop"))
		{
      setOutput("Sell Fish");
      setOutput("What is the location of the fish you want to sell?");
		} 
		else 
		{
      setOutput("Not a valid command.");
      // reset output and input
      if (player.getCurrentLocation().equalsIgnoreCase("forest")) goToForest();
      else if (player.getCurrentLocation().equalsIgnoreCase("lake")) goToLake();
      else if (player.getCurrentLocation().equalsIgnoreCase("shop")) goToShop();
		}
		updateInventoryImages();
  }

	/*---------- Private Game Area methods ----------*/

	/* Game Forest Area */
	/**
	 * Take the player to the forest.
	 */ 
	private void goToForest()
	{
		outputArea.setText("");
		player.setCurrentLocation("forest");
    setOutput("\nYou are in a forest. Where would you like to go?");
    setOutput("\nEnter a valid choice: Lake(L), Shop(S), Quit(Q)\n");
	}

	/*  Game Shop Area */
  private void goToShop()
  {
    player.setCurrentLocation("shop");
    setOutput("\nWelcome to the shop. What would you like to do?\n buy bait (b)\n buy a hook (h)\n sell fish (s)\n or leave (l)");
  }

  private void buyBait()
  {   
    Bait b = new Bait();

    if (player.roomInInventory()) {
      if (player.getWallet() >= b.getCost())
      {
        player.updateWallet(-1*b.getCost());
        player.updateInventory(b, true);
        setOutput(b.say());
      }
      else 
        setOutput("You cannot afford a bait.");
    }
    else 
      setOutput("You have no room in your inventory.");

  }

  private void buyHook()
  {
    Hook h = new Hook();

    if (player.roomInInventory()) {
      if (player.getWallet() >= h.getCost())
      {
        player.updateWallet(-1*h.getCost());
        player.updateInventory(h, true);
        setOutput(h.say());
      }
      else
        setOutput("You cannot afford a hook.");
    }
    else 
      setOutput("You have no room in your inventory.");

  }
  
  private void sellFish(int location)
  {
		boolean sold = player.loseItem("Fish", location, true);

    if (sold)
      setOutput("Thank you. Your wallet has been updated.");
    else
      setOutput("You did not have a fish at that location. Don't try to trick me!"); 

    goToShop();
  }

  /* Game Lake Area */
  public void goToLake()
  {
    player.setCurrentLocation("lake");
    setOutput("\nWelcome to the lake. Would you like to fish?\n yes(y)\n no(n)\n or leave(l)");
  }
  
  public void goFish()
  {
		// generate a Lake full of new LakeObjects
    LakeObject[] lakeObjects = new LakeObject[4];
    lakeObjects[0] = new Fish();
    lakeObjects[1] = new Wallet();
		lakeObjects[2] = new Fish();
		lakeObjects[3] = new Boot();

    if (player.hasHook() && player.hasBait())
    {
      int i = (int)(Math.random() * lakeObjects.length) + 1;
			Hook strongestHook = player.getStrongestHook();
			setOutput("\n");

      if (i >= lakeObjects.length)
      {
        setOutput("\nYou lost your hook  :(");
        player.updateInventory(new Hook(), false);
      }
      else if (lakeObjects[i].wasCaught(strongestHook))
      {
				if (lakeObjects[i].getObjectName().equals("Wallet"))
				{
					player.updateWallet(lakeObjects[i].getCost());
					setOutput("You caught a Wallet!");
					setOutput(lakeObjects[i].say());
					setOutput("Money from the wallet was added to your inventory");
				} 
				else
				{ 
          if(player.roomInInventory())
          {
					  player.updateInventory(lakeObjects[i], true);
            setOutput(lakeObjects[i].say());
          } else 
            setOutput("You have no room in your inventory.");
				}
			}
			else
			{
        setOutput("\nYour hook had a strength of " + strongestHook.getStrength() +
        "\nand needed at least a strength of " + lakeObjects[i].getWeight());
			}
    }
    else
    {
			setOutput("You need a hook and bait to go fishing. You can buy them at the shop.");
		}
  }

}