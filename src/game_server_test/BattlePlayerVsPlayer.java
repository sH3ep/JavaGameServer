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
public class BattlePlayerVsPlayer extends Thread {

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
    public void run() {
        System.out.println("RUN");

        sendInitialInformationToClient();

        do {
            player1.getHero().newRoundHeroCalculation();
            player2.getHero().newRoundHeroCalculation();
            Attack(player1, player2);

            if (player2.getHero().heathPointAfterAttack(0) > 0) {
                Attack(player2, player1);
            }

        } while ((player1.getHero().heathPointAfterAttack(0) > 0) && (player2.getHero().heathPointAfterAttack(0) > 0));
    }

    private void Attack(PvPHero attacker, PvPHero defender) {

        int command = receiveComandFromClient(attacker);
        executeAction(attacker, defender, command);

        sendInformationToClient(attacker, defender);

    }

    private int receiveComandFromClient(PvPHero attacker) {
        try {
            inStream = new ObjectInputStream(attacker.getHero().getSocket().getInputStream());
            Fight_Command command = (Fight_Command) inStream.readObject();

            return command.getCommand();

        } catch (IOException ex) {
            Logger.getLogger(BattleVsMonster.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BattleVsMonster.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;

    }

    private void executeAction(PvPHero attacker, PvPHero defender, int action) {
        if (action == 1) {
            defender.getHero().heathPointAfterAttack(attacker.getHero().Attack());
        }
        if (action == 2){
            defender.getHero().heathPointAfterAttack(attacker.getHero().getSkills().get(0).use(attacker.getHero(), defender.getHero()));
        }
         if (action == 3){
            defender.getHero().heathPointAfterAttack(attacker.getHero().getSkills().get(1).use(attacker.getHero(), defender.getHero()));
        }
    }

    private void sendInformationToClient(PvPHero attacker, PvPHero defender) {
        try {
            outputStream = new ObjectOutputStream(attacker.getHero().getSocket().getOutputStream());
            PvPBattleInformation information = new PvPBattleInformation(attacker.getHero().heathPointAfterAttack(0), defender.getHero().heathPointAfterAttack(0), false);
            outputStream.writeObject(information);

            outputStream = new ObjectOutputStream(defender.getHero().getSocket().getOutputStream());
            information = new PvPBattleInformation(defender.getHero().heathPointAfterAttack(0), attacker.getHero().heathPointAfterAttack(0), false);
            outputStream.writeObject(information);

        } catch (IOException ex) {
            Logger.getLogger(BattleVsMonster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void sendInitialInformationToClient() {

        try {
            outputStream = new ObjectOutputStream(player1.getHero().getSocket().getOutputStream());
            PvPBattleInformation information = new PvPBattleInformation(player1.getHero().heathPointAfterAttack(0), player2.getHero().heathPointAfterAttack(0), true);
            outputStream.writeObject(information);

            outputStream = new ObjectOutputStream(player2.getHero().getSocket().getOutputStream());
            information = new PvPBattleInformation(player2.getHero().heathPointAfterAttack(0), player1.getHero().heathPointAfterAttack(0), false);
            outputStream.writeObject(information);

        } catch (IOException ex) {
            Logger.getLogger(BattleVsMonster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
