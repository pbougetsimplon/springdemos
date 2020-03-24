import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {LoginComponent} from './login/login.component';
import {MenuComponent} from './menu/menu.component';
import {LayoutModule} from '@angular/cdk/layout';
import {
  MatButtonModule,
  MatCardModule,
  MatIconModule,
  MatInputModule,
  MatListModule,
  MatRadioModule,
  MatSelectModule,
  MatSidenavModule,
  MatToolbarModule
} from '@angular/material';
import {MovieListComponent} from './movie-list/movie-list.component';
import {MovieEditComponent} from './movie-edit/movie-edit.component';
import {CategoryListComponent} from './category-list/category-list.component';
import {CategoryEditComponent} from './category-edit/category-edit.component';
import {UserListComponent} from './user-list/user-list.component';
import {ReactiveFormsModule} from '@angular/forms';
import {ReaderGuard} from './guards/reader.guard';
import {CreatorGuard} from './guards/creator.guard';
import {AdminGuard} from './guards/admin.guard';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {JwtInterceptor} from './http-interceptor/jwt.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    MenuComponent,
    MovieListComponent,
    MovieEditComponent,
    CategoryListComponent,
    CategoryEditComponent,
    UserListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    MatInputModule,
    MatSelectModule,
    MatRadioModule,
    MatCardModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [ReaderGuard, CreatorGuard, AdminGuard,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: JwtInterceptor,
      multi: true
    }],
  bootstrap: [AppComponent]
})
export class AppModule {
}
