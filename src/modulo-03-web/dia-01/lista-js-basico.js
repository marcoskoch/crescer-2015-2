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

