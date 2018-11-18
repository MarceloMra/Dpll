/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Gigo
 */
public class Clausula {
    private ArrayList<Literal> literais;
    
    public Clausula(){
        literais = new ArrayList<>();
    }
    
    public void removerLiteral(Integer literal){
        for(Literal i : literais){
            if(i.getLiteral().equals(literal)){
                literais.remove(i);
            }
        }
    }
    
    public Literal clausulaUnitaria(){
        if(literais.size() == 1){
            return literais.get(0);
        }else{
            return null;
        }
    }
    
    
    public boolean estaVazia(){
        if(literais.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    
    public void addLiteral(Literal literal){
        literais.add(literal);
    }
    
    public boolean contemLiteral(Integer literal){
        for(Literal i : literais){
            if(i.getLiteral().equals(literal)){
                return true;
            }
        }
        return false;
    }
    
    public void inicializarLiterais(){
        for(Literal l : literais){
            l.setValoração("*");
        }
    }
}
