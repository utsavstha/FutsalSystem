package Utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by utsav on 8/25/2015.
 */
public class T {
    String message;
    Context context;
    public void showS(Context context,String message){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }
    public void showL(Context context,String message){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }
}
