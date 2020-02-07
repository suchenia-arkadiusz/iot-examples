#include <Arduino.h>
#include <WiFiEsp.h>

void setup() {
  Serial.begin(115200);
  Serial1.begin(115200);
  WiFi.init(&Serial1);
  WiFi.begin("Arek_Room", NULL);

  while(WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }
  
  Serial.println("Connected to the WiFi network");
}

void loop() {
  Serial.println("Writing network info");
  Serial.println(WiFi.SSID());
  Serial.println(WiFi.localIP());
  delay(2000);
}