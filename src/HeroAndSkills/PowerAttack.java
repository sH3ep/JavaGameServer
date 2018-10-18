/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HeroAndSkills;

/**
 *
 * @author sH3ep
 */
public class PowerAttack extends Skill{
    
   
 
    private int attackModifier =2 ;
    
    
    @Override
    public int use (Hero hero, Hero opponentHero){
        
        
        return hero.Attack()*attackModifier;
    }
    
}
