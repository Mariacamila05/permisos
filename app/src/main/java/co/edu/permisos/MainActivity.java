package co.edu.permisos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.Manifest;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 100;
    private Button btnPermisos;
    private Button btnCheck;

    private TextView camera;
    private TextView ubucation;
    private TextView galeria;
    private TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        begin();

        btnCheck.setOnClickListener(this::statusPermisos);
    }

    private void statusPermisos(View view){
        String camara = null;
        String ubicacion = null;
        String galerias = null;

        info.setVisibility(View.INVISIBLE);
        int statusPermisosCamara = ContextCompat.checkSelfPermission(getApplicationContext(),Manifest.permission.CAMERA);
        int statusPermisosUbicacion = ContextCompat.checkSelfPermission(getApplicationContext(),Manifest.permission.ACCESS_COARSE_LOCATION);
        int statusPermisosGaleria = ContextCompat.checkSelfPermission(getApplicationContext(),Manifest.permission.READ_MEDIA_IMAGES);
        if(statusPermisosCamara == 0 )
        {
            camara = "Activida";
        }
        else
        {
            camara = "Desactivado";
        }
        if(statusPermisosUbicacion == 0 )
        {
            ubicacion = "Activida";
        }
        else
        {
            ubicacion = "Desactivado";
        }
        if(statusPermisosGaleria == 0 )
        {
            galerias = "Activida";
        }
        else
        {
            galerias = "Desactivado";
        }



        camera.setText("El estado del permiso de la camara es: " + camara);
        ubucation.setText("El estado permiso de la ubicación es : " + ubicacion);
        galeria.setText("El estado permiso de la Galeria es: " + galerias);
        btnCheck.setEnabled(true);

    }

    public void solicitarPermisos(View view){
        if(ActivityCompat.checkSelfPermission(getApplicationContext(),Manifest.permission.CAMERA )!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA},REQUEST_CODE);
        }
        if(ActivityCompat.checkSelfPermission(getApplicationContext(),Manifest.permission.ACCESS_COARSE_LOCATION )!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},REQUEST_CODE);
        }
        if(ActivityCompat.checkSelfPermission(getApplicationContext(),Manifest.permission.READ_MEDIA_IMAGES )!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_MEDIA_IMAGES},REQUEST_CODE);
        }

        info.setEnabled(false);
    }
    private void begin(){
        camera = findViewById(R.id.tvCamara);
        ubucation = findViewById(R.id.tvUbicacion);
        galeria = findViewById(R.id.tvGaleria);
        btnPermisos = findViewById(R.id.btnSolicitar);
        btnCheck = findViewById(R.id.btnVerificar);
        info = findViewById(R.id.tvInfo);
        btnCheck.setEnabled(true);
    }
}