/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_server_test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sH3ep
 */
public class BattlePlayerVsPlayer extends Thread{

    private PvPHero player1;
    private PvPHero player2;
    private ObjectInputStream inStream = null;
    private ObjectOutputStream outputStream = null;

    public BattlePlayerVsPlayer(PvPHero player1, PvPHero player2) {
        this.player1 = player1;
        this.player2 = player2;
        player1.getHero().setToCombat();
        player2.getHero().setToCombat();
    }
    
    @Override
    public void run(){
        do {      
            Attack(player1, player2);
            
            if (player2.getHero().heathPointAfterAttack(0)>0){
                Attack(player2, player1);
            }
            
        } while ((player1.getHero().heathPointAfterAttack(0)>0)&&(player2.getHero().heathPointAfterAttack(0)>0) );
    }

    private void Attack(PvPHero attacker, PvPHero defender) {
        try {
            inStream = new ObjectInputStream(attacker.getHero().getSocket().getInputStream());
            Fight_Command command = (Fight_Command) inStream.readObject();
            System.out.println("Komenda: " + command.getCommand());
            if (command.getCommand() == 1) {
                defender.getHero().heathPointAfterAttack(attacker.getHero().Attack());
                System.out.println(command.getCommand() + "  jest rowne  1");
            }
         
        } catch (IOException ex) {
            Logger.getLogger(BattleVsMonster.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BattleVsMonster.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            outputStream = new ObjectOutputStream(attacker.getHero().getSocket().getOutputStream());
            PvPBattleInformation information = new PvPBattleInformation(attacker.getHero().heathPointAfterAttack(0), defender.getHero().heathPointAfterAttack(0));
            outputStream.writeObject(information);
            
            outputStream = new ObjectOutputStream(defender.getHero().getSocket().getOutputStream());
            information = new PvPBattleInformation(defender.getHero().heathPointAfterAttack(0), attacker.getHero().heathPointAfterAttack(0));
            outputStream.writeObject(information);

        } catch (IOException ex) {
            Logger.getLogger(BattleVsMonster.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
