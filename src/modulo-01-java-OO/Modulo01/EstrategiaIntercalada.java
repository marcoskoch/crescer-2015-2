import java.util.*;

public class EstrategiaIntercalada implements EstrategiaDeAtaque {
      private ArrayList<Elfo> ordemDoUltimoAtaque = new ArrayList<>();

      public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
          return this.ordemDoUltimoAtaque;
      }

      public void atacar(ArrayList<Elfo> elfos, ArrayList<Dwarf> dwarves) {
          this.ordemDoUltimoAtaque.clear();

          ArrayList<Elfo> vivos = new ArrayList<>();
          for (Elfo elfo : elfos) {
              if (elfo.getStatus() == Status.VIVO) {
                  vivos.add(elfo);
              }
          }

          

          for (Elfo elfoQueVaiAtacar : vivos) {
              ordemDoUltimoAtaque.add(elfoQueVaiAtacar);
              for (Dwarf dwarf : dwarves) {
                  elfoQueVaiAtacar.atirarFlecha(dwarf);
              }
          }
      }
}
