package com.yacol.reflect;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.yacol.sql.util.ResultSetUtil;

public class YCReflectDB {

	@SuppressWarnings("rawtypes")
	public Object get(Object object,Map<String,String> fieldRefCols,ResultSet rs) {
		if(object==null) return object ;
		try {
			Class clazz = object.getClass() ;
			Field fields[] = null ;
			fields = clazz.getDeclaredFields() ;
			if(fieldRefCols==null) {
				fieldRefCols = new HashMap<String,String>() ;
				Set<String> set = ResultSetUtil.getColumnNameSet(rs) ;
				if(set!=null&&set.size()>0) {
					for(String columnName : set) {
						fieldRefCols.put(columnName, columnName) ;
					}
				}
			}
			for(Field field : fields) {
				String name = field.getName() ;
				String key = null ;
				for(String keyTmp : fieldRefCols.keySet()) {
					if(fieldRefCols.get(keyTmp).equals(name)) {
						key = keyTmp ;
						break ;
					}
				}
				if(key!=null&&"".equals(key)) {
					field.setAccessible(true);
					Class classType = field.getType() ;
					Object objValue = null ;
					if(classType == byte.class||classType == Byte.class) {
						objValue = rs.getByte(key) ;
					}else if(classType == int.class||classType == Integer.class||classType == short.class || classType == Short.class ) {
						objValue = rs.getInt(key) ;
					}else if(classType == float.class||classType == Float.class) {
						objValue = rs.getFloat(key) ;
					}else if(classType == double.class||classType == Double.class) {
						objValue = rs.getDouble(key) ;
					}else if(classType == long.class||classType == Long.class) {
						objValue = rs.getLong(key) ;
					}else if(classType == char.class||classType == Character.class) {
						objValue = rs.getString(key) ;
					}else if(classType == boolean.class||classType == Boolean.class) {
						objValue = rs.getBoolean(key) ;
					}else if(classType == Date.class) {//此处需要将java.sql.Date转换为java.util.Date
						objValue = rs.getDate(key) ;
					}else  if(classType == String.class) {
						objValue = rs.getString(key) ;
					}else {
						objValue = rs.getObject(key) ;
					}
					YCReflect.setProperty(object, name, objValue);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return object ;
	}
}
