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
public class Dpll {
    
    public boolean dpll(ArrayList<Clausula> clausulas){
        inicializarLiterais(clausulas);
        
        ArrayList<Clausula> clausulasSimpli = simplifica(clausulas);
        
        if(clausulasSimpli.isEmpty()){
            return true;
        }else if(contemClausulaVazia(clausulasSimpli)){
            return false;
        }

        Integer litEsc = escolherLiteral(clausulasSimpli);
        
        ArrayList<Clausula> v1 = (ArrayList<Clausula>) clausulasSimpli.clone();
        Literal l1 = new Literal();
        l1.setLiteral(litEsc);
        Clausula c1 = new Clausula();
        c1.addLiteral(l1);
        v1.add(c1);
        
        ArrayList<Clausula> v2 = (ArrayList<Clausula>) clausulasSimpli.clone();
        Literal l2 = new Literal();
        l2.setLiteral(litEsc*(-1));
        Clausula c2 = new Clausula();
        c2.addLiteral(l2);
        v2.add(c2);
        
        if(dpll(v1)){
            return true;
        }else if(dpll(v2)){
            return true;
        }else{
            return false;
        }
    }
    
    private Integer escolherLiteral(ArrayList<Clausula> clausulas){
        for(Clausula c : clausulas){
            Literal l = c.escolherLiteral();
            if(l != null){
                return l.getLiteral();
            }
        }
        return null;
    }
    
    private boolean contemClausulaVazia(ArrayList<Clausula> clausulas){
        for(Clausula c : clausulas){
            if(c.estaVazia()){
                return true;
            }
        }
        return false;
    }
    
    private void inicializarLiterais(ArrayList<Clausula> clausulas){
        for(Clausula c : clausulas){
            c.inicializarLiterais();
        }
    }
    
    private ArrayList<Clausula> simplifica(ArrayList<Clausula> clausulas){
        Literal literal = contemClausulasUnitarias(clausulas);
        while(literal != null){
            //Pegar valoração
            apagarClausulas(clausulas, literal.getLiteral());
            removerLiteralDasClausulas(clausulas, literal.getLiteral() * (-1));
            literal = contemClausulasUnitarias(clausulas);
        }
        return clausulas;
    }
    public void printar(ArrayList<Clausula> clausulas){
        for(Clausula c : clausulas){
            c.printar();
            System.out.println("Nova clausula");
        }
    }
    private Literal contemClausulasUnitarias(ArrayList<Clausula> clausulas){
        for(Clausula c : clausulas){
            Literal clausula = c.clausulaUnitaria();
            if(clausula != null){
                return clausula;
            }
        }
        return null;
    }
    
    private void apagarClausulas(ArrayList<Clausula> clausulas, Integer literal){
        ArrayList<Clausula> remover = new ArrayList<>();
        for(Clausula c : clausulas){
            if(c.contemLiteral(literal)){
                remover.add(c);
                break;
            }
        }
        
        for(Clausula c : remover){
            clausulas.remove(c);
        } 
    }
    
    private void removerLiteralDasClausulas(ArrayList<Clausula> clausulas, Integer literal){
        ArrayList<Clausula> remover = new ArrayList<>();
        for(Clausula c : clausulas){
            if(c.contemLiteral(literal)){
                remover.add(c);
            }
        }
        
        for(Clausula c : remover){
            c.removerLiteral(literal);
        }
    }
}
