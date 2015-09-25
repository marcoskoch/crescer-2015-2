import java.util.ArrayList;

public class HordaDeDwarf
{
    private ArrayList <Dwarf> dwarves = new ArrayList<>();

    public void adicionarDwarf (Dwarf dwarf){
        dwarves.add(dwarf);
    }

    public ArrayList getDwarves (){
        return this.dwarves;
    }
}
