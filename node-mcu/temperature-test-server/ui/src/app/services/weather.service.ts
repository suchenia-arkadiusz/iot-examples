import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Device } from '../model/device';
import { Observable } from 'rxjs';
import { WeatherInfo } from '../model/weather-info';

@Injectable({
  providedIn: 'root'
})
export class WeatherService {
  private readonly MAIN_URL = 'http://localhost:8080/api/v1/';

  constructor(private http: HttpClient) { }

  public getDevices(): Observable<Device[]> {
    return this.http.get<Device[]>(`${this.MAIN_URL}getDevices`);
  }

  public getActualWeather(sensorId: string): Observable<WeatherInfo> {
    return this.http.get<WeatherInfo>(`${this.MAIN_URL}/weatherInfo/newest/${sensorId}`);
  }
}
