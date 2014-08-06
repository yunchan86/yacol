package com.yacol.sql.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashSet;
import java.util.Set;

public class ResultSetUtil {

	public static Set<String> getColumnNameSet(ResultSet rs) {
		Set<String> set = new HashSet<String>() ;
		try {
			ResultSetMetaData rsmd = rs.getMetaData() ;
			int count = rsmd.getColumnCount();
			for(int i=1;i<=count;i++) {
				set.add(rsmd.getCatalogName(i)) ;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return set ;
	}
}
