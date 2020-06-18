import java.lang.*;
import javax.swing.*;
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


public class Main{

   private static boolean advance = false;

   public static void main(String[] argc){
      playMusic("ComputerLab.wav");      


      //text based stuff:
      Person[] people = new Person[3];
      
      //public Person(String personName,int ego, int energy, int level){

      people[0] =  new Person("CS Student", 20, 20 , 1);

      people[1] =  new Person("Dr. Horn" , 22, 15 , 2);
      
      people[2] =  new Person("Professor Rubix" , 15, 25 , 3);

      Action[] playerActions = new Action[10];
      Action[] nPCActions = new Action[10];

       // Action(String actionName,int usesLeft,int affectEnemy, int affectEgo, int affectEnergy ){  
       
       //player actions   
      playerActions[0] = new Action("Read Textbook",-1,-2, 0, -2);
      playerActions[1] = new Action("Consult Stack Overflow",-1,-2, 0, -2);
      playerActions[2] = new Action("Drink RedBull",1,0, +1, +4 );
      playerActions[3] = new Action("Drink Coffee",1,0, +1, 3 );
      playerActions[4] = new Action("Stay Late In Office Hours",1,-3, +2, -1 );
      playerActions[5] = new Action("Pester T.A.",-1,-2, +1, -1);
      playerActions[6] = new Action("Throw A Party",-1,0, +3, -3);
      playerActions[7] = new Action("Coffee Date",1,0, +2, +1);
      playerActions[8] = new Action("Sick Day",1,0, +2, +3);
      playerActions[9] = new Action("Meet With Advisor",-1,-2, -1, -1);
           
      //enemy actions
      nPCActions[0] = new Action("Change Assignment Date",-1,-2, +1, 0 );
      nPCActions[1] = new Action("Pop Quiz",1,-3, +1, -2 );
      nPCActions[2] = new Action("Lab Cancelled",1,-3, -1, +1 );
      nPCActions[3] = new Action("Office Hours Cancelled",1,-4, -1, +2 );
      nPCActions[4] = new Action("Midterm",1,-4, -1, +2 );
      nPCActions[5] = new Action("8 AM Final",1,-5, +2, -1 );
      nPCActions[6] = new Action("Alter Grading Criteria",1,-2, +1, -1 );
      nPCActions[7] = new Action("Sick Day",1,0, +3, +4);
      nPCActions[8] = new Action("Recursion Only Assignment",1,-2, 0, 0);
      nPCActions[9] = new Action("No Bathroom Breaks During Exams",1,-3, 0, 0);

      //give the player items
      people[0].addToInventory(playerActions[0]);
      people[0].addToInventory(playerActions[2]);
      people[0].addToInventory(playerActions[1]);
      people[0].addToInventory(playerActions[9]);
      
      people[1].addToInventory(nPCActions[0]);
      people[1].addToInventory(nPCActions[2]);
      people[1].addToInventory(nPCActions[1]);
      people[1].addToInventory(nPCActions[9]);
      
//end of text based stuff;

      JFrame mainMenu = new JFrame("Main Menu");
      JButton startGame = new JButton("Enroll");
      JButton exit = new JButton("Dropout");
      JPanel layout = new JPanel();
      JPanel startGamePanel = new JPanel();
      JPanel exitPanel = new JPanel();
      JPanel titlePanel = new JPanel();
      JLabel title = new JLabel("Code Quest!");
      
      title.setFont(new	Font("Serif",	Font.BOLD, 70));
      title.setForeground(Color.CYAN);
      //titlePanel.setLayout(new BorderLayout(BorderLayout.Center));
      titlePanel.add(title, BorderLayout.NORTH);
      
      startGamePanel.add(startGame);
      exitPanel.add(exit);
                  
      layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));
      layout.add(Box.createRigidArea(new Dimension(0, 2)));
      layout.add(startGamePanel);
      layout.add(exitPanel);
      
      
      startGamePanel.setOpaque(false);
      exitPanel.setOpaque(false);
      layout.setOpaque(false);
      titlePanel.setOpaque(false);
      

      mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      mainMenu.setTitle("Code Quest");
      mainMenu.setSize(500, 400);
      mainMenu.getContentPane().setBackground(Color.BLUE);
      mainMenu.add(layout, BorderLayout.PAGE_END);
      mainMenu.add(titlePanel, BorderLayout.CENTER);
      
      mainMenu.setResizable(false);
      mainMenu.setLocationRelativeTo(null);
      mainMenu.setVisible(true);
      
            
      startGame.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
          
            

      mainMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      mainMenu.dispatchEvent(new WindowEvent(mainMenu, WindowEvent.WINDOW_CLOSING));
            
     

      JFrame openingWindow = new JFrame("Opening");
      openingWindow.setSize(500,400);
      
      JButton headToSchool = new JButton ("Head to school");
      
      JPanel headSchool = new JPanel();
      headSchool.add(headToSchool);
      headSchool.setOpaque(false);
      JPanel layout = new JPanel();
      
      layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));
      layout.add(Box.createRigidArea(new Dimension(0, 2)));
      layout.add(headSchool);
      layout.setBackground(Color.WHITE);
      openingWindow.add(layout, BorderLayout.PAGE_END);
      
      String openingText = "Welcome to the University!\n" 
      + "On behalf of all the school we would\n" 
      + "like to wish you good luck as you work\n" 
      + "towards gaining entry to our CS Major.\n\n"
      + "It will not be easy,\n"
      + "and there will be many challenging\n" 
      + "assignments, but we know you can do it!\n"
      + "\n\n Sincerely, Dean Shrimpo.";
      
      
      JTextArea textArea = new JTextArea();
      textArea.setFont(new Font("Serif", Font.BOLD, 20));
      textArea.setSize(300, 150);
      textArea.setText(openingText);
      textArea.setVisible(true);
      openingWindow.add(textArea);
      textArea.setEditable(false);
      openingWindow.setLocationRelativeTo(null);
      openingWindow.setVisible(true);
      
      headToSchool.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            openingWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            openingWindow.dispatchEvent(new WindowEvent(openingWindow, WindowEvent.WINDOW_CLOSING));
            advance =true;
         }
      }); 
              }
      }); 
      
      exit.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e){
            mainMenu.dispatchEvent(new WindowEvent(mainMenu, WindowEvent.WINDOW_CLOSING));
         }
      }); 
      
        while(advance != true){
                try{
                   Thread.sleep(200);
                   }catch(InterruptedException e){                    
                }
             }
      Combat.combat(people[0],people[1]);

      people[0].addToInventory(playerActions[2]);
      people[0].addToInventory(playerActions[3]);


   } 
   
   public static void playMusic(String songName)
   {
         //play music passed in by title
         AudioInputStream stream;
         AudioFormat format;
         DataLine.Info info;
         Clip clip;
      try 
      {
         File yourFile =  new File(songName);
         stream = AudioSystem.getAudioInputStream(yourFile);
         format = stream.getFormat();
         info = new DataLine.Info(Clip.class, format);
         clip = (Clip) AudioSystem.getLine(info);
         clip.open(stream);
         clip.start();
         Thread.sleep(1000);
         } catch (Exception e)
         {
            System.out.println(e);
         }    
   }  
}