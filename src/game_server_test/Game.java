/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_server_test;

import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author sH3ep
 */
public class Game extends Thread{
    
   private Socket socket;
   List <PvPHero> pvpWaitingPlayers;

    public Game (Socket socket,List<PvPHero> pvpWaitingPlayers){
        this.socket = socket;
        this.pvpWaitingPlayers = pvpWaitingPlayers;
    }
    @Override
    public void run()
    {
       Hero hero = new Hero(socket);
       PvPHero pvPHero = new PvPHero(hero,hero.getSocket());
      // BattleVsMonster battle = new BattleVsMonster(hero);
      //  battle.run();
      SynchronizableGameData data = new SynchronizableGameData(pvpWaitingPlayers);
      data.addToPvpWaitingList(pvPHero);
       
  
    }
    
}
