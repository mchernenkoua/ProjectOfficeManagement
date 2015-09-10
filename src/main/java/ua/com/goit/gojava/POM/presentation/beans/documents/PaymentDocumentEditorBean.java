package ua.com.goit.gojava.POM.presentation.beans.documents;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.documents.PaymentDocument;
import ua.com.goit.gojava.POM.presentation.beans.common.abstraction.DataObjectEditor;
import ua.com.goit.gojava.POM.services.PaymentDocumentService;
import ua.com.goit.gojava.POM.services.common.ApplicationContextProvider;
import ua.com.goit.gojava.POM.services.common.abstraction.DataObjectService;


@ViewScoped
@ManagedBean
public class PaymentDocumentEditorBean extends DataObjectEditor<PaymentDocument> {

	private static final long serialVersionUID = 1L;
	private static final String CLASS_NAME = "Payment Document"; 
	private static final Logger LOG = Logger.getLogger(PaymentDocumentEditorBean.class);
	private PaymentDocumentService paymentDocumentService = 
			ApplicationContextProvider.getApplicationContext().getBean(PaymentDocumentService.class);
	
	@ManagedProperty(value = "#{paymentDocumentDetailsListBean}")
	private PaymentDocumentDetailsListBean documentDetailListBean;

	public PaymentDocumentDetailsListBean getDocumentDetailListBean() {
		return documentDetailListBean;
	}

	public void setDocumentDetailListBean(
			PaymentDocumentDetailsListBean documentDetailListBean) {
		this.documentDetailListBean = documentDetailListBean;
	}

	@Override
	protected String getClassName() {
		return CLASS_NAME;
	}

	@Override
	public void setDataObject(PaymentDocument dataObject) {
		super.setDataObject(dataObject);
		documentDetailListBean.setParentPaymentDocument(dataObject);
	}

	@Override
	protected Logger getLogger() {
		return LOG;
	}

	@Override
	protected DataObjectService<PaymentDocument> getDataService() {
		return paymentDocumentService;
	}

	@Override
	protected PaymentDocument getNewObject() {
		return new PaymentDocument();
	}
	
}
