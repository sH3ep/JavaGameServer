package game_server_test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sH3ep
 */
public class Dragon {
    
    public Dragon ()
    {
        healthPoint = 150;
        attackPoint = 10;
    }
    
    private int healthPoint ;
    private int attackPoint;
    private int battleHP;
    
    public int Attack ()
    {
        return attackPoint;
    }
    
    public int heathPointAfterAttack (int damageReceived)
    {
         int temp = battleHP - damageReceived;
         battleHP = temp;
        return temp;
    }
    
       public void setToCombat ()
    {
        battleHP = healthPoint;
    }
    
    
}
