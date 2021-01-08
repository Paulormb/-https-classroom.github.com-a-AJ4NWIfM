package survey.app.apxeaon.view.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.multibindings.IntoMap
import survey.app.data.interactor.AuthenUseCase
import survey.app.data.interactor.SurveyUseCase
import tran.nam.core.di.inject.ViewModelKey

@Module(includes = [AndroidSupportInjectionModule::class, MainModule.ProvideViewModel::class])
interface MainModule {

    @ContributesAndroidInjector(modules = [InjectViewModel::class])
    fun bind(): MainActivity

    @Module
    class ProvideViewModel {

        @Provides
        @IntoMap
        @ViewModelKey(MainViewModel::class)
        fun provideViewModel(mUseCaseAuthen: AuthenUseCase, mUseSurveyUseCase: SurveyUseCase): ViewModel {
            return MainViewModel(mUseCaseAuthen,mUseSurveyUseCase)
        }
    }

    @Module
    class InjectViewModel {
        @Provides
        fun provideViewModel(
            factory: ViewModelProvider.Factory,
            target: MainActivity
        ) =
            ViewModelProviders.of(target, factory).get(MainViewModel::class.java)
    }
}
