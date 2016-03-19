/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.exceptions;

/**
 *
 * @author Autumn
 */
public class ChooseDrillException extends Exception {
 
    public ChooseDrillException() {
    }

    public ChooseDrillException(String string) {
        super(string);
    }

    public ChooseDrillException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public ChooseDrillException(Throwable thrwbl) {
        super(thrwbl);
    }

    public ChooseDrillException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
    
}

