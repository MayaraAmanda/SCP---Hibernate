<%-- 
    Document   : relatorioOrientador
    Created on : 16/03/2015, 15:19:46
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
        <form action="RelatorioOrientador"
                  method="post" name="exibirOrientador">
           <center>
             <h3> Exibir Orientadores </h3>
             <table>
                <tr>
                    <td><label>Selecione Nucleo:
                        <select name="optNucleo">                 
                        <option>Selecione...</option>
                        <c:forEach items="${nucleo}" var="nucleo">    
                            <option value="${nucleo.codigoNucleo}" selected> ${nucleo.nomeNucleo}</option>
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
