package com.example.projetopamii;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

 public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    double latitude, longitude;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap){
        double lat = Double.parseDouble(PrimeiraTela.mtxtlatitude.getText().toString());
        double log = Double.parseDouble(PrimeiraTela.mtxtlongitude.getText().toString());
        longitude = log;
        latitude =lat;

        mMap = googleMap;
        String local = "Está é a sua localização";


        // Add a marker in Sydney and move the camera
        LatLng etecia = new LatLng(latitude, longitude);

        mMap.addMarker(new MarkerOptions()
                .position(etecia)
                .snippet("Essa é a sua localização")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.local))

                .title(local));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(etecia, 12));


        CircleOptions circleOptions = new CircleOptions();

        circleOptions.center(etecia);
        circleOptions.fillColor(Color.argb(20, 255, 0, 0));
        circleOptions.strokeWidth(11);
        circleOptions.strokeColor(Color.argb(20, 255, 0, 0));
        circleOptions.radius(10000.00);
        mMap.addCircle(circleOptions);



    }
}