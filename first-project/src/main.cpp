#include <Arduino.h>

void setup() {
  Serial.begin(115200);
  Serial.println("App started");
}

void loop() {
  Serial.println("In loop");
  delay(2000);
}