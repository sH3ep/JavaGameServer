package game_server_test;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sH3ep
 */
public class Fight_Command implements Serializable {
    
    private int command;
    public Fight_Command (int command)
    {
        this.command = command;
    }
    
    public int getCommand ()
    {
        return command;
    }
    
}
