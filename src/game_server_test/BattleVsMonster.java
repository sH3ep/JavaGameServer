package game_server_test;

import HeroAndSkills.Hero;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sH3ep
 */
public class BattleVsMonster {

    private Hero hero;
    private Dragon dragon;
    private ObjectInputStream inStream = null;
    private ObjectOutputStream outputStream = null;

    public BattleVsMonster(Hero hero) {
        this.hero = hero;
        this.dragon = new Dragon();
        this.hero.setToCombat();
        this.dragon.setToCombat();
    }

    public void run() {

        do {
            try {
                inStream = new ObjectInputStream(hero.getSocket().getInputStream());
                Fight_Command command = (Fight_Command) inStream.readObject();
                System.out.println("Komenda: " + command.getCommand());
                if (command.getCommand() == 1) {
                    System.out.println(command.getCommand() + "  jest rowne  1");
                }
                if (command.getCommand() == 1) {
                    if (dragon.heathPointAfterAttack(hero.Attack()) > 0) {
                        hero.heathPointAfterAttack(dragon.Attack());
                    }
                }
                if (command.getCommand() != 1) {
                    hero.heathPointAfterAttack(dragon.Attack());
                }

            } catch (IOException ex) {
                Logger.getLogger(BattleVsMonster.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(BattleVsMonster.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                outputStream = new ObjectOutputStream(hero.getSocket().getOutputStream());
                BattleInformation information = new BattleInformation(hero.heathPointAfterAttack(0), dragon.heathPointAfterAttack(0),true);
                outputStream.writeObject(information);
                System.out.println("Twoje HP: " + information.GetHeroHP() + "      HP przeciwnika: " + information.GetOpponentHP());

            } catch (IOException ex) {
                Logger.getLogger(BattleVsMonster.class.getName()).log(Level.SEVERE, null, ex);
            }

        } while ((hero.heathPointAfterAttack(0) > 0) && (dragon.heathPointAfterAttack(0) > 0));

    }

}
