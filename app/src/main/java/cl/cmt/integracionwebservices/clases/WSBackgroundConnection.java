package cl.cmt.integracionwebservices.clases;

import android.os.AsyncTask;
import org.ksoap2.serialization.SoapPrimitive;

/**
 * Created by Cristian on 30-06-2015.
 */
public class WSBackgroundConnection extends AsyncTask<String, Void, SoapPrimitive> {

    @Override
    protected SoapPrimitive doInBackground(String... params) {
        //Recibo los parametros enviados desde el execute()
        String opcion = params[0];
        String valor = params[1];
        //Valido opcion y mando a pedir la conversion
        if(opcion.equals("FtoC")){
            return WSRequestor.getFCConversion(valor);
        }
        else
        {
            if(opcion.equals("CtoF")){
                return WSRequestor.getCFConversion(valor);
            }
            else{
                return null;
            }
        }

    }
}
