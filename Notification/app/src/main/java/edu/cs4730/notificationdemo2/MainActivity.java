package edu.cs4730.notificationdemo2;

import java.util.Calendar;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static String id = "test_channel_01";
    NotificationManager nm;
    int NotID = 1;
    final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);


//        findViewById(R.id.button2).setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //We are going to call the broadcast receiver from notificationDemo1
//                //same problem, this may fail if notificationDemo1 is targeted at API26.  I'm working to find a fix.
//                Intent intent = new Intent();
//                intent.setAction("edu.cs4730.notificationdemo.broadNotification");
//                intent.setPackage("edu.cs4730.notificationdemo"); //in API 26, it must be explicit now.
//                //adding some extra inform again.
//                intent.putExtra("mytype", "alarm from notificationDemo2");
//
//                //---use the AlarmManager to trigger an alarm---
//                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
//
//                //---get current date and time---
//                Calendar calendar = Calendar.getInstance();
//
//                //---sets the time for the alarm to trigger in 2 minutes from now---
//                calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) + 2);
//                calendar.set(Calendar.SECOND, 0);
//
//
//                PendingIntent contentIntent = PendingIntent.getBroadcast(MainActivity.this, NotID, intent, 0);
//                Log.i("MainActivity", "Set alarm, I hope");
//                Toast.makeText(getApplicationContext(), "Alarm for " + calendar.get(Calendar.MINUTE), Toast.LENGTH_SHORT).show();
//
//                //---sets the alarm to trigger---
//                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), contentIntent);
//            }
//        });

        findViewById(R.id.button3).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                progressbarnoti();
            }
        });
        findViewById(R.id.button4).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                activitybarnoti();
            }
        });
        createchannel();
    }

    private void createchannel() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel mChannel = new NotificationChannel(id,
                getString(R.string.channel_name),  //name of the channel
                NotificationManager.IMPORTANCE_LOW);   //importance level
            //important level: default is is high on the phone.  high is urgent on the phone.  low is medium, so none is low?
            // Configure the notification channel.
            mChannel.setDescription(getString(R.string.channel_description));
            // mChannel.enableLights(true);
            // Sets the notification light color for notifications posted to this channel, if the device supports this feature.
            //mChannel.setLightColor(Color.RED);
            // mChannel.enableVibration(true);
            mChannel.setShowBadge(true);
            //mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            nm.createNotificationChannel(mChannel);

        }
    }

    public void progressbarnoti() {
        new Thread(
            new Runnable() {
                @Override
                public void run() {
                    int incr;
                    //create the basic notification
                    NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext(), id)
                        .setOngoing(true)  //user can't remember the notification.
                        .setSmallIcon(R.drawable.ic_announcement_black_24dp)
                        .setContentTitle("Progress Bar")
                        .setContentText("Just Wait For Sometime");

                    // Do the "lengthy" operation 20 times
                    for (incr = 0; incr <= 75; incr += 5) {
                        // Sets the progress indicator to a max value
                        mBuilder.setProgress(100, incr, false);
                        // Displays for first time
                        nm.notify(NotID, mBuilder.build());
                        try {
                            // Sleep for 2 seconds
                            Thread.sleep(2 * 1000);
                        } catch (InterruptedException e) {
                            Log.d(TAG, "sleep failure");
                        }
                    }
                    // When the loop is finished, updates the notification
                    mBuilder.setContentText("Progress complete")
                        .setOngoing(false)  //now the user can remove the notification.
                        .setProgress(0, 0, false);
                    nm.notify(NotID, mBuilder.build());
                }
            }
        ).start();
        NotID++;
    }

 //FIXED NOTIFICATION
    public void activitybarnoti() {
        new Thread(
            new Runnable() {
                @Override
                public void run() {
                    int incr;
                    //create the basic notification
                    NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext(), id)
                        .setSmallIcon(R.drawable.ic_announcement_black_24dp)
                        .setContentTitle("Activity Indicator")   //Title message top row.
                        .setContentText("animated indicator bar");  //message when looking at the notification, second row

                    // Do the "lengthy" operation 20 times
                    for (incr = 0; incr <= 75; incr += 10) {
                        // Sets an activity indicator for an operation of indeterminate length
                        mBuilder.setProgress(0, 0, true);
                        // Displays for the first time.
                        nm.notify(NotID, mBuilder.build());
                        try {
                            // Sleep for 2 seconds
                            Thread.sleep(2 * 1000);
                        } catch (InterruptedException e) {
                            Log.d(TAG, "sleep failure");
                        }
                    }
                    // When the loop is finished, updates the notification
                    mBuilder.setContentText("Fixed complete")
                        .setAutoCancel(true)
                        // Removes the progress bar
                        .setProgress(0, 0, false);
                    nm.notify(NotID, mBuilder.build());
                }
            }
// Starts the thread by calling the run() method in its Runnable
        ).start();
        NotID++;
    }
}