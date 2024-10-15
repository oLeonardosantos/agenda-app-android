package br.com.agendaapp

import android.app.Application
import br.com.agendaapp.database.InitDatabase

class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        InitDatabase.init(this)
    }
}