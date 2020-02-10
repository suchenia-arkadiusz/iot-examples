#include <Wire.h>
#include <SPI.h>
#include <Adafruit_Sensor.h>
#include <Adafruit_BME280.h>

#define BME_SCK D1
#define BME_MISO D4
#define BME_MOSI D2
#define BME_CS D3

#define SAELEVELPRESSURE_HPA (1013.25)

Adafruit_BME280 bme(BME_CS, BME_MOSI, BME_MISO, BME_SCK);

unsigned long delayTime;

void printValues() {
  Serial.print("Temperature: ");
  Serial.print(bme.readTemperature());
  Serial.println(" C");
  
  Serial.print("Pressure: ");
  Serial.print(bme.readPressure() / 100.0F);
  Serial.println(" hPa");
  
  Serial.print("Approx. Altitude: ");
  Serial.print(bme.readAltitude(SAELEVELPRESSURE_HPA));
  Serial.println(" m");
  
  Serial.print("Humidity: ");
  Serial.print(bme.readHumidity());
  Serial.println(" %");
  
  Serial.println();
}

void setup() {
  Serial.begin(115200);
  Serial.println("BME280 Test");

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