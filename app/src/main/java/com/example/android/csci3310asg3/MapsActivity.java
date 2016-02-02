package com.example.android.csci3310asg3;

import android.speech.tts.TextToSpeech;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ArrayList<MyMarker> mMyMarkersArray = new ArrayList<MyMarker>();
    private HashMap<Marker, MyMarker> mMarkersHashMap;
    private ArrayList<String> mCCTVPic = new ArrayList<String>();
    private ArrayList<String> mCCTVDesc = new ArrayList<String>();
    private TextToSpeech t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.US);
                    //t1.setLanguage(Locale.CHINESE);
                }
            }
        });

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        initCCTVDesc();
        initCCTVPic();

        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(-34, 151);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));

        LatLng TKO = new LatLng(22.320591452, 114.254794525);
        mMap.addMarker(new MarkerOptions().position(TKO).title("Marker in TKO"));

        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(TKO));




        // Initialize the HashMap for Markers and MyMarker object
        mMarkersHashMap = new HashMap<Marker, MyMarker>();
        /*
        mMyMarkersArray.add(new MyMarker("Brasil", "icon1", Double.parseDouble("-28.5971788"), Double.parseDouble("-52.7309824")));
        mMyMarkersArray.add(new MyMarker("United States", "icon2", Double.parseDouble("33.7266622"), Double.parseDouble("-87.1469829")));
        mMyMarkersArray.add(new MyMarker("Canada", "icon3", Double.parseDouble("51.8917773"), Double.parseDouble("-86.0922954")));
        mMyMarkersArray.add(new MyMarker("England", "icon4", Double.parseDouble("52.4435047"), Double.parseDouble("-3.4199249")));
        mMyMarkersArray.add(new MyMarker("España", "icon5", Double.parseDouble("41.8728262"), Double.parseDouble("-0.2375882")));
        mMyMarkersArray.add(new MyMarker("Portugal", "icon6", Double.parseDouble("40.8316649"), Double.parseDouble("-4.936009")));
        mMyMarkersArray.add(new MyMarker("Deutschland", "icon7", Double.parseDouble("51.1642292"), Double.parseDouble("10.4541194")));
        mMyMarkersArray.add(new MyMarker("Atlantic Ocean", "icondefault", Double.parseDouble("-13.1294607"), Double.parseDouble("-19.9602353")));
        */

        // https://www.geodetic.gov.hk/smo/tform/tform.aspx
        mMyMarkersArray.add(new MyMarker("0", "0", Double.parseDouble("22.286175065"), Double.parseDouble("114.155448639")));
        mMyMarkersArray.add(new MyMarker("1", "1", Double.parseDouble("22.281298756"), Double.parseDouble("114.157302717")));
        mMyMarkersArray.add(new MyMarker("2", "2", Double.parseDouble("22.279899072"), Double.parseDouble("114.157846293")));
        mMyMarkersArray.add(new MyMarker("3", "3", Double.parseDouble("22.279619524"), Double.parseDouble("114.1616694")));
        mMyMarkersArray.add(new MyMarker("4", "4", Double.parseDouble("22.286617454"), Double.parseDouble("114.154614053")));
        mMyMarkersArray.add(new MyMarker("5", "5", Double.parseDouble("22.281582735"), Double.parseDouble("114.132044844")));
        mMyMarkersArray.add(new MyMarker("6", "6", Double.parseDouble("22.27781664"), Double.parseDouble("114.130901078")));
        mMyMarkersArray.add(new MyMarker("7", "7", Double.parseDouble("22.277569336"), Double.parseDouble("114.159350585")));
        mMyMarkersArray.add(new MyMarker("8", "8", Double.parseDouble("22.277660367"), Double.parseDouble("114.168452068")));
        mMyMarkersArray.add(new MyMarker("9", "9", Double.parseDouble("22.279981258"), Double.parseDouble("114.184860119")));
        mMyMarkersArray.add(new MyMarker("10", "10", Double.parseDouble("22.280676798"), Double.parseDouble("114.174400008")));
        mMyMarkersArray.add(new MyMarker("11", "11", Double.parseDouble("22.281516579"), Double.parseDouble("114.182123862")));
        mMyMarkersArray.add(new MyMarker("12", "12", Double.parseDouble("22.275005569"), Double.parseDouble("114.178067803")));
        mMyMarkersArray.add(new MyMarker("13", "13", Double.parseDouble("22.275023619"), Double.parseDouble("114.179144826")));
        mMyMarkersArray.add(new MyMarker("14", "14", Double.parseDouble("22.279936264"), Double.parseDouble("114.173235631")));
        mMyMarkersArray.add(new MyMarker("15", "15", Double.parseDouble("22.281525656"), Double.parseDouble("114.180445182")));
        mMyMarkersArray.add(new MyMarker("16", "16", Double.parseDouble("22.279520836"), Double.parseDouble("114.181172871")));
        mMyMarkersArray.add(new MyMarker("17", "17", Double.parseDouble("22.279557011"), Double.parseDouble("114.175418865")));
        mMyMarkersArray.add(new MyMarker("18", "18", Double.parseDouble("22.281805002"), Double.parseDouble("114.191283856")));
        mMyMarkersArray.add(new MyMarker("19", "19", Double.parseDouble("22.290473991"), Double.parseDouble("114.195389526")));
        mMyMarkersArray.add(new MyMarker("20", "20", Double.parseDouble("22.2508033"), Double.parseDouble("114.170752859")));
        mMyMarkersArray.add(new MyMarker("21", "21", Double.parseDouble("22.248409532"), Double.parseDouble("114.161178006")));
        mMyMarkersArray.add(new MyMarker("22", "22", Double.parseDouble("22.247614817"), Double.parseDouble("114.161013177")));
        mMyMarkersArray.add(new MyMarker("23", "23", Double.parseDouble("22.248462331"), Double.parseDouble("114.150458314")));
        mMyMarkersArray.add(new MyMarker("24", "24", Double.parseDouble("22.29416619"), Double.parseDouble("114.204667253")));
        mMyMarkersArray.add(new MyMarker("25", "25", Double.parseDouble("22.291112484"), Double.parseDouble("114.21168265")));
        mMyMarkersArray.add(new MyMarker("26", "26", Double.parseDouble("22.288256612"), Double.parseDouble("114.220725898")));
        mMyMarkersArray.add(new MyMarker("27", "27", Double.parseDouble("22.275926651"), Double.parseDouble("114.180804048")));
        mMyMarkersArray.add(new MyMarker("28", "28", Double.parseDouble("22.280270387"), Double.parseDouble("114.18086239")));
        mMyMarkersArray.add(new MyMarker("29", "29", Double.parseDouble("22.343040612"), Double.parseDouble("114.053820841")));
        mMyMarkersArray.add(new MyMarker("30", "30", Double.parseDouble("22.337981836"), Double.parseDouble("114.040458415")));
        mMyMarkersArray.add(new MyMarker("31", "31", Double.parseDouble("22.377782513"), Double.parseDouble("114.184205438")));
        mMyMarkersArray.add(new MyMarker("32", "32", Double.parseDouble("22.381015273"), Double.parseDouble("114.166397033")));
        mMyMarkersArray.add(new MyMarker("33", "33", Double.parseDouble("22.377907451"), Double.parseDouble("114.199993939")));
        mMyMarkersArray.add(new MyMarker("34", "34", Double.parseDouble("22.389086688"), Double.parseDouble("114.203559651")));
        mMyMarkersArray.add(new MyMarker("35", "35", Double.parseDouble("22.371199392"), Double.parseDouble("114.179942596")));
        mMyMarkersArray.add(new MyMarker("36", "36", Double.parseDouble("22.384717545"), Double.parseDouble("114.190527334")));
        mMyMarkersArray.add(new MyMarker("37", "37", Double.parseDouble("22.389972633"), Double.parseDouble("114.196975859")));
        mMyMarkersArray.add(new MyMarker("38", "38", Double.parseDouble("22.421130319"), Double.parseDouble("114.227100432")));
        mMyMarkersArray.add(new MyMarker("39", "39", Double.parseDouble("22.427175918"), Double.parseDouble("114.24074028")));
        mMyMarkersArray.add(new MyMarker("40", "40", Double.parseDouble("22.412049502"), Double.parseDouble("114.212645127")));
        mMyMarkersArray.add(new MyMarker("41", "41", Double.parseDouble("22.43844836"), Double.parseDouble("114.19645828")));
        mMyMarkersArray.add(new MyMarker("42", "42", Double.parseDouble("22.445195304"), Double.parseDouble("114.177224126")));
        mMyMarkersArray.add(new MyMarker("43", "43", Double.parseDouble("22.376228764"), Double.parseDouble("113.960091421")));
        mMyMarkersArray.add(new MyMarker("44", "44", Double.parseDouble("22.388411381"), Double.parseDouble("113.967326443")));
        mMyMarkersArray.add(new MyMarker("45", "45", Double.parseDouble("22.35998279"), Double.parseDouble("114.081971097")));
        mMyMarkersArray.add(new MyMarker("46", "46", Double.parseDouble("22.370480976"), Double.parseDouble("114.074856635")));
        mMyMarkersArray.add(new MyMarker("47", "47", Double.parseDouble("22.37400884"), Double.parseDouble("114.102352055")));
        mMyMarkersArray.add(new MyMarker("48", "48", Double.parseDouble("22.371286293"), Double.parseDouble("114.077429079")));
        mMyMarkersArray.add(new MyMarker("49", "49", Double.parseDouble("22.369315718"), Double.parseDouble("114.060963315")));
        mMyMarkersArray.add(new MyMarker("50", "50", Double.parseDouble("22.357875128"), Double.parseDouble("114.019449046")));
        mMyMarkersArray.add(new MyMarker("51", "51", Double.parseDouble("22.382468593"), Double.parseDouble("113.981162801")));
        mMyMarkersArray.add(new MyMarker("52", "52", Double.parseDouble("22.339071447"), Double.parseDouble("114.131677042")));
        mMyMarkersArray.add(new MyMarker("53", "53", Double.parseDouble("22.473225418"), Double.parseDouble("114.05566895")));
        mMyMarkersArray.add(new MyMarker("54", "54", Double.parseDouble("22.49275587"), Double.parseDouble("114.064981232")));
        mMyMarkersArray.add(new MyMarker("55", "55", Double.parseDouble("22.502176213"), Double.parseDouble("114.081602288")));


        plotMarkers(mMyMarkersArray);



        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(com.google.android.gms.maps.model.Marker marker) {
                marker.showInfoWindow();
                //Toast.makeText(getApplicationContext(), "Oh Boy", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    private void plotMarkers(ArrayList<MyMarker> markers)
    {
        if(markers.size() > 0)
        {
            int i = 0;
            for (MyMarker myMarker : markers)
            {

                // Create user marker with custom icon and other options
                MarkerOptions markerOption = new MarkerOptions().position(new LatLng(myMarker.getmLatitude(), myMarker.getmLongitude()));
                markerOption.icon(BitmapDescriptorFactory.fromResource(R.drawable.abc));

                markerOption.icon(BitmapDescriptorFactory.fromResource(getApplicationContext().getResources()
                    .getIdentifier("i" + i, "drawable", getApplicationContext().getPackageName())));

                Marker currentMarker = mMap.addMarker(markerOption);
                mMarkersHashMap.put(currentMarker, myMarker);

                mMap.setInfoWindowAdapter(new MarkerInfoWindowAdapter());
                i = i + 1;
            }
        }
    }


    private void initCCTVPic() {
        String prefix = "http://tdcctv.data.one.gov.hk/";
        mCCTVPic.add(0, prefix + "H106F.JPG");
        mCCTVPic.add(1, prefix + "H107F.JPG");
        mCCTVPic.add(2, prefix + "H108F.JPG");
        mCCTVPic.add(3, prefix + "H109F.JPG");
        mCCTVPic.add(4, prefix + "H110F.JPG");
        mCCTVPic.add(5, prefix + "H130F.JPG");
        mCCTVPic.add(6, prefix + "H132F2F.JPG");
        mCCTVPic.add(7, prefix + "H138F.JPG");
        mCCTVPic.add(8, prefix + "H201F.JPG");
        mCCTVPic.add(9, prefix + "H203F.JPG");
        mCCTVPic.add(10, prefix + "H204F.JPG");
        mCCTVPic.add(11, prefix + "H207F.JPG");
        mCCTVPic.add(12, prefix + "H209F.JPG");
        mCCTVPic.add(13, prefix + "H210F.JPG");
        mCCTVPic.add(14, prefix + "H214F.JPG");
        mCCTVPic.add(15, prefix + "H215F.JPG");
        mCCTVPic.add(16, prefix + "H216F.JPG");
        mCCTVPic.add(17, prefix + "H222F.JPG");
        mCCTVPic.add(18, prefix + "H305F.JPG");
        mCCTVPic.add(19, prefix + "H307F.JPG");
        mCCTVPic.add(20, prefix + "H401F.JPG");
        mCCTVPic.add(21, prefix + "H422F1.JPG");
        mCCTVPic.add(22, prefix + "H422F2.JPG");
        mCCTVPic.add(23, prefix + "H429F.JPG");
        mCCTVPic.add(24, prefix + "H801F.JPG");
        mCCTVPic.add(25, prefix + "H802F.JPG");
        mCCTVPic.add(26, prefix + "H803F.JPG");
        mCCTVPic.add(27, prefix + "H903F.JPG");
        mCCTVPic.add(28, prefix + "H904F.JPG");
        mCCTVPic.add(29, prefix + "TC551F.JPG");
        mCCTVPic.add(30, prefix + "TC573F.JPG");
        mCCTVPic.add(31, prefix + "SM933F.JPG");
        mCCTVPic.add(32, prefix + "SM934F.JPG");
        mCCTVPic.add(33, prefix + "ST106F.JPG");
        mCCTVPic.add(34, prefix + "ST109F.JPG");
        mCCTVPic.add(35, prefix + "ST112F.JPG");
        mCCTVPic.add(36, prefix + "ST114F.JPG");
        mCCTVPic.add(37, prefix + "ST115F.JPG");
        mCCTVPic.add(38, prefix + "ST117F.JPG");
        mCCTVPic.add(39, prefix + "ST119F.JPG");
        mCCTVPic.add(40, prefix + "TH101F.JPG");
        mCCTVPic.add(41, prefix + "TH110F.JPG");
        mCCTVPic.add(42, prefix + "TH114F.JPG");
        mCCTVPic.add(43, prefix + "RT115F.JPG");
        mCCTVPic.add(44, prefix + "RT116F.JPG");
        mCCTVPic.add(45, prefix + "TC604F.JPG");
        mCCTVPic.add(46, prefix + "TC612F.JPG");
        mCCTVPic.add(47, prefix + "TR101F.JPG");
        mCCTVPic.add(48, prefix + "TR105F.JPG");
        mCCTVPic.add(49, prefix + "TR108F.JPG");
        mCCTVPic.add(50, prefix + "TR114F.JPG");
        mCCTVPic.add(51, prefix + "TR119F.JPG");
        mCCTVPic.add(52, prefix + "TC104F.JPG");
        mCCTVPic.add(53, prefix + "BC101F.JPG");
        mCCTVPic.add(54, prefix + "BC102F.JPG");
        mCCTVPic.add(55, prefix + "BC103F.JPG");
        mCCTVPic.add(56, prefix + "FH104F.JPG");
        mCCTVPic.add(57, prefix + "FH106F.JPG");
        mCCTVPic.add(58, prefix + "FH107F.JPG");
        mCCTVPic.add(59, prefix + "NH101F.JPG");
        mCCTVPic.add(60, prefix + "NH109F.JPG");
        mCCTVPic.add(61, prefix + "NH113F.JPG");
        mCCTVPic.add(62, prefix + "NH115F.JPG");
        mCCTVPic.add(63, prefix + "TP102F.JPG");
        mCCTVPic.add(64, prefix + "TP105F.JPG");
        mCCTVPic.add(65, prefix + "TP112F.JPG");
        mCCTVPic.add(66, prefix + "TP114F.JPG");
        mCCTVPic.add(67, prefix + "K101F.JPG");
        mCCTVPic.add(68, prefix + "K102F.JPG");
        mCCTVPic.add(69, prefix + "K104F.JPG");
        mCCTVPic.add(70, prefix + "K106F.JPG");
        mCCTVPic.add(71, prefix + "K107F.JPG");
        mCCTVPic.add(72, prefix + "K108F.JPG");
        mCCTVPic.add(73, prefix + "K109F.JPG");
        mCCTVPic.add(74, prefix + "K111F.JPG");
        mCCTVPic.add(75, prefix + "K112F.JPG");
        mCCTVPic.add(76, prefix + "K123F.JPG");
        mCCTVPic.add(77, prefix + "K209F.JPG");
        mCCTVPic.add(78, prefix + "K221F.JPG");
        mCCTVPic.add(79, prefix + "K305F.JPG");
        mCCTVPic.add(80, prefix + "K325F.JPG");
        mCCTVPic.add(81, prefix + "K404F.JPG");
        mCCTVPic.add(82, prefix + "K405F.JPG");
        mCCTVPic.add(83, prefix + "K408F.JPG");
        mCCTVPic.add(84, prefix + "K409F.JPG");
        mCCTVPic.add(85, prefix + "K502F.JPG");
        mCCTVPic.add(86, prefix + "K505F.JPG");
        mCCTVPic.add(87, prefix + "K506F.JPG");
        mCCTVPic.add(88, prefix + "K508F.JPG");
        mCCTVPic.add(89, prefix + "K521F.JPG");
        mCCTVPic.add(90, prefix + "K602F.JPG");
        mCCTVPic.add(91, prefix + "K607F.JPG");
        mCCTVPic.add(92, prefix + "K613F.JPG");
        mCCTVPic.add(93, prefix + "K614F.JPG");
        mCCTVPic.add(94, prefix + "K621F.JPG");
        mCCTVPic.add(95, prefix + "K627F.JPG");
        mCCTVPic.add(96, prefix + "K802F.JPG");
        mCCTVPic.add(97, prefix + "K804F.JPG");
        mCCTVPic.add(98, prefix + "K809F2.JPG");
        mCCTVPic.add(99, prefix + "K810F.JPG");
        mCCTVPic.add(100, prefix + "K811F.JPG");
        mCCTVPic.add(101, prefix + "K812F.JPG");
        mCCTVPic.add(102, prefix + "K813F.JPG");
        mCCTVPic.add(103, prefix + "K814F.JPG");
        mCCTVPic.add(104, prefix + "K816F.JPG");
        mCCTVPic.add(105, prefix + "K911F.JPG");
        mCCTVPic.add(106, prefix + "K914F.JPG");
        mCCTVPic.add(107, prefix + "TK101F.JPG");
        mCCTVPic.add(108, prefix + "TK105F.JPG");
        mCCTVPic.add(109, prefix + "TK110F.JPG");
        mCCTVPic.add(110, prefix + "TK904F.JPG");
        mCCTVPic.add(111, prefix + "NL121F.JPG");
        mCCTVPic.add(112, prefix + "NL124F.JPG");
        mCCTVPic.add(113, prefix + "NL126F.JPG");
        mCCTVPic.add(114, prefix + "NL128F.JPG");
        mCCTVPic.add(115, prefix + "PB106F.JPG");
        mCCTVPic.add(116, prefix + "TC560F.JPG");
        mCCTVPic.add(117, prefix + "TR103F.JPG");
        mCCTVPic.add(118, prefix + "TR107F.JPG");
        mCCTVPic.add(119, prefix + "TR111F.JPG");
        mCCTVPic.add(120, prefix + "TR116F.JPG");
        mCCTVPic.add(121, prefix + "SM936F.JPG");
        mCCTVPic.add(122, prefix + "TC101F.JPG");
        mCCTVPic.add(123, prefix + "TC302F.JPG");
        mCCTVPic.add(124, prefix + "TW102F.JPG");
        mCCTVPic.add(125, prefix + "TW103F.JPG");
        mCCTVPic.add(126, prefix + "TW105F.JPG");
        mCCTVPic.add(127, prefix + "TW108F.JPG");
        mCCTVPic.add(128, prefix + "TW109F.JPG");
        mCCTVPic.add(129, prefix + "TW112F.JPG");
        mCCTVPic.add(130, prefix + "TW116F.JPG");
        mCCTVPic.add(131, prefix + "TW117F.JPG");
        mCCTVPic.add(132, prefix + "TW120F.JPG");
        mCCTVPic.add(133, prefix + "TW121F.JPG");
        mCCTVPic.add(134, prefix + "H421F.JPG");
        mCCTVPic.add(135, prefix + "K202F.JPG");
        mCCTVPic.add(136, prefix + "K205F.JPG");
        mCCTVPic.add(137, prefix + "ST701F.JPG");
        mCCTVPic.add(138, prefix + "ST703F.JPG");
        mCCTVPic.add(139, prefix + "ST712F1.JPG");
        mCCTVPic.add(140, prefix + "ST714F.JPG");
        mCCTVPic.add(141, prefix + "ST715F.JPG");
        mCCTVPic.add(142, prefix + "ST721F.JPG");
        mCCTVPic.add(143, prefix + "ST725F.JPG");
        mCCTVPic.add(144, prefix + "ST731F.JPG");
        mCCTVPic.add(145, prefix + "ST732F.JPG");
        mCCTVPic.add(146, prefix + "SW109F.JPG");
        mCCTVPic.add(147, prefix + "SW111F.JPG");
        mCCTVPic.add(148, prefix + "SW112F.JPG");
        mCCTVPic.add(149, prefix + "SW113F.JPG");
        mCCTVPic.add(150, prefix + "TI101F.JPG");
        mCCTVPic.add(151, prefix + "TM101F.JPG");
        mCCTVPic.add(152, prefix + "TM103F.JPG");
        mCCTVPic.add(153, prefix + "TM118F.JPG");
        mCCTVPic.add(154, prefix + "TR704F.JPG");
        mCCTVPic.add(155, prefix + "YL101F.JPG");
        mCCTVPic.add(156, prefix + "YL106F.JPG");
        mCCTVPic.add(157, prefix + "YL111F.JPG");
        mCCTVPic.add(158, prefix + "BC702F.JPG");
        mCCTVPic.add(159, prefix + "TP113F.JPG");
        mCCTVPic.add(160, prefix + "FH706F.JPG");
        mCCTVPic.add(161, prefix + "ST922F.JPG");
        mCCTVPic.add(162, prefix + "SW103F.JPG");
        mCCTVPic.add(163, prefix + "SW108F.JPG");
        mCCTVPic.add(164, prefix + "TL102F.JPG");
        mCCTVPic.add(165, prefix + "TL103F.JPG");
        mCCTVPic.add(166, prefix + "TS102F.JPG");
        mCCTVPic.add(167, prefix + "TS104F.JPG");
        mCCTVPic.add(168, prefix + "TS105F.JPG");
        mCCTVPic.add(169, prefix + "TW701F.JPG");
        mCCTVPic.add(170, prefix + "H702F.JPG");
        mCCTVPic.add(171, prefix + "H703F.JPG");
        mCCTVPic.add(172, prefix + "K901F.JPG");
        mCCTVPic.add(173, prefix + "K931F.JPG");
        mCCTVPic.add(174, prefix + "K952F.JPG");
        mCCTVPic.add(175, prefix + "ST942F.JPG");
        mCCTVPic.add(176, prefix + "K121F.JPG");
        mCCTVPic.add(177, prefix + "TL101F.JPG");
        mCCTVPic.add(178, prefix + "TR706F.JPG");
        mCCTVPic.add(179, prefix + "TS101F.JPG");
    }

    private void initCCTVDesc() {
        mCCTVDesc.add(	0	,"Connaught Road Central near Exchange Square");
        mCCTVDesc.add(	1	,"Pedder Street");
        mCCTVDesc.add(	2	,"Queen's Road Central near Ice House Street");
        mCCTVDesc.add(	3	,"Queen's Road Central near Garden Road");
        mCCTVDesc.add(	4	,"Connaught Road Central near Shun Tak Centre");
        mCCTVDesc.add(	5	,"Pok Fu Lam Road near Pokfield Road");
        mCCTVDesc.add(	6	,"Pok Fu Lam Road near Smithfield Road");
        mCCTVDesc.add(	7	,"Cotton Tree Drive near Murray Building");
        mCCTVDesc.add(	8	,"Hennessy Road near Arsenal Street");
        mCCTVDesc.add(	9	,"Yee Wo Street near Hennessy Road");
        mCCTVDesc.add(	10	,"Fleming Road near Harbour Road");
        mCCTVDesc.add(	11	,"Cross Harbour Tunnel Hong Kong Side");
        mCCTVDesc.add(	12	,"Queen's Road East near Stubbs Road");
        mCCTVDesc.add(	13	,"Aberdeen Tunnel - Wan Chai Side");
        mCCTVDesc.add(	14	,"Harcourt Road near Red Cross Headquarter");
        mCCTVDesc.add(	15	,"Gloucester Road near Wan Chai Interchange");
        mCCTVDesc.add(	16	,"Canal Road Flyover near Time Square");
        mCCTVDesc.add(	17	,"Gloucester Road near Sun Hung Kai Center");
        mCCTVDesc.add(	18	,"Causeway Road near Hing Fat Street");
        mCCTVDesc.add(	19	,"King's Road near Tin Chong Street");
        mCCTVDesc.add(	20	,"Wong Chuk Hang Road near Aberdeen Tunnel");
        mCCTVDesc.add(	21	,"Wong Chuk Hang Road near Aberdeen Technical School");
        mCCTVDesc.add(	22	,"Ap Lei Chau Bridge Road near Aberdeen Police Station");
        mCCTVDesc.add(	23	,"Aberdeen Praya Road near Fish Market");
        mCCTVDesc.add(	24	,"Island Eastern Corridor near Ka Wah Centre");
        mCCTVDesc.add(	25	,"Island Eastern Corridor near Hoi Yu Street");
        mCCTVDesc.add(	26	,"Island Eastern Corridor near Quarry Bay Park");
        mCCTVDesc.add(	27	,"Morrison Hill Road near Sports Road");
        mCCTVDesc.add(	28	,"Canal Road Flyover near Gloucester Road");
        mCCTVDesc.add(	29	,"Kap Shui Mun Bridge");
        mCCTVDesc.add(	30	,"Lantau Link near Toll Plaza");
        mCCTVDesc.add(	31	,"Shing Mun Tunnel Road");
        mCCTVDesc.add(	32	,"Shing Mun Tunnel Shatin Side");
        mCCTVDesc.add(	33	,"Sha Tin Wai Road/Sha Lek Highway Slip Road");
        mCCTVDesc.add(	34	,"Tai Chung Kiu Road near Ravana Garden");
        mCCTVDesc.add(	35	,"Mei Tin Rd nr Che Kung Miu Rd Rbt");
        mCCTVDesc.add(	36	,"Tai Po Road - Shatin Section");
        mCCTVDesc.add(	37	,"Fo Tan Road");
        mCCTVDesc.add(	38	,"Sai Sha Road near Ma On Shan Sports Ground");
        mCCTVDesc.add(	39	,"Sai Sha Road/Kam Ying Road");
        mCCTVDesc.add(	40	,"Tolo Highway near Ma Liu Shui Interchange");
        mCCTVDesc.add(	41	,"Tolo Highway near HK Science Park");
        mCCTVDesc.add(	42	,"Tolo Highway near Island House Interchange");
        mCCTVDesc.add(	43	,"Lung Mun Road near Wu Chui Road");
        mCCTVDesc.add(	44	,"Wong Chu Road near Lung Mun Road");
        mCCTVDesc.add(	45	,"Ting Kau Bridge");
        mCCTVDesc.add(	46	,"Tuen Mun Road to Ting Kau Bridge");
        mCCTVDesc.add(	47	,"Tuen Mun Road - Chai Wan Kok");
        mCCTVDesc.add(	48	,"Tuen Mun Road - Ting Kau Section");
        mCCTVDesc.add(	49	,"Tuen Mun Road - Sham Tseng Interchange");
        mCCTVDesc.add(	50	,"Tuen Mun Road - Tai Lam Kok Section");
        mCCTVDesc.add(	51	,"Tuen Mun Road - Sam Shing Hui");
        mCCTVDesc.add(	52	,"Tsing Kwai Highway Near Container Port 4");
        mCCTVDesc.add(	53	,"San Tin Highway near Fairview Park");
        mCCTVDesc.add(	54	,"San Tin Highway near Mai Po");
        mCCTVDesc.add(	55	,"San Sham Road Roundabout");
        mCCTVDesc.add(	56	,"Fanling Highway near Kwu Tung");
        mCCTVDesc.add(	57	,"Fanling Highway near Sheung Shui Roundabout");
        mCCTVDesc.add(	58	,"Fanling Highway near Pak Wo Road");
        mCCTVDesc.add(	59	,"Jockey Club Road near Fanling Highway");
        mCCTVDesc.add(	60	,"Jockey Club Road near Ma Sik Road");
        mCCTVDesc.add(	61	,"San Wan Road near Lung Sum Avenue");
        mCCTVDesc.add(	62	,"Sha Tau Kok Road near Ma Sik Road");
        mCCTVDesc.add(	63	,"Yuen Shin Road near Ting Kok Road");
        mCCTVDesc.add(	64	,"Tai Po Tai Wo Road near Nam Wan Road");
        mCCTVDesc.add(	65	,"Tai Po Tai Wo Road near Tai Po Road- Tai Wo");
        mCCTVDesc.add(	66	,"Nam Wan Road near Kwong Fuk Road");
        mCCTVDesc.add(	67	,"Salisbury Road near Nathan Road");
        mCCTVDesc.add(	68	,"Salisbury Road near Chatham Road");
        mCCTVDesc.add(	69	,"Canton Road near China HK City");
        mCCTVDesc.add(	70	,"Chatham Road near Austin Road");
        mCCTVDesc.add(	71	,"Cross Harbour Tunnel Kowloon Side");
        mCCTVDesc.add(	72	,"Jordan Road near Ferry Street");
        mCCTVDesc.add(	73	,"Chatham Road near Princess Margaret Road");
        mCCTVDesc.add(	74	,"Waterloo Road / Ferry Street");
        mCCTVDesc.add(	75	,"Waterloo Road near Tung Fong Street");
        mCCTVDesc.add(	76	,"Princess Margaret Road near King's Park");
        mCCTVDesc.add(	77	,"Boundary Street near Tai Hang Tung Road");
        mCCTVDesc.add(	78	,"Cherry Street near Hoi Wang Road");
        mCCTVDesc.add(	79	,"Cheung Sha Wan Road near Kwong Cheung Street");
        mCCTVDesc.add(	80	,"Kwai Chung Road near Mei Fo Sun Chuen");
        mCCTVDesc.add(	81	,"Kai Tak Tunnel Kowloon City Side");
        mCCTVDesc.add(	82	,"Ma Tau Wai Road near Farm Road");
        mCCTVDesc.add(	83	,"Princess Margaret Road/Pui Ching Road");
        mCCTVDesc.add(	84	,"Princess Margaret Road/Argyle Street");
        mCCTVDesc.add(	85	,"Waterloo Road/Cornwall Street");
        mCCTVDesc.add(	86	,"Lung Cheung Road/Chuk Yuen Road");
        mCCTVDesc.add(	87	,"Prince Edward Rd W Flyover nr Olympic Garden");
        mCCTVDesc.add(	88	,"Lung Cheung Road/Po Kong Village Road");
        mCCTVDesc.add(	89	,"Prince Edward Road East near San Po Kong");
        mCCTVDesc.add(	90	,"Lei Yue Mun Road near Cha Kwo Ling Road");
        mCCTVDesc.add(	91	,"Sau Mau Ping Road near Hip Wo Street");
        mCCTVDesc.add(	92	,"Kai Cheung Road near Wang Chiu Road");
        mCCTVDesc.add(	93	,"Lung Cheung Road/Clear Water Bay Road");
        mCCTVDesc.add(	94	,"Kwun Tong Road near Kai Yip Estate");
        mCCTVDesc.add(	95	,"Clear Water Bay Road near Fei Ngo Shan Road");
        mCCTVDesc.add(	96	,"Ching Cheung Road near Caritas Medical Center");
        mCCTVDesc.add(	97	,"Lung Cheung Road near Chak On Estate");
        mCCTVDesc.add(	98	,"Kwun Tong Road near Kowloon Bay MTR Station");
        mCCTVDesc.add(	99	,"Kwun Tong Road near Ngua Tau Kok MTR Station");
        mCCTVDesc.add(	100	,"Tseung Kwan O Road near Tsui Ping South Estate");
        mCCTVDesc.add(	101	,"Kwun Tong Bypass near Laguna City");
        mCCTVDesc.add(	102	,"Kwun Tong Bypass near Lai Yip Street");
        mCCTVDesc.add(	103	,"Kwun Tong Bypass near Kai Cheung Road");
        mCCTVDesc.add(	104	,"West Kowloon Corridor near Nam Cheong Estate");
        mCCTVDesc.add(	105	,"West Kowloon Hwy - Yau Ma Tei Interchange N");
        mCCTVDesc.add(	106	,"West Kowloon Highway near Lai Wan Interchange");
        mCCTVDesc.add(	107	,"Po Lam Road North near Po Hong Road");
        mCCTVDesc.add(	108	,"Po Shun Road near Tseung Kwan O Swimming Pool");
        mCCTVDesc.add(	109	,"Chui Ling Road near Po Shun Road");
        mCCTVDesc.add(	110	,"Tseung Kwan O Tunnel - Tseung Kwan O Side");
        mCCTVDesc.add(	111	,"North Lantau Highway near Sunny Bay");
        mCCTVDesc.add(	112	,"North Lantau Highway near Siu Ho Wan");
        mCCTVDesc.add(	113	,"North Lantau Highway near Pak Mong");
        mCCTVDesc.add(	114	,"North Lantau Highway near Tung Chung");
        mCCTVDesc.add(	115	,"Penny's Bay Highway");
        mCCTVDesc.add(	116	,"Tsing Ma Bridge");
        mCCTVDesc.add(	117	,"Tuen Mun Road - Yau Kom Tau Section");
        mCCTVDesc.add(	118	,"Tuen Mun Road - Sham Tseng Section");
        mCCTVDesc.add(	119	,"Tuen Mun Road - near Tsing Lung Tau");
        mCCTVDesc.add(	120	,"Tuen Mun Road - Siu Lam Section");
        mCCTVDesc.add(	121	,"Cheung Pei Shan Road");
        mCCTVDesc.add(	122	,"Cheung Tsing Bridge");
        mCCTVDesc.add(	123	,"Cheung Tsing Highway near Kam Chuk Kok");
        mCCTVDesc.add(	124	,"Kwai Chung Road near Container Terminal");
        mCCTVDesc.add(	125	,"Tsuen Wan Road near Tsuen Tsing Interchange");
        mCCTVDesc.add(	126	,"Kwai Tsing Road near Tsing Yi Bridge");
        mCCTVDesc.add(	127	,"Kwai Chung Road near Kwai Hing MTR Station");
        mCCTVDesc.add(	128	,"Castle Peak Road near Wo Yi Hop Road");
        mCCTVDesc.add(	129	,"Wo Yi Hop Road near Lei Shu Road");
        mCCTVDesc.add(	130	,"Texaco Road Flyover near Sha Tsui Road");
        mCCTVDesc.add(	131	,"Castle Peak Road near Texaco Road North");
        mCCTVDesc.add(	132	,"Tsuen Wan Road near Tai Chung Road");
        mCCTVDesc.add(	133	,"Tsing Kwai Highway/Cheung Tsing Tunnel");
        mCCTVDesc.add(	134	,"Aberdeen Tunnel - Aberdeen Side");
        mCCTVDesc.add(	135	,"Argyle Street near Yim Po Fong Street");
        mCCTVDesc.add(	136	,"Nathan Road near Lai Chi Kok Road");
        mCCTVDesc.add(	137	,"Tolo Highway near Sha Tin Sewage Treatment Works");
        mCCTVDesc.add(	138	,"Tai Po Road near MTR Racecourse Station");
        mCCTVDesc.add(	139	,"Tate's Cairn Highway near Shatin Hospital");
        mCCTVDesc.add(	140	,"Tate's Cairn Highway near Tai Shek Kwu");
        mCCTVDesc.add(	141	,"Sha Lek Highway near Prince Wales Hospital");
        mCCTVDesc.add(	142	,"Shatin Road near Yuen Chau Kok Park");
        mCCTVDesc.add(	143	,"Lion Rock Tunnel Road near Sun Tin Wai Estate");
        mCCTVDesc.add(	144	,"Ma On Shan Bypass near Heng On Estate");
        mCCTVDesc.add(	145	,"Ma On Shan Bypass near Yiu On Estate");
        mCCTVDesc.add(	146	,"Yuen Long Highway near Hung Tin Road");
        mCCTVDesc.add(	147	,"Yuen Long Highway near Tong Yan San Tsuen Interchange");
        mCCTVDesc.add(	148	,"Yuen Long Highway near Shap Pat Heung");
        mCCTVDesc.add(	149	,"Yuen Long Highway near Pok Oi Interchange");
        mCCTVDesc.add(	150	,"Castle Peak Road near Hung Shui Kiu");
        mCCTVDesc.add(	151	,"Wu Chui Road near Wu King Road");
        mCCTVDesc.add(	152	,"Lung Mun Road near Tuen Mun Recreation and Sports Centre");
        mCCTVDesc.add(	153	,"Pui To Road near Tuen Mun Park");
        mCCTVDesc.add(	154	,"Tuen Mun Road near Tsing Yin Street");
        mCCTVDesc.add(	155	,"Long Tin Road near Long Ping Road");
        mCCTVDesc.add(	156	,"Castle Peak Road nearYuen Long");
        mCCTVDesc.add(	157	,"Castle Peak Road near Pok Oi Interchange");
        mCCTVDesc.add(	158	,"Castle Peak Road near Mai Po");
        mCCTVDesc.add(	159	,"Fanling Highway near Hong Lok Yuen Road");
        mCCTVDesc.add(	160	,"Fanling Highway near MTR Fanling Station");
        mCCTVDesc.add(	161	,"Lion Rock Tunnel Road near Hung Mui Kuk Road");
        mCCTVDesc.add(	162	,"Kong Sham Western Highway near Ha Tsuen");
        mCCTVDesc.add(	163	,"Yuen Long Highway near Tan Kwai Tsuen");
        mCCTVDesc.add(	164	,"Tai Lam Tunnel - Yuen Long Side");
        mCCTVDesc.add(	165	,"Tai Lam Tunnel - Ting Kau Side");
        mCCTVDesc.add(	166	,"Nam Wan Tunnel- Stonecutters Bridge side");
        mCCTVDesc.add(	167	,"Tsing Sha Highway near Lai Chi Kok");
        mCCTVDesc.add(	168	,"Sha Tin Heights Tunnel - Sha Tin Side");
        mCCTVDesc.add(	169	,"Cheung Pei Shan Road near Mei Wan Street");
        mCCTVDesc.add(	170	,"Western Harbour Crossing Hong Kong Side");
        mCCTVDesc.add(	171	,"Connaught Road West");
        mCCTVDesc.add(	172	,"Western Harbour Crossing Kowloon Side");
        mCCTVDesc.add(	173	,"Tate's Cairn Tunnel Kowloon Side");
        mCCTVDesc.add(	174	,"Eastern Harbour Crossing Kowloon Side");
        mCCTVDesc.add(	175	,"Tate's Cairn Tunnel Shatin Side");
        mCCTVDesc.add(	176	,"Canton Road near Salisbury Road");
        mCCTVDesc.add(	177	,"Tsing Long Highway near Ko Po San Tsuen");
        mCCTVDesc.add(	178	,"Tuen Mun Road near MTR Siu Hong Station");
        mCCTVDesc.add(	179	,"Nam Wan Tunnel - Sai Tso Wan Side");
    }


    public class MarkerInfoWindowAdapter implements GoogleMap.InfoWindowAdapter{
        public MarkerInfoWindowAdapter()
        {
        }

        @Override
        public View getInfoWindow(Marker marker)
        {
            return null;
        }

        @Override
        public View getInfoContents(Marker marker)
        {
            View v  = getLayoutInflater().inflate(R.layout.infowindow_layout, null);

            MyMarker myMarker = mMarkersHashMap.get(marker);

            ImageView markerIcon = (ImageView) v.findViewById(R.id.marker_icon);

            TextView markerLabel = (TextView)v.findViewById(R.id.marker_label);

            //markerIcon.setImageResource(manageMarkerIcon(myMarker.getmIcon()));

            //Picasso.with(getApplicationContext()).load("http://i.imgur.com/DvpvklR.png").into(markerIcon);
            Picasso.with(getApplicationContext()).load(mCCTVPic.get(Integer.parseInt(myMarker.getmLabel()))).into(markerIcon);

            markerLabel.setText(mCCTVDesc.get(Integer.parseInt(myMarker.getmLabel())));

            String toSpeak = mCCTVDesc.get(Integer.parseInt(myMarker.getmLabel()));
            //Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_SHORT).show();
            t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            //t1.speak("", TextToSpeech.QUEUE_FLUSH, null);

            return v;
        }

        /*
        private int manageMarkerIcon(String markerIcon)
        {
            if (markerIcon.equals("icon1"))
                return R.drawable.icon1;
            else if(markerIcon.equals("icon2"))
                return R.drawable.icon2;
            else if(markerIcon.equals("icon3"))
                return R.drawable.icon3;
            else if(markerIcon.equals("icon4"))
                return R.drawable.icon4;
            else if(markerIcon.equals("icon5"))
                return R.drawable.icon5;
            else if(markerIcon.equals("icon6"))
                return R.drawable.icon6;
            else if(markerIcon.equals("icon7"))
                return R.drawable.icon7;
            else
                return R.drawable.icondefault;
        }
        */
    }
}
