import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Restaurant } from './restaurant.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'restaurantApplication';

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
    this.http
    .get("http://localhost:8080/restaurants")
    .subscribe( restaurants => {
        console.log(restaurants);
      }
    );
  }
}
