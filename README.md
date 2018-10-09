# MyService_DicodingP5
simply service and intent service trial


SERVICE SEDERHANA
berkenalan dengan service melalui kelas OriginService. Kita inherit kelas dasar dari service seperti yang dijelaskan sebelumnya. Service jenis ini berada pada thread yang sama yaitu ui thread.
Service di atas dijalankan dengan cara berikut ini :

Intent mStartServiceIntent = new Intent(MainActivity.this, OriginService.class);
startService(mStartServiceIntent);
Ingat! Bukan startActivity() seperti pada contoh sebelumnya. Namun startService() karena kita menginginkan sebuah service yang berjalan. Setelah dijalankan, metode onStartCommand() pada OriginService akan dijalankan.

@Override
   public int onStartCommand(Intent intent, int flags, int startId) {
       Log.d(ORIGIN_SERVICE, "OriginService dijalankan");
       ProcessAsync mProcessAsync = new ProcessAsync();
       mProcessAsync.execute();
       return START_STICKY;
   }
Pada metode tersebut, kita menjalankan sebuah thread asynctask untuk melakukan proses yang menyerupai proses yang sulit. Dan ia berjalan secara asynchronous. 

Kekurangan dari service tipe ini adalah tidak menyediakan worker thread diluar ui thread secara default. Jadi tidak ada cara lain, selain membuat thread secara sendiri.

> START_STICKY menandakan bahwa bila service tersebut dimatikan oleh sistem Android karena kekurangan memori, maka ia akan diciptakan kembali jika sudah ada memori yang bisa digunakan. Metode onStartCommand() juga akan dijalankan kembali.

> Pada method onPostExecute() akan memanggil stopSelf() yang berarti akan memberhentikan atau mematikan OriginService dari sistem Android.

- Klik tombol ‘start service’ dan perhatikan pada log-nya. OriginService telah dijalankan dan tidak akan pernah mati sampai dimatikan oleh sistem atau metode stopSelf() atau stopService() dijalankan.
- tambahkan sebuah inner class AsyncTask. Ia seakan-akan menjalankan sebuah proses secara asynchronous dan mematikan/menghentikan dirinya sendiri dengan memanggil metode stopSelf().
- Klik tombol ‘start service’ dan perhatikan log-nya. Service dijalankan secara asynchronous dan mematikan dirinya sendiri setelah proses selesai.
- Jika berhasil dijalankan, pada log androiod monitor akan seperti ini :
HASIL PADA LOG KETIKA TOMBOL START SERVICE DIKLIK 
09-22 09:52:25.028 10209-10209/com.dicoding.myserviceapp D/OriginService: OriginService dijalankan
09-22 09:52:28.074 10209-10209/com.dicoding.myserviceapp D/OriginService: StopService
09-22 09:52:28.078 10209-10209/com.dicoding.myserviceapp D/OriginService: onDestroy()

INTENT SERVICE
IntentService tidak perlu mematikan dirinya sendiri. Service ini akan berhenti dengan sendirinya ketika sudah menjalankan tugasnya.
HASIL KETIKA TOMBOL INTENT SERVICE DIKLIK, PERHATIKAN PADA LOG
09-22 10:32:25.555 10209-28872/com.dicoding.myserviceapp D/DicodingIntentService: onHandleIntent()
09-22 10:32:30.557 10209-10209/com.dicoding.myserviceapp D/DicodingIntentService: onDestroy()

