var clubes = [
  {
    nome: 'Arsenal',
    titulos: [
      { desc: 'Nacionais', qtd: 13 },
      { desc: 'Continentais', qtd: 0 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  }, 
  {
    nome: 'Manchester United',
    titulos: [
      { desc: 'Nacionais', qtd: 20 },
      { desc: 'Continentais', qtd: 3 },
      { desc: 'Mundiais', qtd: 2 }
    ]
  },
  {
    nome: 'Liverpool',
    titulos: [
      { desc: 'Nacionais', qtd: 18 },
      { desc: 'Continentais', qtd: 5 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  },
  {
    nome: 'Chelsea Football Club',
    titulos: [
      { desc: 'Nacionais', qtd: 5 },
      { desc: 'Continentais', qtd: 1 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  }
];

// Exercício 1
var ordenarPorTitulo = function(indexTitulo, clubes){
  clubes.sort(function (a, b) {
    if (a.titulos[indexTitulo].qtd < b.titulos[indexTitulo].qtd) {
      return 1;
    }
    if (a.titulos[indexTitulo].qtd > b.titulos[indexTitulo].qtd) {
      return -1;
    }
    return 0;
  });
  return clubes;
}

function ordenaPorNacionais(clubes){
  clubes = ordenarPorTitulo(0, clubes);
  return clubes;
};

function ordenaPorContinentais(clubes){
  clubes = ordenarPorTitulo(1, clubes);
  return clubes;
};

function ordenaPorMundiais(clubes){
  clubes = ordenarPorTitulo(2, clubes);
  return clubes;
};

//Exercício 2
var somaTitulos = function(indexTitulo, clubes){
  var totalTitulos = 0;
  for (var i = 0, len = clubes.length; i < len; i++) {
    totalTitulos += clubes[i].titulos[indexTitulo].qtd;
  };
  return totalTitulos;
}

function somarPorNacionais(clubes){
  return somaTitulos(0, clubes);
}

function somarPorContinentais(clubes){
  return somaTitulos(1, clubes);
}

function somarPorTodosTitulos(clubes){
  var totalTitulos = 0;
  for (var i = 0, len = clubes.length; i < len; i++) {
    for (var j = 0; j < clubes[i].titulos.length; j++) {
      totalTitulos += clubes[i].titulos[j].qtd;
    };
  };
  return totalTitulos;
}

function topTitulosIngleses(clubes){
  return clubes.titulos[0].qtd > 18;
}

function apenasOsMelhores(clubes){
  return clubes.filter(topTitulosIngleses);
}