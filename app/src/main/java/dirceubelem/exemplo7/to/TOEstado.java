package dirceubelem.exemplo7.to;

import android.content.ContentValues;
import android.database.Cursor;

/**
 * Created by dirceubelem on 10/06/15.
 */
public class TOEstado extends TOBase {

    public static String TABLE = "estado";
    public static String[] COLUMNS = {"estado"};
    private String estado;

    public TOEstado(Cursor cursor) {
        super();

        this.estado = cursor.getString(0);

    }

    public TOEstado() {
        super();
    }

    public ContentValues getContentValues(boolean key) {
        ContentValues values = new ContentValues();
        values.put(COLUMNS[0], this.getEstado());
        return values;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
