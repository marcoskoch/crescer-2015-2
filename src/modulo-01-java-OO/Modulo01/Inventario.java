import java.util.ArrayList;

public class Inventario
{
    ArrayList <Item> inventario = new ArrayList <Item> ();

    public Inventario (){
    }

    public void adicionarItem(Item item){
        inventario.add(item);
    }

    public void perderItem(Item item){
        inventario.remove(item);
    }
}
