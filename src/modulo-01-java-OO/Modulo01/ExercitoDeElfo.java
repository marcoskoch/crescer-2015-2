import java.util.*;

public class ExercitoDeElfo {
    private HashMap <String, Elfo> exercito;
    private HashMap<Status, ArrayList<Elfo>> elfosAgrupadosPorStatus = new HashMap<>();

    public ExercitoDeElfo (){
        this.exercito = new HashMap<>();
    }

    public void alistarUmElfo(Elfo elfo){
      if((elfo instanceof ElfoNoturno || elfo instanceof ElfoVerde) && elfo.getNome() != null){
          exercito.put(elfo.getNome(), elfo);
      }
    }

    public void agruparPorStatus(){
        
        for (Elfo elfo : this.exercito.values() ) {
            if (!this.elfosAgrupadosPorStatus.containsKey(elfo.getStatus())) {
                elfosAgrupadosPorStatus.put(elfo.getStatus(), new ArrayList <Elfo> () );
            }
            elfosAgrupadosPorStatus.get(elfo.getStatus()).add(elfo);
        }
    }

    public Elfo getElfoNoExercitoPorNome(String nome) {
        return this.exercito.get(nome);
    }

    public HashMap getElfosAgrupadosPorStatus() {
        return this.elfosAgrupadosPorStatus;
    }

    public HashMap getExercito(){
        return exercito;
    }

    public boolean equals(Object obj){
        ExercitoDeElfo tropa = (ExercitoDeElfo) obj;
        return this.exercito.equals(tropa.getExercito());
    }
}
