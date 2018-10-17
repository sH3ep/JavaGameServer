/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_server_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



class Handler extends Thread {
        private String name;
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        /**
         * Constructs a handler thread, squirreling away the socket.
         * All the interesting work is done in the run method.
         */
        public Handler(Socket socket) {
            this.socket = socket;
        }}
/**
 *
 * @author sH3ep
 */
public class Game_server_test {

 
  /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        ServerSocket listener = new ServerSocket (9001);
        List <PvPHero> pvpWaitingPlayers = Collections.synchronizedList(new ArrayList<>());
        
        try{
            while (true){
                new Game(listener.accept(),pvpWaitingPlayers).start();
                System.out.println("Ktos sie podlaczyl");
            }
        }finally{
            listener.close();
        }
        
        
        // TODO code application logic here
    }
    
}
