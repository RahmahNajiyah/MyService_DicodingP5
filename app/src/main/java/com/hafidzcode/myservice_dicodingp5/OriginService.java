package com.hafidzcode.myservice_dicodingp5;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;

//todo 5 kelas service
//buat kelas service bernama OriginService dengan cara klik kanan pada package project → New → Service → Service.
//OriginService akan inherit (extends) kepada kelas Service.

public class OriginService extends Service {
    //todo 7
    public static final String ORIGIN_SERVICE = "OriginService";

    public OriginService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    //todo 8
    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Log.d(ORIGIN_SERVICE, "OriginService dijalankan");
        ProcessAsync mProcessAsync = new ProcessAsync();
        mProcessAsync.execute();
        return START_STICKY;
    }
    //todo 10
    //red > alt enter (implement method)
    //menambahkan sebuah inner class AsyncTask. Ia seakan-akan menjalankan sebuah proses secara
    //asynchronous dan mematikan/menghentikan dirinya sendiri dengan memanggil metode stopSelf().
    private class ProcessAsync extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(3000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return null;
        }

        //todo 11
        @Override
        protected void onPostExecute(Void aVoid){
            super.onPostExecute(aVoid);
            Log.d(ORIGIN_SERVICE, "StopService");
            stopSelf();
        }
    }
    //todo 12
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(ORIGIN_SERVICE, "onDestroy()");
    }
}
