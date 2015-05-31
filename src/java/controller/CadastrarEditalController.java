/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Campus;
import model.Edital;
import model.SubArea;
import model.Tipobolsa;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Angelo
 */
public class CadastrarEditalController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        String acao = request.getParameter("acao");
        if (acao.equals("confirmarOperacao")) {
            confirmarOperacao(request, response);
        } else {
            if (acao.equals("prepararOperacao")) {
                prepararOperacao(request, response);
            }
        }
    }

    protected void prepararOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("subareas", SubArea.obterSubAreas());
            request.setAttribute("campi", Campus.obterCampi());
            request.setAttribute("tipoBolsas", Tipobolsa.obterTipoBolsas());

            if (operacao.equals("carregar")) {
            RequestDispatcher view = request.getRequestDispatcher("relatorioEdital.jsp");
            view.forward(request, response);
            
            }
            
            else if (!operacao.equals("Incluir")) {
                int codigoEdital = Integer.parseInt(request.getParameter("codigoEdital"));
                Edital edital = Edital.obterEdital(codigoEdital);
                request.setAttribute("edital", edital);
            }
             
            RequestDispatcher view = request.getRequestDispatcher("Cadastro/cadastrarEdital.jsp");
            view.forward(request, response);

        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        }

    }

    private void confirmarOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, ServletException, IOException, SQLException, ClassNotFoundException {

        String operacao = request.getParameter("operacao");
        int codigoEdital = Integer.parseInt(request.getParameter("codigoEdital"));
        int numeroEdital = Integer.parseInt(request.getParameter("numeroEdital"));
        int anoEdital = Integer.parseInt(request.getParameter("anoEdital"));
        int quantidadeBolsa = Integer.parseInt(request.getParameter("quantidadeBolsa"));
        int validadeBolsa = Integer.parseInt(request.getParameter("validadeBolsa"));
        float valorBolsa = Float.parseFloat(request.getParameter("valorBolsa"));
        int validadeEdital = Integer.parseInt(request.getParameter("validadeEdital"));
        int codigoTipoBolsa = Integer.parseInt(request.getParameter("optTipoBolsa"));
        int codigoCampus = Integer.parseInt(request.getParameter("optCampus"));
        int codigoSubarea = Integer.parseInt(request.getParameter("optSubarea"));

        try {
            Tipobolsa tipoBolsa = null;
            if (codigoTipoBolsa != 0) {
                tipoBolsa = Tipobolsa.obterTipoBolsa(codigoTipoBolsa);
            }
            Campus campus = null;
            if (codigoCampus != 0) {
                campus = Campus.obterCampus(codigoCampus);

            }
            SubArea subArea = null;
            if (codigoSubarea != 0) {
                subArea = SubArea.obterSubArea(codigoSubarea);

            }
            Edital edital = new Edital(codigoEdital, numeroEdital, anoEdital, quantidadeBolsa, validadeBolsa, valorBolsa, validadeEdital, tipoBolsa, campus, subArea);

            
            if (operacao.equals("Incluir")) {
                edital.gravar();
            } else {
                if (operacao.equals("Editar")) {
                    edital.editar();
                } else {
                    if (operacao.equals("Excluir")) {
                        edital.excluir();
                    }
                }
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisarEditalController");
            view.forward(request, response);
        } catch (IOException e) {
            throw new ServletException(e);
        } catch (SQLException e) {
            throw new ServletException(e);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        } catch (ServletException e) {
            throw new ServletException(e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarEditalController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastrarEditalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarEditalController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastrarEditalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
