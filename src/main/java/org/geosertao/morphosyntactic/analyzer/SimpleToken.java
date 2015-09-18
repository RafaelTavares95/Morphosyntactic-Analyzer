/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.geosertao.morphosyntactic.analyzer;

/**
 * Classe que representa os dados obtidos a partir da análise morfossintática da 
 * palavra, um SimpleToken representa uma palavra, a tag correspondente e o lema.
 * @author Rafael Tavares
 */
public class SimpleToken {
    /***
     * Atributo que representa a palavra que vai ser analisada.
     */ 
    private String word;
    /***
     * Atributo que representa a denominação da palavra.
     */
    private String tag;
    /***
     * Atributo que representa o lexema da palavra.
     */
    private String lemma;

    public SimpleToken(String word, String tag, String lemma) {
        this.word = word;
        this.tag = tag;
        this.lemma = lemma;
    }
    
    //Getter and setter
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getLemma() {
        return lemma;
    }

    public void setLemma(String lemma) {
        this.lemma = lemma;
    }

    @Override
    public String toString() {
        return word + "     " + tag + "     " + lemma;
    } 
}
