import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'restaurantApplication';

  loadedRestaurants  = [];

  constructor(private http: HttpClient) {}

  onCreateRestaurant(restaurantData:{name:string, rating:string, type:string}){
    
    this.http.post("http://localhost:8080/restaurants", restaurantData)
    .subscribe(responseData => {
      console.log(responseData);

    });
  }

  onFetchRestaurants(){
    
  }
  onClearRestaurants() {
    // Send Http request
  }
}
