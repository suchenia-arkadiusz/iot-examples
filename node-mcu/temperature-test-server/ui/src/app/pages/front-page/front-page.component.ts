import { Component, OnInit } from '@angular/core';
import { WeatherService } from '../../services/weather.service';

@Component({
  selector: 'app-front-page',
  templateUrl: './front-page.component.html',
  styleUrls: ['./front-page.component.scss']
})
export class FrontPageComponent implements OnInit {
  temperature: number;
  altitude: number;
  pressure: number;
  humidity: number;

  constructor(private weatherService: WeatherService) { }

  ngOnInit(): void {
    this.weatherService.getActualWeather('TAHP_1581860204129')
      .subscribe(actualWeather => {
        this.temperature = actualWeather.temperature;
        this.altitude = actualWeather.altitude;
        this.pressure = actualWeather.pressure;
        this.humidity = actualWeather.humidity;
      });
  }

}
