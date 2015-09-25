import java.util.ArrayList;

// C#
// public class EstrategiaNormal : IEstrategiaDeAtaque, IOutroContrato
public class EstrategiaNormal implements EstrategiaDeAtaque {

    private ArrayList<Elfo> ordemDoUltimoAtaque = new ArrayList<Elfo>();

    public void atacar(ArrayList<Elfo> pelotao, ArrayList<Dwarf> dwarves) {

        ordemDoUltimoAtaque.clear();
        int trintaPorcentoDasIntencoes = (int) ((pelotao.size() * dwarves.size()) * 0.30);
        int count = 0;

        for (Elfo elfo : pelotao) {
            ordemDoUltimoAtaque.add(elfo);
            for (Dwarf dwarf : dwarves) {
                count++;
                if (elfo instanceof ElfoNoturno && trintaPorcentoDasIntencoes <= count) {
                    continue;
                }
                if (elfo.getStatus() == Status.VIVO) {
                    elfo.atirarFlecha(dwarf);
                }
            }
        }
    }

    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
        return this.ordemDoUltimoAtaque;
    }
}
