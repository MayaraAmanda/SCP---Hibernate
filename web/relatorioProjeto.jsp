<%-- 
    Document   : relatorioProjeto
    Created on : 10/03/2015, 19:43:13
    Author     : Mayara Amanda
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="RelatorioProjeto"
                  method="post" name="exibirProjeto">
           <center>
             <h3> Exibir Projetos </h3>
             <table>
                <tr>
                    <td><label>Selecione o Código Tipo Bolsa:
                        <select name="optTipoBolsa">                 
                        <option>Selecione...</option>
                        <c:forEach items="${tipobolsas}" var="tipobolsa">    
                            <option value="${tipobolsa.codigoTipoBolsa}" selected> ${tipobolsa.nomeTipoBolsa}</option>
                        </c:forEach></select></label>
                    </td>
                </tr>
               
             </table><br/><br/>
             
        <button class="botao1" onClick="location.href ='pesquisar.jsp'">
            <span>Voltar</span>
        </button> &nbsp;&nbsp;

        <input type="submit" class="botao1" value="Confirmar"  >
            
           </center>
        </form>
    </body>
</html>
