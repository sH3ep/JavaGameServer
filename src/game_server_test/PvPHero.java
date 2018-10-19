/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_server_test;

import HeroAndSkills.Hero;
import java.net.Socket;

/**
 *
 * @author sH3ep
 */
public class PvPHero implements Comparable<PvPHero> {
    
    
  
    public PvPHero (Hero hero, Socket socket){
        this.hero = hero;
        this.socket = socket;
        
    }
    
    private Socket socket;
    private Hero hero;
    private int pvPRating = 1000;
    
    public int getRating (){
        return pvPRating;
    }
    public Hero getHero (){
        return hero;
    }

    @Override
    public int compareTo(PvPHero comparestu) {
       int compareage=((PvPHero)comparestu).getRating();
        /* For Ascending order*/
        return this.pvPRating-compareage;

        /* For Descending order do like this */
        //return compareage-this.studentage;
    }
    
    
    
}
