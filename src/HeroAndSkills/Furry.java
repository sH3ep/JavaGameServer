/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HeroAndSkills;

import javafx.scene.effect.Effect;

/**
 *
 * @author sH3ep
 */
public class Furry extends Skill implements BuffSkillInterface {

    public Furry() {
        this.durationBaseTime = 2;
        this.durationTime = this.durationBaseTime;
    }

    @Override
    public void setBuffs() {

    }

    @Override
    public boolean effect(Hero hero) {
        if (this.durationTime > 0) {
            hero.setActualAttackPoint(15);
            this.durationTime = this.durationTime - 1;
            return false;

        } else {
            return true;
        }

    }

    @Override
    public int use(Hero hero, Hero opponentHero) {
        hero.getBuffs().add(this);
        hero.setActualAttackPoint(15);
        return hero.Attack();
    }

}
