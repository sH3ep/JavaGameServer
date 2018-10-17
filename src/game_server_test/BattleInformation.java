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
    private int opponentHP;
    private boolean firstAttack;
    
    public BattleInformation (int heroHP, int opponentHP, boolean firstAttack){
        this.heroHP = heroHP;
        this.opponentHP = opponentHP;
        this.firstAttack = firstAttack;
    }
    
    public int GetHeroHP (){
        return heroHP;
    }
    
    public int GetOpponentHP () {
        return opponentHP;
    }
    public boolean GetFirstAttack(){
        return firstAttack;
    }
    /**
     * zmian zmian zmiana
     */
    
}
