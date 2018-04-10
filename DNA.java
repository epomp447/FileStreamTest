/**
* DNA constructs elements from input file "ecoloi.txt"
*into a formatted output file that displays info about
*DNA, Nucleotides, Mass, and title.
* <p>
*  Date: March 30, 2017
*</p>
*
* @author Evan Pomponio
* 
**/
import java.lang.Math;         
public class DNA implements Comparable<DNA>{
   /**
    * The mass of Adenine in the DNA
    */
   final static double AMass=135.128;
    /**
    * The mass of Cytosine in the DNA
    */
   final static double CMass =111.103;
    /**
    * The mass of Guanine in the DNA
    */
   final static double GMass =151.128;
    /**
    * The mass of Thymine in the DNA
    */
   final static double TMass = 125.107; 
   /**
    * The excess mass in the DNA
    */  
   final static double junkMass=100.000;
        
 /**
 * The title for cellular life form or virus
 */       
   private String title;
  /**
  * Nucleotide fixed to uppercase
  */
   private String nucleo;
   
  /**
  * Nucleotide fixed to uppercase and '-' removed 
  */

   private String nucleoFixed;
  /**
  *  count for each Nucleotide
  */
   private int [] countNucleo ={0,0,0,0};  
  /**
  *  nucleoMass % of total mass
  */
   
   private double [] nucleoMass={0,0,0,0}; 
  /**
  *  totalMass of AMass, CMass, GMass, TMass and junkMass
  */
   private double totalMass=0;
    /**
    * No argument constructor initializing all fields to null. 
    */     
   public DNA(){
      title=null;
      nucleo=null;
      nucleoFixed=null;
   }
/**setter for title
@param String title
**/
   public void setTitle(String t){
      title=t;
   }
/**Accessor method for title
@return String title
**/   
   public String getTitle(){
      return title;
   }
/**setter for nucleo
@param String nucleo
**/
   public void setNucleo(String n){
      nucleo=n;
   }
/**Accessor method for nucleo
@return String nucleo
**/ 
   public String getNucleo(){
      return nucleo;
   }
/**setter for setFixedNucleo
@param String setFixedNucleo
**/
   public void setFixedNucleo (String n){
      nucleoFixed=n.replace("-","");
      nucleoFixed=n.toUpperCase();
   }
/**Accessor method for getFixedNucleo
@return String getFixedNucleo
**/ 
   public String getFixedNucleo(){
      return nucleoFixed;
   }   
/**setter for setCountNucleo
@param int [] countNucleo
**/
   public void setCountNucleo(){
      for(int i=0; i<nucleoFixed.length();i++){
         if(nucleoFixed.charAt(i)=='A')
            countNucleo[0]++;
         else if(nucleoFixed.charAt(i)=='C')
            countNucleo[1]++;
         else if(nucleoFixed.charAt(i)=='T')
            countNucleo[2]++;
         else if(nucleoFixed.charAt(i)=='G')
            countNucleo[3]++;
      }         
   }
/**setter for nucleoMass
@param double [] nucleoMass
**/
   public void setMassPercents(){ 
      try{ 
         for(int i=0;i<nucleo.length();i++){
            if (nucleoFixed.charAt(i)=='A'){
               nucleoMass[0]= nucleoMass[0] + AMass;
               totalMass = totalMass + AMass;}
            else if (nucleoFixed.charAt(i)=='C'){
               nucleoMass[1]= nucleoMass[1] + CMass;
               totalMass = totalMass + CMass;}
            else if (nucleoFixed.charAt(i)=='T'){
               nucleoMass[2]= nucleoMass[2] + TMass;
               totalMass = totalMass + TMass;}
            else if (nucleoFixed.charAt(i)=='G'){
               nucleoMass[3]= nucleoMass[3] + GMass;
               totalMass = totalMass + GMass;}
            else if(nucleo.charAt(i)=='-'){
               totalMass = totalMass + junkMass;}
            else throw new InvalidDNAException("Invalid DNA String");
         }//end for loop    
       
      }
      catch(InvalidDNAException e){
         System.out.print("Invalid string");
         System.exit(0);
      }
             
      for(int i=0;i<4;i++)
         nucleoMass[i]=Math.round((nucleoMass[i]/totalMass * 100)*10) / 10.0;  
   }
/**Accessor method for getFixedNucleo
@return String getFixedNucleo
**/ 
   public double getTotalMass(){
      return totalMass;
   }
   
/**Returns a string of instance Variables for DNA
@return String Format
*/
   public String toString(){
      String str="";
      
      str=str +"Region Name: "+ getTitle() + "\n";
      
      str=str +"Nucleotides: "+ getFixedNucleo() + "\n";
   
      str=str +"Nuc Counts: [";
      for (int i =0; i<countNucleo.length-1; i++){
         str+=countNucleo[i] + ",";
         
      }
      str+=countNucleo[countNucleo.length-1] + "] \n";
      
      str=str +"Total Mass%: [";
      for (int i =0; i<nucleoMass.length-1; i++){
         str+=nucleoMass[i] + ",";
         
      }
      str+=nucleoMass[nucleoMass.length-1]  +"] of ";
      str+= String.format ("%.1f \n", totalMass); 
      return str;
   }
    
// sort: returns a negative if this totalMass less than the other totalMass, 0 if this totalMass
// equals the other totalMass, a positive if this totalMass greater than the
   //other totalMass (DNA sorted by least to greatest mass
    
   public int compareTo(DNA other){    
      if (this.getTotalMass()<(other.getTotalMass()))
         return -1;
      else if (this.getTotalMass()>(other.getTotalMass()))
         return 1;
      else
         return 0; 
   }        
}//end DNA class
