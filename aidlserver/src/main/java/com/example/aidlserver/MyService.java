package com.example.aidlserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class MyService extends Service {
    public class PersonImpl extends IPerson.Stub{

        @Override
        public String getName() throws RemoteException {
            return "bill";
        }

        @Override
        public int getAge() throws RemoteException {
            return 25;
        }

    }

    @Override
    public IBinder onBind(Intent intent) {
        return new MyService.PersonImpl();
    }
}
