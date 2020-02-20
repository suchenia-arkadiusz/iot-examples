import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { WeatherInfo } from '../model/weather-info';
import { DeviceInfo } from '../model/device-info';

@Injectable({
  providedIn: 'root'
})
export class WeatherService {
  private readonly MAIN_URL = 'http://localhost:8080/api/v1';

  private headers: HttpHeaders;

  constructor(private http: HttpClient) {
    this.headers = new HttpHeaders({'Access-Control-Allow-Origin': '*'});
  }

  public getDevices(): Observable<DeviceInfo[]> {
    return this.http.get<DeviceInfo[]>(`${this.MAIN_URL}/devices`, {headers: this.headers});
  }

  public getActualWeather(sensorId: string): Observable<WeatherInfo> {
    return this.http.get<WeatherInfo>(`${this.MAIN_URL}/weatherInfo/newest/${sensorId}`);
  }
}
