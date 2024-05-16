package com.example.scenebuilderdemo;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

/**
 *This class is responsible for music
 * @author Jordan Meecham
 */
public class Music {
    void playMusic(String musicLocation)
    {
        try{
            File musicPath = new File(musicLocation);
            if(musicPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath); // Opens the audio input stream from the specified file
                Clip clip = AudioSystem.getClip(); // Gets the Clip object to play the audio
                clip.open(audioInput); // Opens the audio clip with the audio input stream
                clip.start(); // Starts playing the audio
                clip.loop(Clip.LOOP_CONTINUOUSLY); // Loops the audio continuously
            }
            else{ // Shows an error message if the music file is not found
                JOptionPane.showMessageDialog(null,"Music file not found");
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
