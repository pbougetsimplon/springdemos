import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './login/login.component';
import {ReaderGuard} from './guards/reader.guard';
import {AdminGuard} from './guards/admin.guard';
import {MovieListComponent} from './movie-list/movie-list.component';
import {MovieEditComponent} from './movie-edit/movie-edit.component';
import {CreatorGuard} from './guards/creator.guard';
import {UserListComponent} from './user-list/user-list.component';
import {CategoryListComponent} from './category-list/category-list.component';
import {CategoryEditComponent} from './category-edit/category-edit.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: '', component: MovieListComponent, canActivate: [ReaderGuard]},
  {path: 'movie-list', component: MovieListComponent, canActivate: [ReaderGuard]},
  {path: 'movie-edit', component: MovieEditComponent, canActivate: [CreatorGuard]},
  {path: 'category-list', component: CategoryListComponent, canActivate: [ReaderGuard]},
  {path: 'category-edit', component: CategoryEditComponent, canActivate: [CreatorGuard]},
  {path: 'user-list', component: UserListComponent, canActivate: [AdminGuard]},
  {path: '**', component: MovieListComponent, canActivate: [ReaderGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
