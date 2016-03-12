/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Arrays;

/**
 *
 * @author Dallas
 */
public class Tools {
    
    String[] tools;
    private int amountRequired;
    

    public Tools() {
    }
    
    

    public String[] getTools() {
        return tools;
    }

    public void setTools(String[] tools) {
        this.tools = tools;
    }

    public int getAmountRequired() {
        return amountRequired;
    }

    public void setAmountRequired(int amountRequired) {
        this.amountRequired = amountRequired;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Arrays.deepHashCode(this.tools);
        hash = 59 * hash + this.amountRequired;
        return hash;
    }

    @Override
    public String toString() {
        return "ToolsControl{" + "tools=" + tools + ", amountRequired=" + amountRequired + '}';
    }
    
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tools other = (Tools) obj;
        if (this.amountRequired != other.amountRequired) {
            return false;
        }
        if (!Arrays.deepEquals(this.tools, other.tools)) {
            return false;
        }
        return true;
    }
    
    
    
}
