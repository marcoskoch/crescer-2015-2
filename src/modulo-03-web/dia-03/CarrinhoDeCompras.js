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

CarrinhoDeCompras.prototype.forcarCompra = function(){
    var self = this;
    this.intervalo = setInterval(function() {
      self.itens.forEach(function(i) {
      i.valorUnitario += i.valorUnitario * 0.1;
      console.log(i.valorUnitario);
    }); }, 5000);
}

CarrinhoDeCompras.prototype.concluirPedido = function(){
  clearInterval(this.intervalo);
  delete this.intervalo;
}
