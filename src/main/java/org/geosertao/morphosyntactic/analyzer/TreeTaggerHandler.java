/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.geosertao.morphosyntactic.analyzer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import org.annolab.tt4j.TokenHandler;
import org.annolab.tt4j.TreeTaggerException;
import org.annolab.tt4j.TreeTaggerWrapper;

/**
 * Classe que manipula a api do treetagger para fazer de forma simples a análise
 * do texto. Essa classe contém também métodos de configuração do treetagger.
 * @author Rafael Tavares
 * @since JDK 1.7
 */
public class TreeTaggerHandler {
    private String keyProperty;
    private String valueProperty;
    private String model;

    public TreeTaggerHandler() {
    }
    
    /***
     * Construtor com as opções de configuração do treetagger.
     * @param keyProperty chave da propriedade que vai armazenar o caminho onde
     * o treetagger esta instalado.
     * @param valueProperty valor atual da propriedade que vai armazenar o 
     * caminho onde o treetagger esta instalado.
     * @param model caminho do pacote de parâmetros de linguagem escolhido. 
     */
    public TreeTaggerHandler(String keyProperty, String valueProperty, String model) {
        this.keyProperty = keyProperty;
        this.valueProperty = valueProperty;
        this.model = model;
    }
    
    /***
     * Método para obter a chave da propriedade que vai armazenar o caminho onde
     * o treetagger esta instalado.
     * @return 
     */
    public String getKeyProperty() {
        return keyProperty;
    }
    /***
     * Método para alterar a chave da propriedade que vai armazenar o caminho onde
     * o treetagger esta instalado.
     * @param keyProperty 
     */
    public void setKeyProperty(String keyProperty) {
        this.keyProperty = keyProperty;
    }
    /***
     * Método para obter o valor atual da propriedade que vai armazenar o 
     * caminho onde o treetagger esta instalado.
     * @return 
     */
    public String getValueProperty() {
        return valueProperty;
    }
    /***
     * Método para alterar o valor atual da propriedade que vai armazenar o 
     * caminho onde o treetagger esta instalado.
     * @param valueProperty 
     */
    public void setValueProperty(String valueProperty) {
        this.valueProperty = valueProperty;
    }
    /***
     * Método para obter o caminho do pacote de parâmetros de linguagem escolhido.
     * @return 
     */
    public String getModel() {
        return model;
    }
    /***
     * Método para alterar o caminho do pacote de parâmetros de linguagem escolhido.
     * @param model 
     */
    public void setModel(String model) {
        this.model = model;
    }
    
    /**
    * Método que converte uma string, contendo o texto que vai ser analisado, em uma lista de tokens. 
    * @param texto
    * @return
    */	
    private ArrayList<String> asList(String texto){
        ArrayList<String> test = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(texto);
        while(st.hasMoreTokens()){
            test.add(st.nextToken());
        }
        return test;
    }
    /***
     * Método que realiza a análise.
     * @param expression frase que vai ser analisada
     * @return lista com tokens
     * @throws IOException
     * @throws TreeTaggerException 
     */    
    public ArrayList<SimpleToken> loadProcess(String expression) throws IOException, TreeTaggerException{
        final ArrayList<SimpleToken> listtokens = new ArrayList<>();
        System.setProperty(keyProperty, valueProperty); 
	    TreeTaggerWrapper<String> tt = new TreeTaggerWrapper<>();
	    try {
	      tt.setModel(model);
	      tt.setHandler(new TokenHandler<String>() {
	        public void token(String token, String pos, String lemma) {
                    listtokens.add(new SimpleToken(token, pos, lemma));
	        }
	      });
	     tt.process(asList(expression));
	    }
	    finally {
	      tt.destroy();
	    } 
        return listtokens;
    } 
}
