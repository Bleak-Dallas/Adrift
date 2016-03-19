/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.exceptions;

/**
 *
 * @author Dallas
 */
public class FoodControlException extends Exception{

    public FoodControlException() {
    }

    public FoodControlException(String string) {
        super(string);
    }

    public FoodControlException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public FoodControlException(Throwable thrwbl) {
        super(thrwbl);
    }

    public FoodControlException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
    
    
}
