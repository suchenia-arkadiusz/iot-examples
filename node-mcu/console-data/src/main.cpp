#include <Arduino.h>

void setup() {
  Serial.begin(9600);
  Serial.println("App started");
}

void loop() {
  Serial.println("In loop");
  delay(2000);
}