import {Category} from './category.model';

export class Movie {

  constructor(public id: number, public name: string, public duration: number, public category: Category) {
  }
}
