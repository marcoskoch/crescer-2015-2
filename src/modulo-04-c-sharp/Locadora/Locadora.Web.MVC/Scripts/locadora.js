/*Script Locadora*/

$("#btnBuscarJogo").click(function(){
	nome = $('#nomeJogo').val();
  	location.replace('/Relatorio/JogosDisponiveis?nome=' + nome);
});

