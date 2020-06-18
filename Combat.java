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
import javax.swing.SwingUtilities;



public class Combat extends JFrame{

   private static void hold(int timeMilli){
       try{
          Thread.sleep(timeMilli);
                     
       }catch(InterruptedException e){                    
       }
   
   }
   //time between combat steps
   private static int COMBAT_TIME1 = 1000;

   public static boolean combat(Person player, Person enemy){    
      //Person player1 = new Person("BO", 100, 100, 1);
      //Person enemy1 = new Person("Dr. Hearne", 1000, 500, 5);
      boolean isPlayerTurn = true;
      //JFrame myFrame = new JFrame("Code Quest");
      //MainInterface.openInterface(player, enemy);
      MainInterface frame = new MainInterface(player, enemy);
      frame.updateText("You Are Ambushed By "+ enemy.personName);
      hold(COMBAT_TIME1*3);

      while(player.ego > 0 && enemy.ego > 0){
         
       //System.out.println("\n Current Stats");
       //System.out.println(player);
       //System.out.println(enemy);
       //System.out.println();
       
         //if it is the players turn         
       if(isPlayerTurn == true){
         frame.updateText("Player's Turn");
          //System.out.println("Player's Turn");
          frame.buttonPressed = false;
            //Scanner scan = new Scanner(System.in);
            //int playerAction = 0;
          boolean validAction = false;

          while(validAction == false || frame.actionChoice < 0){
               //print inventory
             //System.out.println(player.toStringInventory()); 
               //prompt user
            frame.updateText("Pick An Action");

             //System.out.println("Pick an action");
               //scan in next int 
             while(frame.buttonPressed == false){
                hold(200);
             }
               frame.buttonPressed = false;
                     //playerAction = frame.actionChoice;
               //if the scanned int is greater than zero and is a valid inventory place
               if(frame.actionChoice < Person.INVENTORY_SIZE && frame.actionChoice > -1 && player.inventory[frame.actionChoice] != null){
                  //set the validAction to true
                  validAction = true;
               
               }else{
                  frame.updateText("That Action Is Not Valid");
                    hold(COMBAT_TIME1);
                  //System.out.println("Invalid Action");
                  }
               }                 
               turn(player,enemy,frame.actionChoice,frame);    
                     
               isPlayerTurn = false;    
         }else{
         
         
         //the enemy's turn
            hold(COMBAT_TIME1);
             
            frame.updateText("Opponent's Turn");
                  
            Random rand = new Random();
            int enemyAction = -1;
            boolean validAction = false;
      
            while(validAction == false || enemyAction < 0){
               //generate a random action
               enemyAction = rand.nextInt(Person.INVENTORY_SIZE);
               if(enemyAction < Person.INVENTORY_SIZE &&enemyAction > 0 && enemy.inventory[enemyAction] != null){
                  validAction = true;              
               }  
             }
            //exit while and do turn
            //System.out.println("Enemy Turn");
            
            hold(COMBAT_TIME1);

            turn(enemy,player,enemyAction,frame);
             hold(COMBAT_TIME1*2);

               isPlayerTurn = true;         
         }
         //SwingUtilities.updateComponentTreeUI(myFrame);
         //MainInterface.openInterface(player, enemy);
         frame.updateInterface(player, enemy); 
               
      }  
      hold(COMBAT_TIME1);
 
      if(player.ego <= 0){
         frame.updateText("Game Over!");
     
         //System.out.println("Game Over!");
         return false;     
      }else{
      frame.updateText("Victory");

      //System.out.println("Victory!");            
         return true;
      }
   }

    //give two people and the inventory slot to use 
  public static boolean turn(Person personGoing, Person personNotGoing, int i,MainInterface frame){
      
      // if that inventory slot is not null and the action has more that zero uses left
      if(personGoing.inventory[i] != null && personGoing.inventory[i].usesLeft !=0){
      
            //if the action is consumable decrement it 
            if(personGoing.inventory[i].usesLeft > 0){
               --personGoing.inventory[i].usesLeft;
            }
         //perform the action by changing the current player and the enemy
         frame.updateText(personGoing.personName + " Used " + personGoing.inventory[i]);
         
         hold(COMBAT_TIME1);
         
         int deltaEgo =personGoing.inventory[i].affectEgo * personGoing.level;
         int deltaEnergy =personGoing.inventory[i].affectEnergy * personGoing.level;
         int deltaEnemy = personGoing.inventory[i].affectEnemy * personGoing.level;

         personGoing.ego+=deltaEgo;
         personGoing.energy+=deltaEnergy;
         personNotGoing.ego+=deltaEnemy;


         frame.updateText(personNotGoing.personName +" Lost " + Math.abs(deltaEnemy) + " Ego");

   
         
         //in the case that a consumable is used and none remain, remove that action from the inventory
         if(personGoing.inventory[i].usesLeft == 0){
            personGoing.removeFromInventory(i);
         }
          return true;
      }
      return false;    
   }
}