package com.compulynx.compas.dal;

import java.util.List;

import javax.sql.DataSource;

import com.compulynx.compas.models.Claim;
import com.compulynx.compas.models.CompasResponse;

public interface UploadclaimDal {
	public boolean addUploadclaimDocument(List<Claim> doc); 
	public CompasResponse UploadClaim(String filePath);
}
