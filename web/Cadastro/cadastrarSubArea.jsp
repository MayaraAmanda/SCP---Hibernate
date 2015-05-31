<%-- 
    Document   : cadastrarSubArea
    Created on : 09/09/2014, 20:02:52
    Author     : Mayara Amanda
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="css2.css" media="all" />
        <title>SCP - Sistema de Controle de Projetos</title>
    </head>
    <body>
        <form action="CadastrarSubAreaController?acao=confirmarOperacao&operacao=${operacao}" 
              method="post" name="cadastrarSubArea">
            <center>
            <h3>Cadastrar Subarea Conhecimento - ${operacao} </h3>
            <div>
                <table>
                    <tr>
                        <td>
                            <label>Codigo da Subarea de Conhecimento:</label>
                        </td>
                        <td>
                            <input type="number" required name="codigoSubArea" value="${subArea.codigoSubArea}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>><br><br>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Nome da Subarea de Conhecimento:</label>
                        </td>
                        <td>
                            <input type="text" required name="nomeSubArea" value="${SubArea.nomeSubArea}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>><br/><br/>
                        </td>
                    </tr> 
                </table><br/><br/>
            </center>
                        <button class="botao1" type="submit" name="btnConfirmar" value="Confirmar">
                                <span>Confirmar</span>
                        </button>   
        </form>
                        <button class="botao1" type="submit" onClick="parent.location.href = 'index1.jsp'">
                                <span>Cancelar</span>
                        </button> &nbsp;&nbsp;

                      
    </body>
</html>