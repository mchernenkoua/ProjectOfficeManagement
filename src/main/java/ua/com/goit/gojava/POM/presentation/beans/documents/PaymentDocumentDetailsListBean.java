package ua.com.goit.gojava.POM.presentation.beans.documents;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.documents.PaymentDocument;
import ua.com.goit.gojava.POM.dataModel.documents.PaymentDocumentDetail;
import ua.com.goit.gojava.POM.presentation.beans.common.abstraction.DataObjectListViewer;
import ua.com.goit.gojava.POM.services.POMServicesException;
import ua.com.goit.gojava.POM.services.PaymentDocumentDetailService;
import ua.com.goit.gojava.POM.services.PaymentDocumentService;
import ua.com.goit.gojava.POM.services.common.ApplicationContextProvider;
import ua.com.goit.gojava.POM.services.common.Paginator;
import ua.com.goit.gojava.POM.services.common.abstraction.DataObjectService;


@ViewScoped
@ManagedBean
public class PaymentDocumentDetailsListBean extends DataObjectListViewer<PaymentDocumentDetail> {

	private static final long serialVersionUID = 1L;
	private static final String CLASS_NAME = "Payment Document Detail"; 
	private static final Logger LOG=Logger.getLogger(PaymentDocumentDetailsListBean.class);
	private PaymentDocumentDetailService paymentDocumentDetailService = 
			ApplicationContextProvider.getApplicationContext().getBean(PaymentDocumentDetailService.class);	
	private PaymentDocumentService paymentDocumentService = 
			ApplicationContextProvider.getApplicationContext().getBean(PaymentDocumentService.class);	
	private PaymentDocument parentPaymentDocument;
	
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
	protected List<PaymentDocumentDetail> getDataList(DataObjectService<PaymentDocumentDetail> dataObjectService,
																	Paginator paginator) throws POMServicesException {
		return paymentDocumentService.retrieveAllDetails(parentPaymentDocument, paginator);
	}
	
	public PaymentDocument getParentPaymentDocument() {
		return parentPaymentDocument;
	}

	public void setParentPaymentDocument(PaymentDocument parentPaymentDocument) {
		this.parentPaymentDocument = parentPaymentDocument;
		resetObjects();
	}

	/*public LazyDataModel<PaymentDocumentDetail> getDataObjects(PaymentDocument parentPaymentDocument) {
		if(getParentPaymentDocument() != parentPaymentDocument) {
			setParentPaymentDocument(parentPaymentDocument);
			resetDataObjects();
		}
		return super.getDataObjects();
	}*/


}
