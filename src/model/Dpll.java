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
        
        //Escolher literal L com v(L)=="*"
        
        //Apagar a linha abaixo após a finalização
        return true;
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
            removerLiteralDasClausulas(clausulas, literal.getLiteral()*-1);
            literal = contemClausulasUnitarias(clausulas);
        }
        return clausulas;
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
        for(Clausula c : clausulas){
            if(c.contemLiteral(literal)){
                clausulas.remove(c);
            }
        }
    }
    
    private void removerLiteralDasClausulas(ArrayList<Clausula> clausulas, Integer literal){
        for(Clausula c : clausulas){
            if(c.contemLiteral(literal)){
                c.removerLiteral(literal);
            }
        }
    }
}
