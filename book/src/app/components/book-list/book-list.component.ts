import { Component } from '@angular/core';
import { BookModel } from 'src/app/core/models';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.scss'],
})
export class BookListComponent {
  books: BookModel[] = [
    {
      id: 1,
      title: 'Angular for novice',
      author: 'Unknown',
      price: 120.5,
    },
    {
      id: 2,
      title: 'Java não morreu',
      author: 'Amauri',
      price: 60,
    },
    {
      id: 3,
      title: 'React',
      author: 'José da Silva',
      price: 55,
    },
  ];
}
