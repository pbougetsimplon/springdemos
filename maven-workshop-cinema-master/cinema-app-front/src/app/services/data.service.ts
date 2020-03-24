import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Category} from '../model/category.model';
import {Movie} from '../model/movie.model';
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private httpClient: HttpClient) {
  }

  getCategoryList(): Observable<Category[]> {
    return this.httpClient.get<Category[]>(environment.apiUrl + 'category');
  }

  createNewCategory(category: Category): Observable<Category> {
    return this.httpClient.post<Category>(environment.apiUrl + 'category', category);
  }

  getMovieList(): Observable<Movie[]> {
    return this.httpClient.get<Movie[]>(environment.apiUrl + 'movie');
  }

  createNewMovie(movie: Movie): Observable<Movie> {
    return this.httpClient.post<Movie>(environment.apiUrl + 'movie', movie);
  }
}
