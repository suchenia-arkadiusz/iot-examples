#include <Wire.h>
#include <SPI.h>
#include <Adafruit_Sensor.h>
#include <Adafruit_BME280.h>

#define BME_SCK D1
#define BME_MISO D4
#define BME_MOSI D2
#define BME_CS D3
#define SERIAL_NUMBER "NMCU_1581860204129"
#define SENSOR_SERIAL_NUMBER "TAHP_1581860204129"

#define SAELEVELPRESSURE_HPA (1013.25)

Adafruit_BME280 bme(BME_CS, BME_MOSI, BME_MISO, BME_SCK);

unsigned long delayTime;
float temp;

void printValues() {
  String request = "{\"device\":{\"id\":\"" + String(SERIAL_NUMBER) + "\",\"sensors\":[{\"id\":\"" + String(SENSOR_SERIAL_NUMBER) + "\",\"value\":{";

  request += "\"temperature\":" + String(bme.readTemperature()) + ",";
  request += "\"pressure\":" + String(bme.readPressure() / 100.0F) + ",";
  request += "\"attitude\":" + String(bme.readAltitude(SAELEVELPRESSURE_HPA)) + ",";
  request += "\"humidity\":" + String(bme.readHumidity());
  request += "}}]}}";

  Serial.println(request);
}

void setup() {
  Serial.begin(115200);

  bool status;

  status = bme.begin();
  if(!status) {
    Serial.println("Could not find a valid BME280 sensor, check wiring!");
    while(true);
  }

  Serial.println("-- Default test --");
  delayTime = 10000;

  Serial.println();
}

void loop() {
  printValues();
  delay(delayTime);
}