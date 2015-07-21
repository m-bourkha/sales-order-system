/**
 * 
 */
package com.mycompany.sos.service.transformers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.sos.dao.entities.CustomerPaymentDetailEntity;
import com.mycompany.sos.model.CustomerPaymentDetails;

/**
 * CustomerPaymentDetailTransformerImpl class implementation of CustomerPaymentDetailTransformer interface
 * 
 * @author colin
 *
 */
@Component
public class CustomerPaymentDetailTransformerImpl implements CustomerPaymentDetailTransformer{

	@Autowired
	private CustomerTransformer customerTransformer;
	
	@Override
	public CustomerPaymentDetails getDtoFromEntity(
			CustomerPaymentDetailEntity customerPaymentDetailEntity) {
		
		CustomerPaymentDetails customerPaymentDetails = new CustomerPaymentDetails();
		customerPaymentDetails.setCustomerReference(customerPaymentDetailEntity.getCustomerReference());
		customerPaymentDetails.setCardExpiryDate(customerPaymentDetailEntity.getCardExpiryDate());
		customerPaymentDetails.setCardNo(customerPaymentDetailEntity.getCardNo());
		customerPaymentDetails.setCustomer(customerTransformer.getDtoFromEntity(customerPaymentDetailEntity.getCustomer()));
		
		
		return customerPaymentDetails;
	}

}
