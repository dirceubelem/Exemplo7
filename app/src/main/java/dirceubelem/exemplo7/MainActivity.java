package dirceubelem.exemplo7;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

import dirceubelem.exemplo7.dao.DAOEstado;
import dirceubelem.exemplo7.fw.DBHelper;
import dirceubelem.exemplo7.fw.SharedPreferencesHelper;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean existeBanco = SharedPreferencesHelper.read(this, "database", "created", false);

        if (!existeBanco) {

            DBHelper.createDataBase(new DBHelper.OnCreateDataBaseListener() {
                @Override
                public void onCreateDataBase(boolean success) {

                    SharedPreferencesHelper.write(MainActivity.this, "database", "created", true);

                }
            });

        }

        DAOEstado d = new DAOEstado(this);
        int q = d.quantidade();
        d.close();

        Toast.makeText(this, "Quantidade de estados: " + q, Toast.LENGTH_LONG).show();

    }
}
