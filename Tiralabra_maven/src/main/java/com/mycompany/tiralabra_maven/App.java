package com.mycompany.tiralabra_maven;

import com.mycompany.tiralabra_maven.logiikka.SovellusOhjain;
import com.mycompany.tiralabra_maven.gui.Kayttoliittyma;
import javax.swing.SwingUtilities;

/**
 * Hello world!
 *
 */
public class App {

    /**
     * Main-metodi :)
     *
     * @param args argumentit
     */
    public static void main(String[] args) {

    SovellusOhjain simulaatio = new SovellusOhjain();
        Kayttoliittyma gui = new Kayttoliittyma(simulaatio, 24);
        SwingUtilities.invokeLater(gui);
        while (gui.getPiirtoalusta() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Piirtoalustaa ei ole vielä luotu.");
            }
        }

        Thread piirtoSaie = new Thread(gui.getPiirtoalusta());
        piirtoSaie.start();
    }

}
