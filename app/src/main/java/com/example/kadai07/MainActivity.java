package com.example.kadai07;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Handler;
import android.os.Bundle;
import android.os.Message;
import  android.widget.TextView;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    private Thread th1;
    private Handler hd1;
    private TextView tv1;
    private Thread th2;
    private Handler hd2;
    private TextView tv2;
    private Thread th3;
    private Handler hd3;
    private TextView tv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.view_message);
        hd1 = new Handler(new CountHandler1());
        tv2 = (TextView) findViewById(R.id.view_message2);
        hd2 = new Handler(new CountHandler2());
        tv3 = (TextView) findViewById(R.id.view_message3);
        hd3 = new Handler(new CountHandler3());
    }
    @Override
    public void onStart(){
        super.onStart();
        th1 =new Thread(new CountThread1());
        th1.start();
        th2 =new Thread(new CountThread2());
        th2.start();
        th3 =new Thread(new CountThread3());
        th3.start();
    }
    @Override
    public void onStop(){
        super.onStop();
        th1 =null;
        th2 =null;
        th3 =null;
    }
    class CountHandler1 implements Handler.Callback{
        public boolean handleMessage(Message msg){
            tv1.setText((String) msg.obj);
            return true;
        }
    }
    class CountThread1 implements Runnable {
        public void run(){
            long count =0;
            while (th1 != null){
                count++;
                Message msg = Message.obtain();
                msg.obj=String.valueOf(count % 10);
                hd1.sendMessage(msg);
                try{
                    Thread.sleep(400);
                }catch (InterruptedException e){}
            }
        }
    }

    public void stopNumber1(View view){
        th1 = null;
    }

    class CountHandler2 implements Handler.Callback{
        public boolean handleMessage(Message msg){
            tv2.setText((String) msg.obj);
            return true;
        }
    }
    class CountThread2 implements Runnable {
        public void run(){
            long count =0;
            while (th2 != null){
                count++;
                Message msg = Message.obtain();
                msg.obj=String.valueOf(count % 10);
                hd2.sendMessage(msg);
                try{
                    Thread.sleep(400);
                }catch (InterruptedException e){}
            }
        }
    }

    public void stopNumber2(View view){
        th2 = null;
    }

    class CountHandler3 implements Handler.Callback{
        public boolean handleMessage(Message msg){
            tv3.setText((String) msg.obj);
            return true;
        }
    }
    class CountThread3 implements Runnable {
        public void run(){
            long count =0;
            while (th3 != null){
                count++;
                Message msg = Message.obtain();
                msg.obj=String.valueOf(count % 10);
                hd3.sendMessage(msg);
                try{
                    Thread.sleep(400);
                }catch (InterruptedException e){}
            }
        }
    }
    public void stopNumber3(View view){
        th3 = null;
    }
}










