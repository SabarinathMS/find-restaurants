import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Restaurant } from './restaurant.model';
import { map } from 'rxjs/operators';
import { Subscription } from 'rxjs';

import { RestaurantsService } from './restaurants.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, OnDestroy{
  title = 'restaurantApplication';
  isFetching = false;
  loadedRestaurants:Restaurant[]  = [];
  error = null;
  private errorSub: Subscription;

  constructor(private http: HttpClient, private restaurantsService: RestaurantsService) {}

  ngOnInit(){
      this.errorSub = this.restaurantsService.error.subscribe(errorMessage => {
      this.error = errorMessage;
    });
    this.onFetchRestaurants();
  }
  
  onCreateRestaurant(restaurantData:Restaurant){
    this.restaurantsService.createAndStoreRestaurant(restaurantData);
  }

  onFetchRestaurants(){
    this.isFetching = true;
    this.restaurantsService.fetchRestaurants().subscribe(
      posts => {
        this.isFetching = false;
        this.loadedRestaurants = posts;
      },
      error => {
        this.error = error.message;
        console.log(error);
      }
      );
  }
  onClearRestaurants() {
    this.restaurantsService.deletePosts().subscribe(() => {
      this.loadedRestaurants = [];
    });
  }

  private fetchRestaurants(){
    this.isFetching = true;
    this.http
    .get<{ [key: string]: Restaurant }>("http://localhost:8080/restaurants")
    .pipe(
      map(responseData => {
        const restaurantsArray: Restaurant[] = [];
        for (const key in responseData) {
          if (responseData.hasOwnProperty(key)) {
            restaurantsArray.push({ ...responseData[key], id: key });
          }
        }
        return restaurantsArray;
      })
    )
    .subscribe( restaurants => {
        console.log(restaurants);
        this.isFetching = false;
        this.loadedRestaurants = restaurants;
      }
    );
  }

  ngOnDestroy() {
    this.errorSub.unsubscribe();
  }
}
