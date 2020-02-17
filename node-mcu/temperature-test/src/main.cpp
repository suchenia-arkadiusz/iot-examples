#include <Arduino.h>
#include <OneWire.h>
#include <DallasTemperature.h>

#define ONE_WIRE_BUS D0

OneWire oneWire(ONE_WIRE_BUS);
DallasTemperature sensors(&oneWire);

void setup() {
  Serial.begin(115200);
  Serial.println("Started temperature sensor");
  sensors.begin();
}

void loop() {
  sensors.requestTemperatures();
  Serial.print("Temperature: ");
  Serial.println(sensors.getTempCByIndex(0));
  delay(1000);
}