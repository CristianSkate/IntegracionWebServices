package cl.cmt.integracionwebservices.clases;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.AndroidHttpTransport;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * Created by Cristian on 30-06-2015.
 */
public class WSRequestor {

    public static SoapPrimitive getFCConversion (String valor) {
        final String SOAP_ACTION = "http://www.w3schools.com/webservices/FahrenheitToCelsius";
        final String METHOD_NAME = "FahrenheitToCelsius";
        final String NAMESPACE = "http://www.w3schools.com/webservices/";
        final String URL = "http://www.w3schools.com/webservices/tempconvert.asmx?wsdl";

        SoapObject request = new SoapObject (NAMESPACE, METHOD_NAME);

        // le paso el valor que recojí desde la variable valor
        request.addProperty("Fahrenheit", valor);
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope (SoapEnvelope.VER11);
        soapEnvelope.dotNet = true;
        soapEnvelope.setOutputSoapObject(request);
        AndroidHttpTransport aht = new AndroidHttpTransport (URL);

        try {
            // Llamamos al servicio, obtenemos un resultado de tipo SoapPrimitive
            // que contiene nuestra resputesta
            aht.call (SOAP_ACTION, soapEnvelope);
            SoapPrimitive resultString = (SoapPrimitive) soapEnvelope.getResponse();

            return resultString;

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    public static SoapPrimitive getCFConversion(String valor){
        final String SOAP_ACTION = "http://www.w3schools.com/webservices/CelsiusToFahrenheit";
        final String METHOD_NAME = "CelsiusToFahrenheit";
        final String NAMESPACE = "http://www.w3schools.com/webservices/";
        final String URL = "http://www.w3schools.com/webservices/tempconvert.asmx?wsdl";

        SoapObject request = new SoapObject (NAMESPACE, METHOD_NAME);

        // le paso el valor que recojí desde la variable valor
        request.addProperty("Celsius", valor);
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope (SoapEnvelope.VER11);
        soapEnvelope.dotNet = true;
        soapEnvelope.setOutputSoapObject(request);
        AndroidHttpTransport aht = new AndroidHttpTransport (URL);

        try {
            // Llamamos al servicio, obtenemos un resultado de tipo SoapPrimitive
            // que contiene nuestra resputesta
            aht.call (SOAP_ACTION, soapEnvelope);
            SoapPrimitive resultString = (SoapPrimitive) soapEnvelope.getResponse();

            return resultString;

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
