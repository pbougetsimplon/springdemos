import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Category} from '../model/category.model';
import {Movie} from '../model/movie.model';
import {environment} from "../../environments/environment";
import {User} from '../model/user.model';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private httpClient: HttpClient) {
  }

// =================== all ===========================
  getUserList(): Observable<User[]> {
    return this.httpClient.get<User[]>(environment.apiUrl + 'user/all');
  }


  getCategoryList(): Observable<Category[]> {
    return this.httpClient.get<Category[]>(environment.apiUrl + 'category/all');
  }

  getMovieList(): Observable<Movie[]> {
    return this.httpClient.get<Movie[]>(environment.apiUrl + 'movie/all');
  }

// ===================== add ========================
  createNewCategory(category: Category): Observable<Category> {
    return this.httpClient.post<Category>(environment.apiUrl + 'category/add', category);
  }

  createNewMovie(movie: Movie): Observable<Movie> {
    return this.httpClient.post<Movie>(environment.apiUrl + 'movie/add', movie);
  }
  // ============== del =====================
  // ============== upd =====================


}
