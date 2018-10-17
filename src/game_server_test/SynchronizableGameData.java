/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_server_test;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author sH3ep
 */
public class SynchronizableGameData extends Thread{
    
    public SynchronizableGameData ( List <PvPHero> pvpWaitingPlayers){
      this.pvpWaitingPlayers = pvpWaitingPlayers;
        
    }
    
    private List <PvPHero> pvpWaitingPlayers ;
     
    private long firstPlayerDate =0;
    
    public synchronized void addToPvpWaitingList (PvPHero pvPHero)
    {
        pvpWaitingPlayers.add(pvPHero);
        if (pvpWaitingPlayers.size()==0){
            firstPlayerDate= System.currentTimeMillis();
        }else{
            long tempDate = System.currentTimeMillis();
            if (((tempDate-firstPlayerDate)>5000)&&((pvpWaitingPlayers.size()%2)==0))
            {
                startPvpDraw();
                System.out.println("StartPVPDraw");
            
            }
        }
        
    }

    private void startPvpDraw() {
        Collections.sort(pvpWaitingPlayers);
        for(int i =0; i<pvpWaitingPlayers.size();i=i+2){
            BattlePlayerVsPlayer battle = new BattlePlayerVsPlayer(pvpWaitingPlayers.get(i),pvpWaitingPlayers.get(i+1));
            battle.start();
        }
        
       pvpWaitingPlayers.clear();
        
    }
    
    
    
}
