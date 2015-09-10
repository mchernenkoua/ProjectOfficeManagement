package ua.com.goit.gojava.POM.presentation.beans.documents;

import javax.faces.convert.FacesConverter;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.documents.PaymentDocumentDetail;
import ua.com.goit.gojava.POM.presentation.beans.common.abstraction.DataObjectConverter;
import ua.com.goit.gojava.POM.services.PaymentDocumentDetailService;
import ua.com.goit.gojava.POM.services.common.ApplicationContextProvider;
import ua.com.goit.gojava.POM.services.common.abstraction.DataObjectService;


@FacesConverter(forClass = PaymentDocumentDetail.class)
public class PaymentDocumentDetailConverter extends DataObjectConverter<PaymentDocumentDetail> {

	private static final String CLASS_NAME = "Payment Document Detail"; 
	private static final Logger LOG = Logger.getLogger(PaymentDocumentDetailConverter.class);
	private PaymentDocumentDetailService paymentDocumentService = 
			ApplicationContextProvider.getApplicationContext().getBean(PaymentDocumentDetailService.class);

	@Override
	protected String getClassName() {
		return CLASS_NAME;
	}

	@Override
	protected Logger getLogger() {
		return LOG;
	}

	@Override
	protected DataObjectService<PaymentDocumentDetail> getDataService() {
		return paymentDocumentService;
	}

}
