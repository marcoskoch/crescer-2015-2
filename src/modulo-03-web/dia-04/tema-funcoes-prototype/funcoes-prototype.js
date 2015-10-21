// Escreva uma função no prótipo do tipo String que verifica se a string é um palíndromo.

String.prototype.palindromo = function () {
	inversao = this.split('').reverse().join('');
	return this.toLowerCase() === inversao.toLowerCase();
};

// Escreva uma função no protótipo do tipo Date que verifica se uma data possui um ano bissexto

Date.prototype.bissexto = function () {
	var ano = this.getFullYear();
	return (ano % 4 == 0) && ((ano % 100 != 0) || (ano % 400 == 0));
};

