package ua.com.goit.gojava.POM.presentation.beans.documents;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.documents.PaymentDocument;
import ua.com.goit.gojava.POM.dataModel.documents.PaymentDocumentDetail;
import ua.com.goit.gojava.POM.presentation.beans.common.abstraction.DataObjectEditor;
import ua.com.goit.gojava.POM.services.PaymentDocumentDetailService;
import ua.com.goit.gojava.POM.services.common.ApplicationContextProvider;
import ua.com.goit.gojava.POM.services.common.abstraction.DataObjectService;


@ViewScoped
@ManagedBean
public class PaymentDocumentDetailsEditorBean extends DataObjectEditor<PaymentDocumentDetail> {

	private static final long serialVersionUID = 1L;
	private static final String CLASS_NAME = "Payment Document Detail"; 
	private static final Logger LOG = Logger.getLogger(PaymentDocumentDetailsEditorBean.class);
	private PaymentDocumentDetailService paymentDocumentDetailService = 
			ApplicationContextProvider.getApplicationContext().getBean(PaymentDocumentDetailService.class);

	private PaymentDocument paymentDocument;
	
	public PaymentDocument getPaymentDocument() {
		return paymentDocument;
	}

	public void setPaymentDocument(PaymentDocument paymentDocument) {
		this.paymentDocument = paymentDocument;
	}

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
		return paymentDocumentDetailService;
	}

	@Override
	protected PaymentDocumentDetail getNewObject() {
		PaymentDocumentDetail paymentDocumentDetail = new PaymentDocumentDetail();
		paymentDocumentDetail.setDoc(paymentDocument);
		return paymentDocumentDetail;
	}
	
}
