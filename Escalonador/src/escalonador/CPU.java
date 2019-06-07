/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escalonador;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author Ricardo Monteiro
 */
public class CPU {
    private int id;
    private Processo p;
    private int tempoUtilizacao;
    private PrintStream erro;
    
    public CPU(int id) throws UnsupportedEncodingException{
        this.erro = new PrintStream(System.err, true, "UTF-8");
        this.id = id;
        this.p = null;
    }
    
    public void recebeProcesso(Processo p){
        try{
            this.p = p;
            this.tempoUtilizacao = p.getArrivalTime();
        }catch(Exception e){
            this.erro.println("Erro 1 (CPU.recebeProcesso): Não existe processo para ser adicionado.");
        }
    }
    
    public void recebeProcesso(Processo p, int t){
        try{
            this.p = p;
            this.tempoUtilizacao = t;
        }catch(Exception e){
            this.erro.println("Erro 1 (CPU.recebeProcesso): Não existe processo para ser adicionado.");
        }
    }
    
    public Object enviaProcesso(){
        try{
            this.p.setArrivalTime((this.p.getArrivalTime() - this.tempoUtilizacao));
            Processo p = this.p;
            this.p = null;
            this.tempoUtilizacao = 0;
            return p;
        }catch(Exception e){
            this.erro.println("Erro 2 (CPU.enviaProcesso): Não existe processo para ser enviado.");
            return null;
        }
    }
}
