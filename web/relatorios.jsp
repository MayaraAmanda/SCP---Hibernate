<%-- 
    Document   : relatorios
    Created on : 04/03/2015, 19:39:31
    Author     : Mayara Amanda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="default.css" media="all" />
        <title>SCP - Sistema de Controle de Projetos</title>
    </head>
    <body>
        
        <div id="page">
          <center>
              <h1>Exibir Relatórios</h1>
              <button class="botao" onclick="location.href='CadastrarBolsistaController?acao=prepararOperacao&operacao=carregar'">
                        <span>Bolsista</span>
                </button>
                
                <button class="botao" onclick="location.href='CadastrarCampusController?acao=prepararOperacao&operacao=carregar'">
                        <span>Campus</span>
                </button>
                
                <button class="botao" onclick="location.href='CadastrarCursoController?acao=prepararOperacao&operacao=carregar'">
                        <span>Curso</span>
                </button><br/><br/>
                
                <button class="botao" onclick="location.href='CadastrarEditalController?acao=prepararOperacao&operacao=carregar'">
                        <span>Edital</span>
                </button>
                
                <button class="botao" onclick="location.href='CadastrarFuncionarioController?acao=prepararOperacao&operacao=carregar'">
                        <span>Funcionario</span>
                </button>   
                
                <button class="botao" onclick="location.href='RelatorioInstituicao'">
                        <span>Instituição</span>
                </button><br/><br/>

                <button class="botao" onclick="location.href='CadastrarNucleoController?acao=prepararOperacao&operacao=carregar'">
                        <span> Núcleo</span>
                </button>
                
                <button class="botao" onclick="location.href='CadastrarOrientadorController?acao=prepararOperacao&operacao=carregar'">
                        <span>Orientador</span>
                </button>

                <button class="botao" onclick="location.href='CadastrarProjetoController?acao=prepararOperacao&operacao=carregar'">
                        <span>Projeto</span>
                </button><br/><br/>

                <button class="botao" onclick="location.href='RelatorioSubareaConhecimento'">
                        <span>SubArea</span>
                </button>

                <button class="botao" onclick="location.href='RelatorioTipoBolsa'">
                        <span>Tipo de Bolsa</span>
                </button>
                <button class="botao" onclick="location.href='RelatorioTipoCurso'">
                        <span>Tipo de Curso</span>
                </button><br/><br/>
                
            </center>

        </div>
    </body>
</html>
