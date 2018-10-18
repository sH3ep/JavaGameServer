package HeroAndSkills;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sH3ep
 */
public class Hero {
    
    private int healthPoints;
    private int baseAttackPoints;
    private int battleHP;
    private Socket socket;
    private int actualAttackPoint;
    private List <BuffSkillInterface> Buffs = new ArrayList<BuffSkillInterface> ();
    private List <Skill> skills = new ArrayList<Skill>();
    
    public Hero (Socket socket)
    {
        healthPoints = 120;
        baseAttackPoints = 10;
        actualAttackPoint = 10;
        this.socket = socket; 
        skills.add(new PowerAttack());
        skills.add(new Furry());
    }
    public int Attack (){
        return actualAttackPoint;
    }
    
    public int heathPointAfterAttack (int damageReceived)
    {
        int temp = battleHP - damageReceived;
        battleHP = temp;
        return temp;
    }
    
    public Socket getSocket ()
    {
        return socket;
    }
    
    public void setToCombat ()
    {
        battleHP = healthPoints;
    }
    public List<BuffSkillInterface> getBuffs (){
        return Buffs;
    }
    
    public void setActualAttackPoint (int value)
    {
        actualAttackPoint = value + actualAttackPoint;
    }
    
    public List<Skill> getSkills () {
        return skills;
    }
    
    public void newRoundHeroCalculation ()
    {
        List <Boolean> EffectsToRemove = new ArrayList<>();
        this.actualAttackPoint = this.baseAttackPoints;
        for (BuffSkillInterface buffSkillInterface: Buffs){
           
            EffectsToRemove.add(buffSkillInterface.effect(this));
        }
        int i=0;
        for (Boolean item:EffectsToRemove){
            if (item){Buffs.remove(i);
                
            }
            i++;
        }
    }
}
