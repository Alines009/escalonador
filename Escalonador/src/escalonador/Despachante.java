package escalonador;

import java.util.ArrayList;

public class Despachante {
    public void Despachar(ArrayList<Processo> ProcessosEmEstadoNovo, int quantum, FilaPrioridade fp, FilaComum fc){
        for(int i=0;i < ProcessosEmEstadoNovo.size();i++){
            Processo p = ProcessosEmEstadoNovo.get(i);
            int arrival = p.getArrivalTime(); //Recupera o tempo de chegada do processo
                if(arrival <= quantum){
                    int prioridade = p.getPriority();
                    if(prioridade == 0){
                        int t = fp.recebeProcesso(p);
                        ProcessosEmEstadoNovo.remove(i);
                    } else {
                        int t = fc.recebeProcesso(p);
                        ProcessosEmEstadoNovo.remove(i);
                    }
                }
        }
    }
}
