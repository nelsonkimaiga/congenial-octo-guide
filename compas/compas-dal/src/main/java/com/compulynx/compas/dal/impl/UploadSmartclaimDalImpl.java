//package com.compulynx.compas.dal.impl;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.sql.DataSource;
//
//import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import com.compulynx.compas.dal.UploadSmartclaimDal;
//import com.compulynx.compas.dal.operations.Queryconstants;
//import com.compulynx.compas.models.SmartTransactionMst;
//import com.compulynx.compas.models.CompasResponse;
//
//public class UploadSmartclaimDalImpl implements UploadSmartclaimDal{
//	private DataSource dataSource;
//	
//	public UploadSmartclaimDalImpl(DataSource dataSource) {
//		super();
//		this.dataSource = dataSource;
//	}
//	@Override
//	public boolean addUploadsmartclaimDocument(List<SmartTransactionMst> doc) {
//		// TODO Auto-generated method stub
//		return true;
//	}
//	
//	@Override
//	public CompasResponse uploadSmartClaim(String filePath) {
//		try
//		{
//			ArrayList<SmartTransactionMst>list = getClaimsExcel(filePath);
//			// if (uploadSmartClaim(list))
//			 {
//	
//				return new CompasResponse(200, "Uploaded Successfully");
//			} else {
//				return new CompasResponse(201, "Oops! No Records to upload");
//			}
//		}
//		catch(IOException e) { e.printStackTrace(); return new CompasResponse(201, "Error. Could not process uploaded document."); }
//	
//	}
//	//response message dependent on multiple db transations, hence in dal. refactor excel reading to bal higher abs class though
//	//check api for overwritten compas response messages
//	private ArrayList<SmartTransactionMst> getClaimsExcel(String pathToFile) throws IOException {
//		ArrayList<SmartTransactionMst> Claims = new ArrayList<SmartTransactionMst>();
//		try {
//			System.out.println("FileNameInUploadExcel##" + pathToFile);
//			FileInputStream file = new FileInputStream(new File(pathToFile));
//			XSSFWorkbook workbook = new XSSFWorkbook(file);
//			workbook.getNumberOfSheets();
//			XSSFSheet sheet = workbook.getSheetAt(0);
//			int rows = sheet.getPhysicalNumberOfRows();
//			System.out.println("Number of rows>>" + rows);
//			DataFormatter df = new DataFormatter();
//			//last row contains sample data for test excel file
//			for (int r = 1; r < rows; r++) 
//			{
//				System.out.println("WTF Row>>" + r);
//				XSSFRow row = sheet.getRow(r);
//				XSSFCell cell;
//				SmartTransactionMst Claim = new SmartTransactionMst();
////				Claim.insuranceCode = df.formatCellValue(row.getCell(0));
////				Claim.insuranceName = df.formatCellValue(row.getCell(1));
////				Claim.schemeCode = df.formatCellValue(row.getCell(2));
////				Claim.schemeName = df.formatCellValue(row.getCell(3));
////			    Claim.chargeDate = df.formatCellValue(row.getCell(4));
////			    Claim.receiptNo = df.formatCellValue(row.getCell(5));
////			    Claim.patientNo = df.formatCellValue(row.getCell(6));
////			    Claim.patientName = df.formatCellValue(row.getCell(7));
////			    Claim.membershipNo = df.formatCellValue(row.getCell(8));
////			    Claim.itemCode = df.formatCellValue(row.getCell(9));
////			    Claim.itemName = df.formatCellValue(row.getCell(10));
////			    Claim.transactionType = df.formatCellValue(row.getCell(11));
////			    Claim.remarks = df.formatCellValue(row.getCell(12));
////			    Claim.itemQuantity = Double.parseDouble(df.formatCellValue(row.getCell(13)));
////			    Claim.patientAmount = Double.parseDouble(df.formatCellValue(row.getCell(14)));
////			    Claim.patientDiscount = Double.parseDouble(df.formatCellValue(row.getCell(15)));
////			    Claim.patientNet = Double.parseDouble(df.formatCellValue(row.getCell(16)));
////			    Claim.sponsorAmount = Double.parseDouble(df.formatCellValue(row.getCell(17)));
////			    Claim.sponsorDiscount = Double.parseDouble(df.formatCellValue(row.getCell(18)));
////			    Claim.sponsorNet = Double.parseDouble(df.formatCellValue(row.getCell(19)));
////			    System.out.println(Claim);
////				Claims.add(Claim);			
//			}
//			System.out.println("Number of rows##" + rows);
//			file.close();
//			
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new IOException();
//		}
//		return Claims;
//	}
//	
//	public boolean uploadClaims(ArrayList<SmartTransactionMst> listClaims)
//	{
//		boolean done = false;
//		try 
//		{
//			Connection connection = dataSource.getConnection();
//			//connection.setAutoCommit(false);
//			PreparedStatement preparedStatement = connection.prepareStatement(Queryconstants.insertClaim);
//			PreparedStatement preparedStatement1 = connection.prepareStatement(Queryconstants.getMasterServiceId);
//			PreparedStatement preparedStatement2 = connection.prepareStatement(Queryconstants.getClaimantMemberType);
//			//PreparedStatement preparedStatement3 = connection.prepareStatement(Queryconstants.getAKUHPrincipalBasketBalance);
//			PreparedStatement preparedStatement3 = null;
//			ResultSet rs, rs1, rs2 = null;
//			for(SmartTransactionMst claim: listClaims)
//			{
//				preparedStatement.setString(1, claim.memberNo);
//				preparedStatement.setString(2, claim.accNo);
//				preparedStatement.setString(3, claim.billNo);
//				preparedStatement.setString(4, claim.accNo);
//				preparedStatement.setString(5, claim.cardNumber);
//				preparedStatement.setString(6, claim.deviceId); 
//				preparedStatement.setString(7, claim.invoiceNo);
//				preparedStatement.setString(8, claim.merName);
//				preparedStatement.setString(9, claim.transDate);
//				preparedStatement.setString(10, claim.transStatus); 
//				preparedStatement.setDouble(11, claim.txnAmount); 
//				preparedStatement.setString(12, claim.providerId);
////				preparedStatement.setString(13, claim.remarks); 
////				preparedStatement.setDouble(14, claim.itemQuantity); 
////				preparedStatement.setDouble(15, claim.patientAmount); 
////				preparedStatement.setDouble(16, claim.patientDiscount);
////				preparedStatement.setDouble(17, claim.patientNet); 
////				preparedStatement.setDouble(18, claim.sponsorAmount);
////				preparedStatement.setDouble(19, claim.sponsorDiscount);
////				preparedStatement.setDouble(20, claim.sponsorNet);
//				preparedStatement.execute();
//				
//			//	preparedStatement1.setString(1, claim.itemCode);
//				rs1 = preparedStatement1.executeQuery();
//				rs1.next();
//				int masterServiceId = rs1.getInt("mst_serv_id");
//				
//				preparedStatement2.setString(1, claim.memberNo);
//				rs = preparedStatement2.executeQuery();
//				if(rs.next())
//				{
//					if(rs.getString("member_type").equals("P"))
//					{
//						System.out.println("dealing with principal claimant");
//						//System.out.println("masterServiceId: "+masterServiceId+" membershipNo: "+claim.membershipNo);
//						preparedStatement3 = connection.prepareStatement(Queryconstants.getAKUHPrincipalBasketBalance2);
//						//preparedStatement3.setString(1, claim.membershipNo);
//						//preparedStatement3.setString(2, claim.itemCode);
//						preparedStatement3.setInt(1, masterServiceId);
//						preparedStatement3.setString(2, claim.memberNo);
//					}
//					else //if(rs.getString("member_type").equals("D"))
//					{
//						System.out.println("dealing with dependant claimant");
//						//System.out.println("masterServiceId: "+masterServiceId+" principle_id: "+rs.getString("principle_id"));
//						//preparedStatement3.setString(1, rs.getString("principle_id"));
//						//preparedStatement3.setString(2, claim.itemCode);
//						preparedStatement3 = connection.prepareStatement(Queryconstants.getAKUHPrincipalBasketBalance3);
//						preparedStatement3.setString(1, rs.getString("principle_id"));
//						preparedStatement3.setInt(2, masterServiceId);
//						
//						
//					}
//					rs2 = preparedStatement3.executeQuery();
//					if(rs2.next())
//					{
//						double basketBalance = rs2.getDouble("basket_balance");
//						int allocationId = rs2.getInt("id");
//						System.out.println("Basket balance: "+basketBalance+" id: "+allocationId+" net: "+claim.txnAmount);
//						basketBalance-=claim.txnAmount;
//						PreparedStatement preparedStatement4 = connection.prepareStatement(Queryconstants.updateAllocationAfterClaim);
//						preparedStatement4.setDouble(1, basketBalance);
//						preparedStatement4.setInt(2, allocationId);
//						preparedStatement4.execute();
//						System.out.println("basket balance updated to "+basketBalance);
//					}
//				}
//			}
//			//connection.commit();
//			done = true;
//		}
//		catch(SQLException e) { e.printStackTrace(); }
//		
//		return done;
//	}
//
//}
