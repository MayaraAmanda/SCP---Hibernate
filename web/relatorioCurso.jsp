<%-- 
    Document   : relatorioCurso
    Created on : 10/03/2015, 19:07:48
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
        <form action="RelatorioCurso"
                  method="post" name="exibirCursos">
           <center>
             <h3> Exibir Cursos </h3>
             <table>
                <tr>
                    <td><label>Selecione Tipo Curso:
                        <select name="optTipoCurso">                 
                        <option>Selecione...</option>
                        <c:forEach items="${tipoCurso}" var="tipocurso">    
                            <option value="${tipocurso.codigoTipoCurso}" > ${tipocurso.nomeTipoCurso}</option>
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
