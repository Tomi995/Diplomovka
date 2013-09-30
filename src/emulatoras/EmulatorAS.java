/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emulatoras;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Tomi
 */
public class EmulatorAS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MyParserException, StavException, ZasobnikException {
              
            // TODO code application logic here
         Fetch fetch = new Fetch();
      //  fetch.vykonaj("FETCH-XEe");
        Store store = new Store();
        Push push = new Push();
        Stav stav = new Stav();
        Cond cond = new Cond();
        Add add = new Add();
        
      push.vykonaj("PUSH-2");
      store.vykonaj("STORE-X");
      push.vykonaj("PUSH-1");
      push.vykonaj("PUSH-1");
      fetch.vykonaj("FETCH-X");
      add.vykonaj("ADD");
        
        
     
       // fetch.vykonaj("FETCH-Ycdc");
        //fetch.vykonaj("FETCH-Yxc");

        
       
      
         System.out.println(Zasobnik.getZasobnik().vyber());
         

    /*
                Pattern pattern = Pattern.compile("^PUSH-(([-]|[+])*)([0-9]+)$");
                Matcher match = pattern.matcher("PUSH--+--9-87");
              
                System.out.println(match.groupCount());
                
                if(match.find())
                    System.out.println(match.group(1));
                
                    
                    System.out.println(match.group(3));
               /*
               * /* Stav teest = new Stav();
                
                            
                 teest.vlozPremennu("xas", 4);
                 teest.vlozHodnotu("x", 8);
                 teest.vlozHodnotu("x", 200);
               
                
               
                 
                 System.out.println(teest.vratHodnotu("xas", 0));
                 System.out.println(teest.vratHodnotu("x", 2));
                 System.out.println(teest.vratHodnotu("x", 2));
                 System.out.println(teest.vratHodnotu("x", 1));
                 System.out.println(teest.vratHodnotu("x", 0));
                 System.out.println(teest.vratHodnotu("x", 2));
                 
                 */
                //  System.out.println(teest.vratHodnotu("x",0));         
                //  System.out.println(teest.vratHodnotu("y", 0));

            

                //  System.out.println(zasobnik.jeCislo());   
                //     System.out.println(Integer.parseInt(zasobnik.vyber()));
                //   System.out.println(Integer.parseInt(zasobnik.vyber()));
           



           
            
          /*
            Pattern pattern = Pattern.compile("^PUSH-(([-]|[+])*)([0-9]+)$");
            Matcher match = pattern.matcher("PUSH--+--9-87");
          
            System.out.println(match.groupCount());
            
            if(match.find())
                System.out.println(match.group(1));
            
                
                System.out.println(match.group(3));
           /*
           * /* Stav teest = new Stav();
            
                        
             teest.vlozPremennu("xas", 4);
             teest.vlozHodnotu("x", 8);
             teest.vlozHodnotu("x", 200);
           
            
           
             
             System.out.println(teest.vratHodnotu("xas", 0));
             System.out.println(teest.vratHodnotu("x", 2));
             System.out.println(teest.vratHodnotu("x", 2));
             System.out.println(teest.vratHodnotu("x", 1));
             System.out.println(teest.vratHodnotu("x", 0));
             System.out.println(teest.vratHodnotu("x", 2));
             
             */
            //  System.out.println(teest.vratHodnotu("x",0));         
            //  System.out.println(teest.vratHodnotu("y", 0));

        

            //  System.out.println(zasobnik.jeCislo());   
            //     System.out.println(Integer.parseInt(zasobnik.vyber()));
            //   System.out.println(Integer.parseInt(zasobnik.vyber()));
        



    }
}
