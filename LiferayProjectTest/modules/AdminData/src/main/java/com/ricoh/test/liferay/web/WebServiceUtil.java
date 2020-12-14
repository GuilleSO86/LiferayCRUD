package com.ricoh.test.liferay.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.ricoh.test.liferay.constants.Constants;
import com.ricoh.test.liferay.entities.Coche;
import com.ricoh.test.liferay.entities.Marca;

public class WebServiceUtil {
		
	/**
	 * Calls the url service.
	 * 
	 * @param url
	 * @param method
	 * @return
	 */
	private static String requestWebService(String url, String jsonData, String method) {
		
		StringBuilder stringBuilder = new StringBuilder();
		
		if (method.equals(Constants.GET) || method.equals(Constants.DELETE)) {
			
			stringBuilder = requestWebServiceForGetDelete(url, method);
			
		} else {
			stringBuilder = requestWebServiceForPostPut(url, jsonData, method);
		}
		
		return stringBuilder.toString();
	}
	
	/**
	 * Method for GET and DELETE web service.
	 * 
	 * @param url
	 * @param method
	 * @return
	 */
	private static StringBuilder requestWebServiceForGetDelete(String url, String method) {
		
		StringBuilder stringBuilder = new StringBuilder();
		
		try {
			URL urlVal = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) urlVal.openConnection();
			
			connection.setRequestMethod(method);
			connection.setRequestProperty(Constants.REQUEST_PROPERTY_KEY, Constants.REQUEST_PROPERTY_VALUE);
			connection.setDoOutput(true);
			
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			int c;
			while ((c = bufferedReader.read()) != -1) {
				stringBuilder.append((char) c);
			}
			
		} catch (IOException ioException) {
			
			_log.error("Problem reading/writing on the stream.", ioException);
		}
		
		_log.info("The 'requestWebServiceForGetDelete' method got the following resoult: " + stringBuilder.toString());
		
