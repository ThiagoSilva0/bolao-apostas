/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bolao.relatorio;

import br.com.bolao.domain.Aposta;
import br.com.bolao.domain.Rodada;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author thiag
 */
public class RelatorioAposta {

    private HttpServletResponse response;
    private FacesContext context;
    private ByteArrayOutputStream baos;
    private InputStream stream;

    public RelatorioAposta() {
        this.context = FacesContext.getCurrentInstance();
        this.response = (HttpServletResponse) context.getExternalContext().getResponse();
    }

    /*
    defina um parametro: List<Objeto> lista, se usar JavaBean DataSource
     */
    public void getRelatorio(List<Aposta> apostas) {
        stream = this.getClass().getResourceAsStream("/br.com.bolao.report/aposta.jasper");
        Map<String, Object> params = new HashMap<String, Object>();
        baos = new ByteArrayOutputStream();

        try {

            JasperReport report = (JasperReport) JRLoader.loadObject(stream);

            /*Para usar JavaBeanDataSource defina: new JRBeanCollectionDataSource(lista)
            mude a string do getResourceAsStream("/report/reportPessoaJavaBeanDS.jasper")
             */
            JasperPrint print = JasperFillManager.fillReport(report, params, new JRBeanCollectionDataSource(apostas));
            JasperExportManager.exportReportToPdfStream(print, baos);

            response.reset();
            response.setContentType("application/pdf");
            response.setContentLength(baos.size());
            response.setHeader("Content-disposition", "inline; filename=relatorio.pdf");
            response.getOutputStream().write(baos.toByteArray());
            response.getOutputStream().flush();
            response.getOutputStream().close();

            context.responseComplete();

        } catch (JRException ex) {
            Logger.getLogger(RelatorioRodada.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RelatorioRodada.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
