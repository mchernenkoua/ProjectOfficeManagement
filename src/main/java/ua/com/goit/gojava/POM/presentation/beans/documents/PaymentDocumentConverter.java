package ua.com.goit.gojava.POM.presentation.beans.documents;

import javax.faces.convert.FacesConverter;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.documents.PaymentDocument;
import ua.com.goit.gojava.POM.presentation.beans.common.abstraction.DataObjectConverter;
import ua.com.goit.gojava.POM.services.PaymentDocumentService;
import ua.com.goit.gojava.POM.services.common.ApplicationContextProvider;
import ua.com.goit.gojava.POM.services.common.abstraction.DataObjectService;


@FacesConverter(forClass = PaymentDocument.class)
public class PaymentDocumentConverter extends DataObjectConverter<PaymentDocument> {

	private static final String CLASS_NAME = "Payment Document"; 
	private static final Logger LOG = Logger.getLogger(PaymentDocumentConverter.class);
	private PaymentDocumentService paymentDocumentService = 
			ApplicationContextProvider.getApplicationContext().getBean(PaymentDocumentService.class);

	@Override
	protected String getClassName() {
		return CLASS_NAME;
	}

	@Override
	protected Logger getLogger() {
		return LOG;
	}

	@Override
	protected DataObjectService<PaymentDocument> getDataService() {
		return paymentDocumentService;
	}

}
