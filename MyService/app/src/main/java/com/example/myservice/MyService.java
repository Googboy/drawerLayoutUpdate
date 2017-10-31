package com.example.myservice;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {

    private MyBinder mBinder = new MyBinder();

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
    //新增加的类用于和Activity进行连接通信,当点击绑定服务按钮时，就会触发下载操作
    class MyBinder extends Binder{
        public void startDownload(){
            System.out.println("开始下载!!!!!!!");
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //下面这些代码是创建前台service
       /* Notification notification = new Notification(R.mipmap.ic_launcher,"有消息到来！！！",System.currentTimeMillis());
        Intent notificationIntent = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,notificationIntent,0);
        Notification.Builder mNotification = new Notification.Builder(this);
        mNotification.setSmallIcon(R.mipmap.ic_launcher);
        mNotification.setContentTitle("这是通知标题");
        mNotification.setContentText("这是通知内容");
        startForeground(1,notification);*/
       Intent mIntent = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,mIntent,0);
        Notification.Builder builder = new Notification.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("这是通知标题");
        builder.setContentText("这是通知内容");
        builder.setTicker("新消息");
        builder.setWhen(System.currentTimeMillis());
    }

    @Override
    public int onStartCommand(Intent intent,int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
