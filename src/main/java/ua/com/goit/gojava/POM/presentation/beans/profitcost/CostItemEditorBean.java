package ua.com.goit.gojava.POM.presentation.beans.profitcost;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.profitcost.CostItem;
import ua.com.goit.gojava.POM.presentation.beans.common.abstraction.DataObjectEditor;
import ua.com.goit.gojava.POM.services.CostItemService;
import ua.com.goit.gojava.POM.services.common.ApplicationContextProvider;
import ua.com.goit.gojava.POM.services.common.abstraction.DataObjectService;


@RequestScoped
@ManagedBean
public class CostItemEditorBean extends DataObjectEditor<CostItem> {

	private static final long serialVersionUID = 1L;
	private static final String CLASS_NAME = "Cost Item"; 
	private static final Logger LOG=Logger.getLogger(CostItemEditorBean.class);
	private CostItemService costItemService = 
			ApplicationContextProvider.getApplicationContext().getBean(CostItemService.class);

	@Override
	protected String getClassName() {
		return CLASS_NAME;
	}

	@Override
	protected Logger getLogger() {
		return LOG;
	}

	@Override
	protected DataObjectService<CostItem> getDataService() {
		return costItemService;
	}

	@Override
	protected CostItem getNewObject() {
		return new CostItem();
	}
	
}
