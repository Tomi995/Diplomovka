/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emulatoras;

/**
 *
 * @author Tomi
 */
public class EmulatorAS {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
        // TODO code application logic here
        Inicializacia skuska = new Inicializacia();
       // skuska.hladaj("fsfsd:Fetch-x:SUB:STore-y:add:store-xFetch- z");
        
        System.out.println(skuska.iniciiuj("add:fetch-s:add:add"));
      /*   
        Stav teest = new Stav();
         
         teest.vlozPremennu("z", 3);
         teest.vlozPremennu("y", 2);
         teest.vlozPremennu("y", 6);
         
           teest.vlozPremennu("x", 4);
           teest.vlozHodnotu("x", 8);
           teest.vlozHodnotu("x", 200);
       
       System.out.println(teest.stavy.size());
         System.out.println(teest.vratHodnotu("x", 0));
       
         
         System.out.println(teest.vratHodnotu("x", 1));
         System.out.println(teest.vratHodnotu("x", 2));
         System.out.println(teest.vratHodnotu("x", 2));
         System.out.println(teest.vratHodnotu("x", 1));
         System.out.println(teest.vratHodnotu("x", 0));
         System.out.println(teest.vratHodnotu("x", 2));
         
         */
       //  System.out.println(teest.vratHodnotu("x",0));         
       //  System.out.println(teest.vratHodnotu("y", 0));
     
    // Zasobnik zasobnik = Zasobnik.getZasobnik();
    // zasobnik.vloz(4);
    // zasobnik.vloz("true");
     
     
     
  //  System.out.println(zasobnik.jeCislo());   
//     System.out.println(Integer.parseInt(zasobnik.vyber()));
  //   System.out.println(Integer.parseInt(zasobnik.vyber()));
    
     }
}
