/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.applet.AudioClip;

/**
 *
 * @author gama5
 */
public class Audio {

    public void ClipAudio() {
        AudioClip Sound;
        Sound = java.applet.Applet.newAudioClip(getClass().getResource("/imagenes/LoginMarty.wav"));
        Sound.play();
    }

    public void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    public void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    public void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
}
