import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

import { Restaurant } from './restaurant.model';

@Injectable({ providedIn: 'root' })
export class RestaurantsService {
  
  constructor(private http: HttpClient) {}

  createAndStoreRestaurant(restaurant:Restaurant) {
      this.http
      .post(
        'http://localhost:8080/restaurants', restaurant )
      .subscribe(   responseData => {
          console.log(responseData);
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
        })
      );
  }

  deletePosts() {
    return this.http.delete(
      'http://localhost:8080/restaurants'
    );
  }
}
