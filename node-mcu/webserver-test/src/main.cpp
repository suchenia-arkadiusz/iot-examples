#include <Arduino.h>
#include <ESP8266WiFi.h>
#include <ESP8266WebServer.h>

ESP8266WebServer server(80);

void handleLed() {

}

void configureWiFi() {
  WiFi.mode(WIFI_STA);
  WiFi.hostname("01-ESP-SmartLight");
  WiFi.begin("Arek_Room");

  while(WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }

  Serial.println(WiFi.localIP());
}

void configureEndpoints() {
  pinMode(2, OUTPUT);
  pinMode(5, INPUT_PULLUP);

  server.on("/led/on", []() {
    digitalWrite(2, LOW);
    server.send(200, "text/plain", "Led is on");
  });

  server.on("/led/off", []() {
    digitalWrite(2, HIGH);
    server.send(200, "text/plain", "Led is off");
  });

  server.on("/button", []() {
    server.send(200, "text/plain", String(digitalRead(5)));
  });

  server.on("/pot", []() {
    server.send(200, "text/plain", String(analogRead(A0)));
  });
}

void setup() {
  Serial.begin(115200);

  configureWiFi();
  
  server.on("/", []() {
    server.send(200, "text/plain", "It works");
  });

  configureEndpoints();

  server.begin();
}

void loop() {
  server.handleClient();
}