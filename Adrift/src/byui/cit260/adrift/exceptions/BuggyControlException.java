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
public class BuggyControlException extends Exception {

    public BuggyControlException() {
    }

    public BuggyControlException(String string) {
        super(string);
    }

    public BuggyControlException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public BuggyControlException(Throwable thrwbl) {
        super(thrwbl);
    }

    public BuggyControlException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
    
}
