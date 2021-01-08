package survey.app.data.di

import dagger.Binds
import dagger.Module
import survey.app.data.api.NetModule
import survey.app.data.interactor.AuthenUseCase
import survey.app.data.interactor.AuthenUseCaseImpl
import survey.app.data.interactor.SurveyUseCase
import survey.app.data.interactor.SurveyUseCaseImpl
import survey.app.data.local.PreferenceModule
import javax.inject.Singleton


@Module(includes = [NetModule::class, /*DbModule::class,*/ PreferenceModule::class])
abstract class DataModule {

    @Binds
    @Singleton
    internal abstract fun provideAuthenUseCase(usecase: AuthenUseCaseImpl): AuthenUseCase

    @Binds
    @Singleton
    internal abstract fun provideSurveyUseCase(usecase: SurveyUseCaseImpl): SurveyUseCase
}
