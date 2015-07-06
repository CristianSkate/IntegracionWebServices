package cl.cmt.integracionwebservices.activity;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.concurrent.ExecutionException;

import cl.cmt.integracionwebservices.R;
import cl.cmt.integracionwebservices.clases.WSBackgroundConnection;


public class PrincipalActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        final EditText valor = (EditText)findViewById(R.id.txtValor);
        final TextView resultado = (TextView)findViewById(R.id.lblResultado);
        Button ftoc = (Button)findViewById(R.id.btnCelcius);
        Button ctof = (Button)findViewById(R.id.btnFarenhint);

        ctof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //Le doy resultado a mi label enviando el numero ingresado en el texto anterior
                    resultado.setText(""+new WSBackgroundConnection().execute("CtoF",valor.getText().toString()).get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });

        ftoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //Le doy resultado a mi label enviando el numero ingresado en el texto anterior
                resultado.setText("" + new WSBackgroundConnection().execute("FtoC",valor.getText().toString()).get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
