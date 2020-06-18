public class Action{

   // globals:
   
   public String actionName = new String();
   public int usesLeft;
   public int affectEnemy;
   public int affectEgo;
   public int affectEnergy;
   
   
   //constructor
   
   Action(String actionName,int usesLeft,int affectEnemy, int affectEgo, int affectEnergy ){
   
   this.actionName = actionName;
   this.usesLeft = usesLeft;
   this.affectEnemy = affectEnemy;
   this.affectEgo =affectEgo;
   this.affectEnergy = affectEnergy;

   }
   
   //overridden toString()to give the action's name
   public String toString(){
   
      return actionName;
   
   
   }
   //called when an action is being used;
   //pass this method a reference to the person object "Using" it so that there stats can be altered appropreately
    
   
   
   
}