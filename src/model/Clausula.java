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
        ArrayList<Literal> remover = new ArrayList<>();
        for(Literal i : literais){
            if(i.getLiteral().equals(literal)){
                remover.add(i);
            }
        }
        
        for(Literal i : remover){
            literais.remove(i);
        }
    }
    
    public void printar(){
        for(Literal l : literais){
            System.out.print(l.getLiteral()+", ");
        }
    }
    
    public Literal clausulaUnitaria(){
        if(literais.size() == 1){
            for(Literal l : literais){
                return l;
            }
            return null;
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
    
    public Literal escolherLiteral(){
        if(!literais.isEmpty()){
            for(Literal l : literais){
                if(l.getValoração().equals("*")){
                    return l;
                }
            }
            return null;
        }else{
            return null;
        }
    }
    
    public void addLiteral(Literal literal){
        literais.add(literal);
    }
    
    public boolean contemLiteral(Integer literal){
        for(Literal i : literais){
            
            if(i.getLiteral() != null && i.getLiteral().equals(literal)){
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
