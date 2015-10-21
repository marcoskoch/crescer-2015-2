function CarrinhoDeCompras () {
  this.itens = new Array();
};

CarrinhoDeCompras.prototype.adicionarItem = function(item) {
  this.itens.push(item);
};

CarrinhoDeCompras.prototype.removerItem = function(sku) {
  var indice = this.itens.map(function(elem) { return elem.sku; }).indexOf(sku);
  this.itens.splice(indice, 1);
};

CarrinhoDeCompras.prototype.atualizarQuantidade = function(sku, quantidade){
  var indice = this.itens.map(function(elem) { return elem.sku; }).indexOf(sku);
  this.itens[indice].quantidade = quantidade;
};

CarrinhoDeCompras.prototype.calcularSubTotalCarrinho = function(){
  var soma = 0;
  this.itens.forEach(function(i) {
    soma += i.calcularSubTotal();
  });
  if (this.tentarSorte()%2 == 0) {
    soma = soma * 0.9;
  }
  return soma;
};

CarrinhoDeCompras.prototype.tentarSorte = function(){
  return Math.floor(Math.random() * (5) + 1);
};

carrinho = new CarrinhoDeCompras();

item1 = new Item('654', 'bone', 1, 20);
item2 = new Item('158', 'calca', 2, 150);
item3 = new Item('354', 'tenis', 2, 250);
item4 = new Item('156', 'camiseta', 40, 49);

carrinho.adicionarItem(item1);
carrinho.adicionarItem(item2);
carrinho.adicionarItem(item3);
carrinho.adicionarItem(item4);


carrinho.removerItem('654');
carrinho.atualizarQuantidade('156', 1);
