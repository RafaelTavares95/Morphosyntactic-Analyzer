/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.geosertao.morphosyntactic.analyzer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.annolab.tt4j.TreeTaggerException;

/**
 * Classe de teste.
 * @author Rafael Tavares
 */
public class AppTest {
    public static void main(String[] args) {
        TreeTaggerHandler t = new TreeTaggerHandler("treetagger.home", "C:/TreeTagger", "C:/TreeTagger/lib/pt.par");
        try {
            ArrayList<SimpleToken> tokens = t.loadProcess("Ela estava cantando na chuva");
            for (SimpleToken x : tokens) {
                System.out.println(x.toString());
            }
        } catch (IOException ex) {
            Logger.getLogger(AppTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TreeTaggerException ex) {
            Logger.getLogger(AppTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