		return stringBuilder;
	}
	
	/**
	 * Method for POST and PUT web service.
	 * 
	 * @param urlDomain
	 * @param jsonData
	 * @param method
	 * @return
	 */
	private static StringBuilder requestWebServiceForPostPut(String urlDomain, String jsonData, String method) {
		
		StringBuilder stringBuilder = new StringBuilder();
		
		try {
			URL urlVal = new URL(urlDomain);
			HttpURLConnection connection = (HttpURLConnection) urlVal.openConnection();
			
			connection.setRequestMethod(method);
			connection.setRequestProperty(Constants.REQUEST_PROPERTY_CONTENT, Constants.REQUEST_PROPERTY_VALUE);
			connection.setRequestProperty(Constants.REQUEST_PROPERTY_KEY, Constants.REQUEST_PROPERTY_VALUE);
			connection.setDoOutput(true);
			
			try(OutputStream outputStream = connection.getOutputStream()) {
				byte[] input = jsonData.getBytes(Constants.REQUEST_CHARSET);
				outputStream.write(input, 0, input.length);
				outputStream.flush();
				outputStream.close();
			}
			
			try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
				String responseLine = null;
				while ((responseLine = bufferedReader.readLine()) != null) {
					stringBuilder.append(responseLine.trim());
				}
			}
			
		} catch (IOException ioException) {
			
			_log.error("Problem reading/writing on the stream.", ioException);
		}
		
		_log.info("The 'requestWebServiceForPostPut' method got the following resoult: " + stringBuilder.toString());
		
		return stringBuilder;
	}
	
	/**
	 * Set the requested item to service url.
	 * 
	 * @param url
	 * @param item
	 * @return
	 */
	private static String setItemOnURL(String url, Integer item) {
		
		String urlFinal = StringUtil.replace(url, Constants.PARAMETER.substring(1), item.toString());
		
		_log.info("The 'setItemOnURL' returns: " + urlFinal);
		
		return urlFinal;
	}
	
	/**
	 * Conversion from string to json object.
	 * 
	 * @param data
	 * @return
	 */
	public static JSONObject stringObjectDataToJsonObject(String data) {
		
		JSONObject jsonObjectData = null;
		
		try {
			jsonObjectData = JSONFactoryUtil.createJSONObject(data);
			
		} catch (JSONException jsonException) {
			
			_log.error("Fail to create a json object", jsonException);
		}
		
		_log.info("The 'stringObjectDataToJsonObject' method produced: " + jsonObjectData);
		
		return jsonObjectData;
	}
	
	/**
	 * Conversion from string array data to json array object.
	 * 
	 * @param arrayData
	 * @return
	 */
	public static JSONArray stringArrayObjectsDataToJsonArrayObject(String arrayData) {
		
		JSONArray jsonArrayData = null;
		
		try {
			jsonArrayData = JSONFactoryUtil.createJSONArray(arrayData);
			
		} catch (JSONException jsonException) {

			_log.error("Fail to create a json array object", jsonException);
		}
		
		_log.info("The 'stringArrayObjectsDataToJsonArrayObject' methos produced: " + jsonArrayData);
		
		return jsonArrayData;
	}
	
	/**
	 * Conversion from json object to 'Marca' object.
	 * 
	 * @param jsonMarca
	 * @return
	 */
	public static Marca jsonToMarca(JSONObject jsonMarca) {
		
		Marca marca = new Marca();
		
		marca.setIdMarca(jsonMarca.getInt(Constants.MARCA_PARAM_IDMARCA));
		marca.setNombre(jsonMarca.getString(Constants.MARCA_PARAM_NOMBRE));
		
		Date fechaSql = Date.valueOf((jsonMarca.getString(Constants.MARCA_PARAM_ANIOFUNDACION)).substring(0, 10));
		java.util.Date fechaUtil = new java.util.Date(fechaSql.getTime());
		DateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT_Y_M_D);
		
		marca.setAniofundacion(dateFormat.format(fechaUtil));
		marca.setNacionalidad(jsonMarca.getString(Constants.MARCA_PARAM_NACIONALIDAD));
		
		_log.info("The 'jsonToMarca' method produced: " + marca.toString());
		
		return marca;
	}
	
	/**
	 * Conversion from json object to 'Coche' object.
	 * 
	 * @param jsonCoche
	 * @return
	 */
	public static Coche jsonToCoche(JSONObject jsonCoche) {
		
		Coche coche = new Coche();
		
		coche.setIdCoche(jsonCoche.getInt(Constants.COCHE_PARAM_IDCOCHE));
		coche.setModelo(jsonCoche.getString(Constants.COCHE_PARAM_MODELO));
		coche.setCv(jsonCoche.getInt(Constants.COCHE_PARAM_CV));
		coche.setPrecio(jsonCoche.getDouble(Constants.COCHE_PARAM_PRECIO));
		coche.setMarca(jsonToMarca((JSONObject) jsonCoche.get(Constants.COCHE_PARAM_MARCA)));
		
		_log.info("The 'jsonToCoche' method produced: " + coche.toString());
		
		return coche;
	}
	
	
	/**
	 * Inserts the given car object (json string).
	 * 
	 * @param coche
	 * @return
	 */
	public static String insertCar(String jsonCoche) {
		
		_log.info("Inserting '" + jsonCoche.toString() + "'");
		
		return requestWebService(Constants.URL_SERVICE_COCHE_CREATE, jsonCoche, Constants.POST);
	}
	
	/**
	 * Returns the required car object.
	 * 
	 * @param item
	 * @return
	 */
	public static String getCarById(Integer item) {
		
		_log.info("The 'getCarById' is returning a car with ID " + item.toString());
		
		return requestWebService(setItemOnURL(Constants.URL_SERVICE_COCHE_READ_ITEM, item), null, Constants.GET);
	}
	
	/**
	 * Returns all the cars stored in data base.
	 * 
	 * @return
	 */
	public static String getCars() {
		
		_log.info("Getting all cars");
		
		return requestWebService(Constants.URL_SERVICE_COCHE_READ_ITEMS, null, Constants.GET);
	}
	
	/**
	 * Update specified car object data.
	 * 
	 * @param coche
	 * @return
	 */
	public static String updateCar(String jsonCoche) {
		
		_log.info("Updating '" + jsonCoche.toString() + "'");
		
		return requestWebService(Constants.URL_SERVICE_COCHE_UPDATE, jsonCoche, Constants.PUT);
	}
	
	/**
	 * Deletes the given car object of ID 'item'.
	 * 
	 * @param item
	 * @return
	 */
	public static String deleteCar(Integer item) {
		
		_log.info("Deleting car with item " + item.toString());
		
		return requestWebService(setItemOnURL(Constants.URL_SERVICE_COCHE_DELETE, item), null, Constants.DELETE);
	}
	
	/**
	 * Returns the required 'marca' object.
	 * 
	 * @param item
	 * @return
	 */
	public static String getMarcaById(Integer item) {
		
		_log.info("Getting the 'Marca' object with ID " + item.toString());
		
		return requestWebService(setItemOnURL(Constants.URL_MARCA_ITEM, item), null, Constants.GET);
	}
	
	
	
	private static final Log _log = LogFactoryUtil.getLog(WebServiceUtil.class);
}
