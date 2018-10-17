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
    
    public PvPBattleInformation (int heroHP, int oponentHP){
        this.heroHP = heroHP;
        this.oponentHP = oponentHP;
    }
    
    public int GetHeroHP (){
        return heroHP;
    }
    
    public int GetOponentHP () {
        return oponentHP;
    }
    
}
