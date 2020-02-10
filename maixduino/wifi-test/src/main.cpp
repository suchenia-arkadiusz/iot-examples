#include <Arduino.h>

void setup() {
  Serial.begin(115200);
}

void loop() {
  Serial.print("W");
  delay(1000);
  Serial.print("i");
  delay(1000);
  Serial.print("F");
  delay(1000);
  Serial.print("i");
  delay(1000);
  Serial.print(" ");
  delay(1000);
  Serial.print("T");
  delay(1000);
  Serial.print("e");
  delay(1000);
  Serial.print("s");
  delay(1000);
  Serial.print("t");
  delay(1000);
  Serial.println();
}