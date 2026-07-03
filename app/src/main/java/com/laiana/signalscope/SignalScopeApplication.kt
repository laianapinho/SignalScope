package com.laiana.signalscope

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//Conceitualmente: Este aplicativo usa Hilt. Pode inicializar o sistema de injeção de dependência.
@HiltAndroidApp
class SignalScopeApplication : Application()