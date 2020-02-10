#include <Arduino.h>
#include <Keypad.h>

const byte rows = 4;
const byte cols = 4;

char keys[rows][cols] = {
  {'1', '2', '3', 'A'},
  {'4', '5', '6', 'B'},
  {'7', '8', '9', 'C'},
  {'*', '0', '#', 'D'}
};

byte colPins[rows] = {D3, D2, D1, D0};
byte rowPins[cols] = {D7, D6, D5, D4};

Keypad keypad = Keypad(makeKeymap(keys), rowPins, colPins, rows, cols);

void setup() {
  Serial.begin(115200);
}

void loop() {
  char keyPressed = keypad.getKey();

  if(keyPressed != NULL) {
    Serial.print("Key pressed: ");
    Serial.println(keyPressed);
  }
}