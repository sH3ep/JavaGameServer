package game_server_test;

import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sH3ep
 */
public class Hero {
    
    private int healthPoints;
    private int attackPoints;
    private int battleHP;
    private Socket socket;
    
    public Hero (Socket socket)
    {
        healthPoints = 120;
        attackPoints = 10;
        this.socket = socket;
    }
    public int Attack (){
        return attackPoints;
    }
    
    public int heathPointAfterAttack (int damageReceived)
    {
        int temp = battleHP - damageReceived;
        battleHP = temp;
        return temp;
    }
    
    public Socket getSocket ()
    {
        return socket;
    }
    
    public void setToCombat ()
    {
        battleHP = healthPoints;
    }
    
}
