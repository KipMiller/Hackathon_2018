import java.lang.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.*;
import javax.sound.sampled.*;
import java.net.*;
import javax.sound.sampled.*;


public class MainInterface extends JFrame{

   // Global variables : HOLY CHOW
   public int actionChoice = -1;
   
   boolean buttonPressed;

   public JFrame myFrame;
   public JPanel mainLayout;
   public JPanel infoBox1;
   public JPanel infoBox2;
   public JPanel actionBox;
   public JLabel label;
   public JLabel label2;
   public JLabel label3;
   public JLabel label4;
   public JLabel labelPlayer;
   public JLabel labelEnemy;
   public JPanel labelPanel1;
   public JPanel labelPanel2;
   public JPanel labelPanel3;
   public JPanel labelPanel4;
   public JPanel labelPanelPlayerName;
   public JPanel labelPanelEnemyName;
   public JPanel labelPanelPlayer;
   public JPanel labelPanelEnemy;
   public GridBagLayout gridbag;
   public GridBagConstraints constraints;
   public JTextArea text;
   
   public MainInterface(Person player, Person enemy){
    try{  
      this.myFrame = new JFrame("Code Quest");// the name window name (I.E. at the top of the window     
      this.mainLayout = new JPanel();
      this.buttonPressed = false;
         
      String path = "ComputerLab.jpg";
      File file;
      BufferedImage image;
      JLabel lab;
      JPanel labPanel;
      
      file = new File(path);
      image = ImageIO.read(file);
      lab = new JLabel(new ImageIcon(image));
      labPanel = new JPanel();
      labPanel.setLayout(new GridLayout(1, 0));
      labPanel.setOpaque(false);
      labPanel.add(lab);

      JButton button0= new JButton(player.inventory[0]+"");    
      JButton button1= new JButton(player.inventory[1]+""); 
      JButton button2= new JButton(player.inventory[2]+""); 
      JButton button3= new JButton(player.inventory[3]+""); 
      
      
      JPanel layout = new JPanel();
      JPanel buttonPanel = new JPanel();

      buttonPanel.setLayout(new GridLayout(0, 4));
      buttonPanel.add(button0);
      buttonPanel.add(button1);
      buttonPanel.add(button2);
      buttonPanel.add(button3);
      
      mainLayout.setOpaque(false);
      buttonPanel.setOpaque(false);
     	this.gridbag =	new GridBagLayout();
		
		mainLayout.setLayout(gridbag);
		
		this.constraints =	new GridBagConstraints();
		
      constraints.anchor =	GridBagConstraints.CENTER;
		constraints.gridx	= 0;
		constraints.gridy	= 0;
		constraints.gridheight = 3;
		constraints.gridwidth =	3;
		constraints.weighty = 1;
		constraints.weightx = 1;
      constraints.fill = GridBagConstraints.BOTH;
      mainLayout.add(labPanel, constraints);
      
      constraints.anchor =	GridBagConstraints.SOUTHWEST;
		constraints.gridx	= 0;
		constraints.gridy	= 0;
		constraints.gridheight = 1;
		constraints.gridwidth =	1;
		constraints.weighty = 0.5;
		constraints.weightx = 0.5;
      constraints.fill = GridBagConstraints.NONE;
          
      
      mainLayout.add(buttonPanel, constraints);

		constraints.anchor =	GridBagConstraints.NORTHWEST;
		constraints.gridx	= 0;
		constraints.gridy	= 0;
		constraints.gridheight = 1;
		constraints.gridwidth =	1;
		constraints.weighty = 0.5;
		constraints.weightx = 0.5;

		this.infoBox1 =	new JPanel(new	GridLayout(1, 0));
		this.infoBox2 =	new JPanel(new	GridLayout(1, 0));
		this.actionBox = new JPanel(new GridLayout(1,	0));
		
		infoBox1.setOpaque(false);
		infoBox2.setOpaque(false);
		
		this.label =	new JLabel("Ego: " +	player.ego);
		this.label2 = new JLabel("Energy: " + player.energy);
		this.label3 = new JLabel("Ego: " + enemy.ego);
		this.label4 = new JLabel("Energy: " + enemy.energy);
		this.labelPlayer =	new JLabel(player.personName);
		this.labelEnemy	= new	JLabel(enemy.personName);

		label.setFont(new	Font("",	Font.BOLD, 30));
		label2.setFont(new Font("", Font.BOLD,	30));		 
		label3.setFont(new Font("", Font.BOLD,	30));
		label4.setFont(new Font("", Font.BOLD,	30));
		labelPlayer.setFont(new	Font("",	Font.BOLD, 30));
		labelEnemy.setFont(new Font("", Font.BOLD, 30));
		
		this.labelPanel1 =	new JPanel();
		this.labelPanel2 =	new JPanel();
		this.labelPanel3 =	new JPanel();
		this.labelPanel4 =	new JPanel();
		this.labelPanelPlayerName =	new JPanel();
		this.labelPanelEnemyName	= new	JPanel();
		
		labelPanel1.add(label);
		labelPanel1.setBackground(Color.red);
		labelPanel2.add(label2);
		labelPanel2.setBackground(Color.	YELLOW);
		
		labelPanel3.add(label3);
		labelPanel3.setBackground(Color.red);
		labelPanel4.add(label4);
		labelPanel4.setBackground(Color.	YELLOW);
		
		labelPanelPlayerName.add(labelPlayer);
		labelPanelPlayerName.setBackground(Color.GREEN);
		labelPanelEnemyName.add(labelEnemy);
		labelPanelEnemyName.setBackground(Color.GREEN);
		
		this.labelPanelPlayer	= new	JPanel(new GridLayout(3, 0));
		this.labelPanelEnemy = new JPanel(new GridLayout(3,	0));
		
		labelPanelPlayer.add(labelPanelPlayerName);
		labelPanelPlayer.add(labelPanel1);
		labelPanelPlayer.add(labelPanel2);
		labelPanelEnemy.add(labelPanelEnemyName);
		labelPanelEnemy.add(labelPanel3);
		labelPanelEnemy.add(labelPanel4);

		infoBox1.add(labelPanelPlayer);
		infoBox2.add(labelPanelEnemy);
		
		mainLayout.setLayout(gridbag);
		mainLayout.add(infoBox1, constraints);
		 
		constraints.anchor =	GridBagConstraints.NORTHEAST;
		constraints.gridx	= 2;
		constraints.gridy	= 0;
		constraints.gridheight = 1;
		constraints.gridwidth =	1;
		constraints.weighty = 0.5;
		constraints.weightx = 0.5;
		
		mainLayout.add(infoBox2, constraints);

     // String textArea = "You are ambushed by " + enemy.personName + "!!!";// "                            \n" 
//       + "                            \n" 
//       + "                            \n" 
//       + "                            \n"
//       + "                            \n"
//       + "                            \n" 
//       + "                            \n"
//       + "                            ";
      
      
      

      this.text = new JTextArea();
      text.setSize(300, 150);
      //text.setText(textArea);
      text.setFont(new Font("", Font.BOLD,	15));
      text.setVisible(true);
      text.setEditable(false);
		
      constraints.anchor =	GridBagConstraints.SOUTHEAST;
		constraints.gridx	= 0;
		constraints.gridy	= 0;
		constraints.gridheight = 5;
		constraints.gridwidth =	5;
		constraints.weighty = 0.5;
		constraints.weightx = 0.5;
      
      mainLayout.add(text, constraints);

		myFrame.setSize(1200, 800);	//	X by Y pixels for	window size
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//	close	when you	hit the X
       
		myFrame.add(mainLayout);
             
		myFrame.setLocationRelativeTo(null);//	put in middle of the	screen
		myFrame.setResizable(false);
		myFrame.setVisible(true);// invisible if not	set to true
		
      
      button0.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            actionChoice = 0;
            buttonPressed = true;
         }
      }); 
  
      button1.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            actionChoice = 1;
            buttonPressed = true;
         }
      });
      
      button2.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            actionChoice = 2;
            buttonPressed = true;
         }
      });
      
      button3.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            actionChoice = 3;
            buttonPressed = true;
         }
      });
      }catch(IOException e){
         System.out.print(e);
      }  
   }

   public void updateInterface(Person player, Person enemy){      
      this.label.setText("Ego: " +	player.ego);
 		this.label2.setText("Energy: " + player.energy);
		this.label3.setText("Ego: " + enemy.ego);
      this.label4.setText("Energy: " + enemy.energy);
      this.labelPlayer.setText(player.personName);
      this.labelEnemy.setText(enemy.personName);
      }  
   public void updateText(String update){
      this.text.setText(update);
   }
}