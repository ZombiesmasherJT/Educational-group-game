package com.example.scenebuilderdemo;


import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;


public class music {

    void playMusic(String musicLocation)
    {
        try{
            File musicPath = new File(musicLocation);
            if(musicPath.exists()){
                //runs these instructions if file is found
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start(); //starts to play the file
                clip.loop(Clip.LOOP_CONTINUOUSLY); //loops the file when it ends
            }
            else{
                JOptionPane.showMessageDialog(null,"Music file not found");
                //Gives an error message if file not found
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}

