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
public class BattleInformation implements Serializable {
    
    private int heroHP;
    private int moobHP;
    
    public BattleInformation (int heroHP, int moobHP){
        this.heroHP = heroHP;
        this.moobHP = moobHP;
    }
    
    public int GetHeroHP (){
        return heroHP;
    }
    
    public int GetMoobHP () {
        return moobHP;
    }
    /**
     * zmian zmian zmiana
     */
    
}
