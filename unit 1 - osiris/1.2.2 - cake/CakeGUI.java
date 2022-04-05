/*
* Activity 1.2.2
* GUI
*
* V1.0
* 6/1/2019
* Copyright(c) 2019 PLTW to present. All rights reserved
*/
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.util.ArrayList;

/**
 * This file contains many elements that are outside the scope of CSA, including
 * graphics libraries, inner classes, image IO, Exception, and NumberFormatException
 * Students may take a look "under the hood" of this class and see familiar code
 * but should not expect to understand all of it.
 */
public class CakeGUI
{
  private static Image kitchenImage, cakeImage, twoTierCakeImage, threeTierCakeImage, 
                      cakeCandlesImage, twoTierCakeCandlesImage, threeTierCakeCandlesImage;
  public static boolean READY_TO_EXECUTE = false;
  private static CodeCompiler cc = new CodeCompiler();
  private static ArrayList<CakeObject> cakes = new ArrayList<CakeObject>();

  public CakeGUI() {

    loadFiles();

    JFrame f = new JFrame("Object Creator");
    f.setSize(500, 580);
    f.setLocation(300,200);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel panel = new JPanel()
    {
      static final long serialVersionUID = 122L;
      @Override
      public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // draw background
        g.drawImage(kitchenImage, 0, 0, null);

        if (CakeGUI.READY_TO_EXECUTE){
          for (CakeObject cake : cakes)
          {
            System.out.println("Cake object: " + cake); // Standard output will show a list of all cakes with each repainting.
            if (cake.hasCandles())
            { 
              if (cake.getTiers() == 2)
              {
                g.drawImage(twoTierCakeCandlesImage, cake.getX(), cake.getY(), cake.getWidth(), cake.getHeight(), null);
              }
              else if (cake.getTiers() > 2)
              {
                g.drawImage(threeTierCakeCandlesImage, cake.getX(), cake.getY(), cake.getWidth(), cake.getHeight(), null);
              }
              else
              {
                g.drawImage(cakeCandlesImage, cake.getX(), cake.getY(), cake.getWidth(), cake.getHeight(), null);
              }
            }
            else
            {
              if (cake.getTiers() == 2)
              {
                g.drawImage(twoTierCakeImage, cake.getX(), cake.getY(), cake.getWidth(), cake.getHeight(), null);
              }
              else if (cake.getTiers() > 2)
              {
                g.drawImage(threeTierCakeImage, cake.getX(), cake.getY(), cake.getWidth(), cake.getHeight(), null);
              }
              else
              {
                g.drawImage(cakeImage, cake.getX(), cake.getY(), cake.getWidth(), cake.getHeight(), null);
              }
            }
          }
          System.out.println("Done processing cakes\n");
        } 
        CakeGUI.READY_TO_EXECUTE = false;
      }
    };
    
    panel.setLayout(new BorderLayout());
    f.setContentPane(panel);

    final JTextField textInput = new JTextField(30); 
    JScrollPane textPanel = new JScrollPane(textInput);

    final JButton button = new JButton("Execute");
    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String content = null;
        content = textInput.getText();
      
