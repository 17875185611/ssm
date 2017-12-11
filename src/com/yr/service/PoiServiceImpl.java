package com.yr.service;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yr.dao.PoiDaoImpl;
import com.yr.entry.User;

@Service("poiServiceImpl")
public class PoiServiceImpl implements PoiService {

	@Autowired
	private PoiDaoImpl poiDaoImpl;

	@Override
	public void testPoi(InputStream inputStream) throws Exception {
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = null;
		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
			sheet = workbook.getSheetAt(i);
			XSSFRow row0 = sheet.getRow(0);
			for (int j = 1; j <= sheet.getLastRowNum(); j++) {
				XSSFRow row = sheet.getRow(j);
				User user = new User();
				if (null != row) {
					for (int k = 0; k < row.getLastCellNum(); k++) {
						if (null != row.getCell(k) && !"".equals(row.getCell(k))) {
							String rowvalue = row.getCell(k).toString();
							if ("id".equals(row0.getCell(k).toString())) {
								double id = Double.valueOf(rowvalue);
								user.setId((int) id);
							}
							if ("name".equals(row0.getCell(k).toString())) {
								user.setName(rowvalue);
							}
							if ("age".equals(row0.getCell(k).toString())) {
								double age = Double.valueOf(rowvalue);
								user.setAge((int) age);
							}
							if ("pwd".equals(row0.getCell(k).toString())) {
								double pwd = Double.valueOf(rowvalue);
								user.setPwd((int) pwd);
							}
							if ("sex".equals(row0.getCell(k).toString())) {
								double sex = Double.valueOf(rowvalue);
								user.setSex((int) sex);
							}
							if ("phone".equals(row0.getCell(k).toString())) {
								long phone = Math.round(row.getCell(k).getNumericCellValue());
								String phone1 = String.valueOf(phone);
								user.setPhone(phone1);
							}
							if ("addr".equals(row0.getCell(k).toString())) {
								user.setAddr(rowvalue);
							}
							if ("url".equals(row0.getCell(k).toString())) {
								user.setUrl(rowvalue);
							}
						}
					}
				}
				poiDaoImpl.addUser(user);
			}
		}
	}

	@Override
	public void testWrite(String url) {
		List<User> list = poiDaoImpl.queryAll();
		// TODO Auto-generated method stub
		// 创建Excel的工作书册 Workbook,对应到一个excel文档
		@SuppressWarnings("resource")
		HSSFWorkbook wb = new HSSFWorkbook();

		// 创建Excel的工作sheet,对应到一个excel文档的tab

		HSSFSheet sheet = wb.createSheet("User");

		HSSFRow row = sheet.createRow(0);
		row.setHeight((short) 500);// 设定行的高度
		HSSFCell cell1 = row.createCell(0);
		cell1.setCellValue("id");
		HSSFCell cell2 = row.createCell(1);
		cell2.setCellValue("name");
		HSSFCell cell3 = row.createCell(2);
		cell3.setCellValue("age");
		HSSFCell cell4 = row.createCell(3);
		cell4.setCellValue("pwd");
		HSSFCell cell5 = row.createCell(4);
		cell5.setCellValue("sex");
		HSSFCell cell6 = row.createCell(5);
		cell6.setCellValue("phone");
		HSSFCell cell7 = row.createCell(6);
		cell7.setCellValue("addr");
		HSSFCell cell8 = row.createCell(7);
		cell8.setCellValue("url");

		for (int i = 0; i < list.size(); i++) {
			// 创建Excel的sheet的一行
			HSSFRow rows = sheet.createRow(i + 1);
			rows.setHeight((short) 500);// 设定行的高度

			// 创建一个Excel的单元格
			HSSFCell cells1 = rows.createCell(0);
			cells1.setCellValue(list.get(i).getId());
			HSSFCell cells2 = rows.createCell(1);
			cells2.setCellValue(list.get(i).getName());
			HSSFCell cells3 = rows.createCell(2);
			cells3.setCellValue(list.get(i).getAge());
			HSSFCell cells4 = rows.createCell(3);
			cells4.setCellValue(list.get(i).getPwd());
			HSSFCell cells5 = rows.createCell(4);
			cells5.setCellValue(list.get(i).getSex());
			HSSFCell cells6 = rows.createCell(5);
			cells6.setCellValue(list.get(i).getPhone());
			HSSFCell cells7 = rows.createCell(6);
			cells7.setCellValue(list.get(i).getAddr());
			HSSFCell cells8 = rows.createCell(7);
			cells8.setCellValue(list.get(i).getUrl());
		}

		// 创建超链接
		/*
		 * HSSFHyperlink link = new HSSFHyperlink(HSSFHyperlink.LINK_URL);
		 * link.setAddress("http://www.baidu.com"); cell = row.createCell(1);
		 * cell.setCellValue("百度"); cell.setHyperlink(link);// 设定单元格的链接
		 */

		FileOutputStream os;
		try {
			os = new FileOutputStream(url);
			wb.write(os);
			os.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
