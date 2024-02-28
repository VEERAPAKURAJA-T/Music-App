package com.example.service_app;


import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

import androidx.annotation.Nullable;

public class My_Custom_Service extends Service {
    /*
    The media player class in Android is used to play audio and video files.
It provides a high level interface to control playback, pose, stop, seek and manage other aspects
of multimedia playback. supports a variety of audio and video formats and can be used to play media from various sources,
including local files, network streams and more.
     */
    private MediaPlayer player;
    /*
    It will extend service class from Android app.

The callback methods are used to initiate and destroy the services
 so alt+ enter to implement the callback method, which is the unbind method in this case to play music.
The media player object is used, so I'll create an object of media player.

Private media player.
     */

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        /*
        Please watch the service cycle flow chat.
        So on start command method is implemented so I can create Oncreate method.
But here I'll use the on start command directly.
That will start on calling this method so the execution of the service will start on calling this method.
Here is the logic that I need to execute in the background.
         */
        player= MediaPlayer.create(
                this,
                Settings.System.DEFAULT_RINGTONE_URI
                /*
                I need to use the default ringtone URL again, I'm creating a media player to play the default ringtone
                 */
        );
        // I need to play the ringtone audio on  loop (continuously) .
        player.setLooping(true);
        //This will start or resumes the playback of the music.
        player.start();
        /*
        The last thing here I need to return missing return statement and what type of return I need to
return a variable of type int.But in this case I'm not using integer variables can use not sticky, sticky, sticky compatibility,
flag retry and others start sticky returns the status of the program.So the on start command method of the service is used to handle the incoming start requests.
It returns an integer that specifies how the system should handle the service after it has been started.
There are several return types you can use, including start sticky if you return a start sticky from
on start command method.It indicates that the service should be restarted if it's terminated by the system after it has been
started, the system will recreate the service with a null intent and you will need to handle reinitialization
of any necessary resources.Use this return type If the service performs periodic tasks such as background data synchronization
where you want to ensure that the service resumes operation after being temporarily killed.
         */
        return START_STICKY;
        /*
        The other type is start not sticky.
If you return, start not sticky, it indicates that the service should not be restarted by the system
after it has been terminated.This service will remain stopped unless explicitly started again by the application or the component.
This return type is suitable for services that perform specific tasks and don't need to be running continuously.
For example, a service that plays a sound effect when a notification is received might use this option.
And there are a lot of other modes like started redeliver intent start to sticky compatibility and others.
But the main two types is start not sticky and start sticky.
     return START_NOT_STICKY
         */
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        /*
        The onBind method is a part of the service class and is used specifically in the
        context of bound services.
        A bound service is a type of service that allows other components, usually activities to bind to it
and interact with it by obtaining an I binder interface.And the I binder interface is used to establish a communication channel between the components and the
service if you return null.And this is the default implementation, this indicates that the service doesn't support binding and
therefore cannot be bound to.In this example, I will not bind any activity to this service.
We created my custom service class and we need to start the music and perform the operation to start
this service.
         */
        return null;
    }

}
