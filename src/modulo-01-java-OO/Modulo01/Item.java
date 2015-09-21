public class Item
{
    private String descricao;
    private int quantidade;
    
    /**
     * Cria um item de inventário com a quantidade e descrição informadas
     * 
     * @param quantidade Quantidade de unidades no inventário
     * @param descricao Descrição do item
     */
    public Item(int quantidade, String descricao) {
        this.quantidade = quantidade;
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return this.descricao;
    }
    
    public int getQuantidade() {
        return this.quantidade;
    }
    
    public void aumentar1000Unidades() {
        this.quantidade += 1000;
    }
    
    
    public void aumentar1000UnidadesIrishDwarf(int itens) {
        this.quantidade += 1000 * itens;
    }
    
    public boolean equals(Object obj) {
        Item outro = (Item)obj;
        return this.descricao.equals(outro.getDescricao()) && this.quantidade == outro.getQuantidade();
    }
    
//      public void shimbalaie() {
//         int pa = (this.quantidade * (this.quantidade+1)) / 2;
//         this.quantidade += (1000 * pa);
//     }
}
