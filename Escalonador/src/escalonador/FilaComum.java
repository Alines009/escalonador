/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escalonador;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 *
 * @author Ricardo Monteiro
 */
public class FilaComum {
    private ArrayList<ArrayList<Processo>> filaComum;
    private PrintStream erro;
    
    public FilaComum() throws UnsupportedEncodingException{
        this.erro = new PrintStream(System.err, true, "UTF-8");
        this.filaComum = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            this.filaComum.add(new ArrayList<Processo>());
        }
    }
    
    public Object processoFinalisou(Processo p){
        try{
            return (p.getArrivalTime() == 0);
        }catch(Exception e){
            
            this.erro.println("Erro 1 (FilaComum.processoFinalisou): Não existe processo para comparar o tempo.");
            return null;
        }        
    }
    
    public void recebeProcesso(Processo p){
        try{
            ArrayList<Processo> a = this.filaComum.get(0);
            a.add(p);
            this.filaComum.set(0, a);
        }catch(Exception e){
            this.erro.println("Erro 1 (FilaComum.recebeProcesso): Não existe processo para ser adicionado.");
        }
    }
    
    public Object enviaProcesso(){
        ArrayList<Processo> a;
        for(int i = 0; i < 3; i++){
            a =  this.filaComum.get(i);
            if(!a.isEmpty()){
                Processo p = a.remove(0);
                this.filaComum.set(i,a);
                return p;
            }
        }
        this.erro.println("Erro 2 (FilaComum.enviaProcesso): Fila Vazia.");
        return null;
    }
}
