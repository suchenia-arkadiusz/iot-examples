#include <Arduino.h>
#include <ESP8266WiFi.h>

void setup() {
  Serial.begin(115200);

  WiFi.mode(WIFI_STA);
  WiFi.hostname("01-ESP-SmartLight");
  WiFi.begin("Arek_Room");

  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }

  Serial.println(WiFi.localIP());
}

void loop() {
  // put your main code here, to run repeatedly:
}