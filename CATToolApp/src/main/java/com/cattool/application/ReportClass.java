//package com.cattool.application;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.JasperExportManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
//
//public class ReportClass {
//
//	public static void main(String[] args) throws FileNotFoundException {
//		// TODO Auto-generated method stub
//
//		List<Item> ItemList=new ArrayList<Item>();
//		List<Item> individualList=new ArrayList<Item>();
//		Item iobj=new Item();
//		iobj.setApp_id("id1");
//		iobj.setApp_name("app1");
//		iobj.setApp_desc("app_desc1");
//		Item i1obj=new Item();
//		i1obj.setApp_id("id2");
//		i1obj.setApp_name("app2");
//		i1obj.setApp_desc("app_desc2");
//		
//		ItemList.add(iobj);
//		ItemList.add(i1obj);
//		
////		Iterator iter=ItemList.iterator();
////		while(iter.hasNext())
////		
//		Set<String>arrayId=new HashSet<>();
//	/*	for(Item aid : ItemList)
//		{
//			arrayId.add(aid.getApp_id().toString());
//			System.out.println(aid.);
//		}*/
//		Iterator iter=ItemList.iterator();
//				while(iter.hasNext())
//				{
//				System.out.println(iter.next().toString());
//				}
//					//System.out.println(iter.next());
//					/*for(Item aid1 : ItemList)
//					{
//						if(iter.next().equals(aid1.getApp_id()));
//						{
//							individualList.add(aid1.);
//						}
//					
//					}
//				}*/
//		System.out.println("list creted");
//		
//		JRBeanCollectionDataSource jds=new JRBeanCollectionDataSource(ItemList);
//		Map<String,Object> parametres=new HashMap<String,Object>();
//		parametres.put("ItemDataSource", jds);
//		
//		InputStream reportStream = new FileInputStream("/Users/komjagta/JaspersoftWorkspace/MyReports/Template.jrxml");
//		JasperReport report;
//		try {
//			report = JasperCompileManager.compileReport(reportStream);
//		System.out.println("compiled");
//				//HashMap jasperParameter = new HashMap();
//			    // jasperParameter.put("reportTitle", "Cloud Survey Report");
//
//			     JasperPrint jasperPrint = JasperFillManager.fillReport(report,parametres, jds);
//			     System.out.println("filled");
//			 JasperExportManager.exportReportToPdfFile(jasperPrint, "/hsjd/CloudRreport"+"jk.pdf");
//			 System.out.println("pdf done");
//		} catch (JRException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//
//	}
//
//}
