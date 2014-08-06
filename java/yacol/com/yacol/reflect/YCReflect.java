package com.yacol.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/**
 * 反射类处理的工具方法
 * @author CHY
 *
 */
public class YCReflect {

	@SuppressWarnings("rawtypes")
	public static Object getProperty(Object object,String fieldName){
		Object result = null ;
		if(object==null) return result ;
		Class clazz = object.getClass() ;
		Field field;
		try {
			field = clazz.getDeclaredField(fieldName);
			field.setAccessible(true);
			result = field.get(object) ;
		} catch (NoSuchFieldException e) {
			try {
				throw e ;
			} catch (NoSuchFieldException e1) {
				e1.printStackTrace();
			}
		} catch (SecurityException e) {
			throw e ;
		}catch (IllegalArgumentException e) {
			throw e ;
		} catch (IllegalAccessException e) {
			try {
				throw e ;
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		}
		return result ;
	}
	
	@SuppressWarnings("rawtypes")
	public static void setProperty(Object object,String fieldName,Object filedValue){
		if(object==null) return ;
		Class clazz = object.getClass() ;
		Field field;
		try {
			field = clazz.getDeclaredField(fieldName);
			field.setAccessible(true);
			field.set(object, filedValue); 
		} catch (NoSuchFieldException e) {
			try {
				throw e ;
			} catch (NoSuchFieldException e1) {
				e1.printStackTrace();
			}
		} catch (SecurityException e) {
			throw e ;
		}catch (IllegalArgumentException e) {
			throw e ;
		} catch (IllegalAccessException e) {
			try {
				throw e ;
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	
	public static Object getMethodResult(Object object,String methodName,Object... params){
		Object result = null ;
		if(object==null) return result ;
		Class<? extends Object> clazz = object.getClass() ;
		Class<?> paramsClass[] = null ;
		if(params!=null&&params.length>0) {
			int length = params.length ;
			paramsClass = new Class[params.length] ;
			for(int i=0;i<length;i++) {
				paramsClass[i] = params[i].getClass() ;
			}
		}
		Method method = null;
		try {
			method = clazz.getMethod(methodName, paramsClass);
			result = method.invoke(object, params) ;
		} catch (NoSuchMethodException e) {
			try {
				throw e ;
			} catch (NoSuchMethodException e1) {
				e1.printStackTrace();
			}
		}
		catch (SecurityException e) {
			throw e ;
		}
		catch (IllegalAccessException e) {
			try {
				throw e ;
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		}
		catch (IllegalArgumentException e) {
			throw e ;
		}
		catch (InvocationTargetException e) {
			try {
				throw e ;
			} catch (InvocationTargetException e1) {
				e1.printStackTrace();
			}
		}
		return result ;
	}
	
	public static Object getProperty(String className,String fieldName) {
		Object result = null ;
		Object object;
		try {
			object = Class.forName(className).newInstance();
			result = getProperty(object,fieldName) ;
		} catch (InstantiationException e) {
			try {
				throw e ;
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			}
		} catch (IllegalAccessException e) {
			try {
				throw e ;
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			try {
				throw e ;
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		}
		return result ;
	}
	public static Object getMethodResult(String className,String methodName,Object... params){
		Object result = null ;
		Object object;
		try {
			object = Class.forName(className).newInstance();
			result = getMethodResult(object, methodName, params) ;
		} catch (InstantiationException e) {
			try {
				throw e ;
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			}
		} catch (IllegalAccessException e) {
			try {
				throw e ;
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			try {
				throw e ;
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		}
		return result ;
	}
}
