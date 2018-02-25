package com.example.jeff.vendingmachine;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Item> inventory = new ArrayList<>();

    WifiP2pManager mManager;
    WifiP2pManager.Channel mChannel;
    BroadcastReceiver mReceiver;

    IntentFilter mIntentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillInventory();

        mManager = (WifiP2pManager) getSystemService(Context.WIFI_P2P_SERVICE);
        mChannel = mManager.initialize(this, getMainLooper(), null);
        mReceiver = new WiFiDirectBroadcastReceiver(mManager, mChannel, this);

        mIntentFilter = new IntentFilter();
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(mReceiver, mIntentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mReceiver);
    }

    void fillInventory() {
        inventory.add(new Item("Lay's Classic", 1, 4));
        inventory.add(new Item("Lay's Sour Cream and Onion", 1, 3));
        inventory.add(new Item("Doritos Cool Ranch", 1, 3));
        inventory.add(new Item("Doritos Nacho Cheese", 1, 5));
        inventory.add(new Item("Doritos Spicy Sweet Chili", 1, 3));
        inventory.add(new Item("Taki's Fuego", 1, 2));
        inventory.add(new Item("Brocolli", .50, 4));
        inventory.add(new Item("Apple", .75, 6));
        inventory.add(new Item("Nissin Chicken Ramen", 1.50, 2));
        inventory.add(new Item("5 Hour Energy", 3.50, 4));
    }

    void processPurchase(int itemid) {
        inventory.get(itemid).stock -= 1;
    }
}

