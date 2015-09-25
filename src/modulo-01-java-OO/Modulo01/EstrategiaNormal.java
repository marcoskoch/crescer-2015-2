import java.util.ArrayList;


public class EstrategiaNormal implements EstrategiaDeAtaque {
    public void atacar(ArrayList<Elfo> elfos, ArrayList <Dwarf> dwarves){
        for (Elfo atacantes : elfos ) {
            for (Dwarf atacados : dwarves ) {
                atacantes.atirarFlecha(atacados);
            }
        }
    }
}
