package survey.app.apxeaon.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import survey.app.apxeaon.di.module.UiModule
import survey.app.apxeaon.view.AppState
import survey.app.apxeaon.view.main.MainModule
import survey.app.data.di.DataModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        UiModule::class,
        MainModule::class,
        DataModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<AppState> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }
}
