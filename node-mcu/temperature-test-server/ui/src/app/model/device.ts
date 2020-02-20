import { Sensor } from './sensor';

export interface Device {
  id: string;
  displayName: string;
  sensors: Sensor[];
}
