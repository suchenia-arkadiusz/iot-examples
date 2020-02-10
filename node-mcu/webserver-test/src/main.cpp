#include <Arduino.h>
#include <ESP8266WebServer.h>

ESP8266WebServer server(80);

void handleLed() {

}

void setup() {
  Serial.begin(115200);
  
  server.on("/", []() {
    server.send(200, "text/plain", "It works");
  });

  server.on("/led", handleLed);
  server.begin();
}

void loop() {
  server.handleClient();
}