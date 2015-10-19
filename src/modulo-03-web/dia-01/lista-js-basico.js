// Exercício 1

function daisyGame(numeroPetolas){
    if (numeroPetolas%2 === 0) {
      return 'Love me not';
    } else {
      return 'Love me';
    }
}

// Exercício 2

function maiorTexto(list){
  var maior = '';
  for (var i in list) {
    if (list[i] > maior && typeof(list[i] === 'String')) {
      maior = list[i];
    }
  }
  return maior;
}

// Exercício 3

function msg(instrutor){
  console.log('olá querido instrutor:', instrutor);
}

function imprime(instrutores, funcao){
  if (typeof(funcao) === 'function') {
    for (var i in instrutores) {
        funcao(instrutores[i]);
    }
  } else {
    console.log('parametro inválido.');
  }
}

// Exercício 4

function fiboSum(n){
  var a = 1;
  var b = 1;
  var result;
  for (var i = 0; i < n; i++) {
      if (i === 0) {
        fibo = a;
        result = fibo;
      } else{
        result += b;
        fibo = a + b;
        a = b;
        b = fibo;
      };
  };
  return result;
}

// Exercício 5

function excelis(idx){
  var numeroColuna = 0;
  for (var i = 0; i < idx.length; i++) {
    numeroColuna = numeroColuna * 26 + (idx.charCodeAt(i) - 64) ;
  };

  return numeroColuna;
}

// Exercício 6

function queroCafe(mascada, precos){
  var precosOrdenados = new Array();
  for (var i in precos) {
    if (precos[i] <= mascada) {
      precosOrdenados.push(precos[i]);
    };
  }
  return precosOrdenados.sort();
}