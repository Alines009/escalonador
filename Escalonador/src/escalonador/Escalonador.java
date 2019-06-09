
package escalonador;

import java.util.ArrayList;

public class Escalonador {
    
    public static void main(String[] args) throws Exception{
        int contador = 0;
        ArrayList<Processo> novos = new ArrayList(); //Cria lista de processos novos
        Leitura leitura = new Leitura();
        novos = leitura.lerArquivos();//Lendo o arquivo processos.txt
        
        FilaPrioridade fp = new FilaPrioridade();
        FilaComum fc = new FilaComum();
        
        CPU cpu[] = {new CPU(0), new CPU(1), new CPU(2), new CPU(3)};
        
        boolean executando = true;
        
        fp.ImprimePrioridade();
        fc.ImprimeComum();
        int flag;
        try {
            Despachante d = new Despachante();
            while(executando){
                if(contador%2==0){
                    int i = 0;
                    while(i < novos.size()){
                        flag = d.Despachar(novos.get(i), contador, fp, fc);
                        if(flag == 0){
                            novos.remove(i);
                        }else{
                            i += 1;
                        }
                    }
                    // Se a fila de prioridades está vazia vá para a fila comum
                    if(fp.isVazia()){
                        // Se a fila comum e a fila de novos está também vazia verifica-se as CPUs  
                        if(fc.isVazia()){
                            // Verifico se os CPUs estão ociosos, se sim encerra-se o escalonador
                            if(novos.isEmpty()){
                                boolean flag2 = true;
                                for(int j = 0; (j < cpu.length) && flag2 ; j++){
                                    if(!cpu[j].isOcioso()){
                                        flag2 = false;
                                    }
                                }
                                if(!flag2){
                                    executando = false;
                                }
                            }
                        }else{
                            // Faço uma verificação se todos estão ocupados e sua prioridade
                            ArrayList<Integer> prioridades = new ArrayList<Integer>();
                            for(int j = 0; j < cpu.length; j++){
                                prioridades.add(cpu[j].getPrioridadeProcesso());
                            }
                            // Existe processador livre? Se sim, envia processo para a CPU
                            if(prioridades.contains(-1)){
                                int cpuDisponivel = prioridades.indexOf(-1);
                                cpu[cpuDisponivel].recebeProcesso((Processo) fp.enviaProcesso());
                            }
                        }
                        
                    }else{
                        // Faço uma verificação se todos estão ocupados e sua prioridade
                        ArrayList<Integer> prioridades = new ArrayList<Integer>();
                        for(int j = 0; j < cpu.length; j++){
                            prioridades.add(cpu[j].getPrioridadeProcesso());
                        }
                        // Existe processador livre? Se sim, envia processo para a CPU
                        if(prioridades.contains(-1)){
                            int cpuDisponivel = prioridades.indexOf(-1);
                            cpu[cpuDisponivel].recebeProcesso((Processo) fc.enviaProcesso());
                        }
                    }
                }
                
                
            Thread.sleep (1000); 
            
        
            System.out.print("\nTempo: "+contador);
            contador +=1;
            }
            
       //     fp.ImprimePrioridade();
         //   fc.ImprimeComum();
        } catch (InterruptedException ex) {}
        
    }
    
}
