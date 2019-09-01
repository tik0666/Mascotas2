package com.fcomurillo.mascotas;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.fcomurillo.mascotas.mail.GMailSender;


public class SendMail extends AsyncTask<GMailSender, Void, Void> {
    private ProgressDialog progressDialog;
    private Context context;
    private Contacto activity;


    public SendMail(Context context){
        this.context = context;
        this.activity = (Contacto) context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = ProgressDialog.show(context, context.getString(R.string.comentario_enviandose),
                context.getString(R.string.comentario_enviandose),
                false, false);
    }
    @Override
    protected Void doInBackground(GMailSender ...params) {
        int count = params.length;
        for(int i = 0; i < count; i++){
            try{
                params[i].sendMail();
            } catch (Exception e) {
                Log.e("SendMail", e.getMessage(), e);
            }

        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        //Dismissing the progress dialog
        progressDialog.dismiss();
        //Showing a success message
        Toast.makeText(context, context.getString(R.string.comentario_enviandose), Toast.LENGTH_LONG).show();
        activity.closeActivity();
    }
}
