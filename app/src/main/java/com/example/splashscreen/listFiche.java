package com.example.splashscreen;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class listFiche extends AppCompatActivity {
    /*ListView lstView;
    ArrayList<Fiche> lesFiches=new ArrayList<Fiche>();*/

    ListView lstFiche;
    FicheCustomAdapter mAdapter;

    String url="http://192.168.2.210:8000/menuJSON/1";
    //String url="https://apprentissage-lessablesdolonne.com/espace-entreprise/api/offers";
    ProgressDialog dialog;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lstview_fiche);

        /*Intent intent=getIntent();
        String id=intent.getStringExtra("id");

        FicheSqlHelper ficheSqlHelper=new FicheSqlHelper(listFiche.this);
        lesFiches=ficheSqlHelper.getLesSeries(id);

        lstView=findViewById(R.id.lstView);

        FicheCustomAdapter mAdapter = new FicheCustomAdapter(listFiche.this, lesFiches);

        //ArrayAdapter<String> adapter= new ArrayAdapter<String>(listFiche.this,android.R.layout.simple_list_item_1);
        lstView.setAdapter(mAdapter);*/

        lstFiche = (ListView)findViewById(R.id.lstViewFiche);

        dialog = new ProgressDialog(this);
        dialog.setMessage("Collecte des données en cours...");
        dialog.show();

        StringRequest request = new StringRequest(url, string -> {
            String tmp="{'data':"+string+"}";
            parseJsonData(tmp);
        }, volleyError -> {
            //Toast.makeText(getApplicationContext(), "fdsfsdf", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });

        RequestQueue rQueue = Volley.newRequestQueue(listFiche.this);
        rQueue.add(request);

    }

    void parseJsonData(String jsonString) {
        try {
            JSONObject object = new JSONObject(jsonString);
            JSONArray entrArray = object.getJSONArray("data");
            ArrayList al = new ArrayList();
            //ArrayList <geoloc> al = new ArrayList<geoloc>();

            for(int i = 0; i < entrArray.length(); ++i) {
                JSONObject entrDetail = entrArray.getJSONObject(i);
                Fiche current = new Fiche(
                        entrDetail.getString("mois"),
                        entrDetail.getInt("idEtat"),
                        entrDetail.getInt("id"),
                        entrDetail.getInt("idVisit")
                        );
                al.add(current);
            }

             mAdapter = new FicheCustomAdapter(listFiche.this,al);
             ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, al);
             lstFiche.setAdapter(mAdapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        dialog.dismiss();
    }
}