        System.out.println("Command to execute: " + content);
        CakeAction cakeAction = cc.compile(content);
        if (!content.contains(";"))
        {
          System.out.println("Error: Missing semi-colon in statement");
          cakeAction = null;
        }
        if (cakeAction == null) {
          System.out.println("Error: Could not compile command: " + content + "\n");
        }
        else
        {
          applyCakeAction(cakeAction);
          CakeGUI.READY_TO_EXECUTE = true;
          panel.repaint();
          textInput.setText("");   
        }
      }

      private void applyCakeAction(CakeAction cakeAction)
      {
        boolean cakeExists = false;
        // validate cake exists for this cakeAction
        for (CakeObject cake : cakes)
        {
          if (cake.getCakeIdentifier().equals(cakeAction.getIdentifier()))
          {
            cakeExists = true;
          }
        }

        if (!cakeExists) // This should be a constructor
        {
          System.out.println("New cake identifier " + cakeAction.getIdentifier());
          applyCakeConstructor(cakeAction);
        }
        else // The cake exists! This should be a method call.
        {
          System.out.println("Cake exists, identifier is " + cakeAction.getIdentifier());
          applyCakeMethod(cakeAction);
        }
      }

      private void applyCakeConstructor(CakeAction cakeAction)
      {
        if (cakeAction.getAction().equals("Constructor 0"))
        {
          cakes.add(new CakeObject(cakeAction.getIdentifier()));
        }
        else if (cakeAction.getAction().equals("Constructor 1"))
        {
          // a try is like an if statement, "throwing" an error if the body of the try fails
          try
          {
            // An example for when you have to parse Strings
            //if (cakeAction.getArgs()[0].equals("\"Blue\""))
            int tiers = Integer.parseInt(cakeAction.getArgs()[0]);
            if (tiers <= 1)
            {
              cakes.add(new CakeObject(cakeAction.getIdentifier(), 1));
            }
            else if (tiers == 2)
            {
              cakes.add(new CakeObject(cakeAction.getIdentifier(), 2));
            }
            else 
            {
              cakes.add(new CakeObject(cakeAction.getIdentifier(), 3));
            }
          } catch (NumberFormatException ne) { System.out.println("Error: Number format exception");  }
        }
        else 
        {
          System.err.println("Error: Could not execute cake action " + cakeAction.getAction());
        }
      }

      private void applyCakeMethod(CakeAction cakeAction)
      {
        String cakeMethodIdentifier = cakeAction.getAction();
        
        // all cake methods
        if (cakeMethodIdentifier.equals("setX") ||
            cakeMethodIdentifier.equals("setY") ||
            cakeMethodIdentifier.equals("setColor") ||
            cakeMethodIdentifier.equals("addCandles") ||
            cakeMethodIdentifier.equals("oneTier") ||
            cakeMethodIdentifier.equals("twoTiers") ||
            cakeMethodIdentifier.equals("threeTiers")) 
        {
          System.out.println("Recognized method " + cakeMethodIdentifier);
          for (CakeObject cake : cakes)
          {
            if (cake.getCakeIdentifier().equals(cakeAction.getIdentifier()))     // match method identifiers
            {
              String[] methodArgs = cakeAction.getArgs();
              if (methodArgs != null)  // null args means illegal or undefined method call, ignore it
              {
                if (methodArgs[0].equals(""))
                {
                  // implememnt methods with empty param list
                  if (cakeMethodIdentifier.equals("addCandles"))
                  {
                    cake.addCandles();
                  }
                  else if (cakeMethodIdentifier.equals("oneTier"))
                  {
                    cake.oneTier();
                  }
                  else if (cakeMethodIdentifier.equals("twoTiers"))
                  {
                    cake.twoTiers();
                  }
                  else if (cakeMethodIdentifier.equals("threeTiers"))
                  {
                    cake.threeTiers();
                  }
                }
                else
                {
                  // a try is like an if statement, "throwing" an error if the body of the try fails
                  try 
                  {
                    System.out.println("Trying numerical methods.");

                    int valueToSet = Integer.parseInt(cakeAction.getArgs()[0]);
                    // implement methods with an numeric param
                    if (cakeMethodIdentifier.equals("setX") && valueToSet >= CakeObject.MIN_X_VALUE && valueToSet <= CakeObject.MAX_X_VALUE)
                    {
                      cake.setX(valueToSet);
                    }    
                    if (cakeMethodIdentifier.equals("setY") && valueToSet >= CakeObject.MIN_Y_VALUE && valueToSet <= CakeObject.MAX_Y_VALUE)
                    {
                      cake.setY(valueToSet);
                    }    
                  }
                  catch (NumberFormatException  e)
                  {
                    // implmenet methods with string param
                    String valueToSet = null;
                    if (cakeAction.getArgs().length > 0)
                    {
                      valueToSet = cakeAction.getArgs()[0];
                      valueToSet = valueToSet.substring(1, valueToSet.length()-1);
                    }
                    System.out.println("Trying alphabetical methods with actual params : \"" + valueToSet + "\"");
                    // implement methods with a string param (none in this version )
                    /*
                    if (cakeMethodIdentifier.equals("setColor") && valueToSet.equals("Blue") || valueToSet.equals("Red"))
                    {
                      cake.setColor(valueToSet);
                    }*/
                  }
                }
              }
            }
          }
        }
        else
        {
          System.err.println("Error: Could not process " + cakeMethodIdentifier);
        }
      }
    });

    JPanel subPanel = new JPanel();
    subPanel.add(BorderLayout.NORTH, textPanel);
    subPanel.add(BorderLayout.SOUTH, button);
    subPanel.setSize(450,50);
    panel.add(BorderLayout.SOUTH, subPanel);
    panel.setVisible(true);

    f.getRootPane().setDefaultButton(button);
    f.setVisible(true);
  }

  private void loadFiles()
  {
    // a try is like an if statement, "throwing" an error if the body of the try fails
    try {
      kitchenImage = ImageIO.read(new File("kitchen.png"));      
    } catch (Exception e) { System.err.println("Warning: Could not open file kitchen.png"); } 
    try {
      cakeImage = ImageIO.read(new File("oneTierCake.png"));      
    } catch (Exception e) { System.err.println("Warning: Could not open file oneTierCake.png"); }  
    try {
      twoTierCakeImage = ImageIO.read(new File("twoTierCake.png"));      
    } catch (Exception e) { System.err.println("Warning: Could not open file twoTierCake.png"); } 
    try {
      threeTierCakeImage = ImageIO.read(new File("threeTierCake.png"));      
    } catch (Exception e) { System.err.println("Warning: Could not open file threeTierCake.png"); }
    try {
      cakeCandlesImage = ImageIO.read(new File("oneTierCakeCandles.png"));
    } catch (Exception e) { System.err.println("Warning: Could not open file oneTierCakeCandles.png"); }  
    try {
      twoTierCakeCandlesImage = ImageIO.read(new File("twoTierCakeCandles.png"));      
    } catch (Exception e) { System.err.println("Warning: Could not open file twoTierCakeCandles.png"); } 
    try {
      threeTierCakeCandlesImage = ImageIO.read(new File("threeTierCakeCandles.png"));      
    } catch (Exception e) { System.err.println("Warning:Could not open file threeTierCakeCandles.png"); }
  }
}