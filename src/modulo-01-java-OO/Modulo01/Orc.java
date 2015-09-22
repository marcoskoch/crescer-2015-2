

public class Orc
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private int vida;
    private Inventario inventario;

    public Orc() {
        this.vida = 100;
        this.inventario = new Inventario();
    }
    
    public void adicionarItem(Item item) {
        this.inventario.adicionarItem(item);
    }
    
    public void perderItem(Item item) {
        this.inventario.perderItem(item);
    }
    
    public Inventario getInventario() {
        return this.inventario;
    }

//     public void gerarVida() {
//         this.vida = vidaAleatoria;
//     }

    public void receberAtaque(boolean ehDwarf){
        
        boolean escudo = false;
        
        for(Item item : this.inventario.getItens()){
            if (item.getDescricao().equals("Escudo Uruk Hai")){
                escudo = true;
                break;
            }
        }
        
        if (ehDwarf && escudo){
            this.vida -=5;
        } else {
            this.vida -= 10;
        }
            
    }
    

//     public void adicionarNovoItem(Item i) {
// 
//         if(i.getDescricao() == "Escudo UrukHai") {
//             this.EscudoUrukHai = i;
//         }
//         else if(i.getDescricao().indexOf("Flecha") >= 0) {
// 
//             if(i.getDescricao() == "Flecha1")
//                 this.Flecha1 = i;
//             if(i.getDescricao() == "Flecha2")
//                 this.Flecha2 = i;
//             if(i.getDescricao() == "Flecha3")
//                 this.Flecha3 = i;
//             else
//                 this.Arco = new Item(1, "Arco  Uruk Hay");
//             this.Flecha1 = new Item(1, "Flecha");
//         }
//         else {
//             this.Arco = i;
//         }
// 
//     }
// 
//     public void AtacarAnao(Dwarf anao) {
//         
//     }
}
