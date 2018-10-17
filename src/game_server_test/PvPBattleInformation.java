/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_server_test;

import java.io.Serializable;

/**
 *
 * @author sH3ep
 */
public class PvPBattleInformation implements Serializable{
    
    private int heroHP;
    private int oponentHP;
    private boolean firstAttack;
    
    public PvPBattleInformation (int heroHP, int oponentHP,boolean firstAttack){
        this.heroHP = heroHP;
        this.oponentHP = oponentHP;
        this.firstAttack = firstAttack;
    }
    
    public int GetHeroHP (){
        return heroHP;
    }
    
    public int GetOponentHP () {
        return oponentHP;
    }
    
    public boolean GetFirstAttack(){
        return firstAttack;
    }
    
}
