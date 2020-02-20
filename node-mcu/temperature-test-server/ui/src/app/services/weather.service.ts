import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { WeatherInfo } from '../model/weather-info';
import { DeviceInfo } from '../model/device-info';

@Injectable({
  providedIn: 'root'
})
export class WeatherService {
  private readonly MAIN_URL = 'http://localhost:8080/api/v1';

  constructor(private http: HttpClient) { }

  public getDevices(): Observable<DeviceInfo[]> {
    return this.http.get<DeviceInfo[]>(`${this.MAIN_URL}/devices`);
  }

  public getActualWeather(sensorId: string): Observable<WeatherInfo> {
    return this.http.get<WeatherInfo>(`${this.MAIN_URL}/weatherInfo/newest/${sensorId}`);
  }
}
