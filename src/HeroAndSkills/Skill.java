/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HeroAndSkills;

import HeroAndSkills.Hero;

/**
 *
 * @author sH3ep
 */
public class Skill {
    
    protected String name;
    protected int manaCost;
    protected int coolDownActual;
    protected int cooldownBase;
    protected int durationBaseTime;
    protected int durationTime;
    
    
    
    
    
    public int use(Hero hero, Hero opponentHero)
    {
        
        /**
         * Jaki efekt kazdego skilla
         */
        return hero.Attack();
    }
    
}
