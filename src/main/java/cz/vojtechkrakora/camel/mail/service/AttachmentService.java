package cz.vojtechkrakora.camel.mail.service;

import cz.vojtechkrakora.camel.mail.enums.Templates;
import org.apache.camel.Exchange;
import org.apache.camel.attachment.AttachmentMessage;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Service;

import javax.activation.DataHandler;
import javax.mail.util.ByteArrayDataSource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

@Service
public class AttachmentService {
    public static final String ATTACHMENT_EXAMPLE_TYPE = "text/csv";
    public static final String SIMPLE_TEMPLATE_ATTACHMENT_NAME = "ok.csv";

    /**
     * Adds an attachment for required Template, if template type does not have an attachments adds nothing.
     * @param ex exchange from camel context
     * @param template template for which will be the attachment created
     * @return exchange with possible attachment
     * @throws IOException If some error occurs while retrieving an attachment
     */
    public Exchange addAttachment(Exchange ex, final Templates template) throws IOException {

        if (template == Templates.SIMPLE) {
            return addSimpleTemplateAttachment(ex);
        }

        return ex;
    }


    private Exchange addSimpleTemplateAttachment(Exchange ex) throws IOException {
        AttachmentMessage am = ex.getMessage(AttachmentMessage.class);
        ByteArrayDataSource ba = new ByteArrayDataSource(getDummyCsv(), ATTACHMENT_EXAMPLE_TYPE);
        am.addAttachment(SIMPLE_TEMPLATE_ATTACHMENT_NAME, new DataHandler(ba));

        return ex;
    }

    private ByteArrayInputStream getDummyCsv() throws IOException {

        StringWriter writer = new StringWriter();
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.EXCEL.withSystemRecordSeparator());
        csvPrinter.printRecord("text", "csv", "file", 1, "ok");
        csvPrinter.printRecord("text2", "csv2", "file2", 2, "ok2");
        csvPrinter.printRecord("text3", "csv3", "file3", 3, "ok3");
        csvPrinter.flush();

        return new ByteArrayInputStream(writer.toString().getBytes(StandardCharsets.UTF_8));
    }
}
