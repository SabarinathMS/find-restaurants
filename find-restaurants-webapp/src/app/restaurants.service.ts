import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map, catchError } from 'rxjs/operators';
import { Subject, throwError } from 'rxjs';

import { Restaurant } from './restaurant.model';

@Injectable({ providedIn: 'root' })
export class RestaurantsService {
  error = new Subject<string>();

  constructor(private http: HttpClient) {}

  createAndStoreRestaurant(restaurant:Restaurant) {
      this.http
      .post(
        'http://localhost:8080/restaurants', restaurant )
      .subscribe(   responseData => {
          console.log(responseData);
        },
        error => {
          this.error.next(error.message);
        }
      );
  }

  fetchRestaurants() {
    return this.http
      .get<{ [key: string]: Restaurant }>(
        'http://localhost:8080/restaurants'
      )
      .pipe(
        map(responseData => {
          const postsArray: Restaurant[] = [];
          for (const key in responseData) {
            if (responseData.hasOwnProperty(key)) {
              postsArray.push({ ...responseData[key], id: key });
            }
          }
          return postsArray;
        }),
        catchError(errorRes => {
          // Send to analytics server
          return throwError(errorRes);
        })
      );
  }

  deletePosts() {
    return this.http.delete(
      'http://localhost:8080/restaurants'
    );
  }
}
