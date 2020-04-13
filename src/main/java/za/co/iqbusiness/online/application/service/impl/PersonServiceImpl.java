/**
 * 10 Apr 2020
 */
package za.co.iqbusiness.online.application.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRSaver;
import net.sf.jasperreports.export.OutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import za.co.iqbusiness.online.application.data.Person;
import za.co.iqbusiness.online.application.repository.PersonRepository;
import za.co.iqbusiness.online.application.service.PersonService;

/**
 * @author luckyboyrapudi
 *
 */
@Service
public class PersonServiceImpl implements PersonService {
	
    @Value("${report.path}")
    private String reportPath;
	@Autowired
	private PersonRepository personRepository;

	/**
	 * 10 Apr 2020
	 */
	@Override
	public void doRegister(Person person) {
		personRepository.save(person);

	}

	/**
	 * 10 Apr 2020
	 */
	@Override
	public List<Person> getAllRegisteredPeople() {
		return personRepository.findAll();
	}
	
	
	@Override
	public  byte[] generateReport() throws FileNotFoundException{

		List<Person> persons = new ArrayList<>();
		byte[] bytes = null;
		personRepository.findAll().stream().forEach(e -> persons.add(e));

		try {

			//File file = ResourceUtils.getFile("classpath:person-rpt.jrxml");

			//InputStream input = new FileInputStream(file);
			File file = new File(
					System.getProperty("user.dir") + File.separator + "cfg" + File.separator + "person-rpt.jrxml");
			InputStream input = new FileInputStream(file);
			JasperReport jasperReport = JasperCompileManager.compileReport(input);
			JRSaver.saveObject(jasperReport, "person-rpt");

			JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(persons);
			
			Map<String, Object> parameters = new HashMap<>();

			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, source);
			
			/*
			 * HtmlExporter htmlExporter = new
			 * HtmlExporter(DefaultJasperReportsContext.getInstance());
			 * htmlExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			 * htmlExporter.setExporterOutput(new SimpleHtmlExporterOutput(file));
			 * htmlExporter.exportReport();
			 */
			 //ByteArrayOutputStream out = new ByteArrayOutputStream();
			 bytes=JasperExportManager.exportReportToPdf(jasperPrint);
			/*
			 * JRPdfExporter pdf = new
			 * JRPdfExporter(DefaultJasperReportsContext.getInstance());
			 * pdf.setExporterInput(new SimpleExporterInput(jasperPrint));
			 * pdf.setExporterOutput(new SimpleOutputStreamExporterOutput(out));
			 * pdf.exportReport();
			 */

			//System.out.println("PDF File Generated !!");
			
			return bytes;

		}  catch (JRException  e) {
		      e.printStackTrace();
	    }
	    return bytes;

	}

}
