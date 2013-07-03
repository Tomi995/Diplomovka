/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emulatoras;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tomi
 */
public class EmulatorAS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MyParserException {
        // TODO code application logic here
        
        
/*
              Inicializacia skuska = new Inicializacia();
          skuska.hladaj("fsfsd:Fetch-x:SUB:STore-y:add:store-x:Fetch- z");
         // test
         
  */     
      
        Parser parser = new Parser();
        parser.parse("and:a   dd:pus-md:po(98:s kd:(4))");
        
        
       /* Stav teest = new Stav();
        
                    
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
