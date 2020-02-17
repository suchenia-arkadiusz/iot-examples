import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FrontPageComponent } from './pages/front-page/front-page.component';
import { HeaderComponent } from './components/header/header.component';
import { InfoCardComponent } from './components/info-card/info-card.component';

@NgModule({
  declarations: [
    AppComponent,
    FrontPageComponent,
    HeaderComponent,
    InfoCardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
