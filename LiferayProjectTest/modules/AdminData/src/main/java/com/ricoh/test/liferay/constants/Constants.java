package com.ricoh.test.liferay.constants;

public class Constants {
	
	// Spring API REST
	
	// Root service
	public static final String URL_ROOT = "http://localhost:9090/api";
	
	public static final String PARAMETER = "/{id}";
	
	// 'Coche' service
	public static final String URL_CAR = "/car";
	
	public static final String URL_SERVICE_COCHE_CREATE = URL_ROOT + URL_CAR;
	public static final String URL_SERVICE_COCHE_READ_ITEM = URL_ROOT + URL_CAR + PARAMETER;
	public static final String URL_SERVICE_COCHE_READ_ITEMS = URL_ROOT + URL_CAR + "/listAll";
	public static final String URL_SERVICE_COCHE_UPDATE = URL_ROOT + URL_CAR + "/update";
	public static final String URL_SERVICE_COCHE_DELETE = URL_ROOT + URL_CAR + "/delete" + PARAMETER;
	
	// 'Marca' service
	public static final String URL_MARCA = "/branch";
	
	public static final String URL_MARCA_ITEM = URL_ROOT + URL_MARCA + PARAMETER + "/models";
	
	
	// Connection methods
	public static final String GET = "GET";
	public static final String POST = "POST";
	public static final String PUT = "PUT";
	public static final String DELETE = "DELETE";
	
	
	// JSPs
	public static final String ALTA_COCHE = "/altaCoche.jsp";
	public static final String EDITAR_COCHE = "/editarCoche.jsp";
	public static final String VISTA_COCHE = "/view.jsp";
	
	
	// Render
	public static final String RENDER_ALTA_COCHE = "alta-coche-action";
	public static final String RENDER_EDITAR_COCHE = "editar-coche-action";
	public static final String RENDER_ELIMINAR_COCHE = "eliminar-coche-action";
	
	
	// Objects parameters
	
	// 'Coche'
	public static final String COCHE_PARAM_IDCOCHE = "idCoche";
	public static final String COCHE_PARAM_MODELO = "modelo";
	public static final String COCHE_PARAM_CV = "cv";
	public static final String COCHE_PARAM_PRECIO = "precio";
	public static final String COCHE_PARAM_MARCA = "marca";
	
	// 'Marca'
	public static final String MARCA_PARAM_IDMARCA = "idMarca";
	public static final String MARCA_PARAM_NOMBRE = "nombre";
	public static final String MARCA_PARAM_ANIOFUNDACION = "aniofundacion";
	public static final String MARCA_PARAM_NACIONALIDAD = "nacionalidad";
	public static final String MARCA_PARAM_COCHES = "coches";
	
	
	// Requests
	public static final String REQUEST_PROPERTY_KEY = "Accept";
	public static final String REQUEST_PROPERTY_VALUE = "application/json";
	public static final String REQUEST_PROPERTY_CONTENT = "Content-Type";
	public static final String REQUEST_CHARSET = "utf-8";
	
	
	// Date formats
	public static final String DATE_FORMAT_Y_M_D = "yyyy-MM-dd";
}
