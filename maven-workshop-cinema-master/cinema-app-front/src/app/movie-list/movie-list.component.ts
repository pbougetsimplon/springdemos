import {Component, OnInit} from '@angular/core';
import {DataService} from '../services/data.service';
import {Movie} from '../model/movie.model';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {

  movieList: Movie[] = [];

  constructor(private dataService: DataService) {
  }

  ngOnInit() {
    this.dataService.getMovieList().subscribe(movies => this.movieList = movies);
  }

}
