import java.lang.*;

public class Person{
   public static int INVENTORY_SIZE =4;
   //public access to any person's inventory
   public Action[] inventory;
   public String personName;
   public int ego; //Health
   public int energy; //Mana
   public int level;

   public Person(String personName,int ego, int energy, int level){
      
      this.personName = personName;
      this.inventory = new Action[INVENTORY_SIZE];
      this.ego = ego;
      this.energy = energy;
      this.level = level;
      
   }
   
   //takes an action to search for in the inventory
   //returns its place in the inventory or a -1 if it dne
   public int findActionInInventory(Action actionToFind){
   
      for(int i =0; i<INVENTORY_SIZE; ++i){
         if( inventory[i] != null && inventory[i].equals(actionToFind)){
            return i;
      }
     }
     return -1;
    }
   
   //counts the number of actions in the inventory
   public int countInventory(){
      int count =0;
      for(int i =0; i<INVENTORY_SIZE; ++i){
         //System.out.print(i+": "+inventory[i]+ "\t");
         if( inventory[i]!= null)
            ++count;
      }
      //System.out.println("Number of Actions:"+ count);
      return count;
   }

 public String toStringInventory(){
      String inventoryString = new String();
      for(int i =0; i<INVENTORY_SIZE; ++i){
        inventoryString += "\t"+i+ ": " +inventory[i];
      }
         System.out.println();
      return inventoryString;
   }


   
   
   //takes an action to add to the inventory
   //will increment an action if it is consumable 
   //will not add an infinite action if it already exists
   public boolean addToInventory(Action actionToAdd){
   
     //if the action is in the inventory and is consumable, add another use and return true
     if(findActionInInventory(actionToAdd) >=0){
      //if the item is consumable
         if(actionToAdd.usesLeft >=0){
             ++inventory[findActionInInventory(actionToAdd)].usesLeft;
             System.out.println(this.personName + ": "+ actionToAdd+" Added!");

             
             return true;
         }
         //the action is not a consumable and does already exist so do nothing to the inventory
         System.out.println(this.personName + ": "+ actionToAdd+" Already In Inventory");

         return true;
                       
      }
      //at this point the action does not exist in the inventory and can either be added or rejected if the inventory is too small      
      //if the size will be greater than the allowed inventory size return false 
      if(countInventory() +1 > INVENTORY_SIZE){
         //System.out.println("action not added");
         System.out.println(this.personName + ": "+ "No Room For "+ actionToAdd);


         return false;
      
      }
      
     
      for(int i =0; i < INVENTORY_SIZE;++i){
         if(inventory[i] == null){
            inventory[i] = actionToAdd;
            System.out.println(this.personName + ": "+ actionToAdd+" Added");
            return true;
         }
         
      }
      

      return false;
   }
   //finds an action in inventory and nulls it
   public void removeFromInventory(int i){
         this.inventory[i]=null;
   
      
  
   }
   
   
    //overridden toString()to give the action's name
   public String toString(){
   
      return personName + " " + ego+ " " + energy + " " + level;
   
   
   }


 }
