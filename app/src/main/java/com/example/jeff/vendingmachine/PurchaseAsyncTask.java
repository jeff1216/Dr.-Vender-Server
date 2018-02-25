package com.example.jeff.vendingmachine;

import android.content.Context;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by jefff on 2/24/2018.
 */

public class PurchaseAsyncTask extends AsyncTask<Void, Void, Integer> {
    private MainActivity mActivity;

    public PurchaseAsyncTask(MainActivity mActivity) {
        this.mActivity = mActivity;
    }

    protected Integer doInBackground(Void... params) {
        try {

            /**
             * Create a server socket and wait for client connections. This
             * call blocks until a connection is accepted from a client
             */
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket client = serverSocket.accept();

            /**
             * If this code is reached, a client has connected and transferred data
             * Save the input stream from the client as a JPEG file
             */
            InputStream inputstream = client.getInputStream();
            Integer message = inputstream.read();
            serverSocket.close();
            return message;
        } catch (IOException e) {
            return -1;
        }
    }
    protected void onPostExecute(int message) {
        mActivity.processPurchase(message);
    }
}