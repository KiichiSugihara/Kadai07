package com.example.kadai07;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Handler;
import android.os.Bundle;
import android.os.Message;
import  android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Thread th;
    private Handler hd;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.view_message);
        hd = new Handler(new CountHandler());
    }
    @Override
    public void onStart(){
        super.onStart();
        th =new Thread(new CountThread());
        th.start();
    }
    @Override
    public void onStop(){
        super.onStop();
        th =null;
    }
    class CountHandler implements Handler.Callback{
        public boolean handleMessage(Message msg){
            tv.setText((String) msg.obj);
            return true;
        }
    }
    class CountThread implements Runnable {
        public void run(){
            long count =0;
            while (th != null){
                count++;
                Message msg = Message.obtain();
                msg.obj=String.valueOf(count % 10);
                hd.sendMessage(msg);
                try{
                    Thread.sleep(400);
                }catch (InterruptedException e){}
            }
        }
    }
}










