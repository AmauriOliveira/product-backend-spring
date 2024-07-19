import { Component } from '@angular/core';
import { BookModel } from 'src/app/core/models';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.scss'],
})
export class BookComponent {
  book: BookModel = {
    id: 1,
    title: 'Angular for novice',
    author: 'Unknown',
    price: 120.5,
  };
}
