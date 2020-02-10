#include <Arduino.h>

#define RED D5
#define BLUE D6

void setup() {
  Serial.begin(115200);
  pinMode(RED, OUTPUT);
  pinMode(BLUE, OUTPUT);
}

void loop() {
  digitalWrite(RED, LOW);
  digitalWrite(BLUE, HIGH);
  delay(100);
  digitalWrite(RED, HIGH);
  digitalWrite(BLUE, LOW);
  delay(100);
}