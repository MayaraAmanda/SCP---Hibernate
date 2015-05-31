/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function enviarDados(){ 

if(document.dados.tx_nome.value=="" || document.dados.tx_nome.value.length < 8) { 
alert( "O campo não pode ficar em branco!" );
document.dados.codigoTipoCurso.focus(); 

return false; } 

if( document.dados.tx_email.value=="" || document.dados.tx_email.value.indexOf('@')==-1 || document.dados.tx_email.value.indexOf('.')==-1 ) { 
alert( "Preencha campo E-MAIL corretamente!" ); 
document.dados.tx_email.focus(); 

return false; } 

if (document.dados.tx_mensagem.value=="") { 
alert( "Preencha o campo MENSAGEM!" ); 
document.dados.tx_mensagem.focus(); 

return false; } 

if (document.dados.tx_mensagem.value.length < 50 ) { 
alert( "É necessario preencher o campo MENSAGEM com mais de 50 caracteres!" ); 
document.dados.tx_mensagem.focus(); return false; } 

return true; }