import java.util.ArrayList;

public class Inventario
{
    ArrayList <Item> inventario = new ArrayList <Item> ();

    public void adicionarItem(Item item){
        inventario.add(item);
    }

    public void perderItem(Item item){
        inventario.remove(item);
    }

    public String getDescricoesItens(){
        String descricaoItens = "";

        for(int i = 0; i < inventario.size(); i++)
        {
            Item item = inventario.get(i);
            
            if(i != 0)
                descricaoItens += ", ";
                
            descricaoItens += item.getDescricao();
        }
        
        return descricaoItens;
    }
}
