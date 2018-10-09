package com.hafidzcode.myservice_dicodingp5;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions and extra parameters.
 */

//todo to make intent service
//buat service baru dengan nama DicodingIntentService : klik kanan pada package utama project → New → Service → Service (Intent Service).
//unchecked include helper. Include helper akan menambahkan metode yang dapat membantu di dalam pembuatan services. Akan tetapi pada modul ini, kita tidak menggunakan metode tersebut.

//todo 1 (intent service)
public class DicodingIntentService extends IntentService {
    public static String EXTRA_DURATION = "extra_duration";
    public static final String TAG = "DicodingIntentService";
    public DicodingIntentService(){
        super("DicodingIntentService");
    }
    //Kode dibawah akan dijalankan pada thread terpisah secara asynchronous.
    //Jadi kita tidak membutuhkan lagi obyek AsyncTask seperti pada service sebelumnya.
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d(TAG, "onHandleIntent");
       if (intent != null){
           int duration = intent.getIntExtra(EXTRA_DURATION, 0);
           try {
               Thread.sleep(duration);
           }catch (InterruptedException e){
               e.printStackTrace();
               Thread.currentThread().interrupt();
           }

       }
    }
    //todo 2 (intent service)
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
    }

}
