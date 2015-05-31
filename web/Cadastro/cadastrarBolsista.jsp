<%-- 
    Document   : cadastrarBolsista
    Created on : 26/11/2014, 16:45:02
    Author     : Angelo
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="page1">
            <form action="CadastrarBolsistaController?acao=confirmarOperacao&operacao=${operacao}"
                  method="post" name="CadastrarBolsista">
                <center><h3>Cadastro de Bolsistas - ${operacao}</h3></center>
                <fieldset>
                    <legend>Dados Pessoais</legend>

                        <label for="codigo">Codigo:</label> 
                        <input type="number" required name="txtCodigo" value="${bolsista.pessoas.codigo}"<c:if test="${operacao != 'Incluir'}"> readonly</c:if>>&nbsp &nbsp
                
                        <label for="nome">Nome: </label>
                        <input type="text" name="txtNome" value="${bolsista.pessoas.nome}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>&nbsp &nbsp
                        
                        <label for="nome">Matricula: </label>
                        <input type="number" name="txtMatricula" value="${bolsista.matricula}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>&nbsp &nbsp
                        
                        <label for="email">Email: </label>
                        <input type="email"  name="txtEmail" value="${bolsista.pessoas.email}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>&nbsp &nbsp
                    
                        <label>Data de Nascimento: </label>
                        <input type="date" name="txtDataNascimento" value="${bolsista.pessoas.dataNascimento}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>><br/><br/>
                        
                        <label>UF de Nascimento:</label>
                                <input list="ufNascimento" name="txtUfNascimento" size="10" value="${bolsista.pessoas.ufNascimento}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                <datalist id="ufNascimento" >
                                    <option value="AC"> Acre 
                                    <option value="AL">Alagoas
                                    <option value="AM">Amazonas
                                    <option value="AP">Amapá
                                    <option value="BA">Bahia
                                    <option value="CE">Ceará
                                    <option value="DF">Distrito Federal
                                    <option value="ES">Espírito Santo
                                    <option value="GO">Goiás 
                                    <option value="MA">Maranhão
                                    <option value="MG">Minas Gerais
                                    <option value="MT">Mato Grosso
                                    <option value="MS">Mato Grosso do Sul
                                    <option value="PA">Pará
                                    <option value="PB">Paraíba
                                    <option value="PE">Pernambuco
                                    <option value="PI">Piauí
                                    <option value="PR">Paraná
                                    <option value="RJ">Rio de Janeiro
                                    <option value="RN">Rio Grande do Norte
                                    <option value="RO">Rondônia
                                    <option value="RR">Roraima
                                    <option value="RS">Rio Grande do Sul
                                    <option value="SC">Santa Catarina
                                    <option value="SE">Sergipe
                                    <option value="SP">São Paulo
                                    <option value="TO">Tocantins
                                </datalist>&nbsp &nbsp
                        
                                <label>Estado Civil:</label>
                                <input type="text" required name="txtEstadoCivil" size="13" value="${bolsista.pessoas.estadoCivil}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>&nbsp &nbsp
                                
                                <label>Nacionalidade:</label>
                                <input type="text" required name="txtNacionalidade" size="16" value="${bolsista.pessoas.nacionalidade}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>&nbsp &nbsp
                        
                                <label for="rg">RG: </label>
                                <input type="text" required name="txtRg" size="22" value="${bolsista.pessoas.rg}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>&nbsp &nbsp
                                
                                <label for="rg">Orgão Expedidor: </label>
                                <input type="text" name="txtOrgaoExpedidor" size="19" value="${bolsista.pessoas.orgaoExpedidor}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>><br/><br/>
                        
                                <label>Expedição :</label>
                                <input type="date" name="txtDataExpedicaoRG" size="5" value="${bolsista.pessoas.dataExpedicaoRg}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>&nbsp &nbsp
                        
                                <label>CPF :</label>
                                <input type="number" required name="txtCpf" value="${bolsista.pessoas.cpf}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if> >&nbsp &nbsp
                        
                                <label>Nome da Mãe:</label>
                                <input type="text" name="txtNomeMae" size="18" value="${bolsista.pessoas.nomeMae}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>&nbsp &nbsp
                            
                                <label>Nome do Pai:</label>
                                <input type="text" name="txtNomePai" size="13" value="${bolsista.pessoas.nomePai}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>&nbsp &nbsp
                            
                                <label>Naturalidade:</label>
                                <input type="text" name="txtNaturalidade" size="23" value="${bolsista.pessoas.naturalidade}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>><br/><br/>
                        
                                <label>Sexo:</label>
                        
                                <input list="sexo" name="txtSexo" size="22" value="${bolsista.pessoas.sexo}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if> >
                                <datalist id="sexo" >
                                    <option value="F"> Feminino
                                    <option value="M">Masculino
                                </datalist>&nbsp &nbsp
                        
                                <label>Grupo Sanguíneo:</label>
                                <input type="text" name="txtGrupoSanguineo" size="8" value="${bolsista.pessoas.grupoSanguineo}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>&nbsp &nbsp
                         
                                <label>Fator RH:</label>
                                <input type="text" name="txtFatorRH" size="22" value="${bolsista.pessoas.fatorRh}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>&nbsp &nbsp
                         
                                <label>Necessidade Especial:</label>
                                <input list="necessidadeEspecial" name="txtNecessidadeEspecial" size="6" value="${bolsista.pessoas.necessidadeEspecial}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if> >
                                <datalist id="necessidadeEspecial" >
                                    <option value="Sim"> Sim 
                                    <option value="Não">Não
                                </datalist>&nbsp &nbsp
                                
                                <label>Cor/Raça:</label>
                                <input type="text" name="txtCor" size="25" value="${bolsista.pessoas.cor}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>><br/><br/>
                         
                                <label>Escolaridade:</label>
                                <input type="text" name="txtEscolaridade" size="15" value="${bolsista.pessoas.escolaridade}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>&nbsp &nbsp
                        
                                <label for="numeroComprovanteMilitar">Número do comprovante de alistamento: </label>
                                <input type="text" name="txtNumeroComprovanteMilitar" value="${bolsista.pessoas.numeroComprovanteMilitar}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>&nbsp &nbsp
                        
                                <label for="tituloEleitor">Título Eleitor: </label>
                                <input type="number" name="txtTituloEleitor" size="15" value="${bolsista.pessoas.tituloEleitor}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>&nbsp &nbsp
                         
                                
                                <label>Pis/Pasep:</label>
                                <input type="text" name="txtPisPasep" size="25" value="${bolsista.pessoas.pisPasep}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>><br/><br/>
                    
                                <label>Selecione o curso:
                                <select name="optCurso">
                                        <option>Selecione...</option>
                                    <c:forEach items="${cursos}" var="curso">
                                        <option value="${curso.codigoCurso}"
                                                <c:if test="${curso.codigoCurso == bolsista.curso.codigoCurso}"> selected </c:if>>
                                            ${curso.nomeCurso}</option>
                                    </c:forEach></select>
                                </label>&nbsp &nbsp
                        
                                <label>Selecione o projeto:
                                <select name="optProjeto">
                                        <option>Selecione...</option>
                                    <c:forEach items="${projetos}" var="projeto">
                                        <option value="${projeto.codigoProjeto}"
                                                <c:if test="${projeto.codigoProjeto == bolsista.projeto.codigoProjeto}"> selected </c:if>>
                                            ${projeto.nomeProjeto}</option>
                                    </c:forEach></select>
                                </label>&nbsp &nbsp
                        
                        
                                <label>Selecione o campus:
                                <select name="optCampus">
                                        <option>Selecione...</option>
                                    <c:forEach items="${campi}" var="campus">
                                        <option value="${campus.codigoCampus}" <c:if test="${campus.codigoCampus == bolsista.pessoas.campus.codigoCampus }"> selected</c:if>>
                                            ${campus.nomeCampus}</option>
                                    </c:forEach></select>
                                </label>
                        </td>
                    </tr>
                
                </fieldset><br/>
                    <fieldset>
                        <legend>Dados de endereço</legend>
                        
                                <label for="rua">Rua:</label>
                                <input type="text" name="txtRua" size="30" value="${bolsista.pessoas.rua}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>&nbsp &nbsp

                                <label>Numero:</label>
                                <input type="text" name="txtNumero" size="10" value="${bolsista.pessoas.numero}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>&nbsp &nbsp

                                <label for="rua">Complemento:</label>
                                <input type="text" name="txtComplemento" size="40" value="${bolsista.pessoas.complemento}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>&nbsp &nbsp

                                <label for="bairro">Bairro: </label>
                                <input type="text" name="txtBairro" value="${bolsista.pessoas.bairro}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>><br/><br/>

                                <label for="cidade">Cidade: </label>
                                <input type="text" name="txtCidade" value="${bolsista.pessoas.cidade}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>&nbsp &nbsp

                                <label for="estado">Estado:</label>
                                <input list="Estado" name="txtEstado"size="19" value="${bolsista.pessoas.uf}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>&nbsp &nbsp
                                <datalist id="Estado" >
                                    <option value="AC"> Acre 
                                    <option value="AL">Alagoas
                                    <option value="AM">Amazonas
                                    <option value="AP">Amapá
                                    <option value="BA">Bahia
                                    <option value="CE">Ceará
                                    <option value="DF">Distrito Federal
                                    <option value="ES">Espírito Santo
                                    <option value="GO">Goiás 
                                    <option value="MA">Maranhão
                                    <option value="MG">Minas Gerais
                                    <option value="MT">Mato Grosso
                                    <option value="MS">Mato Grosso do Sul
                                    <option value="PA">Pará
                                    <option value="PB">Paraíba
                                    <option value="PE">Pernambuco
                                    <option value="PI">Piauí
                                    <option value="PR">Paraná
                                    <option value="RJ">Rio de Janeiro
                                    <option value="RN">Rio Grande do Norte
                                    <option value="RO">Rondônia
                                    <option value="RR">Roraima
                                    <option value="RS">Rio Grande do Sul
                                    <option value="SC">Santa Catarina
                                    <option value="SE">Sergipe
                                    <option value="SP">São Paulo
                                    <option value="TO">Tocantins
                                </datalist>&nbsp &nbsp

                                <label for="cep">CEP: </label>
                                <input type="text" name="txtCep" value="${bolsista.pessoas.cep}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>&nbsp &nbsp

                                <label>País:</label>
                                <input type="text" name="txtPais" size="14" value="${bolsista.pessoas.pais}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>&nbsp &nbsp
                    </fieldset><br/>
                    <fieldset>
                        <legend>Dados Bancarios</legend>
                        
                                <label for="banco">Banco: </label>
                                <input type="text" name="txtNomeBanco" value="${bolsista.nomeBanco}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>&nbsp &nbsp
                                
                                <label for="agencia">Agência: </label>
                                <input type="text" name="txtAgencia" value="${bolsista.agencia}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>>&nbsp &nbsp
                            
                                <label for="contaCorrente">Conta Corrente: </label>    
                                <input type="text" name="txtContaCorrente" value="${bolsista.contaCorrente}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>&nbsp &nbsp
                        
                    </fieldset>
                
                    <button class="botao1" type="submit" name="btnConfirmar"  value= "Confirmar">
                        <span>Confirmar</span>
                    </button>
                
            </form>
            <center>
                <button class="botao1" onClick="parent.location.href = 'PesquisarBolsistaController'" value="Cancelar">
                    <span>Cancelar</span>
                </button> &nbsp;&nbsp;
            </center>
        </div>
    </body>
</html>