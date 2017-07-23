package com.liliumproject.android.gitrepapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import co.moonmonkeylabs.realmsearchview.RealmSearchView;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {
    private RealmSearchView realmSearchView;
    private RepRecyclerViewAdapter adapter;
    private Realm realm;
    List<Rep> entries ;
    Rep r1,r2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entries = new ArrayList<Rep>(){
            {

            }
        };
        r1 = new Rep();
        r2 = new Rep();

        RealmSearchView realmSearchView = (RealmSearchView) findViewById(R.id.search_view);
        r1.setTitle("test");
        r1.setContent("aaa");
        r1.setDate("bbb");
        r1.setUrl("ccc");
        r2.setTitle("test2");
        r2.setContent("aaa");
        r2.setDate("bbb");
        r2.setUrl("ccc");
        resetRealm();

        realm = Realm.getInstance(this);
        RepRecyclerViewAdapter adapter = new RepRecyclerViewAdapter(this, realm, "title");
        realmSearchView.setAdapter(adapter);
        entries.add(r1);
        entries.add(r2);
        realm.beginTransaction();
        realm.copyToRealm(entries);
        realm.commitTransaction();


    }
    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (realm != null) {
            realm.close();
            realm = null;
        }
    }
    private RealmConfiguration getRealmConfig() {
        return new RealmConfiguration
                .Builder(this)
                .deleteRealmIfMigrationNeeded()
                .build();
    }

    private void resetRealm() {
        Realm.deleteRealm(getRealmConfig());
    }

}
