import { Component, OnInit } from '@angular/core';
import {DataService} from '../services/data.service';
import {Category} from '../model/category.model';

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategoryListComponent implements OnInit {

  categoryList: Category[] = [];
  constructor(private dataService: DataService) { }

  ngOnInit() {
    this.dataService.getCategoryList().subscribe(categories => this.categoryList = categories);
  }

}
