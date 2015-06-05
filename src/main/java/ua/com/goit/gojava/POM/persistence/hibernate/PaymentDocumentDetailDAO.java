package ua.com.goit.gojava.POM.persistence.hibernate;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.documents.PaymentDocumentDetail;
import ua.com.goit.gojava.POM.persistence.hibernate.abstraction.AbstractDAO;

public class PaymentDocumentDetailDAO extends AbstractDAO<PaymentDocumentDetail> {
	
	private static final String CLASS_NAME = "Payment Document Detail"; 
	private static final Logger LOG = Logger.getLogger(PaymentDocumentDetailDAO.class);
	
	public PaymentDocumentDetailDAO() {
		super(PaymentDocumentDetail.class);
	}
	
	@Override
	protected String getClassName() {
		
		return CLASS_NAME;
	}

	@Override
	protected Logger getLog() {
		
		return LOG;	
	}

	@Override
	protected PaymentDocumentDetail getNewObject() {

		return new PaymentDocumentDetail();	
	}
	
}
