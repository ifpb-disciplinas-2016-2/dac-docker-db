package ifpb.ads.dac;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.function.Consumer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ricardo Job
 */
@WebServlet(name = "PessoaServlet", urlPatterns = {"/cadastro"})
public class PessoaServlet extends HttpServlet {

    private Pessoas pessoas = new Pessoas();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        listar(response, "--Listagem--");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");

        Pessoa pessoa = new Pessoa(nome);

        boolean retorno = pessoas.salvar(pessoa);

        listar(response, (retorno ? "Sucesso" : "Erro"));

    }

    private void listar(HttpServletResponse response, String mensagem) throws IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PessoaServlet</title>");
            out.println("</head>");
            out.println("<body>");

            out.println("<h1>" + mensagem + "</h1>");

            List<Pessoa> todas = pessoas.todas();

            todas.stream().forEach(printPessoa(out));

            out.println("</body>");
            out.println("</html>");
        }

    }

    private static Consumer<Pessoa> printPessoa(PrintWriter out) {
        return p -> out.println("<p>"
                + p.getId()
                + " - "
                + p.getNome()
                + "</p>");
    }

}
