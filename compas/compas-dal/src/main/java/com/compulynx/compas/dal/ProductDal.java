/**
 * 
 */
package com.compulynx.compas.dal;

import java.util.List;

import com.compulynx.compas.models.BeneficiaryGroup;
import com.compulynx.compas.models.CompasResponse;
import com.compulynx.compas.models.Product;


/**
 * @author Anita
 *
 */
public interface ProductDal {
	CompasResponse UpdateProduct(Product product);

	List<Product> GetProducts(int orgId);
	
	List<BeneficiaryGroup> GetBnfGroups(int orgId);
	
	CompasResponse UpdateBnfGroup(BeneficiaryGroup bnfGrp);
}
