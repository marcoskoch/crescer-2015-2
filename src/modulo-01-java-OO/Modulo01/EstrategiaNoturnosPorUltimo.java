import java.util.*;

public class EstrategiaNoturnosPorUltimo implements EstrategiaDeAtaque {
    private ArrayList<Elfo> ordemDoUltimoAtaque = new ArrayList<>();
    private ArrayList<Elfo> verdesPrimeiro = new ArrayList<>();

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

        for (Elfo ordenandoElfos : vivos) {
            boolean éVerde = ordenandoElfos instanceof ElfoVerde;
            if (éVerde) {
                verdesPrimeiro.add(ordenandoElfos);
            }
        }

        for (Elfo ordenandoElfos : vivos) {
            boolean éElfoNoturno = ordenandoElfos instanceof ElfoNoturno;
            if (éElfoNoturno) {
                verdesPrimeiro.add(ordenandoElfos);
            }
        }

        for (Elfo elfoQueVaiAtacar : verdesPrimeiro) {
            for (Dwarf dwarf : dwarves) {
                elfoQueVaiAtacar.atirarFlecha(dwarf);
            }
            ordemDoUltimoAtaque.add(elfoQueVaiAtacar);
        }
    }

}
