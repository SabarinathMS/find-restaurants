import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Restaurant } from './restaurant.model';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'restaurantApplication';
  isFetching = false;

  loadedRestaurants:Restaurant[]  = [];

  constructor(private http: HttpClient) {}

  ngOnInit(){
    this.fetchRestaurants();
  }
  
  onCreateRestaurant(restaurantData:Restaurant){
    this.http
    .post("http://localhost:8080/restaurants", restaurantData)
    .subscribe( responseData => {
      console.log(responseData);
      }
    );
  }

  onFetchRestaurants(){
    this.fetchRestaurants();
  }
  onClearRestaurants() {
    // Send Http request
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
}
