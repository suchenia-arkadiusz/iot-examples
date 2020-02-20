import { WeatherInfo } from './weather-info';

export interface Sensor {
  id: string;
  displayName: string;
  values: WeatherInfo[];
}
