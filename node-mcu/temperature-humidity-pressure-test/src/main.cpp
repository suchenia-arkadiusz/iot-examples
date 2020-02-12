#include <Wire.h>
#include <SPI.h>
#include <Adafruit_Sensor.h>
#include <Adafruit_BME280.h>

#define BME_SCK D1
#define BME_MISO D4
#define BME_MOSI D2
#define BME_CS D3
#define RED_LED D5
#define BLUE_LED D6

#define SAELEVELPRESSURE_HPA (1013.25)

Adafruit_BME280 bme(BME_CS, BME_MOSI, BME_MISO, BME_SCK);

unsigned long delayTime;
float temp;

void printValues() {
  Serial.print("Temperature: ");
  temp = bme.readTemperature();
  Serial.print(temp);
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

  if(temp > 23.0F) {
    digitalWrite(RED_LED, HIGH);
    digitalWrite(BLUE_LED, LOW);
  } else {
    digitalWrite(BLUE_LED, HIGH);
    digitalWrite(RED_LED, LOW);
  }
}

void setup() {
  Serial.begin(115200);
  pinMode(RED_LED, OUTPUT);
  pinMode(BLUE_LED, OUTPUT);
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